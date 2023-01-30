package book_sorter;

import java.util.Comparator;

public class SorterByNumberOfPage implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getNumberOfPage() - b2.getNumberOfPage();
    }
}
