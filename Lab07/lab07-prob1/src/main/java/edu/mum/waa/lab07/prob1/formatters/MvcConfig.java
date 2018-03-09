package edu.mum.waa.lab07.prob1.formatters;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan
public class MvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PlayFormatter());
	}

}
