/**
 * clasa concreta care viziteaza
 * are cate o metoda de visitare pentru fiecare tip de nod
 * metodele acceseaza metodele de aceptare ale copiilor nodurilor pana se ajunge la frunze,adica la OperandNode
 * atunci se apeleaza metoda de verificare (check) a feedului respectiv
 * @author Constantin Peticila
 */
public class Visitor implements IVisitor {

    /**
     * daca e un AndNode returneaza si intre metodele de acceptare ale copiiilor
      * @param operatorNode nodul
     * @param f feedul folosit
     * @return si
     */
    public boolean visit(AndNode operatorNode, FeedStruct f){
        return (operatorNode.Left.accept(this,f) && operatorNode.Right.accept(this,f));
    }

    public boolean visit(OrNode operatorNode, FeedStruct f){
        return (operatorNode.Left.accept(this,f) || operatorNode.Right.accept(this,f));

    }

  public boolean visit(OperandNode operandNode,FeedStruct f) {
        return operandNode.check(f);
    }
  }
