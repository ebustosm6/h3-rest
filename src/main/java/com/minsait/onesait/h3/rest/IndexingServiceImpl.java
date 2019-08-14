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
package com.minsait.onesait.h3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;


@Service
public class IndexingServiceImpl implements IndexingService {
	
	@Autowired
	private H3Core h3;
	
	@Override
	public String geoToH3(double latitude, double longitude, int resolution) {
		if (resolution < 0) {
			resolution = 0;
		}
		if (resolution > 15) {
			resolution = 15;
		}
		
		return h3.geoToH3Address(latitude, longitude, resolution);
	}

	@Override
	public GeoCoord h3ToGeo(String h3Address) {
		return h3.h3ToGeo(h3Address);
	}

	@Override
	public List<GeoCoord> h3ToGeoBoundary(String h3Address) {
		return h3.h3ToGeoBoundary(h3Address);
	}


}
