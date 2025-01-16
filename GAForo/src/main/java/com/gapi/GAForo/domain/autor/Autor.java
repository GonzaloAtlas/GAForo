package com.gapi.GAForo.domain.autor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Embeddable
@Getter
// @NoArgsConstructor
@AllArgsConstructor
public class Autor {
    private String nombre;
    private String edad;
    private String telefono;
    private String correo;

    public Autor(){}

    public Autor(DatosAutor autor) {
        this.nombre= autor.nombre();
        this.edad = autor.edad();
        this.telefono = autor.telefono();
        this.correo = autor.correo();
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEdad() {return edad;}

    public void setEdad(String edad) {this.edad = edad;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public Autor actualizarDatos(DatosAutor autor) {
        this.nombre = autor.nombre();
        return  this;
    }
}
