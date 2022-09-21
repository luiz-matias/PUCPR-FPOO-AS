package LojaJogos;

import java.io.*;
import java.util.ArrayList;

public class ArquivosLoja {

    private ArrayList<Produto> produtos;

    public ArquivosLoja() {
        this.produtos = new ArrayList<>();
    }

    public void adicionaProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
        System.out.println("Total = " + this.produtos.size() + " produtos listados com sucesso!\n");
    }

    public void excluirProduto(Produto produto) {
        if (this.produtos.contains(produto)) {
            this.produtos.remove(produto);
            System.out.println("[Produto " + produto.toString() + "excluido com sucesso!]\n");
        } else
            System.out.println("Produto inexistente!\n");
    }

    public void excluirProdutos() {
        produtos.clear();
        System.out.println("Produtos excluidos com sucesso!\n");
    }

    public void gravarProdutos() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"));
            for (Produto produto : produtos) {
                outputStream.writeObject(produto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void recuperarProdutos() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("produtos.dat"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Jogo)
                    this.produtos.add((Jogo) obj);
                else if (obj instanceof Eletronico)
                    this.produtos.add((Eletronico) obj);
                else if (obj instanceof Assinatura)
                    this.produtos.add((Assinatura) obj);
            }
        } catch (EOFException ex) {     // when EOF is reached
            System.out.println("Fim do arquivo");
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                    System.out.println("Produtos recuperados com sucesso!\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ArquivosLoja loja = new ArquivosLoja();

        Jogo counterStrike = new Jogo("Counter-Strike", "Jogo desenvolvido em 1999", 19.90, "Valve", "Tiro", 18);
        Jogo godOfWar = new Jogo("God Of War", "Jogo desenvolvido em 2018", 199.90, "Santa Monica Studios", "Aventura", 16);
        Eletronico playstation5 = new Eletronico("Playstation 5", "Console desenvolvido em 2020", 4599.90, "Sony", "B0B3Z4WB52", CondicaoEletronico.NOVO);
        Assinatura playstationPlus = new Assinatura("Playstation+", "Serviço de assinatura da Sony/Playstation", 139.90, "Playstation Plus", 90, "ABCDE-12345-54321-EDCBA");

        loja.adicionaProduto(counterStrike);
        loja.adicionaProduto(godOfWar);
        loja.adicionaProduto(playstation5);
        loja.adicionaProduto(playstationPlus);
        loja.listarProdutos();
        loja.gravarProdutos();
        loja.excluirProduto(godOfWar);
        loja.listarProdutos();
        loja.excluirProdutos();
        loja.listarProdutos();
        loja.recuperarProdutos();
        loja.listarProdutos();
    }

}
