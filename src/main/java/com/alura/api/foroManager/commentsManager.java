package com.alura.api.foroManager;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record commentsManager(
        @NotNull
        @JsonAlias("id") Long Id,
        @NotBlank
        @JsonAlias("titulo") String Titulo,
        @NotBlank
        @JsonAlias("mensaje") String Mensaje,
        @NotBlank
        @JsonAlias("fechaCreación") String Fecha,
        @NotNull
        @JsonAlias("status") boolean Estado,
        @NotBlank
        @JsonAlias("autor") String Autor,
        @NotBlank
        @JsonAlias("curso") String NombreCurso
        ) {
}
