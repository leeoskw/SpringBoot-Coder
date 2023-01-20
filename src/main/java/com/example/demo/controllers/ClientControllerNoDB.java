package com.example.demo.controllers;

import com.example.demo.models.entities.ClientNoDB;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientControllerNoDB {

    @GetMapping("/ellie")
    public ClientNoDB getClient(){
        return new ClientNoDB(1L, "Ellie, The Cat", "2");
    }

    @GetMapping("/{id}")
    public ClientNoDB getClientById1(@PathVariable Long id){
        return new ClientNoDB(id, "Leo, The Human", "123.456.789-99");
    }

    // pra cair nessa requisição, tem que passar na url o parâmetro id: http://localhost:8080/client?id=22
    @GetMapping
    public ClientNoDB getClientById2(@RequestParam(name = "id") Long id){
        return new ClientNoDB(id, "Leo, The Human", "123.456.789-99");
    }
}
