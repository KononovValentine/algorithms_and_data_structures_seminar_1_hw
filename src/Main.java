// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        sort();
    }

    static void sort() {
        int[] arr = {123, 321, 12, 2, 14, 5, 1233, 23};
        System.out.println("Изначальный массив: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    // пирамидальная сортировка
    private static void heapSort(int[] arr) {
        int length = arr.length;

        // переформирует массив
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, length);
        }

        // меняет последний элемент местами с максимальным
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    // сравнение потомков с родителем
    private static void heapify(int[] arr, int i, int length) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        // проверяет левого потомка
        if (l < length && arr[l] > arr[largest]) {
            largest = l;
        }
        // проверяет правого потомка
        if (r < length && arr[r] > arr[largest]) {
            largest = r;
        }
        // если один из потомков больше, меняет его значение на значение родителя
        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, length);
        }
    }
}