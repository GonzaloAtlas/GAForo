package com.gapi.GAForo.domain.topico;

import com.gapi.GAForo.domain.autor.Autor;
import com.gapi.GAForo.domain.autor.DatosAutor;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   DatosAutor autor,
                                   Curso curso) {
}
