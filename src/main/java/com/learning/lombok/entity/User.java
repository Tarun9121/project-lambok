package com.learning.lombok.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
}

/**
 * @Getter @Setter @ToString @EqualsAndHashcode @RequiredArgsConstructor (only for final fields) are included
 * to customize @ToString you can use one of the following you required
 * In Lombok, you can customize the `toString()` method even when using `@Data` or other annotations that generate the `toString()` method by default. Lombok provides the `@ToString` annotation, which allows you to exclude fields or customize how the `toString()` method behaves.
 *
 * Here’s how you can customize the `toString()` while using `@Data`:
 *
 * ### Customizing `toString()` with `@ToString` in Lombok
 *
 * #### Example 1: Exclude Fields from `toString()`
 * You can use the `@ToString` annotation and exclude certain fields from being included in the `toString()` output. For example, sensitive information like passwords or large fields like lists might be excluded.
 *
 * #### Code:
 * ```java
 * import lombok.Data;
 * import lombok.AllArgsConstructor;
 * import lombok.NoArgsConstructor;
 * import lombok.ToString;
 *
 * @Data
 * @NoArgsConstructor
 * @AllArgsConstructor
 * @ToString(exclude = "password") // Exclude password from toString()
 * public class User {
 *     private Long id;
 *     private String name;
 *     private String email;
 *     private String password; // This field will not be included in the toString()
 * }
 * ```
 *
 * #### Usage:
 * ```java
 * public class Main {
 *     public static void main(String[] args) {
 *         User user = new User(1L, "John", "john@example.com", "secretPassword");
 *         System.out.println(user); // password will be excluded from the output
 *     }
 * }
 * ```
 *
 * #### Output:
 * ```
 * User(id=1, name=John, email=john@example.com)
 * ```
 *
 * #### Example 2: Include Only Specific Fields in `toString()`
 * You can also configure `@ToString` to include only specific fields if you prefer:
 *
 * ```java
 * import lombok.Data;
 * import lombok.AllArgsConstructor;
 * import lombok.NoArgsConstructor;
 * import lombok.ToString;
 *
 * @Data
 * @NoArgsConstructor
 * @AllArgsConstructor
 * @ToString(onlyExplicitlyIncluded = true) // Only fields marked with @ToString.Include will be in the output
 * public class User {
 *     private Long id;
 *     @ToString.Include // Include this field in toString()
 *     private String name;
 *     @ToString.Include // Include this field in toString()
 *     private String email;
 *     private String password; // Will not be included in toString()
 * }
 * ```
 *
 * #### Usage:
 * ```java
 * public class Main {
 *     public static void main(String[] args) {
 *         User user = new User(1L, "John", "john@example.com", "secretPassword");
 *         System.out.println(user); // Only name and email will be shown
 *     }
 * }
 * ```
 *
 * #### Output:
 * ```
 * User(name=John, email=john@example.com)
 * ```
 *
 * ### Example 3: Customize Field Names in `toString()`
 * If you want to change the format or customize how fields are displayed, you can use `@ToString.Include` with `name` to give fields custom names in the `toString()` output.
 *
 * ```java
 * import lombok.Data;
 * import lombok.AllArgsConstructor;
 * import lombok.NoArgsConstructor;
 * import lombok.ToString;
 *
 * @Data
 * @NoArgsConstructor
 * @AllArgsConstructor
 * @ToString
 * public class User {
 *     private Long id;
 *
 *     @ToString.Include(name = "UserName") // Customize field name in toString()
 *     private String name;
 *
 *     private String email;
 *     private String password;
 * }
 * ```
 *
 * #### Usage:
 * ```java
 * public class Main {
 *     public static void main(String[] args) {
 *         User user = new User(1L, "John", "john@example.com", "secretPassword");
 *         System.out.println(user); // "UserName" will be shown instead of "name"
 *     }
 * }
 * ```
 *
 * #### Output:
 * ```
 * User(id=1, UserName=John, email=john@example.com, password=secretPassword)
 * ```
 *
 * ### Summary of `@ToString` Customization:
 * 1. **Exclude fields**: Use `@ToString(exclude = "fieldName")` to exclude specific fields.
 * 2. **Include only specific fields**: Use `@ToString(onlyExplicitlyIncluded = true)` and mark fields with `@ToString.Include`.
 * 3. **Customize field names**: Use `@ToString.Include(name = "customName")` to customize field names in the `toString()` output.
 *
 * By using `@ToString`, you can customize the behavior of the `toString()` method even when Lombok’s `@Data` generates it automatically.
 *
 */


