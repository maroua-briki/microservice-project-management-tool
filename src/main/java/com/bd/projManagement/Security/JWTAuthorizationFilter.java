package com.bd.projManagement.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin","*"); //Autotoriser les appli de tout les domaines d'envoyer des req (domaines: localhost:4200 : angular)
        response.addHeader("Access-Control-Allow-Headers","Origin,Accept,X-Requested-with, " + //autoriser les navigateurs à envoyer des req avec tt ses entete
                "Content-type,Access-Control-Request-Method,Access-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Allow-Headers","Origin,Accept,X-Requested-with, Content-type,Access-Control-Allow-Origin,Access-Control-Allow-Credentials,authorization");
        response.addHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,PATCH");
        if (request.getMethod().equals(("OPTIONS"))){
            response.setStatus(HttpServletResponse.SC_OK);

        }
        else
        {String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);



            Claims claims= Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws((jwtToken.replace(SecurityConstants.TOKEN_PREFIX,"")))
                    .getBody();
            String username=claims.getSubject();
//System.out.println(username);
            ArrayList<Map<String,String>> roles=(ArrayList<Map<String, String>>)claims.get("roles");
            System.out.print(roles);
            Collection<GrantedAuthority> authorities=new ArrayList<>();
            roles.forEach(r->{
                authorities.add(new SimpleGrantedAuthority(r.get("authority")));
            });
            UsernamePasswordAuthenticationToken authenticationToken=
                    new UsernamePasswordAuthenticationToken(username,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request,response);
        }

    }
}
