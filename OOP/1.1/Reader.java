public class Reader {
    private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private String phone;

    public Reader(String fullName, int libraryCardNumber, String faculty, String dateOfBirth, String phone) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

    public void takeBook(int numBooks) {
        System.out.println(fullName + " took " + numBooks + " books");
    }

    public void takeBook(String bookTitles) {
        System.out.println(fullName + " took books: " + String.join(", ", bookTitles));
    }

    public void takeBook(Book... books) {
        String[] bookTitles = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            bookTitles[i] = books[i].getTitle();
        }
        System.out.println(fullName + " took books: " + String.join(", ", bookTitles));
    }

    public void returnBook(int numBooks) {
        System.out.println(fullName + " returned " + numBooks + " books");
    }

    public void returnBook(String bookTitles) {
        System.out.println(fullName + " returned books: " + String.join(", ", bookTitles));
    }

    public void returnBook(Book... books) {
        String[] bookTitles = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            bookTitles[i] = books[i].getTitle();
        }
        System.out.println(fullName + " returned books: " + String.join(", ", bookTitles));
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
}

