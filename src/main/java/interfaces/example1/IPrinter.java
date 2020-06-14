package interfaces.example1;

/**
 * @author Bharath.MC
 * @since Aug-2019
 *
 * Abastract: Multiple default and static methods in interface
 */
public interface IPrinter {
    void print();

    default void printConsole(){
        System.out.println("This is printing on console");
    }

    default void printPaper(){
        System.out.println("This is printing on Paper");
    }

    static void printStream(){
        System.out.println("This is printing on Stream");
    }

    static void printJson(){
        System.out.println("This is printing JsonData");
    }
}
