package com.bitbooth.rascl.exercise1;

public class IdentifierNode extends Node {

    public final String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    @Override
    protected String getName() { return "\'" + name + "\'"; }

    @Override
    public String toString() {
        return getName();
    }
}
