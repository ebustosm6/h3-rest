package com.minsait.onesait.h3.controller;

import org.springframework.http.ResponseEntity;

public interface InspectionController {
	
	ResponseEntity<String> h3IsValid(String h3Address);
	
	ResponseEntity<String> h3GetResolution(String h3Address);
	
	ResponseEntity<String> h3GetBaseCell(String h3Address);
	
	ResponseEntity<String> h3IsResClassIII(String h3Address); 
	
	ResponseEntity<String> h3IsPentagon(String h3Address); 

}
