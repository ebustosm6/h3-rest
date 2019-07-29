package com.minsait.onesait.h3.rest;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uber.h3core.util.GeoCoord;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConversionServiceImpl implements ConversionService{

	@Override
	public String geoCoordsToWKT(List<GeoCoord> geoCoordsPolygon) {
			String wktString = "POLYGON((";
			GeoCoord firstPoint = geoCoordsPolygon.get(0);
			for (GeoCoord c: geoCoordsPolygon) {
				wktString += c.lat + " " + c.lng + ",";
			}
			if (wktString.endsWith(","))
			{
				wktString += firstPoint.lat + " " + firstPoint.lng;
			}
			wktString += "))";
		return wktString;
	}

	@Override
	public String geoCoordsToStringArray(List<GeoCoord> geoCoordsPolygon) {
		String polygonString = "[";
		for (GeoCoord c: geoCoordsPolygon) {
			polygonString += "[" + c.lat + ", " + c.lng + "], ";
		}
		if (polygonString.endsWith(", "))
		{
			polygonString = polygonString.substring(0, polygonString.length() -2);
		}
		polygonString += "]";
		return polygonString;
	}

}
