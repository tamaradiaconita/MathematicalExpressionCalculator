/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Aspire
 */
public class OutputStack {//clasa cu metode ce formeaza stiva in care gasesc arborele final
    
    Stack variableStack = new Stack();//stiva cu operanzi
    Stack operatorStack = new Stack();//stiva cu operatori
    SingletonTree tree = SingletonTree.getInstance(); 
    
    public void addVariableToStack(Node node){
        variableStack.push(node);
    }
    /**
     * 
     * @param expression expresia eval pe care o citesc din fisier
     * @return arborele
     */
    public Node construcParseTree(String[] expression){
        NodeFactory nodeFactory = new NodeFactory(); //= new Node();//nodul pe care il introduc in stiva cu variabile
        Node node = null;
        Node var1 = new Node();//var1 si var2 sunt fiii nodului pe care il introduc in stiva cu variabile
        Node var2 = new Node();
        Node sign = new Node();//nodul pe care il scot din stiva cu semne
        
        for(int i = 0; i < expression.length; i++){//parcurg expresia citita din fisier
            if(expression[i] != null){
                if("+".equals(expression[i]) || "-".equals(expression[i]) || "/".equals(expression[i]) || "*".equals(expression[i]) || "(".equals(expression[i]) || ")".equals(expression[i])){
                    node = nodeFactory.getNode(expression[i]);
                    establishPriority(node, expression[i]);
                }
                if(!"+".equals(expression[i]) && !"-".equals(expression[i]) && !"/".equals(expression[i]) && !"*".equals(expression[i]) && !"(".equals(expression[i]) && !")".equals(expression[i])){
                    node = nodeFactory.getNode(expression[i]);
                    addVariableToStack(node);//adaug operanzii pe stiva cu variabile
                }
                else
                    InsertInTree(node, expression[i]);
            }
        }
        PopWhatIsLeft();
        
        Node result = (Node)variableStack.pop();
        printNode(result);
        System.out.println("");
        return result;
    }
    public void InsertInTree(Node node, String expression){
        if(expression.equals("(")){
            operatorStack.push(node);
        }
        else if(expression.equals(")")){
            PopWhatIsLeft();
        }
        else if(operatorStack.empty())
            operatorStack.push(node);
        else{
            comparePriorities(node);
        }
    }
    public void PopWhatIsLeft(){
        Stack auxStack = new Stack();
        Node auxNode = new Node();
        while(!operatorStack.empty()){
            auxNode = (Node)(operatorStack.pop());
            if(auxNode.var.equals("(")){
                Stack auxVariableStack = new Stack();
                Node node = null;
                if(!auxStack.empty()){
                    for(int i = 0; i <= auxStack.size() ; i++){
                        node = (Node)variableStack.pop();
                        auxVariableStack.push(node);
                    }
                    while(!auxStack.empty()){
                        node = (Node) (auxStack.pop());
                        Node var1 = (Node) auxVariableStack.pop();
                        Node var2 = (Node) auxVariableStack.pop();
                        node.nodesArray[0] = var1;
                        node.nodesArray[1] = var2;
                        auxVariableStack.push(node);
                    }
                    node = (Node) auxVariableStack.pop();
                    variableStack.push(node);
                }
                return;
            }
            else if(auxNode.priority == 1){
                Node var1 = (Node) variableStack.pop();
                Node var2 = (Node) variableStack.pop();
                auxNode.nodesArray[1] = var1;
                auxNode.nodesArray[0] = var2;
                variableStack.push(auxNode);
            }
            else
                auxStack.push(auxNode);
        }
        Stack auxVariableStack = new Stack();
        while(!variableStack.empty()){
            Node node = (Node) variableStack.pop();
            auxVariableStack.push(node);
        }
        variableStack = auxVariableStack;
        
        while(!auxStack.empty()){
            Node node = (Node) (auxStack.pop());
            Node var1 = (Node) variableStack.pop();
            Node var2 = (Node) variableStack.pop();
            node.nodesArray[0] = var1;
            node.nodesArray[1] = var2;
            variableStack.push(node);
        }
    }
    
    void establishPriority(Node node, String expression){
        if(expression.equals("*"))
            node.priority = 1;
        if(expression.equals("/"))
            node.priority = 1; 
        if(expression.equals("("))
            node.priority = -1;
        if(expression.equals(")"))
            node.priority = -1;
    }
    
    void comparePriorities(Node node){
        Node var1 = new Node();
        Node var2 = new Node();
        Node sign = new Node();
        //SingletonTree tree = SingletonTree.getInstance();
        if(!variableStack.empty()){
            sign = (Node) operatorStack.peek();
            if(node.priority > sign.priority) //compar prioritatea operatiei 
                operatorStack.push(node);
            else if ((node.priority < sign.priority) || (node.priority == sign.priority && node.priority == 1)) {
                sign = (Node) operatorStack.pop();
                var1 = (Node) variableStack.pop();
                var2 = (Node) variableStack.pop();
                sign.nodesArray[1] = var1;
                sign.nodesArray[0] = var2;
                operatorStack.push(node);
                variableStack.push(sign);
                
            }
            else
                operatorStack.push(node);
        }
    }
    
    void printStack(Stack stack){
        if((!stack.isEmpty())){
            Iterator<Node> iter = stack.iterator();
            while(iter.hasNext()){
                Node nod = new Node();
                nod = iter.next();
                System.out.println("nodul : " + nod.var );
                System.out.println("fiii noduui: ");
                printNode(nod);
            }
        }
    }
    
    void printNode(Node node){
        SingletonTree tree = SingletonTree.getInstance();
        if(node == null)
            return;
        System.out.println(node.var);
        printNode(node.nodesArray[0]);
        printNode(node.nodesArray[1]);
    }
    
}
    
