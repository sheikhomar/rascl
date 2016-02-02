package com.bitbooth.rascl;

public class OperatorNode extends Node {
    public final OperatorType type;

    public OperatorNode(OperatorType type, Node left, Node right) {
        this.type = type;
        this.children.add(left);
        this.children.add(right);
    }

    @Override
    protected String getName() {
        String left = this.children.firstElement().getName();
        String right = this.children.lastElement().getName();
        String operator = "?";
        switch (type) {
            case Times: operator = "*"; break;
            case Plus: operator = "+"; break;
        }

        return left + " " + operator + " " + right;
    }

    @Override
    public String toString() {
        String operator = "Unknown";
        switch (type) {
            case Times: operator = "Times"; break;
            case Plus: operator = "Plus"; break;
        }
        return operator;
    }
}
