import java.util.*;

/**
 *Clasa pentru generare expresie postfixata
 * Expresia se va genera intr-un ArrayList
 * @author Constantin Peticila
 */
 class ShuntingYard {

    /**
     * Metoda care imi genereaza spatii inainte si dupa paranteze
     * Primeste un string pe care il spliteaza string cu string pana la spatiu intr-un vector de stringuri
     * @param init -stringul initial primit la crearea de observer
     * @return vector format din stringurile din stringul initial la care s-a generat spatiu inainte si dupa paranteze
     */
     static String[] inorderarr(String init){

         String[] in;
         init= init.replaceAll("\\)", " \\) ");
         init = init.replaceAll("\\(", "\\( ");
         init = init.replaceAll(" +", " ");
         in = init.split("\\s");

        return in;
     }

    /**
     *metoda foloseste un vector de stringuri si ii pune elementele intr-un ArrayList astfel:
     * daca este stringul este "si" sau "sau" sau paranteaza le pune separat intr un element
     * daca este string diferit de cele de mai sus -pune 3 stringuri consecutive intr-un element ("le value 4.6)
     * @param in vectorul creeat la metoda anterioara
     * @return arraylist format dupa modelul de mai sus
     */
     static ArrayList<String> inorder(String[] in) {

        ArrayList<String> inord = new ArrayList<>();

        for (int i = 0; i < in.length ; i++) {
            if (in[i].equals("(") || in[i].equals(")") || in[i].equals("&&") || in[i].equals("||")) {
                inord.add(in[i]);
            } else {
                inord.add(in[i] + " " + in[i+1] + " " + in[i + 2]);
                i = i+2;
            }
        }
        return inord;

    }

    /**
     * realizaza scrierea postfixata
     * in functie de stringul citit din arrayul de stringuri dat ca parametru se realizeaza operatii
     * daca stringul este paranteza "("se va pune pe stiva
     * daca stringul este ")" vom pune in array elementele de pe stiva pana in gasim perechea
     * daca stringul  este sau sau si punem in array ce e  pe stiva daca aceasta nu e vida
     * daca este diferit de cele de mai sus punem direct in array
     * @param a arrayul de stringuri rezultat din metoda inorder
     * @return scrierea postfixata intr-un array list
     */
    static ArrayList<String> postfix(ArrayList<String> a) {

        ArrayList<String> q = new ArrayList<>();
        Stack<String> stack = new Stack<>();


        a.forEach(current -> {
            switch (current) {
                case "(":
                    stack.push("(");
                    break;
                case ")":
                    while (!stack.peek().equals("(")) {
                        q.add(stack.pop());
                    }
                    stack.pop();
                    break;
                case "||":
                case "&&":
                    if ( stack.empty() )
                        stack.push(current);
                    else {
                        while (!stack.peek().equals("(")) {
                            q.add(stack.pop());
                        }
                        stack.push(current);
                    }

                    break;
                default:
                    q.add(current);
                    break;
            }
        });

        while(!stack.empty()) {
            q.add(stack.pop());
        }

        return q;
    }




}
