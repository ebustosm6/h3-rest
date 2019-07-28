/**
 * Copyright Indra Soluciones Tecnologías de la Información, S.L.U.
 * 2013-2019 SPAIN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.minsait.onesait.h3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.onesait.h3.rest.ConversionService;
import com.minsait.onesait.h3.rest.IndexingService;
import com.uber.h3core.util.GeoCoord;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("indexing")
@RestController
@Api(value = "Indexing functions", tags = { "indexing" })
@ApiResponses({ @ApiResponse(code = 429, message = "Too Many Requests"),
		@ApiResponse(code = 500, message = "Error processing request"),
		@ApiResponse(code = 403, message = "Forbidden") })
public class IndexingControllerImpl implements IndexingController {
	
	private static final String HTTP_GET = "GET";
	private static final String RES_GEO2H3 = "{\"h3Address\":\"%s\"}";
	private static final String RES_H32GEO = "{\"latitude\":\"%s\", \"longitude\":%s}";
	private static final String RES_H32GEOBOUNDARY = "{\"boundary\":\"%s\", \"WKT\":\"%s\"}";
	
	@Autowired
	private IndexingService indexingService;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	@GetMapping("/geoToH3")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Converts geo coordinates to h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<?> geoToH3(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int resolution) {
		String res = indexingService.geoToH3(latitude, longitude, resolution);
		String jsonString = String.format(RES_GEO2H3, res);
		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
	}

	@Override
	@GetMapping("/h3ToGeo")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Converts h3 address to centroid geo coordinates")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<?> h3ToGeo(@RequestParam String h3Address) {
		GeoCoord geoCoords = indexingService.h3ToGeo(h3Address);
		String jsonString = String.format(RES_H32GEO, geoCoords.lat, geoCoords.lng);
		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
	}

	@Override
	@GetMapping("/h3ToGeoBoundary")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Return geo boundary of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<?> h3ToGeoBoundary(@RequestParam String h3Address) {
		List<GeoCoord> geoBoundary = indexingService.h3ToGeoBoundary(h3Address);
		String stringPolygon = conversionService.geoCoordsToStringArray(geoBoundary);
		String stringWKT = conversionService.geoCoordsToWKT(geoBoundary);
		String jsonString = String.format(RES_H32GEOBOUNDARY, stringPolygon, stringWKT);
		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
		
	}

}
