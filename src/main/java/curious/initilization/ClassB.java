package curious.initilization;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class ClassB extends ClassA{

    static {
        System.out.println("Class B Static Block");
    }

    {
        System.out.println("Class B Default Block");
    }

    public ClassB (){
        System.out.println("Class B Constructor");
    }
}
