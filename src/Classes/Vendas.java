/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vendas {
    private String codigo;
    private Date dataVenda;
    private Double valorTotal;
     public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


    public Vendas() {
        this.codigo = "";
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
    }

    public Vendas(String codigo) {
        this.codigo = "";
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
    }
    
    public Vendas(String codigo, Date dataVenda, double valorTotal){
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
     @Override
    public String toString() {
        return getCodigo() + ";" + Vendas.formato.format(getDataVenda()) + ";" + getValorTotal();
    }
    
    public void salvarVendas() throws IOException{ 
        FileWriter fw = new FileWriter("vendas.txt",true );
        PrintWriter pw = new PrintWriter(fw);
        pw.print(getCodigo() + ";" + Vendas.formato.format(getDataVenda()) + ";" + getValorTotal()+"\n");
        pw.flush();
        pw.close();
        fw.close();
        }
}



