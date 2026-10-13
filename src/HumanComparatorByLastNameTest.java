import java.util.*;

public class HumanComparatorByLastNameTest {
    public  static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human("Иван", "Петров", 30));
        list.add(new Human("Пётр", "Иванов", 22));
        list.add(new Human("Анна", "Сидорова", 40));
        list.add(new Human("Олег", "Иванов", 22));
        list.add(new Human("Мария", "Петрова", 35));

        System.out.println("Исходный список:");
        for (Human h : list) {
            System.out.println(h);
        }

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(list);
        System.out.println("\na) HashSet");
        for (Human h : hashSet) {
            System.out.println(h);
        }

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("\nb) LinkedHashSet");
        for (Human h: linkedHashSet) {
            System.out.println(h);
        }

        // c) TreeSet с сортировкой по фамилии (метод compareTo)
        Set<Human> treeSet = new TreeSet<>(list);
        System.out.println("\nc) TreeSet");
        for (Human h: treeSet) {
            System.out.println(h);
        }

        // d) TreeSet с компаратором по фамилии
        Set<Human> treeSet2 = new TreeSet<>(new HumanComparatorByLastName());
        treeSet2.addAll(list);
        System.out.println("\nd) treeSet с компараторм по фамилии");
        for (Human h: treeSet2) {
            System.out.println(h);
        }

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSet3 = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.age, h2.age);
            }
        });
        treeSet3.addAll(list);
        System.out.println("\ne) TreeSet с компаратором по возрасту.");
        for (Human h: treeSet3) {
            System.out.println(h);
        }
    }
}
// HashSet — порядок вообще не сохраняется, элементы лежат как попало.
// LinkedHashSet — запоминает порядок, в котором элементы добавлялись. Поэтому тут порядок такой же, как в исходном списке.
// TreeSet — всегда хранит элементы отсортированными. TreeSet считает элементы одинаковыми, если компаратор вернул 0.
// У нас две «Ивановых» — компаратор по фамилии говорит, что они равны, поэтому одну из них TreeSet просто выкинул (d).
// То же самое с возрастом в пункте (e), если попадутся ровесники.