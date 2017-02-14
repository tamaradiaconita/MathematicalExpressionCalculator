/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Aspire
 */
public class Variable { 
    String type;//tipul variabilei
    String name;//numele variabilei
    String value;//valoarea variabilei
    
    ArrayList<Variable> varsArray = new ArrayList();//vector ce contine variabilele citite din fisier, cu tot cu tipul, numele si valoarea lor
    
    public Variable(String type, String name, String value) {
        this.type = type;
        this.value = value;
        this.name = name;
    }

    Variable() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param type tipul de data al variabilei
     * @param name numele variabile
     * @param value valoarea variabilei
     */
    public void add(String type, String name, String value){
        Variable var = new Variable(type, name, value);
        varsArray.add(var);//adaug variabila in vectorul de variabile
    }
    
}
