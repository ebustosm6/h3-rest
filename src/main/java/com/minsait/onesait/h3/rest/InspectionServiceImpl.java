package com.minsait.onesait.h3.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.h3core.H3Core;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InspectionServiceImpl implements InspectionService {
	
	@Autowired
	private H3Core h3;

	@Override
	public boolean h3IsValid(String h3Address) {
		return h3.h3IsValid(h3Address);
	}

	@Override
	public int h3GetResolution(String h3Address) {
		return h3.h3GetResolution(h3Address);
	}

	@Override
	public int h3GetBaseCell(String h3Address) {
		return h3.h3GetBaseCell(h3Address);
	}

	@Override
	public boolean h3IsResClassIII(String h3Address) {
		return h3.h3IsResClassIII(h3Address);
	}

	@Override
	public boolean h3IsPentagon(String h3Address) {
		return h3.h3IsPentagon(h3Address);
	}
	

}
