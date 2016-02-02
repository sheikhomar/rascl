package com.bitbooth.rascl;

import java.util.Vector;

public abstract class Node {
    protected Vector<Node> children;

    protected Node() {
        children = new Vector<>();
    }

    public Vector<Node> getChildren() {
        return children;
    }

    protected abstract String getName();
}
