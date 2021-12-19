package com.log4j.cve;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {

	private static final Logger logger = LoggerFactory.getLogger(RestMainController.class);

	@GetMapping("/")
	public String echo(@RequestHeader("X-Api-Version") String apiVersion) {
		ThreadContext.put("apiVersion", apiVersion);
		logger.info("Received a request");
		return "Hello, API Controller!";
	}
	
	@PostMapping("/addrecord")
	public String addRecord(@RequestBody InputRequest request) {
		ThreadContext.put("clientRef", request.getClientRef());
		logger.info("Received a request");
		return "Hello, Input Request!";
	}
}
