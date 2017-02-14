/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Aspire
 */
public class EvaluateExpression{
    static Stack resultStack = new Stack();//stiva ce va contine rezultatul final
    /**
     * 
     * @return returneaza stiva cu nodurile arborelui, in care se va afla rezultatul final
     */
    public static Stack getInstance(){
        return resultStack; //sstiva in care se gaseste rezultatul final al expresiei
    }
    /**
     * 
     * @param tree arborele
     * @param variable vectorul in care am salvat variabilele
     */
    public void PostOrder(Node tree, Variable variable){
        if(tree == null)
            return;
        /*parcurg arborele post ordine si pun nodurile cu variabile in stiva*/
        /*daca intalnesc un nod ce contine un operand, scot 2 noduri din stiva(vor contine 2 variabile), fac operatia si pun nodul rezultat*/
        PostOrder(tree.nodesArray[0], variable);
        PostOrder(tree.nodesArray[1], variable);
        
        if(tree instanceof OperationNode){
            Node var2 = (Node) resultStack.pop();
            Node var1 = (Node) resultStack.pop();
            if(var1 instanceof VariableNode)
                ((VariableNode)var1).accept(new EvaluateNodeVisitor(), variable);
            if(var2 instanceof VariableNode)
                ((VariableNode)var2).accept(new EvaluateNodeVisitor(), variable);
            resultStack.push(var1);
            resultStack.push(var2);
            ((OperationNode)tree).accept(new EvaluateNodeVisitor(), variable);
        }
        else
            resultStack.push(tree);
    }
}
