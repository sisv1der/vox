package ru.yarigo.vox;

import org.springframework.boot.SpringApplication;

public class TestVoxApplication {

	public static void main(String[] args) {
		SpringApplication.from(VoxApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
