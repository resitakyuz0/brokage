package com.ing.brokage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/orderListings").setViewName("orderListings");
        registry.addViewController("/createOrder").setViewName("createOrder");
        registry.addViewController("/deleteOrder").setViewName("deleteOrder");
        registry.addViewController("/assetListings").setViewName("assetListings");
        registry.addViewController("/login").setViewName("login");
    }

}
