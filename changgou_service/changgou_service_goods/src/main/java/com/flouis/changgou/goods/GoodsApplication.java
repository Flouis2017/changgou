package com.flouis.changgou.goods;

import com.flouis.changgou.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GoodsApplication {

	@Value("${workerId}")
	private Integer workerId;

	@Value("${datacenterId}")
	private Integer datacenterId;

	@Bean
	public IdWorker idWorker(){
		return new IdWorker(workerId, datacenterId);
	}

	public static void main(String[] args) {
		SpringApplication.run(GoodsApplication.class);
	}

}
