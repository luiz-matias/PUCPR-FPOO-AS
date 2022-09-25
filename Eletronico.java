package LojaJogos;

public class Eletronico extends Produto {

    private String marca;
    private String modelo;
    private CondicaoEletronico condicao;

    public Eletronico(double id, String nome, String descricao, double preco, String marca, String modelo, CondicaoEletronico condicao) {
        super(id, nome, descricao, preco);
        this.marca = marca;
        this.modelo = modelo;
        this.condicao = condicao;
    }

    @Override
    public String apresentar() {
        String apresentacao = "";

        switch (condicao) {
            case NOVO:
                apresentacao = "Este novíssimo equipamento foi feito pela " + marca + " (modelo " + modelo + "). O mesmo está em condições perfeitas para uso e nunca foi tirado da caixa!";
                break;
            case SEMINOVO:
                apresentacao = "Este é um equipamento feito pela " + marca + " (modelo " + modelo + ") e apesar de seminovo, está em condições perfeitas e sem apresentar nenhum sinal de uso!";
                break;
            case USADO:
                apresentacao = "Este é um equipamento feito pela " + marca + " (modelo " + modelo + ") e que já apresenta condições de uso, mas que está em perfeito estado para ainda ter uma longa vida útil.";
                break;
        }

        return apresentacao;
    }
}