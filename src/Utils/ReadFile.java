/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Izadora
 */
public class ReadFile {
    public static ArrayList<String> readFile(String s){
        File file = new File(s);
        FileInputStream fileName = null;
        try{
            fileName = new FileInputStream(file);
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Erro");
        }
        ArrayList<String> strarr = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(fileName));
        String temp = "";
        try {
            for(;;)
            {
                temp = br.readLine();
                if (temp == null)
                    break;
                strarr.add(temp);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null,"Erro");
        }
        return strarr;
    }
    
}
