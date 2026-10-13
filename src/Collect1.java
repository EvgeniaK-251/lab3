import java.util.*;

public class Collect1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int N = scn.nextInt();
        scn.close();

        // a) Создайте массив из N случайный чисел от 0 до 100.
        System.out.println("a) Исходный массив:");
        Random rnd = new Random();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rnd.nextInt(101);
        }
        System.out.println((Arrays.toString((arr))));

        // b) На основе массива создайте список List.
        System.out.println("b) Список на основе массива.");
        List<Integer> lst = new ArrayList<>(Arrays.asList(arr));
        System.out.println(lst);

        // c) Отсортируйте список по возрастанию.
        System.out.println("c) Сортировка списка по возрастанию.");
        Collections.sort(lst);
        System.out.println((lst));

        // d) Отсортируйте список в обратном порядке.
        System.out.println("d) Сортировка в обратном порядке.");
        Collections.sort(lst, Collections.reverseOrder());
        System.out.println(lst);

        // e) Перемешайте список.
        System.out.println("e) Перемешанный список.");
        Collections.shuffle(lst);
        System.out.println(lst);

        // f) Выполните циклический сдвиг на 1 элемент.
        System.out.println("f) Циклический сдвиг на 1 элемент.");
        if (!lst.isEmpty()) {
            Collections.rotate(lst, -1);
        }
        System.out.println(lst);

        //g) Оставьте в списке только уникальные элементы.
        System.out.println("g) Только уникальные элементы.");
        System.out.println("Исходный массив:");
        System.out.println(lst);
        Set<Integer> unique_set = new LinkedHashSet<>(lst);
        List<Integer> unique_lst = new ArrayList<>(unique_set);
        System.out.println("Список с уникальными элементами:");
        System.out.println(unique_lst);

        //h) Оставьте в списке только дублирующиеся элементы.
        System.out.println("h) Только дублирующиеся элементы списка.");
        Map<Integer, Integer> count_elem = new HashMap<>();
        for (Integer num: lst) {
            count_elem.put(num, count_elem.getOrDefault(num, 0) + 1);
        }
        List<Integer> duplicates_lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> count: count_elem.entrySet()) {
            if (count.getValue() > 1) {
                duplicates_lst.add(count.getKey());
            }
        }
        System.out.println(duplicates_lst);

        //i) Из списка получите массив.
        System.out.println("i) Получить массив из списка.");
        Integer[] new_arr = lst.toArray(new Integer[0]);
        System.out.println(Arrays.toString(new_arr));

        //j) Посчитайте количество вхождений каждого числа в массив и выведите на экран.
        System.out.println("j) Количество вхождений каждого числа.");
        for (Map.Entry<Integer, Integer> count: count_elem.entrySet()) {
            System.out.println(count.getKey() + ": " + count.getValue() + " шт.");
        }
    }
}
