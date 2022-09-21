package LojaJogos;

public enum CondicaoEletronico {
    NOVO(1), SEMINOVO(2), USADO(3);

    public final int condicaoEletronico;

    CondicaoEletronico(int condicaoEletronico) {
        this.condicaoEletronico = condicaoEletronico;
    }
}