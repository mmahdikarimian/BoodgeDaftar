package ir.dte.boodgedaftar.config;


import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final RsaKeyProperties rsaKeys;

	public SecurityConfig(RsaKeyProperties rsaKeys) {
		this.rsaKeys = rsaKeys;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("hello "+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		System.out.println(rsaKeys.toString());
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests( auth -> auth
								.requestMatchers("boodge/showalledarekol").hasAnyAuthority("SCOPE_ROLE_ADMIN","SCOPE_ROLE_MOAVEN")
								.requestMatchers("boodge/edarekoldetails/**").hasAnyAuthority("SCOPE_ROLE_ADMIN","SCOPE_ROLE_MOAVEN")
								.requestMatchers("boodge/edarekoldetails/majazi").hasAnyAuthority("SCOPE_ROLE_MODIRMAJAZI")
								.requestMatchers("boodge/edarekoldetails/honarvarasaneh").hasAnyAuthority("SCOPE_ROLE_MODIRMARKAZ")
								.requestMatchers("boodge/edarekoldetails/ejraii").hasAnyAuthority("SCOPE_ROLE_MODIREJRAII")
						.requestMatchers("boodge/showalledare").hasAnyAuthority("SCOPE_ROLE_ADMIN","SCOPE_ROLE_MOAVEN")
//						.requestMatchers("boodge/showedare/*").authenticated()
								.anyRequest().authenticated()
				)
//				.oauth2ResourceServer(auth -> auth.jwt(Customizer.withDefaults()))
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults())
				.build();
	}


	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails admin = User
				.withUsername("admin")
				.password("{noop}admin")
				.roles("ADMIN")
				.authorities("level1")
				.build();

		UserDetails moaven = User
				.withUsername("moaven")
				.password("{noop}moaven")
				.roles("MOAVEN")
				.authorities("level2")
				.build();

		UserDetails modirOmoorEjraii = User
				.withUsername("ejraii")
				.password("{noop}ejraii")
				.roles("MODIREJRAII")
				.authorities("level3")
				.build();

		UserDetails modirMarkazHonarVaRasaneh = User
				.withUsername("modir-markaz")
				.password("{noop}modir-markaz")
				.roles("MODIRMARKAZ")
				.authorities("level3")
				.build();
		UserDetails modirMajazi = User
				.withUsername("modir-majazi")
				.password("{noop}modir-majazi")
				.roles("MODIRMAJAZI")
				.authorities("level3")
				.build();

		return new InMemoryUserDetailsManager(admin, moaven, modirOmoorEjraii, modirMarkazHonarVaRasaneh, modirMajazi);
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
	}

	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}
}


//class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//	SimpleUrlAuthenticationSuccessHandler userSuccessHandler =
//			new SimpleUrlAuthenticationSuccessHandler("/user-page");
//	SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
//			new SimpleUrlAuthenticationSuccessHandler("/boodge/showalledarekol");
//	SimpleUrlAuthenticationSuccessHandler moavenSuccessHandler =
//			new SimpleUrlAuthenticationSuccessHandler("/boodge/showalledarekol");
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//										Authentication authentication) throws IOException, ServletException {
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		for (final GrantedAuthority grantedAuthority : authorities) {
//			String authorityName = grantedAuthority.getAuthority();
//			if (authorityName.equals("ROLE_ADMIN")) {
//				// if the user is an ADMIN delegate to the adminSuccessHandler
//				this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//				return;
//			}
//			if (authorityName.equals("ROLE_MOAVEN")) {
//				// if the user is an ADMIN delegate to the adminSuccessHandler
//				this.moavenSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//				return;
//			}
//		}
//		// if the user is not an admin delegate to the userSuccessHandler
//		this.userSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//	}
//}