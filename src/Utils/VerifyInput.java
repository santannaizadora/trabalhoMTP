/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Izadora
 */
public class VerifyInput {
    
    public String ifExists(String param) throws NullPointerException{
        if("".equals(param)){
            JOptionPane.showMessageDialog(null,"Todos os campos devem estar preenchidos");
        }
        return param;
    }
}
