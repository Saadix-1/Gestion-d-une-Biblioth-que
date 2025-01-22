interface Borrowable {
    void borrow(String borrower);
}

class Book implements Borrowable {
    private final String title;
    private String author;
    private boolean isBorrowed = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void borrow(String borrower) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(borrower + " a emprunté le livre : " + title);
        } else {
            System.out.println("Désolé, le livre " + title + " est déjà emprunté.");
        }
    }

    @Override
    public String toString() {
        return "Livre: " + title + ", Auteur: " + author + ", Emprunté: " + isBorrowed;
    }
}

public class Library {
    private static Book[] books = new Book[10];
    private static int bookCount = 0;

    public static void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("La bibliothèque est pleine !");
        }
    }

    public static void displayBooks() {
        System.out.println("Livres dans la bibliothèque :");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].toString());
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Data Structures", "Jane Smith");

        Library.addBook(book1);
        Library.addBook(book2);

        Library.displayBooks();

        book1.borrow("Saad");

        Library.displayBooks();

        Object obj = book2;
        if (obj instanceof Book) {
            Book castedBook = (Book) obj;
            System.out.println("Cast réussi : " + castedBook.getTitle());
        }

        Integer totalBooks = bookCount;
        int unboxedCount = totalBooks;
        System.out.println("Nombre total de livres : " + unboxedCount);

        final Book specialBook = new Book("Design Patterns", "Gang of Four");
        Library.addBook(specialBook);
    }
}
