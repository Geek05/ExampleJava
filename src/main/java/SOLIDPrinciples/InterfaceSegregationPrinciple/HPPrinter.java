package SOLIDPrinciples.InterfaceSegregationPrinciple;

public class HPPrinter implements IPrint, IScan {

    @Override
    public void print() {
        System.out.println("HP Printer print");
    }

    @Override
    public void scan() {
        System.out.println("Scan HPPrinter");
    }

    @Override
    public void scanPhoto() {
        System.out.println("Scan HPscanPhoto");
    }
}
