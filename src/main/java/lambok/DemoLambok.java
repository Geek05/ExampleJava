package lambok;

import lombok.SneakyThrows;
import org.junit.Test;

/**
 * @author Bharath.MC
 * @since Oct-2019
 */
public class DemoLambok {

    public void print(int a) throws Exception{
        System.out.println("a="+a);
        if(a!=10)
            throw new Exception("this is checked exception");
    }

    @SneakyThrows
    public void callPrint(int a){
        print(a);
    }

    public static void main(String[] args) {
        Todo todo1 = new Todo();
        todo1.setTaskName("Walking");
        todo1.setDuration(20);
        System.out.println(todo1);

        EmployeeWithLombok employeeWithLombok = EmployeeWithLombok
                .builder()
                .empId("123")
                .firstName("Bharath")
                .lastname("MC")
                .phoneNo("9964233426")
                .build();
        System.out.println(employeeWithLombok);

        Student student1 = new Student("Bharath","MC", 20, 3);
        Student student2 = new Student("Ram","kumar", 20, 3);
        System.out.println(student1 + " "+ student2);
        System.out.println(student1.equals(student2));

        DemoLambok demoLambok = new DemoLambok();
        demoLambok.callPrint(10);

    }

    @Test
    public  void test(){
        Todo todo1 = new Todo();
        todo1.setTaskName("Walking");
        todo1.setDuration(20);
        System.out.println(todo1);
    }
}
