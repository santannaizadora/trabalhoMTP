/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Utils.ReadFile.readFile;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Izadora
 */
public class ItemVenda {
    private static Produtos produto;
    private int quantidade;
    

    public ItemVenda() {
        this.produto = new Produtos();
        this.quantidade = 0;
        
    }

    public ItemVenda(int codigo) {
        this.produto = new Produtos();
        this.quantidade = 0;
        
    }

    public Produtos getProduto() {
        return produto;
    }

    public static void setProduto(Produtos produto) {
        ItemVenda.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String salvarItens() throws IOException{
         FileWriter fw = new FileWriter("itemVenda.txt",true );
        PrintWriter pw = new PrintWriter(fw);
        pw.print(getProduto() + ";" + getQuantidade()+"\n");
        pw.flush();
        pw.close();
        fw.close();
        return null;
    }


}


