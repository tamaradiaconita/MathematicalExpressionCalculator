/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Aspire
 */
public class Tema3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File in = new File("C:\\Users\\Aspire\\Desktop\\input.txt");
        FileReader fileReader = new FileReader(in);
        BufferedReader br = new BufferedReader(fileReader);
        
        PrintWriter writer = new PrintWriter("arbore.out");
        
        String line = null;
        String[] splitLine = new String[1000];
        String[] auxString = new String[1000];
        Variable var = new Variable();
        String[] expression = new String[1000];
        OutputStack output = new OutputStack();
        
        /*citesc din fisier facand spli dupa elimitatorul ";" si fac operatiile corespunzatoare: eval-evaluez expresia, altfel adaug variabilele in vectorul cu variabile */
        while((line = br.readLine()) != null){
            splitLine = line.split(";", -1);
            for(int i = 0; i < splitLine.length; i++){
                if(!"".equals(splitLine[i])){
                    if(splitLine[i].startsWith("eval")){
                        splitLine[i] = splitLine[i].substring(5);
                        expression = splitLine[i].split(" ", -1);
                        Node result = output.construcParseTree(expression);
                        EvaluateExpression evEx = new EvaluateExpression();
                        evEx.PostOrder(result, var);
                       // evEx.printStack(evEx.resultStack);
                    }
                    else{
                        if(splitLine[i].startsWith("string")){
                            expression[0] = "string";
                            int j;
                            for(j = 7; ; j++){
                                if(line.charAt(j) == '=')
                                    break;
                            }
                            expression[1] = line.substring(7, j - 1);
                            expression[2] = line.substring(j + 3, line.length() - 2);
                            var.add(expression[0], expression[1], expression[2]);
                        }
                        else{
                            String[] aux = new String[5];
                            aux = splitLine[i].split(" ", -1);
                            var.add(aux[0], aux[1], aux[3]);
                        }
                    }
                }
            }
        }
        
       /*scot rezultatele de pe stiva si le scriu in fisier*/
       
       EvaluateExpression evEx = new EvaluateExpression();
         if((!evEx.resultStack.isEmpty())){
            Iterator<Node> iter = evEx.resultStack.iterator();
            while(iter.hasNext()){
                Node node = new Node();
                node = iter.next();
                if((node.result instanceof Integer && (int)node.result == GlobalVariable.a) || (node.result instanceof Double && (double)node.result == GlobalVariable.b) ){
                    System.out.println("NaN");
                    writer.println("NaN");
                }
                else if(node.result instanceof Double){
                    System.out.println(Math.round(((double)node.result) * 100.0) / 100.0);
                    writer.println(Math.round(((double)node.result) * 100.0) / 100.0);
                }
                else{
                    writer.println(node.result);
                    System.out.println(node.result + node.result.getClass().getName());
                }
            }
        }
        writer.close();
    }
}
