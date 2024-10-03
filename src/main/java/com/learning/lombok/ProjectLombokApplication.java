package com.learning.lombok;

import com.learning.lombok.entity.Produts;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectLombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLombokApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			Produts pocoMobile = Produts.builder()
							.productId(12)
									.productName("pocoMobile")
					.price(100)
											.build();

			Produts samsung = pocoMobile.toBuilder().productId(10).productName("samsung").build();
			System.out.println(pocoMobile + " " + samsung);
		};
	}


}
