package com.bitbooth.rascl.exercise1;

public class Bootstrapper {
    public static void run(String[] args) {
        IdentifierNode idA = new IdentifierNode("a");
        VariableNode varA = new VariableNode(idA);

        IdentifierNode idN = new IdentifierNode("n");
        VariableNode varN = new VariableNode(idN);

        IdentifierNode id1 = new IdentifierNode("1");
        NumberNode num1 = new NumberNode(id1);

        OperatorNode plus = new OperatorNode(OperatorType.Plus, varA, varN);
        OperatorNode times = new OperatorNode(OperatorType.Times, plus, num1);

        System.out.println();

        System.out.println(times.getName());
        printDepthFirst(times);
        System.out.println();

        System.out.println();
        Node n = parse("a + n * 1");
        System.out.println(n.getName());
        printDepthFirst(n);

    }

    private static Node parse(String input) {
        Node root = null;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'a') && (ch <= 'z')) {
                IdentifierNode idNode = new IdentifierNode("" + ch);
                VariableNode varNode = new VariableNode(idNode);
                if (root == null)
                    root = varNode;
                else
                    root.children.add(varNode);
            } else if (ch == '+' || ch == '*') {
                OperatorType type = ch == '+' ? OperatorType.Plus : OperatorType.Times;
                OperatorNode opNode = new OperatorNode(type, root, null);
                root = opNode;
            } else if (ch >= '0' && ch <= '9') {
                IdentifierNode idNode = new IdentifierNode("" + ch);
                NumberNode varNode = new NumberNode(idNode);
                if (root == null)
                    root = varNode;
                else
                    root.children.add(varNode);
            }

        }
        return root;
    }

    private static void printDepthFirst(Node node) {
        if (node == null)
            return;

        if (!node.children.isEmpty()) {
            for (int i = 0; i < node.children.size(); i++) {
                printDepthFirst(node.children.get(i));
            }
        }

        System.out.print(node);
        System.out.print(" ");
    }
}
