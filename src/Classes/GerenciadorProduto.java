/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Utils.ReadFile.readFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Izadora
 */
public class GerenciadorProduto{
    private ArrayList <Produtos> listaProdutos = new ArrayList();
    
     public GerenciadorProduto(ArrayList lista){
        listaProdutos = lista;
    }
   
    public GerenciadorProduto(){
        listaProdutos = new ArrayList();
    }
    
    @Override
    public String toString() {
        return listaProdutos.toString();
    }
    
    public void listarProduto(){
       ArrayList<String> arr = readFile("produtos.txt");
        try{
            for(String ss : arr) {
            String[] s = ss.split(";");
            for (int i = 0; i < 1; i++) {
                Produtos p = new Produtos((s[0]), s[1], Double.parseDouble(s[2]));
		listaProdutos.add(p);
		}
	}
        }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"Erro");
                
        }
    }
    public void removeProduto(String codigo) throws IOException{
        listarProduto();
        for(int i=0; i<listaProdutos.size();i++){
            if(listaProdutos.get(i).getCodigo().equals(codigo)){
                listaProdutos.remove(i);
                JOptionPane.showMessageDialog(null,"Produto excluido com sucesso!");
            }
        }
        try{
           Writer out = new FileWriter("produtos.txt");
           out.write("");
           out.flush();
           FileWriter fw = new FileWriter("produtos.txt");
           PrintWriter pw = new PrintWriter(fw);
           pw.print(listaProdutos.toString().replaceAll("\\[","").
                   replaceAll("\\]","").
                   replaceAll ("\\,",System.lineSeparator()).replaceAll(" ","").trim() + "\n"); 
         
           pw.close();
           fw.close();
           
           
       } catch(FileNotFoundException fn){
           JOptionPane.showMessageDialog(null,"Não foi possível realizar a exclusão");
        }  
            if (listaProdutos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há produtos cadastrados");   
        JOptionPane.showMessageDialog(null,"Produto não encontrado");
       
        
        }
     
    }
     public void editNomeProduto(String codigo, String nome) throws IOException{
            listarProduto();
        for(Produtos p : listaProdutos){
            if(p.getCodigo().equals(codigo)) {
            p.setNome(nome);
            System.out.print(p);

        }
     }try{
           Writer out = new FileWriter("produtos.txt");
           out.write("");
           out.flush();
           FileWriter fw = new FileWriter("produtos.txt");
           PrintWriter pw = new PrintWriter(fw);
           pw.print(listaProdutos.toString().replaceAll("\\[","").
                   replaceAll("\\]","").
                   replaceAll ("\\,",System.lineSeparator()).replaceAll(" ","").
                   trim() + "\n"); 
           pw.close();
           fw.close();
           JOptionPane.showMessageDialog(null,"Produto alterado");
           
       } catch(FileNotFoundException fn){
           JOptionPane.showMessageDialog(null,"Não foi possível alterar");
        }      

  }
     public void editPrecoProduto(String codigo, String preco) throws IOException{
        listarProduto();
        for(Produtos p : listaProdutos){
            if(p.getCodigo().equals(codigo)) {
                p.setPrecoVenda(Double.parseDouble(preco));
                JOptionPane.showMessageDialog(null,"Produto alterado");
            }
        
        try{
             Writer out = new FileWriter("produtos.txt");
             out.write("");
             out.flush();
             FileWriter fw = new FileWriter("produtos.txt");
             PrintWriter pw = new PrintWriter(fw);
             pw.print(listaProdutos.toString().replaceAll("\\[","").
                   replaceAll("\\]","").
                   replaceAll ("\\,",System.lineSeparator()).replaceAll(" ","").
                   trim() + "\n");   
            
             pw.close();
             fw.close();
             

        } catch(FileNotFoundException fn){
            JOptionPane.showMessageDialog(null,"Não foi possível alterar");
         }   
        }
         listaProdutos.clear();
    }
     public String verifyCode(String param){
     listarProduto();
     for(Produtos p : listaProdutos){
            if(p.getCodigo().equals(param)){
                JOptionPane.showMessageDialog(null,"Código já em uso!");
            }
     }
     return null;
     }
}
     