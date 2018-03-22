/**
 * clasa specifica unui operator
 * aceasta contine metode ce returneaza un boolean si care sunt implementate in clasele care extind clasa Operator
 * @author Constantin Peticila
 */
public abstract  class Operator {
    /**
     *
     * @param a reprezinta valoarea din expresie (ex 4.6 din "le value 4.6")
     * @param b reprezinta valoarea feedului
     * @return implementata in functie de clasa
     */
    public abstract boolean make(double a,double b);

    /**
     *
     * @param a reprezinta numele feedului din expresie cu care trebuie sau nu sa fie egal feedul adaugat
     * @param b numele feedului adaugat
     * @return va verifica daca numele sunt la fel sau nu
     */
    public abstract boolean make(String a,String b);


}
