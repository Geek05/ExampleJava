package interfaces.example1;

/**
 * @author Bharath.MC
 * @since Aug-2019
 */
public class PrinterDemo {

    public static void main(String[] args) {
        System.out.println("Call default Functions using Interface Name");
        IPrinter iPrinter = new PrinterImpl();
        iPrinter.printConsole();
        iPrinter.printPaper();
        System.out.println("___________________________________________________");

        //Call Static Functions
        System.out.println("Call Static Functions using Interface Name");
        IPrinter.printJson();
        IPrinter.printStream();
        System.out.println("___________________________________________________");

        //Call implementation Functions using Interface Reference
        System.out.println("Call implementation Functions using Interface Reference");
        iPrinter.print();
        System.out.println("___________________________________________________");

        PrinterImpl.staticFunctionInImplClass();
    }
}
