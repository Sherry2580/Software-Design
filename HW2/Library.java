package HW2;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Library {
	private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void addReader(Reader reader) {
        readers.add(reader);
    }
    
    public void borrowBook(Reader reader, Book book) {
        if (reader.borrowBook(book)) {
            borrowingRecords.add(new BorrowingRecord(new Date(), book, reader));
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Failed to borrow the book.");
        }
    }
    
    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        for (BorrowingRecord record : borrowingRecords) {
            if (record.getBook().equals(book) && record.getReader().equals(reader)) {
                record.setReturnDate(new Date());
                break;
            }
        }
    }
    
    public void showBorrowingHistory(Reader reader) {
        for (BorrowingRecord record : borrowingRecords) {
            if (record.getReader().equals(reader)) {
                System.out.println(record);
            }
        }
    }

}
