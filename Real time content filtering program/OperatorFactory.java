/**
 * clasa ce contine metoda ce imi returneaza un obiect al unei clase ce extinde clasa Operator in functie de un string
 * sunt folosite Singleton si Factory Desing Patterns
 */
class OperatorFactory {

    private static OperatorFactory instance = null;

    private OperatorFactory(){}

      static OperatorFactory getInstance(){
        if(instance == null)
            instance = new OperatorFactory();
        return instance;
    }

    /**
     * metoda ce im returneaza un obiect specific unei clase ce extinde clasa Operator
     * aceasta analizeaza stringul primit ca argument si opereaza in functie de acesta
     * @param st stringul primit ca argument
     * @return un tip de operator
     */
    static Operator getopp (String st){
             switch (st){
            case "eq":
                return new Eq();
            case "ne":
                return new Ne();
            case "le":
                return new Le();
            case "lt":
                return new Lt();
            case "ge":
                return new Ge();
            case "gt":
                return new Gt();
        }
        throw new IllegalArgumentException();
    }
}
