package com.bitbooth.rascl.exercise1;

public class VariableNode extends Node {
    public VariableNode(IdentifierNode child) {
        this.children.add(child);
    }

    @Override
    protected String getName() {
        String childName = children.firstElement().getName();
        return childName;
    }

    @Override
    public String toString() {
        return "Var";
    }
}


