package com.gapi.GAForo.domain.topico;

import com.gapi.GAForo.domain.autor.Autor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private String status;
    @Embedded
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private boolean activo;


    public Topico(){}

    public Topico(@Valid DatosDeRegistroDeTopico datosDeRegistroDeTopico) {
        this.activo = true;
        this.id = datosDeRegistroDeTopico.id();
        this.titulo = datosDeRegistroDeTopico.titulo();
        this.mensaje = datosDeRegistroDeTopico.mensaje();
        this.fechaDeCreacion = datosDeRegistroDeTopico.fechaDeCreacion();
        this.status = datosDeRegistroDeTopico.status();
        this.autor = new Autor(datosDeRegistroDeTopico.autor());
        this.curso = datosDeRegistroDeTopico.curso();
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getMensaje() {return mensaje;}

    public void setMensaje(String mensaje) {this.mensaje = mensaje;}

    public LocalDateTime getFechaDeCreacion() {return fechaDeCreacion;}

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public Autor getAutor() {return autor;}

    public void setAutor(Autor autor) {this.autor = autor;}

    public Curso getCurso() {return curso;}

    public void setCurso(Curso curso) {this.curso = curso;}

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.titulo = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.autor() != null){
            this.autor = autor.actualizarDatos(datosActualizarTopico.autor());
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
