package com.example.avaliacaofinal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.avaliacaofinal.dto.ReservaDTO;
import com.example.avaliacaofinal.model.Cliente;
import com.example.avaliacaofinal.model.Reserva;
import com.example.avaliacaofinal.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ReservaService {

@Autowired
private ReservaRepository repository;

@Autowired
private ClienteService clienteservice;

public List<Reserva> getAllReservas(){
return repository.getAllReservas();
}
    
public Reserva getReservaByNumero(long numero) {
    Optional<Reserva> op = repository.getReservaByNumero(numero);
	return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva nao cadastrada"));
}

public Reserva save(Reserva reserva, int idcliente){
    Cliente cliente = clienteservice.getClienteByCodigo(idcliente);
    
    reserva.setDataReserva(LocalDateTime.now());     
    reserva.setCliente(cliente);
    cliente.addReserva(reserva);
    return repository.save(reserva);
        
}

public ReservaDTO toDTO(Reserva reserva){
    ReservaDTO dto = new ReservaDTO();
    dto.setDataReserva(reserva.getDataReserva());
    dto.setDescricao(reserva.getDescricao());
    dto.setVeiculos(reserva.getVeiculos());
    dto.setNumero(reserva.getNumero());
    dto.setReservaEncerrada(reserva.isReservaFechada());
    dto.setTotalReserva(reserva.totalReserva());
    return dto;
}

public List<ReservaDTO> toListDTO(List<Reserva> reservas){
    ArrayList<ReservaDTO> listDTO = new ArrayList<ReservaDTO>();
        for(Reserva r: reservas){
            listDTO.add(toDTO(r));
        }
        return listDTO;
    }


}
