package com.gapi.GAForo.domain.topico;

import com.gapi.GAForo.domain.autor.DatosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDeRegistroDeTopico(Long id,
                                      @NotBlank
                                      String titulo,
                                      @NotBlank
                                      String mensaje,
                                      @NotNull
                                      LocalDateTime fechaDeCreacion,
                                      @NotBlank
                                      String status,
                                      @Valid
                                      DatosAutor autor,
                                      @NotNull
                                      Curso curso) {
}