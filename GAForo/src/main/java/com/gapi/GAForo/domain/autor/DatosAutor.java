package com.gapi.GAForo.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutor(@NotBlank
                         String nombre,
                         @NotBlank
                         String edad,
                         @NotBlank
                         String telefono,
                         @NotBlank
                         @Email
                         String correo) {
}
