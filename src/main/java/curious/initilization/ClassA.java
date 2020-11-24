package curious.initilization;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class ClassA {
    static {
        System.out.println("Class A Static Block");
    }

    {
        System.out.println("Class A Default Block");
    }

    public ClassA (){
        System.out.println("Class A Constructor");
    }
}
