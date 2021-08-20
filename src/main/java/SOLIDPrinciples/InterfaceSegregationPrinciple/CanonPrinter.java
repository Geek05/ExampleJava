package SOLIDPrinciples.InterfaceSegregationPrinciple;

public class CanonPrinter implements IPrint {
    
    @Override
    public void print() {
        System.out.println("Cannon Printer print");
    }
}
