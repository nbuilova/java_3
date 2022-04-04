package lesson_1_hw;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        String[] arr = {"one", "two", "three"};
        System.out.println(arrayToArrayList(arr));
        swap(arr, 1, 2);
        System.out.println(arrayToArrayList(arr));

        Integer[] nums = {1, 2, 3};
        swap(nums, 2, 0);
        System.out.println(arrayToArrayList(nums));

        Box<Apple> boxWithApples = new Box<>();
        boxWithApples.add(new Apple());

        Box<Orange> boxWithOranges = new Box<>();
        boxWithOranges.add(new Orange());

        Box<Apple> boxWithApples1 = new Box<>();
        boxWithApples1.add(new Apple());
        boxWithApples1.add(new Apple());
        boxWithApples1.add(new Apple());

        System.out.println("Вес коробки с яблоками = " + boxWithApples.getWeight());
        System.out.println("Вес коробки с апельсинами = " + boxWithOranges.getWeight());
        System.out.println("Вес коробки1 с яблоками = " + boxWithApples1.getWeight());

        System.out.println(boxWithApples.compare(boxWithApples1));
    }

    public static void swap(Object[] arr, int index1, int index2) {
        Object obj = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = obj;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
