/**
 * clasa ce extinde operator
 * metodele acesteia returneaza true in cazul egalitatii parametrilor
 */
public class Eq extends Operator {

    public boolean make(double a,double b){
        return a == b;
    }

    public boolean make(String a,String b){   return a.equals(b); }
}