/**
 * You can customize the behavior of the `equals()` and `hashCode()` methods in Lombok using the `@EqualsAndHashCode` annotation. Here’s how you can do it:
 *
 * ### 1. **Basic Usage of `@EqualsAndHashCode`**
 *
 * By default, `@EqualsAndHashCode` considers all fields when generating the methods. You can customize this behavior by using the following options:
 *
 * - **Exclude fields** from `equals()` and `hashCode()`
 * - **Include specific fields** only
 * - **Use only fields from the superclass** (if your class extends another class)
 *
 * ### Example 1: Excluding Fields
 *
 * You can exclude certain fields (like sensitive information) from the `equals()` and `hashCode()` methods:
 *
 * #### Code:
 * ```java
 * import lombok.Data;
 * import lombok.EqualsAndHashCode;
 *
 * @Data
 * @EqualsAndHashCode(exclude = "password") // Exclude password from equals and hashCode
 * public class User {
 *     private Long id;
 *     private String name;
 *     private String email;
 *     private String password; // This field will be excluded
 * }
 * ```
 *
 * ### Example 2: Including Specific Fields Only
 *
 * If you want to include only specific fields in `equals()` and `hashCode()`, you can use `@EqualsAndHashCode(onlyExplicitlyIncluded = true)` and mark the fields you want to include:
 *
 * #### Code:
 * ```java
 * import lombok.Data;
 * import lombok.EqualsAndHashCode;
 *
 * @Data
 * @EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only fields marked with @EqualsAndHashCode.Include will be included
 * public class User {
 *     private Long id;
 *
 *     @EqualsAndHashCode.Include // Include this field in equals and hashCode
 *     private String name;
 *
 *     @EqualsAndHashCode.Include // Include this field in equals and hashCode
 *     private String email;
 *
 *     private String password; // This field will not be included
 * }
 * ```
 *
 * ### Example 3: Customizing `equals()` and `hashCode()` with Superclass
 *
 * If your class extends another class and you want to include or exclude fields from the superclass, you can use the `callSuper` parameter:
 *
 * #### Code:
 * ```java
 * import lombok.Data;
 * import lombok.EqualsAndHashCode;
 *
 * @Data
 * @EqualsAndHashCode(callSuper = true) // Call equals and hashCode of the superclass
 * public class User extends BaseEntity {
 *     private Long id;
 *     private String name;
 *     private String email;
 * }
 * ```
 *
 * ### Example 4: Customizing Method Behavior with `@EqualsAndHashCode`
 *
 * If you want to customize how `equals()` and `hashCode()` methods are generated, you can override them manually. Lombok allows you to do this while still using its features.
 *
 * #### Code:
 * ```java
 * import lombok.Data;
 * import lombok.EqualsAndHashCode;
 *
 * @Data
 * @EqualsAndHashCode
 * public class User {
 *     private Long id;
 *     private String name;
 *     private String email;
 *
 *     @Override
 *     public boolean equals(Object o) {
 *         if (this == o) return true;
 *         if (!(o instanceof User)) return false;
 *         User user = (User) o;
 *         return name.equals(user.name) && email.equals(user.email); // Customize equality based on name and email
 *     }
 *
 *     @Override
 *     public int hashCode() {
 *         return Objects.hash(name, email); // Customize hashCode based on name and email
 *     }
 * }
 * ```
 *
 * ### Summary of Customizing `equals()` and `hashCode()`:
 * 1. **Exclude fields**: Use `@EqualsAndHashCode(exclude = "fieldName")`.
 * 2. **Include specific fields only**: Use `@EqualsAndHashCode(onlyExplicitlyIncluded = true)` and mark the fields with `@EqualsAndHashCode.Include`.
 * 3. **Call superclass methods**: Use `callSuper = true` to include superclass fields in `equals()` and `hashCode()`.
 * 4. **Manually override**: Override the methods manually while still using Lombok for other annotations if needed.
 *
 * These options give you control over how `equals()` and `hashCode()` behave, allowing you to implement custom logic as necessary.
 */

