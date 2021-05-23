package DesignPatterns.Creational.Builder;

public class BuilderDemo {

    public static void main(String[] args) {

        /**
         * Method 1 : static inner classs
         */
        Order order = Order.Builder()
                .ID(10)
                .CustomerName("Bharath")
                .build();
        System.out.println(order);

        Student student = Student.Builder()
                .Name("Bharath")
                .ID(1234);
        System.out.println(student);

        Student student2 = Student.Builder()
                .Name("Alex")
                .ID(55555);

        System.out.println(student2);
        System.out.println(student);

        /**
         * Method 3 : Lombok
         */
        LOrder lOrder = LOrder.builder()
                .id(555)
                .name("Ramesh")
                .build();
        System.out.println(lOrder);
    }
}
