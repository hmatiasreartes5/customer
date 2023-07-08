package com.matiasreartes.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		String profile = getProfile();
		new SpringApplicationBuilder(CustomerApplication.class)
				.profiles(profile)
				.run(args);
	}

	private static String getProfile() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el perfil de ejecución: ");
		System.out.println("1-local");
		System.out.println("2-dev");
		int value = scanner.nextInt();

		return switch (value) {
			case 2 -> "dev";
			default -> "local";
		};
	}
}
