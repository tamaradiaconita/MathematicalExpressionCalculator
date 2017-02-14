/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.util.Iterator;
import java.util.Stack;
import static tema3.EvaluateExpression.resultStack;

/**
 *
 * @author Aspire
 */
public class EvaluateNodeVisitor implements NodeVisitor{
/**
 * 
 * @param number nod ce contine o variabila
 * @param variable vectorul de variabile
 * @return 
 */
    @Override
    public Object visitNumber(VariableNode number, Variable variable) {
        Iterator<Variable> iter = variable.varsArray.iterator();
        while(iter.hasNext()){
            Variable var = iter.next();
            if(var.name.equals(number.var)){
                switch (var.type) {
                    case "int":
                        number.result = Integer.valueOf(var.value);
                        break;
                    case "double":
                        number.result = Double.valueOf(var.value);
                        break;
                    default:
                        number.result = var.value;
                        break;
                }
            }
        }
        return null;
    }
/**
 * 
 * @param operator nod ce contine un semn
 * @param variable vectorul de variabile
 * @return 
 */
    @Override
    public String visitOperand(OperationNode operator, Variable variable) {
        Stack result = EvaluateExpression.getInstance();
        
        if(result.empty())
            return null;
        
        Add add = new Add();
        Substract substract = new Substract();
        Divide divide = new Divide();
        Multiply multiply = new Multiply();
        
        Node resultNode = new Node();
        Node var1 = (Node) (result.pop());
        Node var2 = (Node) (result.pop());
        
        switch(operator.var){
            case "+":{
                Object sum = add.AddOperation(var2.result, var1.result);
                //System.out.println(var1.result + " " + var2.result + " " + sum);
                resultNode.result = sum;
                break;
            }
            case "-":{
                Object difference = substract.SubstractOperation(var2.result, var1.result);
                //System.out.println(var1.result + " " + var2.result + " " + difference);
                resultNode.result = difference;
                break;
            }
            case "/":{
                Object division = divide.DivideOperation(var2.result, var1.result);
                //System.out.println(var1.result + " " + var2.result + " " + division);
                resultNode.result = division;
                break;
            }
            case "*":{
                Object multiplication = multiply.MultiplyOperation(var2.result, var1.result);
                //System.out.println(var1.result + " " + var2.result + " " + multiplication);
                resultNode.result = multiplication;
                break;
            }
        }
        result.push(resultNode);
        return null;    
    }
}
