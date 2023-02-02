package book_list;

import book_sorter.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[]args) {
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Book> list = new ArrayList<>();
        Map<String, String> newBookList = new HashMap<>();

        bookList.add(new book_sorter.Book("Var Mısın?","Doğan Cüceloğlu", "Ocak 2021", 317));
        bookList.add(new book_sorter.Book("Othello", "William Shakespeare", "Ağustos 2008", 157));
        bookList.add(new book_sorter.Book("Hamlet", "William Shakespeare", "Mart 2008",186));
        bookList.add(new book_sorter.Book("Kumru ile Kumru", "Tahsin Yücel", "2005",308));
        bookList.add(new Book("Hanne", "Bahadır Yenişehirlioğlu","Aralık 2020",279));

        //bookList.stream().forEach(Book -> newBookList.put(Book.getName(), Book.getAuthorName()));

        bookList.forEach(Book -> newBookList.put(Book.getName(), Book.getAuthorName()));

        newBookList.keySet().forEach(String -> System.out.println("Name: " + String + " * Author: " + newBookList.get(String)));

        bookList.stream().filter(Book -> Book.getNumberOfPage()>200).forEach(list::add);
        //bookList.stream().filter(Book -> Book.getNumberOfPage()>200).forEach(Book -> list.add(Book));

        System.out.println("***********************************");

        list.forEach(Book -> System.out.println(Book.getName()));


    }
}
