package com.example.avaliacaofinal.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.avaliacaofinal.model.Veiculo;

public class ReservaDTO {
    private long numero;
    private String descricao;
    private LocalDateTime dataReserva;
    private LocalDateTime inicio;
    private boolean reservaEncerrada;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    private double totalReserva;

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

    public boolean isReservaEncerrada() {
        return reservaEncerrada;
    }

    public void setReservaEncerrada(boolean reservaEncerrada) {
        this.reservaEncerrada = reservaEncerrada;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
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
