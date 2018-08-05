package com.springboot.datajpa.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.springboot.datajpa.app.auth.handler.LoginSuccessHandler;
import com.springboot.datajpa.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private LoginSuccessHandler successHandler;
	@Autowired
	private JpaUserDetailsService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		//En este metodo se establecen los permisos por roles para proteger los recursos de la aplicación WEB
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar**","/api/clientes/**").permitAll()
		/* Remplazamos las restricciones programaticas para usar anotaciones en el controlador 
		.antMatchers("/ver/**").hasAnyRole("USER")
		.antMatchers("/uploads/**").hasAnyRole("USER")		
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.antMatchers("/factura/**").hasAnyRole("ADMIN")
		*/
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.successHandler(successHandler)	
		.loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/error_403");
		
		
	}

	@Autowired
	public void configurarGlobal(AuthenticationManagerBuilder build ) throws Exception {
		// Este metodo recibe una instancia de AutenticationManagerBuilder a traves de la inyección con el @Autowired, para poder usar los metodos de encriptacion de passwords
		
		build.userDetailsService(userDetailService)		
		.passwordEncoder(passwordEncoder);
		
		
		/* Seccion para con el codigo anterior autentificar mediante JDBC
		.usersByUsernameQuery("select  username, password, enable from users where username = ?")
		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on(a.user_id = u.id) where u.username = ?");
		
		//Forma de establecer los usuarios y roles de forma estatica desde el codigo
		/*
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
		*/
	}
	
}
