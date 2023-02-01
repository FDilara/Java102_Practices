package patika_store;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {
    public static final Scanner input = new Scanner(System.in);
    private static TreeSet<Brand> brands;
    static {
        brands = new TreeSet<>(new OrderBrandByName());

        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }
    public static void main(String[] args) {

        String managementPanel = "1.Listing brands\n" +
                "2.Product Listing\n" +
                "3.Adding a Product\n" +
                "4.Product Deletion\n" +
                "5.Product Filtering";

        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        categories.add("Mobile Phone");
        categories.add("Notebook");


        while (true) {
            System.out.println(managementPanel);
            System.out.println("Enter the choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    for (Brand brand : brands) {
                        System.out.println("Id: " + brand.getId() + " - Name: " + brand.getName());
                    }
                    break;
                case 2:
                    String category = printAndChoiceCategory(categories);
                    listingByCategoryName(products, category);
                    break;
                case 3:
                    String category1 = printAndChoiceCategory(categories);
                    System.out.println("Enter the brand: ");
                    String brandName = input.next();
                    for (Brand brand : brands) {
                        if(Objects.equals(brand.getName(), brandName)) {
                            addProduct(products, brand, category1);
                            break;
                        }
                    }
                    System.out.println("Brand not found!");
                    break;
                case 4:
                    String category2 = printAndChoiceCategory(categories);
                    System.out.println("Enter the id of product: ");
                    int id = input.nextInt();
                    deleteProduct(products, id, category2);
                    break;
                case 5:
                    System.out.println("Enter the id: ");
                    int id1 = input.nextInt();
                    System.out.println("Enter the brand: ");
                    String brandName1 = input.nextLine();
                    for (Brand brand : brands) {
                        if(Objects.equals(brand.getName(), brandName1)) {
                            filtering(products, id1, brand);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("Do you want to add new category(Y-N): ");
                    String yOrN = input.nextLine();
                    if(Objects.equals(yOrN, "Y")) {
                        System.out.println("New category name: ");
                        String newCategory = input.nextLine();
                        categories.add(newCategory);
                    }
                    break;
            }
        }
    }

    public static String printAndChoiceCategory(ArrayList<String> categoryList) {
        for (String category : categoryList) {
            System.out.println(category);
        }
        System.out.println("Enter the category: ");
        return input.next();
    }

    public static void listingByCategoryName(ArrayList<Product> productList, String categoryName) {
        int i = 0;
        for (Product product : productList) {
            if(Objects.equals(product.getCategoryName(), categoryName)) {
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getBrand().getName());

                i++;
            }
            //print products according to the format *********************************
        }
        if(i==0) {
            System.out.println("No products added in this category.");
        }
    }

    public static void filtering(ArrayList<Product> productList, int id, Brand brand) {

    }

    public static void addProduct(ArrayList<Product> productList, Brand brand, String categoryName) {
        System.out.println("Enter the information of new product: ");
        double price = input.nextDouble();
        double discountRate = input.nextDouble();
        int stockAmount = input.nextInt();
        String name = input.next();
        int storage = input.nextInt();
        double screenSize = input.nextDouble();
        int batteryPower = input.nextInt();
        int ram = input.nextInt();
        String colour = input.next();

        productList.add(new Product(productList.size()+1, price, discountRate, stockAmount, name, brand, storage, screenSize, batteryPower, ram, colour, categoryName));

        System.out.println("The product added.");
    }

    public static void deleteProduct(ArrayList<Product> productList, int id, String categoryName) {
        int i = 0;
        for (Product product : productList) {
            if (product.getId() == id && Objects.equals(product.getCategoryName(), categoryName)) {
                productList.remove(product);
                System.out.println("The product deleted.");

                i++;
            }
        }
        if(i==0) {
            System.out.println("Product not found.");
        }
    }

}
