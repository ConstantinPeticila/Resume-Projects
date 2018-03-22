
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * clasa specifica unui observator
 * Acesta are specific un numar=id,un string -expresia de la creare si un map in care tine feedurile
 * @author Constantin Peticila
 */
class Observator {
    int nr;
    String st;
    Map<String,FeedStruct> map=new TreeMap<>();

    /**
     * constructor care initializeaza un OBservator cu un numar anume si o expresie sub forma de string
     * @param nrovs -numarul observatorului
     * @param string -expresie
     */
    Observator(int nrovs,String string){
        this.nr = nrovs;
        this.st = string;
    }

    /**
     * printare in cazul in care expresia este nil
     * pentru fiecare intrare din mapul de feeduri calculam fluctuatia unde este cazul
     * afisam numarul observarului,numele feedului,valoarea acestuia,fluctiatia si numarul de schimbari
     * apoi facem actualizarile in ceea ce priveste numarul de schimbari si ultima valoare printata
     */
    void print(){

        for(Map.Entry<String, FeedStruct> entry:map.entrySet()){
            String key = entry.getKey();
            FeedStruct o = entry.getValue();

            if(o.valprint != 0.00){
                o.fluct = -(100 - o.lastval*100/o.valprint);
                if(o.fluct == -0.00)
                    o.fluct = 0.00;
            }

            System.out.println("obs "+ nr+": "+ key+" "+ String.format( "%.2f",o.lastval) +" "+ String.format( "%.2f",o.fluct ) +"% "+o.numberch);
            entry.getValue().numberch =0;
            entry.getValue().valprint = o.lastval;
            }

    }

    /**
     * printare in cazul in care expresia este diferita de nil
     * in acest caz realizez arborele folosind expresia postfixata rezultata din stringul de la crearea observerului
     * calculez fluctuatia daca este cazul
     * verific
     */
     void print2(){

        String[] infixarr = ShuntingYard.inorderarr(st.substring(1));
        ArrayList<String> infix = ShuntingYard.inorder(infixarr);
        ArrayList<String> arb = ShuntingYard.postfix(infix);


        Visitor a = new Visitor();
        Node node = ExpressionTree.constructTree(arb);

        for(Map.Entry<String,FeedStruct> entry:map.entrySet()){
            String key = entry.getKey();
            FeedStruct o = entry.getValue();
            if(o.valprint != 0.00){
                o.fluct = -(100 - o.lastval*100/o.valprint);
                if(o.fluct == -0.00)
                    o.fluct = 0.00;
            }

            if(node instanceof OperandNode ) {
                if(a.visit((OperandNode)(node),o)) {
                    System.out.println("obs " + nr + ": " + key + " " + String.format("%.2f", o.lastval) + " " + String.format("%.2f", o.fluct) + "% " + o.numberch);
                    entry.getValue().numberch = 0;
                    entry.getValue().valprint = o.lastval;

                }
            }
            if(node instanceof OrNode ){
                if(a.visit((OrNode) (node),o)) {
                    System.out.println("obs " + nr + ": " + key + " " + String.format("%.2f", o.lastval) + " " + String.format("%.2f", o.fluct) + "% " + o.numberch);
                    entry.getValue().numberch = 0;
                    entry.getValue().valprint = o.lastval;

                }
            }
                if( node instanceof AndNode )
                        if(a.visit((AndNode) (node),o)) {
                            System.out.println("obs " + nr + ": " + key + " " + String.format("%.2f", o.lastval) + " " + String.format("%.2f", o.fluct) + "% " + o.numberch);
                             entry.getValue().numberch = 0;
                            entry.getValue().valprint = o.lastval;
            }
        }

    }

    /**
     * meotda de update a unui feed din map
     * daca feedul exista atunci ii se modifica doar valoarea si creste nuamrul de schimbari
     * daca nu exista atunci il creez si il bag in map
     * @param st numele feedului (ex:"GOLD")
     * @param in valaorea acestuia
     */
   void update(String st,double in){
       int ok = 1;
        for(Map.Entry<String,FeedStruct> entry:map.entrySet()){
            if(entry.getKey().equals(st)){
                entry.getValue().lastval = in;
                ok = 0;
                entry.getValue().numberch++;
            }
        }
        if (ok == 1){
           FeedStruct obs = new FeedStruct(st,in,0.00,1);
         map.put(st,obs);
        }
     }

}
