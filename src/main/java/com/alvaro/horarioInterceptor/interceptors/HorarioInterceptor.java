package com.alvaro.horarioInterceptor.interceptors;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("HorarioInterceptor")
public class HorarioInterceptor implements HandlerInterceptor {

	@Value("${config.horario.apertura}") // Valor del application.properties
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		Calendar calendar = Calendar.getInstance();
		
		int hora = calendar.get(Calendar.HOUR_OF_DAY); // Obtenemos hora actual
		
		if (hora >= apertura && hora < cierre) { // Si la hora está entre la de apertura y cierre funciona
			
			// StringBuilder sirve para manejar String mutables sin tener que crear otros
			StringBuilder mensaje = new StringBuilder("Bienvenidos al horario de atención al cliente, ");
			mensaje.append("atendemos desde las " + apertura + " hasta las " + cierre + ".");
			mensaje.append("Gracias por su visita.");
			
			request.setAttribute("mensaje", mensaje);
			return true;
		}
		
		response.sendRedirect(request.getContextPath().concat("/cerrado"));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String mensajeHorario = request.getAttribute("mensaje").toString(); // Recibimos el atributo del preHandle()
		
		if (modelAndView != null && handler instanceof HandlerMethod) {
			modelAndView.addObject("mensajeHorario", mensajeHorario);
		}
		
	}
}
