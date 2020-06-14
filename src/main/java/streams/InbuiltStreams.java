package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bharath.MC
 * @since Nov-2019
 */
public class InbuiltStreams {

    public static void intStream() {
        //sample finding sum
        int sum = IntStream
                .range(1, 5)
                .sum();
        System.out.println(sum);

        //functional refrence
        IntStream
                .range(1, 5)
                .forEach(System.out::print);
        System.out.println();

        //skip and lambda
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x));
        System.out.println();
    }

    public static void StreamOf() {
        //Stream of example - sort and print first element
        Stream.of("c", "a", "x", "y")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println();

        //get stream out of array - Using Arrays.stream(array) or Stream.of(array)
        String[] fruits = {"apple", "banana", "mango", "grapes", "avacado", "pomogranate", "orange", "guvaua"};
        Arrays.stream(fruits)
                .filter(x -> x.startsWith("a"))
                .filter(x -> x.endsWith("e") || x.endsWith("o"))
                .sorted()
                .forEach(element -> System.out.print(element + ","));
    }

    public static void mapExample() {
        //average squares of integer array using map
        Integer[] numbers = {2, 4, 6};
        Stream.of(numbers)
                .map(x -> x * x)
                .forEach(element -> System.out.println(element));

        Arrays.stream(new int[]{2, 4, 6})
                .map(element -> element * element)
                .average()
                .ifPresent(System.out::print);
    }

    public static void listExample() {

        //Convert list into caps and find fruits stats with a and p
        String[] fruits = {"apple", "banana", "mango", "grapes", "avacado", "pomogranate", "orange", "guvaua"};
        List<String> fruitList = Arrays.asList(fruits);
        fruitList.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a") || x.startsWith("p"))
                .forEach(elemet -> System.out.println(elemet));
        System.out.println("  -------------------  ");
    }

    public static void csvReading() throws IOException {
        Stream<String> rows = Files.lines(Paths.get("data.csv"));
        rows.skip(1)
                .map(row -> row.split(","))
                .map(data -> data[2])
                .sorted()
                .forEach(x -> System.out.println(x));
        rows.close();

        rows = Files.lines(Paths.get("data.csv"));
        Map<String, String> datamap = rows.skip(1)
                .map(row -> row.split(","))
                .collect(Collectors.toMap(row -> row[0], row -> row[1]));
        for(String key : datamap.keySet())
            System.out.println(key + ", "+ datamap.get(key));
        rows.close();
    }

    //Pending implementation
    public static void csvAsListofMap() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data.csv"));
        List<String> dataRows = lines.skip(1)
                .collect(Collectors.toList());
        dataRows.stream()
                .map(x -> x.split(","));
    }

    public static void SummaryStatistics(){
        int[] scores = {60, 67, 89, 50, 95, 98};
        IntSummaryStatistics summary = IntStream.of(scores)
                .summaryStatistics();
        System.out.println(summary);
    }

    public static void main(String[] args) throws IOException {
        SummaryStatistics();
    }
}
