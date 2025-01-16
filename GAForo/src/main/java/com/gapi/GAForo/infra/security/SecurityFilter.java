package com.gapi.GAForo.infra.security;

import com.gapi.GAForo.domain.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("El filtro esta siendo llamado, inicio del filtro");
        // obtener el token del Header
        var authHeader = request.getHeader("Authorization");//.replace("Bearer ", "");
        System.out.println(authHeader);
        /*if(token == null || token == ""){
            throw new RuntimeException("El token enviado no es valido");
        }*/
        if(authHeader != null){
            /*System.out.println("Validamos que el token no es null en SecurityFilter");*/
            var token = authHeader.replace("Bearer ", "");
            var userName = tokenService.getSubject(token); //Extract username
            if(userName != null){
                // Token valido
                var usuario = usuarioRepository.findByLogin(userName);
                var authentication =
                        new UsernamePasswordAuthenticationToken(usuario, null,
                                usuario.getAuthorities()); //Forzando Inicio de Sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }
}
