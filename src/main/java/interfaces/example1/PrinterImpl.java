package interfaces.example1;

/**
 * @author Bharath.MC
 * @since Aug-2019
 */
public class PrinterImpl implements IPrinter{

    @Override
    public void print() {
        System.out.println("Plain Print");
    }

    public static void staticFunctionInImplClass(){
        System.out.println("static Function In Impl Class");
    }
}
