/**
 * interfata ce reprezinta visitorul
 * el poate vizita noduri de tip AndNode,OrNode si OperandNode
 * FeedStructul este util pentru ca metodele de acceptare si vizitare se apeleaza recursiv pana se ajunge la o frunza unde se analizaza informatia din ea comparativ cu feedul
 */
public interface IVisitor {
    /**
     * acesta viziteaza
     * @param operatorNode nodul
     * @param f feedul
     * @return in functie de tipul nodului
     */
   boolean visit(AndNode operatorNode, FeedStruct f);

    boolean visit(OrNode operatorNode, FeedStruct f);

    boolean visit(OperandNode operandNode, FeedStruct f) ;
}
