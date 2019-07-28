package com.minsait.onesait.h3.rest;import java.util.List;

import com.uber.h3core.util.GeoCoord;

public interface ConversionService {
	
	String geoCoordsToWKT(List<GeoCoord> geoCoordsPolygon);
	String geoCoordsToStringArray(List<GeoCoord> geoCoordsPolygon);

}
