package com;

public interface BookDAO {

    void addBook(Book b);

    void viewAllBooks();

    void updatePrice(int id,String author,double price);

    void deleteBook(int id);

    void displayByTitle(String title);

}