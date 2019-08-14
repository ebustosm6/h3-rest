package com.minsait.onesait.h3.rest;import java.util.List;

import com.uber.h3core.exceptions.DistanceUndefinedException;
import com.uber.h3core.exceptions.LineUndefinedException;
import com.uber.h3core.exceptions.PentagonEncounteredException;

public interface TraversalService {

	List<String> kRing(String h3Address, int numberRings);

	List<List<String>> kRingDistances(String h3Address, int numberRings);

	List<List<String>> hexRange(String h3Address, int numberRings) throws PentagonEncounteredException;

	List<String> hexRing(String h3Address, int numberRings) throws PentagonEncounteredException;

	List<String> h3Line(String h3startAddress, String h3endAddress) throws LineUndefinedException;

	int h3Distance(String h3startAddress, String h3endAddress) throws DistanceUndefinedException;

}
