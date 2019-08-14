package com.minsait.onesait.h3.rest;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uber.h3core.util.GeoCoord;

@Service
public class ConversionServiceImpl implements ConversionService{

	@Override
	public String geoCoordsToWKT(List<GeoCoord> geoCoordsPolygon) {
		StringBuilder wktString = new StringBuilder();
		wktString.append("POLYGON((");
			GeoCoord firstPoint = geoCoordsPolygon.get(0);
			
			for (GeoCoord c: geoCoordsPolygon) {
				wktString.append(c.lat + " " + c.lng + ",");
			}
			if (wktString.toString().endsWith(","))
			{
				wktString.append(firstPoint.lat + " " + firstPoint.lng);
			}
			wktString.append("))");
		return wktString.toString();
	}

	@Override
	public String geoCoordsToStringArray(List<GeoCoord> geoCoordsPolygon) {
		StringBuilder polygonString = new StringBuilder();
		polygonString.append("[");
		for (GeoCoord c: geoCoordsPolygon) {
			polygonString.append("[" + c.lat + ", " + c.lng + "], ");
		}
		if (polygonString.toString().endsWith(", ")) {
			polygonString.delete(polygonString.length() -2, polygonString.length());
		}
		polygonString.append("]");
		return polygonString.toString();
	}

}
