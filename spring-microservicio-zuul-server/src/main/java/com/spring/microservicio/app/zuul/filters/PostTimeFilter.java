package com.spring.microservicio.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostTimeFilter extends ZuulFilter{
	
	private Logger log = LoggerFactory.getLogger(PreTimeFilter.class);


	public PostTimeFilter() {}

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
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

				
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);

		
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
