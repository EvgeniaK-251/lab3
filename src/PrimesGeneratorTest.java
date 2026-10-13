import java.util.Iterator;
import java.util.Scanner;

// Проверочный класс
public class PrimesGeneratorTest {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите количество простых чисел N: ");
        int n = scr.nextInt();
        scr.close();

        PrimesGenerator generator = new PrimesGenerator(n);

        // Вывод в прямом порядке через иетратор
        System.out.println("Первые " + n + " простых чисел в прямом порядке:");
        Iterator<Integer> iter1 = generator.iterator();
        int i = 1;
        while (iter1.hasNext()) {
            System.out.println("Число № " + i++ + ": " + iter1.next());
        }
        // Вывод в обратном порядке через итератор
        System.out.println("Первые " + n + " простых чисел в обратном порядке:");
        Iterator<Integer> iter2 = generator.reverseIterator();
        i = n;
        while (iter2.hasNext()) {
            System.out.println("Число № " + i-- + ": " + iter2.next());
        }
    }
}