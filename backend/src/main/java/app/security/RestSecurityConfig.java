package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import app.security.jwt.JwtRequestFilter;


@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    RepositoryUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	//Expose AuthenticationManager as a Bean to be used in other services
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**");
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/comment/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/comment/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/comment/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/ajax/moreRecommendations").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/ajax/moreCommentsProfile/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/films/regis/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/films/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/films/addFilm").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/films/addFilm").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/films/editFilm/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/films/editFilm/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/films/**").hasRole("ADMIN");
		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().disable();

		// Enable Http Basic Authentication
		http.httpBasic();
		
		// Disable Form login Authentication
		http.formLogin().disable();

		// Avoid creating session 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Add JWT Token filter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}