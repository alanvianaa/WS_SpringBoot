package com.alan.demows.resources;

import com.alan.demows.models.Evento;
import com.alan.demows.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoResource {

    @Autowired
    private EventoRepository er;

    @GetMapping(produces="application/json")
    public @ResponseBody Iterable<Evento> listaEventos(){
        Iterable<Evento> listaEventos = er.findAll();

        return listaEventos;
    }

    @PostMapping()
    public Evento cadastroEvento(@RequestBody @Valid Evento evento){
        return er.save(evento);
    }

    @DeleteMapping()
    public Evento deletaEvento(@RequestBody Evento evento){
        er.delete(evento);
        return evento;
    }

}
