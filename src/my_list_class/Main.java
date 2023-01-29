package my_list_class;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String selectCapacity;
        Scanner input = new Scanner(System.in);

        MyListClass<Integer> myListClass;

        System.out.println("Do you want to enter the initial capacity of the array, " +
                "or start with the default capacity: (Y - N)");
        selectCapacity = input.next();
        if(!selectCapacity.equalsIgnoreCase("Y")) {
            myListClass = new MyListClass<>();
        } else {
            System.out.println("Enter initial capacity value:");
            int value = input.nextInt();
            myListClass = new MyListClass<>(value);
        }

        while(true) {
            int n;
            System.out.println("The number of elements you will enter: ");
            n = input.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ". element: ");
                myListClass.add(input.nextInt());
            }
            myListClass.print();

            System.out.println("Do you want to continue entering elements? (Y - N): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        int select;
        do {
            System.out.println("Choice a operation: ");
            System.out.println("Operations menu ---> ");
            System.out.println("1.Size \n2.Set index \n3.Get index \n4.Remove \n" +
                    "5.Index of value \n6.Last index of value \n7.Is empty \n" +
                    "8.Array \n9.Clear \n10.Sub array \n11.Contains \n12.Exit");

            select = input.nextInt();
            int index, value;
            switch (select) {
                case 1:
                    System.out.println("Size: "+ myListClass.size());
                    break;
                case 2:
                    System.out.println("Enter the index: ");
                    System.out.println("Enter the set value: ");
                    index = input.nextInt();
                    value = input.nextInt();
                    myListClass.setIndex(index, value);
                    myListClass.print();
                    break;
                case 3:
                    System.out.println("Enter the index: ");
                    index = input.nextInt();
                    System.out.println(myListClass.get(index));
                    break;
                case 4:
                    System.out.println("Enter the index: ");
                    index = input.nextInt();
                    System.out.println(myListClass.remove(index));
                    myListClass.print();
                    break;
                case 5:
                    System.out.println("Enter the value: ");
                    value = input.nextInt();
                    System.out.println(myListClass.indexOf(value));
                    break;
                case 6:
                    System.out.println("Enter the value: ");
                    value = input.nextInt();
                    System.out.println(myListClass.lastIndexOf(value));
                    break;
                case 7:
                    System.out.println(myListClass.isEmpty());
                    break;
                case 8:
                    System.out.println(Arrays.toString(myListClass.toArray()));
                    break;
                case 9:
                    myListClass.clear();
                    myListClass.print();
                    break;
                case 10:
                     System.out.println("Enter the start: ");
                     System.out.println("Enter the finish: ");
                     int start = input.nextInt();
                     int finish = input.nextInt();
                    System.out.println(Arrays.toString(myListClass.sublist(start, finish)));
                     break;
                case 11:
                     System.out.println("Enter the value: ");
                     value = input.nextInt();
                    System.out.println(myListClass.contains(value));
                     break;
                case 12:
                     break;
                default:
                     System.out.println("Invalid choice");
            }
        } while (select>0 && select!=12);

    }

}
