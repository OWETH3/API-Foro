package com.alura.api.foroManager;

import jakarta.validation.constraints.NotBlank;

public record authenticationManager(
        @NotBlank
        String login,
        @NotBlank
        String clave
) {

}
