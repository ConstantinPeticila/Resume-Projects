/**
 * structura unui feed
 * Aceasta structura contine urmatoarele variabile membru:
 * -nume-un string pentru a pasta numele (exmpl:"GOLD")
 * -lastval -ultima valoare care a intrat
 * -fluct - fluctuatia valorii
 * -numberch - numarul de schimbari de valori
 * -vaprint - valoarea inainte de printare
 * -nrschimbinit -numarul initial de schimbari
 * @author Cosntantin Peticila
 */
public class FeedStruct {

    String nume;
    double lastval;
    double   fluct;
    int numberch = 0;
    double valprint = 0.00;
    int nrschinit = 0;
    /**
     * constructor pentru initializarea unui feedstruct cu anumite valori
     * @param s numele
     * @param lastv ultima valoare
     * @param fluct fluctuatia
     * @param numberch numarul de schimbari
     */
    public FeedStruct(String s, double lastv,double fluct,int numberch){
        this.nume = s;
        this.numberch = numberch;
        this.fluct = fluct;
        this.lastval = lastv;
    }
}
