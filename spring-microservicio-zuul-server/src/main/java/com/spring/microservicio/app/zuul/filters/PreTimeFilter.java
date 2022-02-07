package com.spring.microservicio.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreTimeFilter extends ZuulFilter{

	private Logger log = LoggerFactory.getLogger(PreTimeFilter.class);
	
	public PreTimeFilter() {}

	/**
	 * Valida si el filtro se esta ejecutando
	 */
	@Override
	public boolean shouldFilter() {

		return true;
	}

	/**
	 * Ejecuta el filtro
	 */
	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("Entrando al post filter");

				
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
				
		log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("Tiempo transcurrido en milisegundos  %s ms.", tiempoTranscurrido));

		
		return null;
	}

	/**
	 * Indica el tipo de filtro
	 */
	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
