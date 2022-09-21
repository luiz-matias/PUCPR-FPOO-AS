package LojaJogos;

public class Jogo extends Produto {

    private String desenvolvedora;
    private String genero;
    private int faixaEtariaMinima;

    public Jogo(String nome, String descricao, double preco, String desenvolvedora, String genero, int faixaEtariaMinima) {
        super(nome, descricao, preco);
        this.desenvolvedora = desenvolvedora;
        this.genero = genero;
        this.faixaEtariaMinima = faixaEtariaMinima;
    }

    @Override
    public String apresentar() {
        return "Este jogo foi desenvolvido pela " + desenvolvedora + " com o intuito de atingir e divertir os fãs com " + faixaEtariaMinima + " anos ou mais que amam o gênero de " + genero + ". Leve sua cópia agora mesmo!";
    }
}
