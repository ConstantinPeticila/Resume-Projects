/**
 * clasa care extinde clasa Node si care accepta visitor
 */
public class AndNode extends Node implements IVisitable {

   AndNode(Node left, Node right) {

        super(left, right);
    }

    @Override

    /**
     * metoda care primeste un visiotr si un feed struct si returneaza true sau false in functie de metoda visit
     */
    public boolean accept(IVisitor visitor,FeedStruct f) {

        return visitor.visit(this,f);
    }
 }