/**
 * `@Builder` in Lombok is a powerful annotation that automatically generates a **builder pattern** for your class. The builder pattern is a design pattern that provides a flexible and readable way to construct complex objects, especially when an object has many fields or optional fields.
 *
 * ### How the `@Builder` Annotation Works:
 * When you apply `@Builder` to a class or a method, Lombok generates a static inner `Builder` class with methods to set the values of each field in a step-by-step manner. It also generates a `build()` method that returns the fully constructed object.
 *
 * ### Example Without Lombok:
 * To understand the benefits of `@Builder`, let's first look at a manually written builder pattern:
 *
 * ```java
 * public class User {
 *     private String name;
 *     private String email;
 *     private int age;
 *
 *     // Private constructor to enforce the use of the builder
 *     private User(Builder builder) {
 *         this.name = builder.name;
 *         this.email = builder.email;
 *         this.age = builder.age;
 *     }
 *
 *     // Static inner builder class
 *     public static class Builder {
 *         private String name;
 *         private String email;
 *         private int age;
 *
 *         public Builder name(String name) {
 *             this.name = name;
 *             return this;
 *         }
 *
 *         public Builder email(String email) {
 *             this.email = email;
 *             return this;
 *         }
 *
 *         public Builder age(int age) {
 *             this.age = age;
 *             return this;
 *         }
 *
 *         public User build() {
 *             return new User(this);
 *         }
 *     }
 *
 *     // Getters (or other methods)...
 * }
 * ```
 *
 * To use this builder:
 * ```java
 * User user = new User.Builder()
 *     .name("John Doe")
 *     .email("john.doe@example.com")
 *     .age(25)
 *     .build();
 * ```
 *
 * ### Example Using Lombok `@Builder`:
 * With Lombok, the `@Builder` annotation simplifies this entire process:
 *
 * ```java
 * import lombok.Builder;
 * import lombok.ToString;
 *
 * @Builder
 * @ToString
 * public class User {
 *     private String name;
 *     private String email;
 *     private int age;
 * }
 * ```
 *
 * Here’s how it works:
 * - The `@Builder` annotation tells Lombok to generate a builder class for `User`.
 * - The `@ToString` annotation is optional, but it generates a `toString()` method, useful for printing objects.
 *
 * To use the builder with Lombok:
 * ```java
 * User user = User.builder()
 *     .name("John Doe")
 *     .email("john.doe@example.com")
 *     .age(25)
 *     .build();
 *
 * System.out.println(user);
 * ```
 *
 * ### Advantages of Using `@Builder`:
 * 1. **Improved Readability**: Instead of a long constructor or multiple setter methods, you can set values in a readable, step-by-step manner.
 * 2. **Immutability**: If you make your fields `final` and do not provide setter methods, the builder pattern allows you to maintain immutability while still constructing the object in a flexible way.
 * 3. **Optional Parameters**: With the builder pattern, you can easily skip fields that are optional, avoiding constructor overloads.
 * 4. **Flexible Object Creation**: The builder pattern is especially helpful when you have a large number of fields or when you need to construct an object with a combination of mandatory and optional fields.
 *
 * ### Additional Features:
 * - **@Builder(toBuilder = true)**: Generates a `toBuilder()` method that creates a new builder from the existing object's values, allowing you to clone and modify objects.
 *
 *    Example:
 *    ```java
 *    User updatedUser = user.toBuilder().email("new.email@example.com").build();
 *    ```
 *
 * - **@Singular**: When working with collections, you can use `@Singular` in the builder to add elements one by one to a list, set, or map.
 *
 *    Example:
 *    ```java
 *    @Builder
 *    public class User {
 *        private String name;
 *        private String email;
 *        @Singular private List<String> roles;
 *    }
 *
 *    User user = User.builder()
 *        .name("John Doe")
 *        .email("john.doe@example.com")
 *        .role("Admin")   // Add one role
 *        .role("User")    // Add another role
 *        .build();
 *    ```
 *
 * ### Conclusion:
 * Lombok's `@Builder` annotation significantly reduces boilerplate code and provides a clean, flexible way to construct objects. It improves code readability and maintainability by automating the creation of the builder pattern.
 */