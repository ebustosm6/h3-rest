package com.minsait.onesait.h3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.h3core.H3Core;
import com.uber.h3core.exceptions.DistanceUndefinedException;
import com.uber.h3core.exceptions.LineUndefinedException;
import com.uber.h3core.exceptions.PentagonEncounteredException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TraversalServiceImpl implements TraversalService {

	@Autowired
	private H3Core h3;
	
	@Override
	public List<String> kRing(String h3Address, int numberRings) {
		return h3.kRing(h3Address, numberRings);
	}
	
	@Override
	public List<List<String>> kRingDistances(String h3Address, int numberRings) {
		return h3.kRingDistances(h3Address, numberRings);
	}
	
	@Override
	public List<List<String>> hexRange(String h3Address, int numberRings) throws PentagonEncounteredException {
		return h3.hexRange(h3Address, numberRings);
	}
	
	@Override
	public List<String> hexRing(String h3Address, int numberRings) throws PentagonEncounteredException {
		return h3.hexRing(h3Address, numberRings);
	}
	
	@Override
	public List<String> h3Line(String h3startAddress, String h3endAddress) throws LineUndefinedException {
		return h3.h3Line(h3startAddress, h3endAddress);
	}
	
	@Override
	public int h3Distance(String h3startAddress, String h3endAddress) throws DistanceUndefinedException {
		return h3.h3Distance(h3startAddress, h3endAddress);
	}
}
