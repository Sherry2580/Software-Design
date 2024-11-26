package HW2;
import java.util.Date;

public class LibrarySystem {
	public static void main(String[] args) {
        Library library = new Library();
        
        Book book1 = new Book("Java Programming", "John Doe", "123456789", 2020, 5);
        Book book2 = new Book("Python Basics", "Jane Smith", "987654321", 2019, 3);
        library.addBook(book1);
        library.addBook(book2);
        
        Reader reader1 = new Reader("Alice", "R001", new Date(), "123-4567");
        library.addReader(reader1);
        
        library.borrowBook(reader1, book1);
        
        library.showBorrowingHistory(reader1);
        
        library.returnBook(reader1, book1);
        
        library.showBorrowingHistory(reader1);
    }

}
