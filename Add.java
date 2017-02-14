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
public class Add {
    /**
     * 
     * @param var1 primul operand
     * @param var2 al doilea operand
     * @return rezultatul operatiei
     */
    public Object AddOperation(Object var1, Object var2){
        GlobalVariable globalVariable = new GlobalVariable();
        if(var1 instanceof Integer && var2 instanceof Integer){
            if((int)var1 == GlobalVariable.a || (int)var2 == GlobalVariable.a)
                return GlobalVariable.a;
            return (int)((int)var1 + (int)var2);
        }
        else if(var1 instanceof Integer && var2 instanceof Double){
            if((int)var1 == GlobalVariable.a || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            return (double)((int)var1 + (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Double){
            if((Double)var1 == GlobalVariable.b || (Double)var2 == GlobalVariable.b)
                return GlobalVariable.b;
            return (double)((double)var1 + (double)var2);
        }
        else if(var1 instanceof Double && var2 instanceof Integer){
            if((Double)var1 == GlobalVariable.b || (int)var2 == GlobalVariable.a)
                return GlobalVariable.b;
            return (double)((double)var1 + (int)var2);
        }
        else if(var1 instanceof String && var2 instanceof Integer){
            if(((int)var2 == GlobalVariable.a))
                return (String)((String)var1 + "NaN");
            return (String)((String)var1 + Integer.toString((int) var2));
        }
        else if(var1 instanceof Integer && var2 instanceof String){
            if((int)var1 == GlobalVariable.a)
                return (String)("NaN" + (String) var2);
            return (String)(Integer.toString((int) var1) + (String)var2);
        }
        else if(var1 instanceof String && var2 instanceof String)
            return(String)((String)var1 + (String)var2);
        else if(var1 instanceof String && var2 instanceof Double){
            if((Double)var2 == GlobalVariable.b)
                return(String)((String)var1 + "NaN");
            return (String)((String)var1 + Double.toString(Math.round(((double) var2) * 100.0) / 100.0));
        }
        else if(var1 instanceof Double && var2 instanceof String){
            if((Double)var1 == GlobalVariable.b)
                return(String)("NaN" + (String)var2);
            return (String)(Double.toString(Math.round(((double) var1)*100.0)/100.0)  + (String)var2);
        }
        return null;
    }
}
