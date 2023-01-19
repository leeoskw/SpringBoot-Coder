package com.example.demo.controllers;

import com.example.demo.models.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/ellie")
    public Client getClient(){
        return new Client(1L, "Ellie, The Cat", "2");
    }

    @GetMapping("/{id}")
    public Client getClientById1(@PathVariable Long id){
        return new Client(id, "Leo, The Human", "123.456.789-99");
    }

    // pra cair nessa requisição, tem que passar na url o parâmetro id: http://localhost:8080/client?id=22
    @GetMapping
    public Client getClientById2(@RequestParam(name = "id") Long id){
        return new Client(id, "Leo, The Human", "123.456.789-99");
    }
}
