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
package com.minsait.onesait.h3.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

//@Configuration
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class OAuthConfiguration {
//
//	@Value("${security.oauth2.client.clientId}")
//	private String CLIENT_ID;
//
//	@Value("${security.oauth2.client.clientSecret}")
//	private String CLIENT_SECRET;
//
//	@Value("${security.oauth2.client.checkTokenEndpointUrl}")
//	private String CHECK_TOKEN_ENDPOINT_URL;
//	
//
//	@Primary
//	@Bean
//	public RemoteTokenServices remoteTokenServices() {
//		final RemoteTokenServices tokenServices = new RemoteTokenServices();
//		tokenServices
//				.setCheckTokenEndpointUrl(CHECK_TOKEN_ENDPOINT_URL);
//		tokenServices.setClientId(CLIENT_ID);
//		tokenServices.setClientSecret(CLIENT_SECRET);
//		return tokenServices;
//	}
//
//}
