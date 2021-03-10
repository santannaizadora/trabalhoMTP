/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Izadora
 */
public class Produtos {
    private String codigo;
    private String nome;
    private Double precoVenda;


    public Produtos() {
        this.codigo = "";
        this.nome = "";
        this.precoVenda = 0.0;

    }
    public Produtos(String codigo, String nome, double preco ) {
        this.codigo = codigo;  
        this.nome = nome;
        this.precoVenda = preco;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return getCodigo() + ";" + getNome() + ";" + getPrecoVenda();
    }


    public String salvarProduto() throws IOException {
        FileWriter fw = new FileWriter("produtos.txt",true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(getCodigo() + ";" + getNome() + ";" + getPrecoVenda()+"\n");
        pw.flush();
        pw.close();
        fw.close();
        return null;
    }
}




