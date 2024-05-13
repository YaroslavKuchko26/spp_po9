import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MySet set = new MySet(1);
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Choose option:\n" +
                    "\t1. add element\n" +
                    "\t2. remove element\n" +
                    "\t3. add elements (union)\n" +
                    "\t4. search for an element\n" +
                    "\t5. check set equality\n" +
                    "\t6. print set\n" +
                    "\t7. show number of elements\n" +
                    "\t... exit\n");
            int elem = Integer.parseInt(in.next());
            switch (elem) {
                case 1: {
                    System.out.print("Enter a number: ");
                    int temp = Integer.parseInt(in.next());
                    set.add(temp);
                    break;
                }
                case 2: {
                    System.out.print("Enter a number: ");
                    int temp = Integer.parseInt(in.next());
                    set.remove(temp);
                    break;
                }
                case 3: {
                    System.out.print("Enter amount of numbers: ");
                    int length = Integer.parseInt(in.next());
                    int[] array = new int[length];
                    System.out.print("Enter numbers: ");
                    for(int i = 0; i < length; ++i) {
                        int temp = Integer.parseInt(in.next());
                        array[i] = temp;
                    }
                    MySet setToUnite = new MySet(array);
                    set.union(setToUnite);
                    break;
                }
                case 4: {
                    System.out.print("Enter a number: ");
                    int temp = Integer.parseInt(in.next());
                    set.print();
                    if(set.contains(temp)) {
                        System.out.print("Set contains " + Integer.toString(temp) + "\n");
                    }
                    else {
                        System.out.print("Set doesn't contain " + Integer.toString(temp) + "\n");
                    }

                    break;
                }
                case 5: {
                    System.out.print("Enter amount of numbers: ");
                    int length = Integer.parseInt(in.next());
                    int[] array = new int[length];
                    System.out.print("Enter numbers: ");
                    for(int i = 0; i < length; ++i) {
                        int temp = Integer.parseInt(in.next());
                        array[i] = temp;
                    }
                    MySet temp = new MySet(array);
                    set.print();
                    temp.print();
                    if(set.equals(temp)) {
                        System.out.print("Sets are equal\n");
                    }
                    else {
                        System.out.print("Sets aren't equal\n");
                    }
                    break;
                }
                case 6: {
                    set.print();
                    break;
                }
                case 7: {
                    System.out.print(String.valueOf(set.getSetCapacity()) + '\n');
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }
}