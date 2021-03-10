/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Utils.ReadFile.readFile;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Izadora
 */
public class GerenciadorVendas {
        private ArrayList <Vendas> listaVendas = new ArrayList();
        private ArrayList <Produtos> listaProdutos = new ArrayList();
    
     public GerenciadorVendas(ArrayList lista){
        listaVendas = lista;
    }
   
    public GerenciadorVendas(){
        listaVendas = new ArrayList();
    }
    @Override
    public String toString() {
        return listaVendas.toString();
    }
    public double ValorTotal(String codigo, int quant){
  ArrayList<String> arr = readFile("produtos.txt");
            for(String ss : arr) {
            String[] s = ss.split(";");
            for (int i = 0; i < 1; i++) {
                Produtos p = new Produtos((s[0]), s[1], Double.parseDouble(s[2]));
		listaProdutos.add(p);
            }
            }
        double valor = 0;
        for(int i=0; i<listaProdutos.size();i++){
            if(listaProdutos.get(i).getCodigo().equals(codigo)){
               valor = listaProdutos.get(i).getPrecoVenda();
            }
        }
        double soma = 0;
        soma += valor * quant;
        listaProdutos.clear();
   return soma;
}
    public void listarVendas() throws ParseException{
       ArrayList<String> arr = readFile("vendas.txt");
        try{
            for(String ss : arr) {
            String[] s = ss.split(";");
            for (int i = 0; i < 1; i++) {
                Vendas v = new Vendas((s[0]), Vendas.formato.parse(s[1]), Double.parseDouble(s[2]));
		listaVendas.add(v);
		}
	}
        }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"Erro");
                
        }
    }
    
    public void consultaPeriodo(Date data1, Date data2) throws ParseException, IOException{
        listarVendas();
        FileWriter fw = new FileWriter("consulta.txt");
        PrintWriter pw = new PrintWriter(fw);
        for (int i=0; i<listaVendas.size(); i++){
            if(data1.before(listaVendas.get(i).getDataVenda())&&data2.after(listaVendas.get(i).getDataVenda()) 
               ||data1.equals(listaVendas.get(i).getDataVenda())&&data2.after(listaVendas.get(i).getDataVenda()) ||
                  data1.before(listaVendas.get(i).getDataVenda())&&data2.equals(listaVendas.get(i).getDataVenda())  ){
                //System.out.println(listaVendas.get(i).toString());
                pw.print(listaVendas.get(i).toString()+"\n");  
        }
            
    }
         pw.close();
         fw.close();
         listaVendas.clear();
    }
    public void consultaDia(Date data) throws ParseException, IOException{
        listarVendas();
        FileWriter fw = new FileWriter("consulta.txt");
        PrintWriter pw = new PrintWriter(fw);
        for (int i=0; i<listaVendas.size(); i++){
            if(data.equals(listaVendas.get(i).getDataVenda())){
                System.out.println(listaVendas.get(i).toString());
                pw.print(listaVendas.get(i).toString()+"\n");      
        }
    }
         pw.close();
         fw.close();
         listaVendas.clear();
    }
}
