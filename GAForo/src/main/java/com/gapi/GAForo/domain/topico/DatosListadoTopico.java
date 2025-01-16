package com.gapi.GAForo.domain.topico;

import com.gapi.GAForo.domain.autor.Autor;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 Autor autor,
                                 Curso curso) {


    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(),topico.getAutor(), topico.getCurso());
    }


}
