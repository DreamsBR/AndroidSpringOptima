package com.idat.android.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.idat.android.app.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class AdministracionDeEdificiosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministracionDeEdificiosApiApplication.class, args);
	}

}
