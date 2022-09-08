package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */

        System.out.println("\n********************************************************************************");
        System.out.println("Task1:\n");


        Map<String,Long> persons = Arrays.stream(RAW_DATA)
                .toList()
                .stream()
                .distinct()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.groupingBy(Person::getName,Collectors.counting()));

        for (Map.Entry<String,Long> t : persons.entrySet()){
            System.out.println("Key: "+t.getKey()+"\n"+
                               "Value:"+t.getValue());
        }

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */

        System.out.println("\n********************************************************************************");
        System.out.println("Task2:\n");


        int sum = 10;
        int[] arr = new int[]{3, 4, 2, 7};

        List<String> numbers = Arrays.stream(findSum(arr,sum))
                .collect(Collectors.toList());
        System.out.println(numbers);

        /*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

        System.out.println("\n********************************************************************************");
        System.out.println("Task3:\n");

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false

    }

    // Функция поиска 2 чисел, которые в сумме дают sum (Task2)
    public static String[] findSum (int[] a, int sum) {
        for (int i=0; i<a.length;i++){
            for (int j=i; j<a.length;j++){
                if (a[i]+a[j]==sum){
                    return new String[]{ Integer.toString( a[i] ) , Integer.toString( a[j] ) };
                }
            }
        }
        return new String[]{"Нет подходящих пар чисел"};
    }

    // Функция нечеткого поиска (Task3)
    public static boolean fuzzySearch (String part, String full){
        char[] a = part.toCharArray();
        char[] b = full.toCharArray();
        int i=0;
        for (char symbol : b){
            if (a.length>0 && a[i]==symbol) {
                i++;
                if (i>=a.length){return true;}
            }
        }
        return false;
    }

}
