public class Main1 {
    public static void main(String[] args) {
        NumberSet set1 = new NumberSet(5);
        set1.addElement(1.0); //1
        set1.addElement(2.0); //2
        set1.addElement(3.3); //3
        set1.addElement(24.4); //4
        set1.removeElement(3.3); //3
        set1.addElement(3.0); //4
        set1.addElement(2.0); //5
        System.out.println("Множество set1: " + set1);
        set1.removeElement(2.0);
        System.out.println("Множество set1 после удаления элемента 2.0: " + set1);
        System.out.println("Принадлежит ли 24.4 множеству set1: " + set1.contains(24.4));

        NumberSet set2 = new NumberSet(5);
        set2.addElement(2.0); //1
        set2.addElement(3.0); //2
        set2.addElement(4.0); //3
        set2.addElement(5.0); //4
        set2.addElement(6.0); //5
        set2.addElement(9.0); // проверка на полноту (6)
        System.out.println("Множество set2: " + set2);

        NumberSet unionSet = set1.union(set2);
        System.out.println("Объединение множеств: " + unionSet);


        boolean areEqual = set1.equals(set2); //Проверка на равенство двух множеств

        if (areEqual) {
            System.out.println("Множества set1 и set2 равны.");
        } else {
            System.out.println("Множества set1 и set2 не равны.");
        }
    }
}