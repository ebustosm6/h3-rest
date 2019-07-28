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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@EnableOAuth2Client
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private OAuth2ClientContext oauth2ClientContext;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.csrf().disable();
//		http.logout();
//		http.authorizeRequests().antMatchers("/login**", "/**/*.css", "/img/**", "/third-party/**", "/").permitAll();
//		http.authorizeRequests().antMatchers("/health/", "/info", "/metrics", "/trace", "/logfile").permitAll();
//		http.authorizeRequests().regexMatchers("^/swagger.*", "^/v2/api-docs.*").permitAll();
//		http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"));
		http.authorizeRequests().anyRequest().permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/webjars/**");
	}

}
