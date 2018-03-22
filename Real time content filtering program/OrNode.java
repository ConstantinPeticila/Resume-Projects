/**
 * Nod ce contine "||"
 */
public class OrNode  extends Node implements IVisitable {

       OrNode(Node left,Node right) {

            super(left, right);
        }

    /**
     * metoda de acceptare apeleaza metoda visitorul de vizitare care va apela metodele de acceptare a copiilor
     * @param visitor visitorul
     * @param f feedul prezent sub forma unei structuri
     * @return motoda de visitare specifica pentru Ornode
     */
        @Override
        public boolean accept(IVisitor visitor,FeedStruct f) {

            return visitor.visit(this,f);
        }
    }

