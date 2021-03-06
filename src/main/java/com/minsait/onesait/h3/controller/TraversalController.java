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

import org.springframework.http.ResponseEntity;

public interface TraversalController {
	
	ResponseEntity<String> kRing(String h3Address, int numberRings);

	ResponseEntity<String> kRingDistances(String h3Address, int numberRings);

	ResponseEntity<String> hexRange(String h3Address, int numberRings);

	ResponseEntity<String> hexRing(String h3Address, int numberRings);

	ResponseEntity<String> h3Line(String h3startAddress, String h3endAddress);

	ResponseEntity<String> h3Distance(String h3startAddress, String h3endAddress);


}
