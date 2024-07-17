package com.alura.api.controller;

import com.alura.api.Model.ICommentModel;
import com.alura.api.Model.commentsModel;
import com.alura.api.Response.ApiResponse;
import com.alura.api.foroManager.commentsManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comments")
public class commentsController {

    @Autowired
    private ICommentModel commentModel;

    //Obtener los datos de la BD MySQL
    @GetMapping
    public Page<commentsModel> getComments(Pageable pageable){
        return commentModel.findAll(pageable);
    }

    //Registrar los comentarios, y meterlos en la base de datos.
    @PostMapping
    public void postComments(@RequestBody  @Valid commentsManager commentJson){
        commentsModel model = new commentsModel(commentJson);
        commentModel.save(model);
        System.out.println("Se agrego un nuevo comentario.");
        ResponseEntity.noContent().build();
    }

    //Borrar comentarios.
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteComments(@PathVariable Long id){
        if (commentModel.existsById(id)){
            commentModel.deleteById(id);
            ApiResponse response = new ApiResponse("Borrar Comentario", true, "Se ha Borrado Correctamente.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response = new ApiResponse("Borrar Comentario", false, "Comentario No Encontrado.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar comentarios.i
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> putComments(@PathVariable Long id, @RequestBody @Valid commentsManager Comment){
        if (commentModel.existsById(id)){
            commentsModel model = new commentsModel(Comment);
            commentModel.save(model);
            ApiResponse response = new ApiResponse("Actualizar Comentario", true, "Se ha Actualizado Correctamente.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response = new ApiResponse("Actualizar Comentario", false, "Comentario No Encontrado.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
