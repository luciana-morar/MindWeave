package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Permite aplicației React (Vite) să ceară date
public class TestController {

    @GetMapping("/api/test")
    public Map<String, String> testConnection() {
        return Map.of(
                "status", "Activ",
                "mesaj", "Conexiunea dintre React și Spring Boot funcționează perfect!"
        );
    }
}

