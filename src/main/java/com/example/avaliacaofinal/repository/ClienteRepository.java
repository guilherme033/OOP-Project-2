package com.example.avaliacaofinal.repository;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import com.example.avaliacaofinal.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    private List<Cliente> clientes;
    private int next;

@PostConstruct
public void criarClientes(){
    Cliente c1 = new Cliente();
    Cliente c2 = new Cliente();
    Cliente c3 = new Cliente();

    c1.setCodigo(1);
    c1.setNome("João");
    c1.setEndereco("Rua A, 160");
    c1.setCpf("444.444.555-55");

    c2.setCodigo(2);
    c2.setNome("Maria");
    c2.setEndereco("Rua B, 170");
    c2.setCpf("777.777.888-88");

    c3.setCodigo(3);
    c3.setNome("Gabriela");
    c3.setEndereco("Rua C, 180");
    c3.setCpf("999.444.666-11");

    next = 4;
}

public List<Cliente> getAllClientes() {
    return clientes;
}

public Optional<Cliente> getClienteByCodigo(int codigo) {
    for (Cliente aux : clientes) {
        if (aux.getCodigo() == codigo) {
            return Optional.of(aux);
        }
    }
    return Optional.empty();
}

public Cliente save(Cliente cliente) {
    cliente.setCodigo(next++);
    clientes.add(cliente);
    return cliente;
}

public void remove(Cliente cliente) {
    clientes.remove(cliente);
}

public Cliente update(Cliente cliente) {

    Cliente aux = getClienteByCodigo(cliente.getCodigo()).get();

    if(aux != null){
        aux.setEndereco(cliente.getEndereco());
        aux.setNome(cliente.getNome());
   
    }

    return aux;
}
    
}
