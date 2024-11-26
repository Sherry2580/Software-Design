package HW2;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private int availableCopies;
    
    public Book(String title, String author, String isbn, int publicationYear, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }
    public int getAvailableCopies() { return availableCopies; }

    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        } else {
            return false;
        }
    }
    
    public void returnBook() {
        availableCopies++;
    }
    
    public boolean isAvailable() {
        return availableCopies > 0;
    }
    
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + 
               ", Year: " + publicationYear + ", Available Copies: " + availableCopies;
    }

}
