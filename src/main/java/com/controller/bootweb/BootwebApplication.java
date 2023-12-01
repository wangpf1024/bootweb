package com.controller.bootweb;

import com.controller.bootweb.demo.gof23.build.Computer;
import com.controller.bootweb.demo.gof23.build.HighEndComputerBuilder;
import com.controller.bootweb.demo.gof23.build.LowEndComputerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootwebApplication.class, args);
	}
}
