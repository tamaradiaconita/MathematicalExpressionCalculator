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
public class Substract {
    /**
     * 
     * @param var1 primul operand
     * @param var2 al doilea operand
     * @return rezultatul operatiei
     */
    public Object SubstractOperation(Object var1, Object var2){
        GlobalVariable globalVariable = new GlobalVariable();
        if(var1 instanceof Integer && var2 instanceof Integer){
            if((int)var1 == globalVariable.a || (int)var2 == globalVariable.a)
                return globalVariable.a;
            return (int)((int)var1 - (int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof Double){
            if((int)var1 == globalVariable.a || (Double)var2 == globalVariable.b)
                return globalVariable.b;
            return (double)((int)var1 - (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Double){
            if((Double)var1 == globalVariable.b || (Double)var2 == globalVariable.b)
                return globalVariable.b;
            return (double)((double)var1 - (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Integer){
            if((Double)var1 == globalVariable.b || (int)var2 == globalVariable.a)
                return globalVariable.b;
            return (double)((double)var1 - (int)var2);
        }
        else if(var1 instanceof String && var2 instanceof Integer){
            if((int)var2 > ((String)var1).length())
                return "";
            if(((int)var2) == globalVariable.a)
                return (String)var1;
            if((int)var2 < 0){
                for(int i = 0; i < Math.abs((int)var2); i++)
                    var1 = (String)var1 + "#";
                return (String)var1;
            }
            return (String)((String)var1).substring(0, ((String)var1).length() - (int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof String){
            if((int)var1 == globalVariable.a)
                return globalVariable.a;
            return (int)((int)var1 - ((String)var2).length());
        }
        else if(var1 instanceof Double && var2 instanceof String){
            if((Double)var1 == globalVariable.b)
                return globalVariable.b;
            else
                return (double)((double)var1 - ((String)var2).length());
        }
        else if(var1 instanceof String && var2 instanceof Double)
            if((Double)var2 == globalVariable.b)
                return globalVariable.b;
            else
                return (double)(((String)var1).length()  - (double)var2);
        else if(var1 instanceof String && var2 instanceof String)
        
            return (int)((String)var1).length() - ((String)var2).length();
        return null;
    }
    
}
