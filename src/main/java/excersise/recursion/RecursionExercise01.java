package excersise.recursion;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class RecursionExercise01 {

    public static int sum(int n) {
        if (n <= 0)
            return 0;
        return n + sum(n - 1);
    }

    //sum between range
    public static int sum(int start, int end) {
        if (end > start)
            return end + sum(start , end - 1);
        return end;
    }

    public static int factorialLoop(int n){
        int factorial = 1;
        for (int i = n; i > 0 ; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int factorial(int n){
        if(n==1)
            return 1;
        return n * factorial(n-1);
    }

    /**
     * Print from 1 to 100
     * if n/3 ==0 FIZZ
     * if n/5 ==0 BUZZ
     */
    public static void FizzBuzzLoop(){
        String text ="";
        for (int i = 0; i <=100; i++) {
            if(i%3==0 && i%5==0)
                text = "FizzBuzz";
            else if (i % 3 == 0)
                text = "Fizz";
            else if (i % 5 == 0)
                text = "Buzz";
            else
                text = Integer.toString(i);
            System.out.println(text);
        }
    }

    /**
     * Recursion
     * Print from 1 to 100
     * if n/3 ==0 FIZZ
     * if n/5 ==0 BUZZ
     * Print reverse
     */
    public static void FizzBuzz(int n){
        if(n<1) {
            System.out.println(n);
            return;
        }
        String text ="";
        if(n%3==0 && n%5==0)
            text = "FizzBuzz";
        else if (n % 3 == 0)
            text = "Fizz";
        else if (n % 5 == 0)
            text = "Buzz";
        else
            text = Integer.toString(n);
        System.out.println(text);
        FizzBuzz(n-1);
    }

    /**
     * Recursion
     * Print from 1 to 100
     * if n/3 ==0 FIZZ
     * if n/5 ==0 BUZZ
     * Print forward
     */
    public static void FizzBuzz2(int n){
        if(n>100) {
            return;
        }
        String text ="";
        if(n%3==0 && n%5==0)
            text = "FizzBuzz";
        else if (n % 3 == 0)
            text = "Fizz";
        else if (n % 5 == 0)
            text = "Buzz";
        else
            text = Integer.toString(n);
        System.out.println(text);
        FizzBuzz2(n+1);
    }

    /**
     * 1 1 2 3 4 5 6
     */
    public static void fibbonnacciLoop(int n){
        int n1 = 0, n2 =1;
        int fib =0;
        System.out.print(n1+" "+n2);
        for (int i = 0; i <n; i++) {
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
            System.out.print(" "+fib+" ");
        }
    }

    /**
     * Recursion
     * 1 1 2 3 4 5 6
     */
    public static int fibbonnacciRecursion(int n){
        if(n<=1)
            return 1;
        return fibbonnacciRecursion(n-2) + fibbonnacciRecursion(n-1);
    }

    public static void fibbonnacciUsingRecursion(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(fibbonnacciRecursion(i)+" ");
        }
    }


    public static void main(String[] args) {
        int n = 6;
        fibbonnacciUsingRecursion(n);
    }
}
