package com.example.avaliacaofinal.model;

public class Veiculo {

    int     codigo;
    String  modelo; 
    double  valordiaria;
    int     quantidade;

    public Veiculo(){
    }

    public Veiculo(int codigo, String modelo, double valordiaria, int quantidade) {
		this.codigo = codigo;
		this.modelo = modelo;
        this.valordiaria = valordiaria;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotalVeiculo(){
        return valordiaria * quantidade;
    }
    
    
}
