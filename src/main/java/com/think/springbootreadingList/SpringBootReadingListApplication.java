package com.think.springbootreadingList;

//import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReadingListApplication.class, args);
		// 关闭banner
		// SpringApplication app = new
		// SpringApplication(SpringBootReadingListApplication.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.run(args);
	}
}
