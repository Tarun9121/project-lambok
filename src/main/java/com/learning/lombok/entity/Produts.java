package com.learning.lombok.entity;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Builder(toBuilder = true)
public class Produts {
    private int productId;
    private String productName;
    private double price;
}
