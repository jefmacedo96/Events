package br.ufc.crateus.events.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomAuthenticatorProvider implements AuthenticationProvider {

//	@Autowired
//	private LoginService loginService;
//	private Logger logger = LoggerFactory.getLogger(CustomAuthenticatorProvider.class);

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String nome = authentication.getName();
		Object credenciais = authentication.getCredentials();
		System.out.println("Entrou no basic");
//		if (!(credenciais instanceof String)) {
//			throw new BadCredentialsException("Invalid password");
//		}
		String senha = credenciais.toString();

//		Servidor servidor = null;
//		try {
//			servidor = loginService.login(nome, Utils.cripty(senha));
//		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		if (servidor == null)
//			throw new BadCredentialsException("Login ou senha invalidos");
//
//		logger.debug("authenticate: " + servidor);
//
//		Set<GrantedAuthority> autorizacoes = new HashSet<GrantedAuthority>();
//		for (Perfil perfil : servidor.getPerfis()) {
//			autorizacoes.addAll(perfil.getPermissoes());
//		}
		return new UsernamePasswordAuthenticationToken(nome, senha, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
