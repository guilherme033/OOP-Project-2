package com.example.avaliacaofinal.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cliente {
    
    int     codigo;
    String  nome;
    String  endereco; 
    String  cpf;

    @JsonIgnore
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean addReserva(Reserva reserva) {
        return reservas.add(reserva);
    }

    public boolean removeReserva(Reserva reserva) {
        return reservas.remove(reserva);
    }

    public double somaTotalReservas() {
        double soma = 0;

        for (Reserva reserva : reservas) {
            soma += reserva.totalReserva();
        }

        return soma;
    }

    public double somaTotalReservasEncerradas() {
        double soma = 0;

        for (Reserva reserva: reservas) {
            if (reserva.isReservaFechada()) {
                soma += reserva.totalReserva();
            }
        }

        return soma;
    }
}
