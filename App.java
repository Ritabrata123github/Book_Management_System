package com;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO dao = new BookDAOImpl();   // runtime polymorphism

        while(true)
        {
            System.out.println("\n1 Add Book");
            System.out.println("2 View All Books");
            System.out.println("3 Update Price");
            System.out.println("4 Delete Book");
            System.out.println("5 Display By Title");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch(ch)
            {

            case 1:

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Book Title: ");
                String title = sc.next();

                System.out.print("Enter Author Name: ");
                String author = sc.next();

                System.out.print("Enter Book Price: ");
                double price = sc.nextDouble();

                Book b = new Book(id,title,author,price);

                dao.addBook(b);

                break;

            case 2:

                dao.viewAllBooks();

                break;

            case 3:

                System.out.print("Enter Book ID: ");
                int uid = sc.nextInt();

                System.out.print("Enter Author Name: ");
                String a = sc.next();

                System.out.print("Enter New Price: ");
                double p = sc.nextDouble();

                dao.updatePrice(uid,a,p);

                break;

            case 4:

                System.out.print("Enter Book ID to Delete: ");
                int did = sc.nextInt();

                dao.deleteBook(did);

                break;

            case 5:

                System.out.print("Enter Book Title: ");
                String t = sc.next();

                dao.displayByTitle(t);

                break;

            case 6:

                System.out.println("Exiting Program...");
                System.exit(0);

            }

        }

    }

}