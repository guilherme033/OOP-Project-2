package com.example.avaliacaofinal.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.example.avaliacaofinal.dto.ClienteDTO;
import com.example.avaliacaofinal.dto.ReservaDTO;
import com.example.avaliacaofinal.model.Cliente;
import com.example.avaliacaofinal.model.Reserva;
import com.example.avaliacaofinal.service.ClienteService;
import com.example.avaliacaofinal.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

@Autowired
private ClienteService clienteservice;

@Autowired
private ReservaService reservaservice;

@GetMapping()
public List<Cliente> getClintes(){
return clienteservice.getAllClientes();
}

@GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClienteByCodigo(@PathVariable int codigo) {
    Cliente cliente = clienteservice.getClienteByCodigo(codigo);
    return ResponseEntity.ok(cliente);
}

@GetMapping("/{idcliente}/reservas")
    public List<ReservaDTO> getVeiculosCliente(@PathVariable int idcliente) {
    Cliente cliente = clienteservice.getClienteByCodigo(idcliente);
    return reservaservice.toListDTO(cliente.getReservas());
}

@PostMapping()
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletRequest request, UriComponentsBuilder builder) 
{
    Cliente cliente = clienteservice.fromDTO(clienteDTO);
    Cliente novocliente = clienteservice.save(cliente);
    UriComponents  uricomponents = builder.path(request.getRequestURI() + "/" + novocliente.getCodigo()).build();
    return ResponseEntity.created(uricomponents.toUri()).build();
}

@PostMapping("/{idcliente}/reservas")
    public ResponseEntity<Cliente> save(@PathVariable int idcliente, @RequestBody Reserva reserva, HttpServletRequest request, UriComponentsBuilder builder) 
{
    reserva = reservaservice.save(reserva, idcliente);
    UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + reserva.getNumero()).build();
    return ResponseEntity.created(uriComponents.toUri()).build();
}

@DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remove(@PathVariable int codigo) {
    clienteservice.removeByCodigo(codigo);
    return ResponseEntity.noContent().build();
}

@PutMapping("/{codigo}")
    public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO, @PathVariable int codigo) {
    Cliente cliente = clienteservice.fromDTO(clienteDTO);
    cliente.setCodigo(codigo);
    cliente = clienteservice.update(cliente);
    return ResponseEntity.ok(cliente);
}

}






   
