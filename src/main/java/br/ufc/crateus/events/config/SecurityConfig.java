package br.ufc.crateus.events.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticatorProvider customAuthenticatorProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.cors().and().httpBasic().and().authorizeRequests().antMatchers("/api/**").authenticated().and().logout().logoutRequestMatcher(new
        // AntPathRequestMatcher("/api/logout"))
        // .logoutSuccessHandler((new
        // HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))).clearAuthentication(true)
        // .invalidateHttpSession(true).deleteCookies("JSESSIONID").and()
        // .authorizeRequests().antMatchers("/public/**").permitAll();
        http.cors().and().authorizeRequests().antMatchers("/api/**").authenticated().and()
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticatorProvider);
    }

}
