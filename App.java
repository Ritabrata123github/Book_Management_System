package com;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO dao = new BookDAOImpl();   // Runtime Polymorphism

        while(true)
        {
            System.out.println("\n1 Add Book");
            System.out.println("2 View All Books");
            System.out.println("3 Update Price");
            System.out.println("4 Delete Book");
            System.out.println("5 Display By Title");
            System.out.println("6 Exit");

            int ch = sc.nextInt();

            switch(ch)
            {

            case 1:

                System.out.println("Enter id title author price");

                int id=sc.nextInt();
                String title=sc.next();
                String author=sc.next();
                double price=sc.nextDouble();

                Book b=new Book(id,title,author,price);

                dao.addBook(b);

                break;

            case 2:

                dao.viewAllBooks();

                break;

            case 3:

                System.out.println("Enter id author new price");

                dao.updatePrice(sc.nextInt(), sc.next(), sc.nextDouble());

                break;

            case 4:

                System.out.println("Enter id");

                dao.deleteBook(sc.nextInt());

                break;

            case 5:

                System.out.println("Enter title");

                dao.displayByTitle(sc.next());

                break;

            case 6:

                System.exit(0);

            }

        }

    }

}