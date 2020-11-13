package com.bachelor.fileUploadServer.exception;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Component
public class ResponseErrorHandler  extends DefaultResponseErrorHandler {
	
	private static final Logger logger = LogManager.getLogger(ResponseErrorHandler.class);

	
	  @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
		  String statusText = response.getStatusText();
			HttpHeaders headers = response.getHeaders();
		
		  logger.error(statusText,headers,"error while calling the api ");
				  }
	}

