package com.example.avaliacaofinal.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Reserva {

private long numero;
private String descricao;
@JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
private LocalDateTime   dataReserva;
private LocalDateTime   inicio;
private Cliente cliente;
private boolean reservaFechada;

private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();


public Reserva(){
}

public Reserva(long numero) {
    this.numero = numero;
}

public long getNumero() {
    return numero;
}

public void setNumero(long numero) {
    this.numero = numero;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

public boolean isReservaFechada() {
    return reservaFechada;
}

public void setReservaFechada(boolean reservaFechada) {
    this.reservaFechada = reservaFechada;
}

public ArrayList<Veiculo> getVeiculos() {
    return veiculos;
}

public void setVeiculos(ArrayList<Veiculo> veiculos) {
    this.veiculos = veiculos;
}

public boolean addVeiculo(int codigo, String modelo, Double valordiaria, int quantidade) {
    return veiculos.add(new Veiculo(codigo, modelo, valordiaria, quantidade));
}

@JsonGetter
public double totalReserva() {
    double total = 0;

    for (Veiculo veiculo : veiculos) {
        total += veiculo.getTotalVeiculo();
    }
    return total;
}


@Override
public String toString() {
    return "Reserva [Cliente = " + cliente.getCodigo() + ", Data do Pedido = " + dataReserva + ", Descrição = " + descricao
            + ", Numero = " + numero + "]";
}

public LocalDateTime getDataReserva() {
    return dataReserva;
}

public void setDataReserva(LocalDateTime dataReserva) {
    this.dataReserva = dataReserva;
}

public LocalDateTime getInicio() {
    return inicio;
}

public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
}

}
