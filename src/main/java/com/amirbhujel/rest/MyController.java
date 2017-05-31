package com.amirbhujel.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller  -- If used Spring 3.0 or lower
@RestController
@RequestMapping("/greeting")
public class MyController {
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	//public @ResponseBody String sayhello(@PathVariable String name){ -- If used Spring 3.0 or lower
	public String sayhello(@PathVariable String name){
		
		return "Hello " + name;
	}
	
	@RequestMapping(value="/stockQuote/{firmName}", method=RequestMethod.GET)
	public StockQuoteResponse getStockQuote(@PathVariable String firmName){
		
		StockQuoteResponse response = new StockQuoteResponse();
		response.setFirmName(firmName);
		response.setStockValue(1000);
		
		return response;
	}
	
	// In Spring 4.0 the response is automatically converted into JSON object format when Jackson API used.
	// In Spring 3.0 the converters need to be used for converting the JSOn into JSON  object format.
	// Such converters need to be specified in the servlet.xml file.
}
