package library;
import java.util.ArrayList;
public class Patron {
    private String name;
    private String contactInfo;
    private Book borrowedBooks;
    public Patron(String name,String contactInfo,Book borrowedBooks){
        this.name=name;
        this.contactInfo=contactInfo;
        this.borrowedBooks=borrowedBooks;
    }
    public Book getBorrowedBooks() {
        return borrowedBooks;
    }

   /* public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }*/
    public String getName() {
        return name;
    }


    public String getContactInfo() {
        return contactInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowedBooks(Book borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
