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
public class Divide {
    /**
     * 
     * @param var1 primul operand 
     * @param var2 al doilea operand
     * @return rezultatul operatiei
     */
    public Object DivideOperation(Object var1, Object var2){
        GlobalVariable globalVariable = new GlobalVariable();
        if(var1 instanceof Integer && var2 instanceof Integer){
            if((int)var2 == 0 || (int)var1 == GlobalVariable.a || (int)var2 == GlobalVariable.a)
                return GlobalVariable.a;
            else 
                return (int)((int)var1/(int)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Integer){
            if((int)var2 == 0 || (Double)var1 == GlobalVariable.b || (int)var2 == GlobalVariable.a)
                return GlobalVariable.b;
            else
                return (double)((double)var1/(int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof Double){
             if((double)var2 == 0 || (int)var1 == GlobalVariable.a || (double)var2 == GlobalVariable.b)
                 return GlobalVariable.b;
            else
                return (double)((int)var1/(double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Double){
            if((Double)var1 == GlobalVariable.b || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            if((double)var2 == 0)
                return GlobalVariable.b;
            else
                return (double)((double)var1/(double)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof String){
            if((int)var1 == GlobalVariable.a)
                return GlobalVariable.a;
            if(((String)var2).length() == 0)
                return GlobalVariable.a;
            else 
                return (int)((int)var1/((String)var2).length());
        }
        else if(var1 instanceof Double && var2 instanceof String){
            if(((String)var2).length() == 0 || (Double)var1 == GlobalVariable.b)
                return GlobalVariable.b;
            else 
                return (double)((double)var1/((String)var2).length());
        }
        else if(var1 instanceof String && var2 instanceof Integer){
            if((int) var2 == GlobalVariable.a)
                return (String)var1;
            if((int)var2 <= 0)
                return (String)(var1);
            else
                return ((String)var1).substring(0, ((String)var1).length()/(int)var2);
        }
        else if(var1 instanceof String && var2 instanceof Double){
            if((double)var2 == 0 || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            else
                return (double)(((String)var1).length()/(double)var2);
        }
        else if(var1 instanceof String && var2 instanceof String){
            if(((String)var2).equals("NaN"))
                return (String)var2;
            if(((String)var2).length() == 0)
                return GlobalVariable.a;
            else 
                return (int)(((String)var1).length()/((String)var2).length());
        }
        return null;
    }
}
