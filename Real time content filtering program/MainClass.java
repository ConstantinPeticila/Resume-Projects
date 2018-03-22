
import java.util.Scanner;

/**
 * clasa principala in care creez un feed cu observatori
 */
public class MainClass {
    /**
     * creez un feed apoi in functie de ce citesc de la tastatura apelez una din metodele acestuia
     * cititul incepe cu begin si se termina cu end
     * @param args argumente
     */
    public static void main(String args[]) {

        Feed f = Feed.getInstance();
        Scanner sc = new Scanner(System.in);

        String aux;
        aux = sc.next();
        if(aux.equals("begin"))
            aux = sc.next();
        else return;
        while (!aux.equals("end")) {
            if ( aux.equals("create_obs") ) {
                f.attach(new Observator(sc.nextInt(),sc.nextLine()));

            }
            if ( aux.equals("feed") ) {
                f.notifyAllObservers(sc.next(),sc.nextDouble());
            }
            if ( aux.equals("print") ) {
                f.print(sc.nextInt());
            }
            if ( aux.equals("delete_obs") ){
                f.remove(sc.nextInt());
            }
            aux = sc.next();
        }



    }
}
