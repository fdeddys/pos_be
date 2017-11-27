package com.ddabadi.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}
//    public Properties hibernateProperties() {
//        Properties properties = new Properties();
//
//        // second-level cache:
//        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.EhCacheRegionFactory");
//        properties.setProperty("hibernate.cache.use_query_cache", "true");
//        return properties;
//    }
}
