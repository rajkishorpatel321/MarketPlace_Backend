package com.tp.marketplace;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
        // Set strict matching strategy for better accuracy in field mapping
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Customize the configuration if needed (e.g., skipping null fields)
        modelMapper.getConfiguration().setSkipNullEnabled(true);
		return new ModelMapper();
	}
}
