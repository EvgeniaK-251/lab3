import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PrimesGenerator implements Iterable<Integer> {
    public final int count;

    // Конструктор
    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным.");
        }
        this.count = count;
    }

    // Итератор для перебора в прямом порядке
    @Override
    public Iterator<Integer> iterator() {
        return new PrimeIterator();
    }

    // Итератор для перебора в обратном порядке
    public Iterator<Integer> reverseIterator() {
        return new ReversePrimeIterator();
    }


    private class PrimeIterator implements Iterator<Integer> {
        private int generated = 0;  // кол-во уже сгенерированных чисел
        private int current = 1;  // текущее число для проверки

        @Override
        public boolean hasNext() {
            return generated < count;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Больше простых чисел нет.");
            }
            while (!isPrime(++current)) {
                // продолжаем поиск
            }
            generated++;
            return current;
        }
    }

    private class ReversePrimeIterator implements Iterator<Integer> {
        private final int[] primes;
        private int index;

        public  ReversePrimeIterator() {
            // Генерируем все N простых чиел
            primes = new int[count];
            int found = 0;
            int current = 1;
            while (found < count) {
                if (isPrime(++current)) {
                    primes[found++] = current;
                }
            }
            index = count - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw  new NoSuchElementException("Больше простых чисел нет.");
            }
            return primes[index--];
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}