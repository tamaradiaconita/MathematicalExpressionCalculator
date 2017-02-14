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
public class NodeFactory { //am doua tipuri de noduri: unul ce contine operatia si altul ce contine variabila
    /**
     * 
     * @param nodeType tipul nodului
     * @return returnez tipul nodului
     */
    public Node getNode(String nodeType){
        if("+".equals(nodeType) || "-".equals(nodeType) || "/".equals(nodeType) || "*".equals(nodeType) || "(".equals(nodeType) || ")".equals(nodeType))
            return new OperationNode(nodeType);
        else
            return new VariableNode(nodeType);
    }
}
