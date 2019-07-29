package com.minsait.onesait.h3.error;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class ModelErrorHandler extends  DefaultResponseErrorHandler  {
	  @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    // do nothing, only pass through
	  }


}
