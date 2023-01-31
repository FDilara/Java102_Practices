package book_sorter;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> booksByName = new TreeSet<>(new SorterByName());
        TreeSet<Book> booksByPage = new TreeSet<>(new SorterByNumberOfPage());

        booksByName.add(new Book("Var Mısın?","Doğan Cüceloğlu", "Ocak 2021", 317));
        booksByName.add(new Book("Othello", "William Shakespeare", "Ağustos 2008", 157));
        booksByName.add(new Book("Hamlet", "William Shakespeare", "Mart 2008",186));
        booksByName.add(new Book("Kumru ile Kumru", "Tahsin Yücel", "2005",308));
        booksByName.add(new Book("Hanne", "Bahadır Yenişehirlioğlu","Aralık 2020",279));

        booksByPage.add(new Book("Var Mısın?","Doğan Cüceloğlu", "Ocak 2021", 317));
        booksByPage.add(new Book("Othello", "William Shakespeare", "Ağustos 2008", 157));
        booksByPage.add(new Book("Hamlet", "William Shakespeare", "Mart 2008",186));
        booksByPage.add(new Book("Kumru ile Kumru", "Tahsin Yücel", "2005",308));
        booksByPage.add(new Book("Hanne", "Bahadır Yenişehirlioğlu","Aralık 2020",279));

        System.out.println("\nAccording to name of book\n");
        for(Book book : booksByName) {
            System.out.println("Book Name: "+book.getName()+" - "
                    +"Author: "+book.getAuthorName()+" - "
                    +"Date: "+book.getDate()+" - "
                    +"Number of Page: "+book.getNumberOfPage());
        }

        System.out.println("\n=============================\n");

        System.out.println("According to page number of book\n");
        for(Book book : booksByPage) {
            System.out.println("Book Name: "+book.getName()+" - "
                    +"Author: "+book.getAuthorName()+" - "
                    +"Date: "+book.getDate()+" - "
                    +"Number of Page: "+book.getNumberOfPage());
        }
    }

}
