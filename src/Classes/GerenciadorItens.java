/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Utils.ReadFile.readFile;
import java.util.ArrayList;

/**
 *
 * @author Izadora
 */
public class GerenciadorItens {
    private ArrayList <Produtos> listaItens = new ArrayList();
    
     public GerenciadorItens(ArrayList lista){
        listaItens = lista;
    }
   
    public GerenciadorItens(){
        listaItens = new ArrayList();
    }
    @Override
    public String toString() {
        return listaItens.toString();
}
    
    
    public void Produto(String codigo){
    ArrayList<String> arr = readFile("produtos.txt");
        for(String ss : arr) {
        String[] s = ss.split(";");
        for (int i = 0; i < 1; i++) {
            if(s[0].equals(codigo)){
                Produtos p = new Produtos((s[0]), s[1], Double.parseDouble(s[2]));
                listaItens.add(p);
                ItemVenda.setProduto(p);
            }
        }
        }
    listaItens.clear();
    }   
}
