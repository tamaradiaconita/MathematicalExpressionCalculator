/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Aspire
 */
public class Node {
    Node[] nodesArray = new Node[2];
    String var;//numele variabilei
    String type;//tipul variabilei
    String value;//valoarea variabilei
    Object result; //rezultatul dupa ce se efectueaza operatia dintre 2 frunze
    int priority = 0;
    
    Node(){
        
    }
    Node(String var){
        this.var = var;
    }
}
