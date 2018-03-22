/**
 * clasa concreta care implementeaza IVisitable si care accepta obiectul de tip visitor;
 */
public class Node implements IVisitable {
     Node Left;
     Node Right;

    /**
     * constructor care prerminte creeare unui Node cu nodurile Left si Right specificate
     * @param left nodul reprezentand fiul din stanga
     * @param right fiul din dreapta
     */
     Node(Node left, Node right) {
        Left = left;
        Right = right;
    }

    /**
     * metoda de acceptare
     * @param visitor visitorul
     * @param f feedul prezent sub forma unei structuri
     * @return nu se ajunge nicioada aici pentru ca orice nod e de tip AndNode,OrNode sau OperandNode
     */
    @Override
    public boolean accept(IVisitor visitor, FeedStruct f)  {

        return true;
    }
}



