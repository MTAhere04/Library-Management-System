package library;
import java.time.LocalDate;
public class Transaction {
    private Book borrowedBook;
    private Patron patron;
    private LocalDate dueDate;
    private LocalDate returnDate;
    public Transaction(Book borrowedBook,Patron patron,LocalDate returnDate){
        this.borrowedBook=borrowedBook;

        this.patron=patron;

        this.returnDate=returnDate;
    }


}
