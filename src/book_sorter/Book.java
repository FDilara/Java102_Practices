package book_sorter;

public class Book {
    private String name, authorName, date;
    private int numberOfPage;

    public Book(String name, String authorName, String date, int numberOfPage) {
        this.name = name;
        this.authorName = authorName;
        this.date = date;
        this.numberOfPage = numberOfPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
