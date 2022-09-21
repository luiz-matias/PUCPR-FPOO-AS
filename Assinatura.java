package LojaJogos;

public class Assinatura extends Produto {

    private String nomeServico;
    private int quantidadeDias;
    private String codigoAtivacao;

    public Assinatura(String nome, String descricao, double preco, String nomeServico, int quantidadeDias, String codigoAtivacao) {
        super(nome, descricao, preco);
        this.nomeServico = nomeServico;
        this.quantidadeDias = quantidadeDias;
        this.codigoAtivacao = codigoAtivacao;
    }

    @Override
    public String apresentar() {
        return "Esta assinatura lhe permitirá desfrutar dos serviços da(o) " + nomeServico + " por " + quantidadeDias + " dias! Basta ativar o código " + codigoAtivacao + " na plataforma " + nomeServico + " para utilizá-lo!";
    }

}