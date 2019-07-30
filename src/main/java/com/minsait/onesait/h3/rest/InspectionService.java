package com.minsait.onesait.h3.rest;

public interface InspectionService {
	
	boolean h3IsValid(String h3Address);
	
	int h3GetResolution(String h3Address);
	
	int h3GetBaseCell(String h3Address);
	
	boolean h3IsResClassIII(String h3Address);

	boolean h3IsPentagon(String h3Address);


}
