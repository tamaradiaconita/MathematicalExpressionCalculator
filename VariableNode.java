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
public class VariableNode extends Node implements NodePart{

    public VariableNode(String nodeType) {
        super(nodeType);
    }
    
    @Override
    public void accept(NodeVisitor nodeVisitor, Variable variable) {
        nodeVisitor.visitNumber(this, variable);
    }
    
}
