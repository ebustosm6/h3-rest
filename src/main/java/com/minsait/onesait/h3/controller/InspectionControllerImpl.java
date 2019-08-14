package com.minsait.onesait.h3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.onesait.h3.rest.InspectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("inspection")
@RestController
@Api(value = "Inspection functions", tags = { "inspection" })
@ApiResponses({ @ApiResponse(code = 429, message = "Too Many Requests"),
		@ApiResponse(code = 500, message = "Error processing request"),
		@ApiResponse(code = 403, message = "Forbidden") })
public class InspectionControllerImpl implements InspectionController {
	
	private static final String HTTP_GET = "GET";
	private static final String RES_H3ISVALID = "{\"h3Address\":\"%s\", \"isValid\":\"%s\"}";
	private static final String RES_H3RESOLUTION = "{\"h3Address\":\"%s\", \"resolution\":\"%s\"}";
	private static final String RES_H3GETBASE = "{\"h3Address\":\"%s\", \"baseCell\":\"%s\"}";
	private static final String RES_H3ISRESIII = "{\"h3Address\":\"%s\", \"isResIII\":\"%s\"}";
	private static final String RES_H3ISPENTAGON = "{\"h3Address\":\"%s\", \"isPentagon\":\"%s\"}";
	
	@Autowired
	private InspectionService inspectionService;
	
	@Override
	@GetMapping("/h3IsValid")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check if h3 address is valid")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3IsValid(@RequestParam String h3Address) {
		boolean isValid = inspectionService.h3IsValid(h3Address);
		String jsonString = String.format(RES_H3ISVALID, h3Address, isValid);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/h3GetResolution")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check resolution of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3GetResolution(@RequestParam String h3Address) {
		int resolution = inspectionService.h3GetResolution(h3Address);
		String jsonString = String.format(RES_H3RESOLUTION, h3Address, resolution);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}

	@Override
	@GetMapping("/h3GetBaseCell")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Get base cell of h3 address")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3GetBaseCell(@RequestParam String h3Address) {
		int baseCell = inspectionService.h3GetBaseCell(h3Address); 
		String jsonString = String.format(RES_H3GETBASE, h3Address, baseCell);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}

	@Override
	@GetMapping("/h3IsResClassIII")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check if h3 is Res Class III")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3IsResClassIII(@RequestParam String h3Address) {
		boolean isResIII = inspectionService.h3IsResClassIII(h3Address); 
		String jsonString = String.format(RES_H3ISRESIII, h3Address, isResIII);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}

	@Override
	@GetMapping("/h3IsPentagon")
	@ApiOperation(response = String.class, httpMethod = HTTP_GET, value = "Check if h3 is pentagon")
	@ApiResponse(code = 429, message = "Too Many Requests")
	public ResponseEntity<String> h3IsPentagon(@RequestParam String h3Address) {
		boolean isPentagon = inspectionService.h3IsPentagon(h3Address); 
		String jsonString = String.format(RES_H3ISPENTAGON, h3Address, isPentagon);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}

}
