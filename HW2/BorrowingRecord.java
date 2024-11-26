package HW2;
import java.util.Date;

public class BorrowingRecord {
	private Date borrowDate;
    private Date returnDate;
    private Book book;
    private Reader reader;
    
    public BorrowingRecord(Date borrowDate, Book book, Reader reader) {
        this.borrowDate = borrowDate;
        this.book = book;
        this.reader = reader;
    }

    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }
    public Book getBook() { return book; }
    public Reader getReader() { return reader; }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    @Override
    public String toString() {
        return "Borrow Date: " + borrowDate + ", Return Date: " + returnDate + 
               ", Book: " + book + ", Reader: " + reader;
    }

}
