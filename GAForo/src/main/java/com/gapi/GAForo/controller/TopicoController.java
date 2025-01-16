package com.gapi.GAForo.controller;

import com.gapi.GAForo.domain.topico.DatosDeRegistroDeTopico;
import com.gapi.GAForo.domain.autor.DatosAutor;
import com.gapi.GAForo.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepositorio;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid  DatosDeRegistroDeTopico datosDeRegistroDeTopico,
                                          UriComponentsBuilder uriComponentsBuilder){
        System.out.println("El request llega correctamente");
        Topico topico = topicoRepositorio.save(new Topico(datosDeRegistroDeTopico));
        //Return 201 created
        //URL donde encontrar topico http://localhost:8080/topicos/xx
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                new DatosAutor(topico.getAutor().getNombre(),
                        topico.getAutor().getEdad(),
                        topico.getAutor().getTelefono(),
                        topico.getAutor().getCorreo()),
                topico.getCurso());
        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion){
//        return topicoRepositorio.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(topicoRepositorio.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepositorio.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(
                new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                        new DatosAutor(topico.getAutor().getNombre(),
                                topico.getAutor().getEdad(),
                                topico.getAutor().getTelefono(),
                                topico.getAutor().getCorreo()),
                        topico.getCurso()));
    }

    // Delete Logico (No elimina datos de la base de datos)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepositorio.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
    // Delete NO logico, si elimina datos de la base de datos
    //    public void eliminarTopico(@PathVariable Long id){
    //        Topico topico = topicoRepositorio.getReferenceById(id);
    //        topicoRepositorio.delete(topico);
    //    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepositorio.getReferenceById(id);
        topico.desactivarTopico();
        var  datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                new DatosAutor(topico.getAutor().getNombre(),
                        topico.getAutor().getEdad(),
                        topico.getAutor().getTelefono(),
                        topico.getAutor().getCorreo()),
                topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }
}
