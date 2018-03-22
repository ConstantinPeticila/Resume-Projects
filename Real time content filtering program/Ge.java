/**
* clasa ce extinde operator
* metodele acesteia returneaza true in cazul in care primul parametru este mai mic sau egal
 * doar pentru valoare
*/
 public class Ge extends Operator {

    public boolean make(double a,double b){
        return a <= b;
    }

    public  boolean make(String a,String b){
        return true;
    }
}
