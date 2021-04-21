import entity.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //EMPTY --------------------------------------------------------------------------------------------------------
        Stream<Object> empty = Stream.empty();
        empty
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // LIST TO SET -------------------------------------------------------------------------------------------------
        List<Integer> listInt = List.of(1, 6, 3, 10, 2);
        Set<Integer> streamSet = listInt.stream()
                .sorted()
                .skip(2)
                .collect(Collectors.toSet());
        System.out.println(streamSet);
        // SET TO LIST -------------------------------------------------------------------------------------------------
        Set<String> setString = Set.of("some text", "another text", "more text", "text");
        List<String> streamList = setString.stream()
                .collect(Collectors.toList());
        System.out.println(streamList);
        // MAP(values) TO LIST -----------------------------------------------------------------------------------------
        Map<Integer, String> mapIntStr = Map.of(12, "secret text", 22, "very secret text",
                3, "test secret text", 41, "last secret text");
        Stream<Map.Entry<Integer, String>> toList = mapIntStr.entrySet().stream();
        toList.collect(Collectors.toList()).forEach(System.out::println);
        //NumberString to Int ------------------------------------------------------------------------------------------
        List<String> numberString = List.of("1", "2", "2", "2", "3", "4", "5", "6", "7", "8");
        Set<Integer> setStream = numberString.stream()
                .skip(1)
                .limit(8)
                .map(Integer::parseInt)
                .filter(val -> val % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(setStream);
        //if to list
//          List<String> numberStringTwo = List.of("1", "2", "2", "2", "3", "4", "5", "6", "7", "8");
//                List<Integer> listStringToNumber = numberStringTwo.stream()
//                        .skip(1)
//                        .limit(8)
//                        .map(Integer::parseInt)
//                        .filter(val -> val % 2 == 0)
//                        .distinct()
//                        .collect(Collectors.toList());
//                System.out.println(listStringToNumber);
        // PARALLEL STREAM ---------------------------------------------------------------------------------------------
        Optional<Integer> someOptional = Stream.of(3, 5, 1, 7, 5, 5, 2, 7, 0, -1, -10, 100)
                .parallel()
                .sorted()
                .filter(val -> val > 1 && val < 10)
                .findFirst();
        System.out.println(someOptional.get());
        //REFERENCE METHODS IN STREAM ----------------------------------------------------------------------------------
        List<Car> cars = Arrays.asList(
                new Car("1111"),
                new Car("5555"),
                new Car(null),
                new Car(""),
                new Car("3838"),
                new Car("3223"));
        Car someCar = new Car("2222");
        cars.stream()
                .map(Car::getNumber)                                   // not static, all entity
                .filter(str -> str != null && !str.isEmpty())
                .map(Car::updateNumberToKiev)                          // static
                .collect(Collectors.toCollection(ArrayList::new))      // constructor
                .forEach(someCar::startEngine);                        // method for entity
    }
}
