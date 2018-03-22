
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * clasa Feed are o lista cu observatori si metode specifice de adaugare,notificare si stergere
 * aceasta contine asemenea unui observer si un map cu feedstructuri pentru adaugarea in mapurile observerilor a feddurilor realizate inaintea creerii lor
 * @author Constantin Peticila
 */
    class Feed {

    private static  Feed Instance = null;

    /**
     * folosesc Singleton
     * @return instanta
     */
    static Feed getInstance(){
        if(Instance == null)
            Instance = new Feed();
        return Instance;
    }

    private Map<String, FeedStruct> map1 = new TreeMap<>();
    private List<Observator> observers = new ArrayList<>();

    /**
     * adaugare unui observer in lista
     * ii pun toate feedurile adaugate inainte creerii lui
     * si ii modific toate changeurile la 0
     * @param observer observerul adaugat in lista
     */
   void attach(Observator observer){

        for(Map.Entry<String, FeedStruct> entry:map1.entrySet()){ observer.update(entry.getKey(),entry.getValue().lastval); }
        for(Map.Entry<String, FeedStruct> entry: observer.map.entrySet()){ entry.getValue().numberch =0;}

        observers.add(observer);

    }

    /**
     * stergerea din lista a unui observer
     * caut dupa numarul lui in lista
     * cand il gasit il sterg si ma opresc
     * @param obs numarul observerului ce trebueie sters
     */
     void remove(int obs){

        for(Observator observer:observers) {
            if ( observer.nr == obs ){
                observers.remove(observer);
                break;
            }
        }

     }


    /**
     * printarea feedurilor specifice unui observer
     * caut numarul observerului
     * verific daca expresia sa este nil sau nu
     * si apelez una dintre cele doua functii de afisare
     * @param nrobs numarul observerului a carui treemap trebuie afisat
     */
    void print(int nrobs){

        for(Observator observers:observers){
            if(observers.nr == nrobs){
                if (observers.st.equals(" nil"))
                    observers.print();
                else
                    observers.print2();
             }
        }
    }

    /**
     * metoda ce pune in treemapul fiecarui observer un feed
     * feedul este pus si in mapul acestei clase
     * @param nume numele feedului
     * @param val valaorea acestuia
     */
     void notifyAllObservers(String nume,double val) {

        for (Observator observer : observers) {
            observer.update(nume, val);
        }

        int ok = 1;
        for(Map.Entry<String, FeedStruct> entry:map1.entrySet()){
            if(entry.getKey().equals(nume)){
                entry.getValue().lastval = val;
                entry.getValue().nume = nume;
                entry.getValue().nrschinit = 1;
                ok = 0;
                entry.getValue().numberch =0;
            }
        }
        if (ok == 1){
            FeedStruct obs = new FeedStruct(nume,val,0.00,0);
            map1.put(nume,obs);
        }
    }
}

