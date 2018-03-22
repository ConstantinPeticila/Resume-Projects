
import java.util.ArrayList;
 import java.util.Stack;

/**
 * clasa care-mi realizeaza arborele pornind de la scrierea postfixata
 * @author Constantin Peticila
 */
 class ExpressionTree {
    /**
     * metoda care-mi realizeaza arborele
     * in functie de string creeaza un nod respectiv si se pune pe stiva
     *-AndNode
     * -OrNode
     * -OperandNode
     * @param s -array de stringuri rezultat din scrierea postifxata
     * @return root-nodul principal
     */
    static Node constructTree(ArrayList<String> s) {

        Stack<Node> stack = new Stack<>();
        OperandNode operandNode;
        AndNode andNode;
        OrNode orNode;
        Node node1;
        Node node2;

        for (String current : s) {
           if ( current.equals("||") ) {
                node1 = stack.pop();
                node2 = stack.pop();

                orNode = new OrNode(node2, node1);
                stack.push(orNode);

            } else if ( current.equals("&&") ) {
                node1 = stack.pop();
                node2 = stack.pop();

                andNode = new AndNode(node2, node1);
                stack.push(andNode);
            } else if ( !current.equals("||") && !current.equals("&&") ) {
                operandNode = new OperandNode(current);
                operandNode.fil = current;
                stack.push(operandNode);
            }
        }
        node1 = stack.peek();
        stack.pop();

        return node1;
    }

}