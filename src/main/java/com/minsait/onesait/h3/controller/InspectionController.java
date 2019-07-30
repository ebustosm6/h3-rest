package com.minsait.onesait.h3.controller;

import org.springframework.http.ResponseEntity;

public interface InspectionController {
	
	ResponseEntity<?> h3IsValid(String h3Address);
	
	ResponseEntity<?> h3GetResolution(String h3Address);
	
	ResponseEntity<?> h3GetBaseCell(String h3Address);
	
	ResponseEntity<?> h3IsResClassIII(String h3Address); 
	
	ResponseEntity<?> h3IsPentagon(String h3Address); 

}
