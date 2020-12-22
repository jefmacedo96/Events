package br.ufc.crateus.events.service;


import br.ufc.crateus.events.service.http.Payload;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class TokenAuthenticationService {

    // EXPIRATION_TIME = 10 dias
    static final String HEADER_STRING = "Authorization";
    static final String APP_ID = "d68448cd-fb61-4ca3-9fdf-2abcc1f81b6c";


    public static Authentication getAuthentication(HttpServletRequest request) {
        OkHttpClient client = new OkHttpClient();

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            try {
                Request requestAuth = new Request.Builder()
                        .url("http://npds.crateus.ufc.br:8102/oauth/token/isValid")
                        .addHeader("Authorization", token)
                        .addHeader("X-APP-ID", APP_ID)
                        .build();

                try (Response response = client.newCall(requestAuth).execute()) {

                    if (response.code() == 200) {
                        Gson gson = new Gson();
                        Payload payload = gson.fromJson(response.body().string(), Payload.class);
                        
                        return new UsernamePasswordAuthenticationToken(payload.getId(),payload, Collections.emptyList());
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            // Collections.emptyList());
            // faz parse do token
            // String user =
            // Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,
            // "")).getBody()
            // .getSubject();

            // if (user != null) {
            // return new UsernamePasswordAuthenticationToken(user, null,
            // Collections.emptyList());
            // }
        }
        return null;
    }

}