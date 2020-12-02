package com.example.avaliacaofinal.controller;

import java.util.List;
import com.example.avaliacaofinal.model.Reserva;
import com.example.avaliacaofinal.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reservas")
public class ReservaController {

@Autowired
private ReservaService service;

@GetMapping
    public List<Reserva> getAllReservas() {
    return service.getAllReservas();
}

@GetMapping("/{numero}")
    public ResponseEntity<Reserva> getReservaByNumero(@PathVariable long numero) {
    Reserva reserva = service.getReservaByNumero(numero);
    return ResponseEntity.ok(reserva);	
    }
}
