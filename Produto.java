package LojaJogos;

import java.io.Serializable;

public abstract class Produto implements Serializable {

    private double id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(double id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String toString() {
        String retorno = "";
        retorno += "ID " + this.id + "\n";
        retorno += "Nome: " + this.nome + "\n";
        retorno += "Descrição: " + this.descricao + "\n";
        retorno += "Preço: R$ " + this.preco + "\n";
        retorno += "Apresentação do produto: " + this.apresentar() + "\n";
        return retorno;
    }

    public abstract String apresentar();
}
