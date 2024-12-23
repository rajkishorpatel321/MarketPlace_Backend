package com.tp.marketplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allows CORS for all endpoints
                .allowedOrigins(environment.getProperty("Frontent.server.request"),"http://localhost:3001","https://clever-rolypoly-ba2370.netlify.app/","https://clever-rolypoly-ba2370.netlify.app","https://www.krshisathinow.xyz/") // Allow the React app's origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                .allowedHeaders("*")
		.allowCredentials(true); // Allow all headers
    }
}
