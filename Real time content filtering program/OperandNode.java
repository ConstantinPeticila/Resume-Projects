/**
 * clasa ce reprezinta frunzele
 * Nodurile terminale nu sunt nici AndNode nici OrNode
 * Acestea sunt de tipul OperandNode
 */
public class OperandNode extends Node implements IVisitable {

   String fil;

     OperandNode(String value) {
        super(null, null);
        }

    /**
     *
     * @param visitor visitorul
     * @param f feedul prezent sub forma unei structuri
     * @return metoda de visitare specifica pentru OperandNode
     */
    @Override
    public boolean accept(IVisitor visitor, FeedStruct f) {
        return visitor.visit(this,f);
    }

    /**
     * metoda de verificare
     * acesta foloseste un string de forma "le value 43","eq name GOLD"
     * spliteaza stringul in functie de spatiu
     * si in functie de primul string creeaza operatorul specific
     * iar apoi returneaza rezultatul metodei operatorului in functie de ultimul string (ex : GOLD) si numele
     * sau ultimavaloare a feedului
     * @param f un feedstruct
     * @return true daca indeplineste conditia si fals altfel
     */
     boolean check(FeedStruct f){
       String[] vector = fil.split(" ");
      OperatorFactory factory =OperatorFactory.getInstance();
        Operator operator = factory.getopp(vector[0]);
        try {
            return operator.make(Double.parseDouble(vector[2]), f.lastval);
        }
        catch (NumberFormatException e ) {
            return operator.make(vector[2], f.nume);
        }
    }

}
