package com.minsait.onesait.h3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.onesait.h3.rest.TraversalService;
import com.uber.h3core.exceptions.DistanceUndefinedException;
import com.uber.h3core.exceptions.LineUndefinedException;
import com.uber.h3core.exceptions.PentagonEncounteredException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("traversal")
@RestController
@Api(value = "Traversal functions", tags = { "travesal" })
@ApiResponses({ @ApiResponse(code = 429, message = "Too Many Requests"),
		@ApiResponse(code = 500, message = "Error processing request"),
		@ApiResponse(code = 403, message = "Forbidden") })
public class TraversalControllerImpl implements TraversalController {
	
	private static final String HTTP_GET = "GET";
	private static final String RES_KRING = "{\"h3Address\":\"%s\", \"rings\":\"%s\"}";
	private static final String RES_KRINGDISTANCES = "{\"h3Address\":\"%s\", \"ringDistances\":\"%s\"}";
	private static final String RES_HEXRANGES = "{\"h3Address\":\"%s\", \"hexRanges\":\"%s\"}";
	private static final String RES_HEXRINGS = "{\"h3Address\":\"%s\", \"hexRings\":\"%s\"}";
	private static final String RES_H3LINE = "{\"h3startAddress\":\"%s\", \"h3endAddress\":\"%s\", \"h3Line\":\"%s\"}";
	private static final String RES_H3DISTANCE = "{\"h3startAddress\":\"%s\", \"h3endAddress\":\"%s\", \"h3Distance\":\"%s\"}";
	
	@Autowired
	private TraversalService traversalService;
	
	@Override
	@GetMapping("/kRing")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> kRing(@RequestParam String h3Address, @RequestParam int numberRings) {
		List<String> rings = traversalService.kRing(h3Address, numberRings);
		String jsonString = String.format(RES_KRING, h3Address, rings);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/kRingDistances")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> kRingDistances(@RequestParam String h3Address, @RequestParam int numberRings) {
		List<List<String>> rings = traversalService.kRingDistances(h3Address, numberRings);
		String jsonString = String.format(RES_KRINGDISTANCES, h3Address, rings);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/hexRange")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> hexRange(@RequestParam String h3Address, @RequestParam int numberRings) {
		ResponseEntity<String> response;
		try {
			List<List<String>> ranges = traversalService.hexRange(h3Address, numberRings);
			String jsonString = String.format(RES_HEXRANGES, h3Address, ranges);
			response = new ResponseEntity<>(jsonString, HttpStatus.OK);
		} catch (PentagonEncounteredException e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@Override
	@GetMapping("/hexRing")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> hexRing(@RequestParam String h3Address, @RequestParam int numberRings) {
		ResponseEntity<String> response;
		try {
			List<String> rings = traversalService.hexRing(h3Address, numberRings);
			String jsonString = String.format(RES_HEXRINGS, h3Address, rings);
			response = new ResponseEntity<>(jsonString, HttpStatus.OK);
		} catch (PentagonEncounteredException e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@Override
	@GetMapping("/h3Line")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3Line(@RequestParam String h3startAddress, @RequestParam String h3endAddress) {
		ResponseEntity<String> response;
		try {
			List<String> rings = traversalService.h3Line(h3startAddress, h3endAddress);
			String jsonString = String.format(RES_H3LINE, h3startAddress, h3endAddress, rings);
			response = new ResponseEntity<>(jsonString, HttpStatus.OK);
		} catch (LineUndefinedException e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@Override
	@GetMapping("/h3Distance")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3Distance(@RequestParam String h3startAddress, @RequestParam String h3endAddress) {
		ResponseEntity<String> response;
		try {
			int distance = traversalService.h3Distance(h3startAddress, h3endAddress);
			String jsonString = String.format(RES_H3DISTANCE, h3startAddress, h3endAddress, distance);
			response = new ResponseEntity<>(jsonString, HttpStatus.OK);
		} catch (DistanceUndefinedException e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}


}
