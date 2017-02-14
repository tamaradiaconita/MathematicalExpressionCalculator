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
public class Multiply {/**
 * 
 * @param var1 primul operand
 * @param var2 al doilea operand
 * @return rezultatul operatiei
 */
    public Object MultiplyOperation(Object var1, Object var2){
        GlobalVariable globalVariable = new GlobalVariable();
        if(var1 instanceof Integer && var2 instanceof Integer){
            if((int)var1 == GlobalVariable.a || (int)var2 == GlobalVariable.a)
                return GlobalVariable.a;
            return (int)((int)var1 * (int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof Double){
            if((int)var1 == GlobalVariable.a || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            return (double)((int)var1 * (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Double){
            if((Double)var1 == GlobalVariable.b || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            return (double)((double)var1 * (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Integer){
            if((Double)var1 == GlobalVariable.b || (int)var2 == GlobalVariable.a)
                return GlobalVariable.b;
            return (double)((double)var1 * (int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof String){
            if(((int) var1) <= 0 || (int)var1 == GlobalVariable.a)
                return (String)("");
            String result = null;
            for(int i = 0; i < (int)var1 ; i++){
                if(result != null)
                    result = result + (String)var2;
                else
                    result = (String)var2;
            }
            return result;
            //return (String)var2;
        }
        else if(var1 instanceof String && var2 instanceof Integer){
            if ((int)var2 <= 0 || (int)var2 == GlobalVariable.a)
                return (String)("");
            String result = null;
            for(int i = 0; i < (int)var2 ; i++){
                if(result != null)
                    result = result + (String)var1;
                else
                    result = (String)var1;
               // var1 = (String)var1 + (String)var1;
            }
            return result;
            //return (String)var1;
        }
        else if(var1 instanceof String && var2 instanceof Double)
            if((double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            else
                return (double)(((String)var1).length() * (double)var2);
        else if(var1 instanceof Double && var2 instanceof String)
            if((double)var1 == GlobalVariable.b)
                return GlobalVariable.b;
            else
                return (double)(((String)var2).length() * (double)var1);
        else if(var1 instanceof String && var2 instanceof String)
            return (int)(((String)var1).length() * ((String)var2).length());
        return null;
    }
}
      
