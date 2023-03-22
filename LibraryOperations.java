package librarySystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryOperations {

    static List<LibraryOperations> books = new ArrayList<LibraryOperations>();
    int bookid;
    String bookname;
    boolean isAvailable;

    public LibraryOperations(int bookid, String bookname, boolean isAvailable) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.isAvailable = isAvailable;
    }

    public static void main(String [] args) {
        Scanner sc= new Scanner(System.in);

        // Adding some initial books
        books.add(new LibraryOperations(1, "java", true));
        books.add(new LibraryOperations(2, "mysql", true));
        books.add(new LibraryOperations(3, "angular", true));
        books.add(new LibraryOperations(4, "c++", true));
        books.add(new LibraryOperations(5, "junit", true));

        while(true) {
            System.out.println("Welcome to Library Management System");
            System.out.println("1.Add Book\n"+
                    "2.Show All Books\n"+
                    "3.Show Available Books\n"+
                    "4.Borrow Book\n"+
                    "5.Return Book\n"+
                    "6.Exit\n");
            System.out.println("Enter Your Choice !");

            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    addBook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    showAllAvailableBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Thank you for Using Library System!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter Valid Choice !");
            }
        }
    }

    static void addBook() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Book ID: ");
        int bookid = sc.nextInt();
        System.out.println("Enter Book Name: ");
        String bookname = sc.next();
        books.add(new LibraryOperations(bookid, bookname, true));
    }

    static void showAllBooks() {
        System.out.println("All Books: ");
        for(LibraryOperations book : books) {
            System.out.println("Book ID: " + book.bookid + ", Book Name: " + book.bookname + ", Available: " + book.isAvailable);
        }
    }

    static void showAllAvailableBooks() {
        System.out.println("Available Books: ");
        for(LibraryOperations book : books) {
            if(book.isAvailable) {
                System.out.println("Book ID: " + book.bookid + ", Book Name: " + book.bookname);
            }
        }
    }

    static void borrowBook() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Book ID to Borrow: ");
        int bookid = sc.nextInt();
        boolean found = false;
        for(LibraryOperations book : books) {
            if(book.bookid == bookid) {
                if(book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book Borrowed Successfully!");
                } else {
                    System.out.println("Book is not Available for Borrowing!");
                }
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Book Not Found!");
        }
    }

    static void returnBook() {
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter Book ID to Return: ");
    int bookid = sc.nextInt();
    boolean found = false;
    for(LibraryOperations book : books) {
        if(book.bookid == bookid) {
            if(!book.isAvailable) {
                book.isAvailable = true;
                System.out.println("Book Returned Successfully!");
            } else {
                System.out.println("This Book is Already Available!");
            }
            found = true;
            break;
        }
    }
    if(!found) {
        System.out.println("Book Not Found!");
    }
}
}