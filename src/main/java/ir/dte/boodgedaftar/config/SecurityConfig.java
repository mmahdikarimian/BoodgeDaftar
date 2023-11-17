package ir.dte.boodgedaftar.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



 @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 Resource resource = new ClassPathResource("static/assets/");
	 String resourceString =resource.getURI().toString();
	 http
			 .authorizeHttpRequests((authorize) -> authorize
					 .requestMatchers("/assets/**").permitAll()
					 .requestMatchers("boodge/showalledarekol").hasAnyRole("MOAVEN","ADMIN")
					 .anyRequest().authenticated()
			 )
			 .formLogin((form) -> form
					 .loginPage("/login")
					 .successHandler(new CustomAuthenticationSuccessHandler())
					 .permitAll()
			 )
			 .logout((logout) -> logout
					 .logoutSuccessUrl("/login")
					 .permitAll());
	 // @formatter:on
	 return http.build();
	}

	// @formatter:off
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		UserDetails moaven = User.withDefaultPasswordEncoder()
				.username("moaven")
				.password("moaven")
				.roles("MOAVEN")
				.build();
//		UserDetails modirOmoorEjraii = User.withDefaultPasswordEncoder()
//				.username("ejraii")
//				.password("ejraii")
//				.roles("MODIREJRAII")
//				.build();
//		UserDetails modirAmoozesh = User.withDefaultPasswordEncoder()
//				.username("modir-amoozesh")
//				.password("modir-amoozesh")
//				.roles("MODIRAMOOZESH")
//				.build();
//		UserDetails modirMarkazHonarVaRasaneh = User.withDefaultPasswordEncoder()
//				.username("modir-markaz")
//				.password("modir-markaz")
//				.roles("MODIRMARKAZ")
//				.build();
//		UserDetails modirMajazi = User.withDefaultPasswordEncoder()
//				.username("modir-majazi")
//				.password("modir-majazi")
//				.roles("MODIRMAJAZI")
//				.build();
//		UserDetails modirHoze = User.withDefaultPasswordEncoder()
//				.username("modir-hozeh")
//				.password("modir-hozeh")
//				.roles("MODIRHOZEH")
//				.build();
		return new InMemoryUserDetailsManager(admin, moaven);
//		return new InMemoryUserDetailsManager(admin, moaven, modirOmoorEjraii, modirAmoozesh, modirHoze,
//				modirMajazi, modirMarkazHonarVaRasaneh);
	}

}


class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	SimpleUrlAuthenticationSuccessHandler userSuccessHandler =
			new SimpleUrlAuthenticationSuccessHandler("/user-page");
	SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
			new SimpleUrlAuthenticationSuccessHandler("/boodge/showalledarekol");
	SimpleUrlAuthenticationSuccessHandler moavenSuccessHandler =
			new SimpleUrlAuthenticationSuccessHandler("/boodge/showalledarekol");

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			String authorityName = grantedAuthority.getAuthority();
			if (authorityName.equals("ROLE_ADMIN")) {
				// if the user is an ADMIN delegate to the adminSuccessHandler
				this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
				return;
			}
			if (authorityName.equals("ROLE_MOAVEN")) {
				// if the user is an ADMIN delegate to the adminSuccessHandler
				this.moavenSuccessHandler.onAuthenticationSuccess(request, response, authentication);
				return;
			}
		}
		// if the user is not an admin delegate to the userSuccessHandler
		this.userSuccessHandler.onAuthenticationSuccess(request, response, authentication);
	}
}