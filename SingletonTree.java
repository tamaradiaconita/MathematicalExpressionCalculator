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
public class SingletonTree{
    public static SingletonTree tree = null;
    Node node = new Node();
    SingletonTree(){
        
    }
    public static SingletonTree getInstance(){
        if(tree == null){
            tree = new SingletonTree();
        }
        return tree;
    }
}
