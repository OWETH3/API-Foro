package com.alura.api.controller;

import com.alura.api.foroManager.authenticationManager;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager Manager;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid authenticationManager authenticationManager){
        Authentication token = new UsernamePasswordAuthenticationToken(authenticationManager.login(), authenticationManager.clave());
        Manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
