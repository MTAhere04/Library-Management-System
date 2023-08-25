import library.Book;
import library.Patron;
import library.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class LibraryManagementSystem {
        public static void main(String[] args) {
            System.out.println("Welcome to the library!!\n");
            ArrayList<Book> books = new ArrayList<>();// To store books
            libadd(books);
            ArrayList<Patron> patrons = new ArrayList<>(); // To store patrons
            ArrayList<Transaction> transactions = new ArrayList<>();


           while (true) {
                System.out.println("for Registering as a new patron: 1");
                System.out.println("for borrowing a book : 2\n(note that u must be a patron to borrow a book");
               System.out.println("for generaing details of patron : 3");
               System.out.println("for generating details of all patrons registered : 4");
                System.out.println("for registering a new book :5 ");
                Scanner in = new Scanner(System.in);
                int ch = in.nextInt();
                switch (ch) {
                    case 1:
                        register(in,patrons);
                        break;
                    case 2:BorrowBook(in,books,patrons,transactions);
                            break;
                    case 3:
                        getdetails(in,patrons);
                        break;
                    case 4:
                        Display(patrons);
                        break;
                    case 5: registerBook(in,books);
                        break;
                    case 6: exit(0);

                    default:
                        System.out.println("Invalid input");
                        exit(0);
                }
            }

        }
    public static void register(Scanner in,ArrayList<Patron> patrons){
        System.out.println("Enter your name");
        String nm=in.next();
        for(Patron p :patrons) {
            if (p.getName().equalsIgnoreCase(nm)) {
                System.out.println("user existing");
                return;
            }
        }
        System.out.println("Enter branch");
        String branch=in.next();
        Patron pat=new Patron(nm,branch,null);
        patrons.add(pat);

    }
    public static void Display(ArrayList<Patron> patrons){
        for(Patron p :patrons) {
            System.out.println("Name: "+p.getName());
            System.out.println("Branch: "+p.getContactInfo());
            System.out.println("Book Borrowed (yes/no) ");
            if(p.getBorrowedBooks()!=null){
                System.out.print("yes\n");
            }
            else{
                System.out.print("No\n");
                return;
            }
        }
    }

    public static void BorrowBook(Scanner in,ArrayList<Book>books,ArrayList<Patron>patrons,ArrayList<Transaction>transactions){
            Patron pat=null;
            System.out.println("Enter your name");
            String nm=in.next();
            String br=in.next();
            for(Patron p :patrons) {
                if (p.getName().equalsIgnoreCase(nm)) {
                    pat = p;
                }
                }
                if (pat == null) {
                    System.out.println("User not a registered Patron!!\nPlease register and try again");
                    return;
                }
                System.out.println("Available books:");
                for (int i = 0; i < books.size(); i++) {
                    Book book = books.get(i);
                    if (book.isAvailable()) {
                        System.out.println(i + ". " + book.getTitle());
                    }
                }
                System.out.println("Enter the index of the book you want to borrow");
                int borrowIndex=in.nextInt();
                if(borrowIndex<0 || borrowIndex>=books.size())
                {
                    System.out.println("Invalid choice");
                    return;
                }
                Book selectedbook=books.get(borrowIndex);
                if(! selectedbook.isAvailable()){
                    System.out.println("Selected book is not available");
                    return;
                }
                LocalDate currentdate=LocalDate.now();
                System.out.println("the book is issued on "+currentdate);
                LocalDate Return=currentdate.plusMonths(1);
                System.out.println("The return date is "+Return);
                selectedbook.setAvailable(false);
                Transaction transact=new Transaction(selectedbook,pat,Return);
                transactions.add(transact);
                pat.setBorrowedBooks(selectedbook);
                System.out.println("Book is Borrowed successfully");
    }
    public static void getdetails(Scanner in,ArrayList<Patron>patrons){
        System.out.println("Enter the patron name to get details");
        String nm=in.next();
            for(Patron p :patrons) {
            if (p.getName().equalsIgnoreCase(nm)) {
                System.out.println("Name: "+p.getName());
                System.out.println("Branch: "+p.getContactInfo());
                System.out.println(" Book Borrowed (yes/no) ");
                if(p.getBorrowedBooks()!=null){
                    System.out.print("yes");
                }
                else{
                    System.out.print("No");
                    return;
                }
            }
        }
    }
    public static void registerBook(Scanner in,ArrayList<Book>books){
            String Title=in.next();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
           if(Title==book.getTitle()){
               System.out.println("Book already exists");
               return;
           }
        }
        System.out.println("Enter author of the above book");
        String auth=in.next();
        System.out.println("Enter serial no");
        int ser=in.nextInt();
        books.add(new Book(Title,auth,ser));
    }
    public static void libadd(ArrayList<Book> books){

        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald",1));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee",2));
        books.add(new Book("1984", "George Orwell",3));
        books.add(new Book("Pride and Prejudice", "Jane Austen",4));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger",5));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien",6));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",7));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien",8));
        books.add(new Book("The Chronicles of Narnia", "C.S. Lewis",9));
        books.add(new Book("Brave New World", "Aldous Huxley",10));
    }
}

