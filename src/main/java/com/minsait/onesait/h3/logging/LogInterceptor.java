package com.minsait.onesait.h3.logging;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {
	public static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";
	public static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		final String correlationId = getCorrelationIdFromHeader(request);
		MDC.put(CORRELATION_ID_LOG_VAR_NAME, correlationId);
		log.info("New request with address: {} , URL:{} , User-Agent: {} , has id: {} ", request.getRemoteAddr(),
				request.getRequestURL(), request.getHeader(HttpHeaders.USER_AGENT), correlationId);

		return true;
	}

	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception ex) throws Exception {
		MDC.remove(CORRELATION_ID_LOG_VAR_NAME);
	}

	private String getCorrelationIdFromHeader(final HttpServletRequest request) {
		String correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
		if (StringUtils.isEmpty(correlationId)) {
			correlationId = generateUniqueCorrelationId();
		}
		return correlationId;
	}

	public static String generateUniqueCorrelationId() {
		return UUID.randomUUID().toString();
	}
}
