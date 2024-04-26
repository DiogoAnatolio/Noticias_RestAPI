package com.example.Noticias_RestAPI.controller;

import com.example.Noticias_RestAPI.model.NoticiasEntity;
import com.example.Noticias_RestAPI.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private NoticiasService service;

    @GetMapping("/noticias")
    public String consultarNoticias(){
        return service.consultarNoticias();
    }

    @GetMapping("/release")
    public String consultarRelease(){ return service.consultarRelease(); }
    @GetMapping("/noticiaserelease")
    public String consultarNoticiaseRelease(){ return service.consultarNoticiaseRelease(); }

    @PostMapping("/novasnoticias")
    public NoticiasEntity adicionarNoticia(@RequestBody NoticiasEntity novaNoticia) { return service.inserirNoticia(novaNoticia);
    }

    @PostMapping("/novasrelease")
    public NoticiasEntity adicionarRelease (@RequestBody NoticiasEntity novaRelease) { return service.inserirRelease(novaRelease);
    }

}