package HW2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reader {
	private String name;
    private String readerId;
    private Date registrationDate;
    private String contactNumber;
    private List<Book> borrowedBooks = new ArrayList<>();
    
    public Reader(String name, String readerId, Date registrationDate, String contactNumber) {
        this.name = name;
        this.readerId = readerId;
        this.registrationDate = registrationDate;
        this.contactNumber = contactNumber;
    }

    public String getName() { return name; }
    public String getReaderId() { return readerId; }
    public Date getRegistrationDate() { return registrationDate; }
    public String getContactNumber() { return contactNumber; }
    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < 3 && book.isAvailable()) {
            if (book.borrowBook()) {
                borrowedBooks.add(book);
                return true;
            }
        }
        return false;
    }
    
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
        }
    }

    public void showBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

}
