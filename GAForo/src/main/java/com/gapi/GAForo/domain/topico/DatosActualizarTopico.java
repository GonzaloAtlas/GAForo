package com.gapi.GAForo.domain.topico;

import com.gapi.GAForo.domain.autor.Autor;
import com.gapi.GAForo.domain.autor.DatosAutor;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull
                                    Long id,
                                    String titulo,
                                    String mensaje,
                                    DatosAutor autor) {

}
