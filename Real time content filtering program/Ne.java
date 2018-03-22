/**
 * clasa ce extinde operator
 * metodele acesteia returneaza true in cazul in care parametrii sunt diferiti
 * atat pentru valoare cat si pentru nume
 */
public class Ne extends Operator {

    public boolean make(double a,double b){
        return a != b;
    }

    public boolean make(String a,String b){
        return !a.equals(b);
    }
}
