package LojaJogos;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LojaJogos {
    private ArrayList<Produto> produtos;

    public LojaJogos() {
        this.produtos = new ArrayList<Produto>();
    }

    public String[] leValores(String[] dadosIn) {
        String[] dadosOut = new String[dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i] + ": ");

        return dadosOut;
    }

    public Jogo leJogo() {

        String[] valores = new String[7];
        String[] nomeVal = { "ID", "Nome", "Descrição", "Preço", "Desenvolvedora", "Gênero", "Faixa Etária Mínima" };
        valores = leValores(nomeVal);

        int faixaEtaria = this.retornaInteiro(valores[6]);

        Jogo jogo = new Jogo(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], faixaEtaria);
        return jogo;
    }

    public Eletronico leEletronico() {

        String[] valores = new String[7];
        String[] nomeVal = { "ID", "Nome", "Descrição", "Preço", "Marca", "Modelo", "Condição do Eletrônico" };
        valores = leValores(nomeVal);

        int condicaoElet = this.retornaInteiro(valores[6]);

        Eletronico elet = new Eletronico(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5],
                condicaoElet);
        return elet;
    }

    public Assinatura leAssinatura() {

        String[] valores = new String[7];
        String[] nomeVal = { "ID", "Nome", "Descrição", "Preço", "Nome do Serviço", "Duração (Quantidade de dias)",
                "Chave de Ativação" };
        valores = leValores(nomeVal);

        int duracao = this.retornaInteiro(valores[5]);

        Assinatura assinatura = new Assinatura(valores[0], valores[1], valores[2], valores[3], valores[4], duracao,
                valores[6]);
        return assinatura;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // Tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // Gera um erro se não conseguir transformar
            return false;
        }
    }

    public int retornaInteiro(String entrada) { // retorna um valor inteiro

        // Permanece no loop enquanto não conseguir converter para inteiro, repetindo o
        // input do usuário
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nPor favor, digite um número inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    /*
     * TODO Implementar Sistema de UI para interagir com os objetos (JOptionPane)
     * - 1. Inserir
     * - 2. Exibir
     * - 3. Limpar
     * - 4. Gravar em arquivo
     * - 5. Recuperar de arquivo
     * - 9. Sair
     */

    public void menuLojaJogos() {
        String menu = "";
        String entrada;
        int opc1, opc2;

        do {
            menu = "Controle LojaJogos\n" +
                    "Opções:\n" +
                    "1. Entrar Produtos\n" +
                    "2. Exibir Produtos\n" +
                    "3. Limpar Produtos\n" +
                    "4. Gravar Produtos\n" +
                    "5. Recuperar Produtos\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog(menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Produtos da LojaJogos\n" +
                            "Opções:\n" +
                            "1. Jogo\n" +
                            "2. Eletrônico\n" +
                            "3. Assinatura\n";

                    entrada = JOptionPane.showInputDialog(menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2) {
                        case 1:
                            produtos.add((Produto) leJogo());
                            break;
                        case 2:
                            produtos.add((Produto) leEletronico());
                            break;
                        case 3:
                            produtos.add((Produto) leAssinatura());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Não foi escolhido um produto para registro!");
                    }

                    break;

                case 2: // Exibir dados
                    if (produtos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Primeiramente, registre produtos");
                        break;
                    }
                    String dados = "";
                    for (int i = 0; i < produtos.size(); i++) {
                        dados += produtos.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null, dados);
                    break;
                case 3: // Limpar Dados
                    if (produtos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Entre com produtos primeiramente");
                        break;
                    }
                    produtos.clear();
                    JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (produtos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Entre com produtos primeiramente");
                        break;
                    }
                    // salvaProdutos(produtos);
                    JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    produtos = recuperaProdutos();
                    if (produtos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Fim do aplicativo LojaJogos");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main(String[] args) {

        LojaJogos loja = new LojaJogos();
        loja.menuLojaJogos();
    }

}
