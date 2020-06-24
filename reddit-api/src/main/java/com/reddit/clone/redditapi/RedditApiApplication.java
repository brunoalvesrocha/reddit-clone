package com.reddit.clone.redditapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditApiApplication.class, args);
	}

}
