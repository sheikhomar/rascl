package com.bitbooth.rascl.exercise1;

public class NumberNode extends Node {
    public NumberNode(IdentifierNode child) {
        this.children.add(child);
    }

    @Override
    protected String getName() {
        String childName = children.firstElement().getName();
        return "\"" + childName + "\"";
    }

    @Override
    public String toString() {
        return "Int";
    }
}
