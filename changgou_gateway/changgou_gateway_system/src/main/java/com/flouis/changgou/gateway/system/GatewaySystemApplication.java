package com.flouis.changgou.gateway.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
public class GatewaySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySystemApplication.class, args);
	}

	@Bean
	public KeyResolver ipKeyResolver(){
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	}

}
