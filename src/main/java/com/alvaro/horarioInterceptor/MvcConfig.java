package com.alvaro.horarioInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Autowired
	@Qualifier("HorarioInterceptor")
	private HandlerInterceptor horario;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Excluimos la ruta del html "cerrado" para que se muestre fuera del horario
		registry.addInterceptor(horario).excludePathPatterns("/cerrado");
	}
}
