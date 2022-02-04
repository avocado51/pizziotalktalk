package com.avocado.pizziotalktalk.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.avocado.pizziotalktalk.controller.response.ErrorMessage;
import com.avocado.pizziotalktalk.controller.response.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IdFilter implements Filter {

	private ObjectMapper objectMapper;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String userId = httpServletRequest.getHeader("X-USER-ID");
		if (userId == null) {
			ResponseMessage responseMessage = new ResponseMessage();
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setStatus(403);
			errorMessage.setMessage("X-USER-ID is Null");
			responseMessage.setError(errorMessage);

			response.getWriter().write(objectMapper.writeValueAsString(responseMessage));

			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
