package com.alura.api.Model;

import com.alura.api.foroManager.commentsManager;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "comments")
@Getter
public class commentsModel {
    @Id
    @Column(unique = true)
    private Long id;
    String Titulo;
    String Mensaje;
    String Fecha;
    String Estado;
    String Autor;
    String NombreCurso;

    public commentsModel(){}

    public commentsModel(commentsManager comment) {
        this.id = comment.Id();
        this.Titulo = comment.Titulo();
        this.Mensaje = comment.Mensaje();
        this.Fecha = comment.Fecha();
        this.Autor = comment.Autor();
        this.NombreCurso = comment.NombreCurso();

        if (comment.Estado() == true) this.Estado = "Resuelto";
        else this.Estado = "Sin Resolver";
    }

}
