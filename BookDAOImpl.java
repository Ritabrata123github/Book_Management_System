package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BookDAOImpl implements BookDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("book-unit");

    public void addBook(Book b) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(b);

        em.getTransaction().commit();

        em.close();
    }

    public void viewAllBooks() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select b from Book b");

        List<Book> list = q.getResultList();

        for(Book b : list)
        {
            System.out.println(b.getId()+" "+b.getTitle()+" "+b.getAuthor()+" "+b.getPrice());
        }

        em.close();
    }

    public void updatePrice(int id,String author,double price) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query q = em.createQuery("update Book b set b.price=:p where b.id=:i and b.author=:a");

        q.setParameter("p", price);
        q.setParameter("i", id);
        q.setParameter("a", author);

        q.executeUpdate();

        em.getTransaction().commit();

        em.close();
    }

    public void deleteBook(int id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book b = em.find(Book.class, id);

        if(b!=null)
        {
            em.remove(b);
        }

        em.getTransaction().commit();

        em.close();
    }

    public void displayByTitle(String title) {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select b from Book b where b.title=:t");

        q.setParameter("t", title);

        List<Book> list = q.getResultList();

        for(Book b : list)
        {
            System.out.println(b.getId()+" "+b.getTitle()+" "+b.getAuthor()+" "+b.getPrice());
        }

        em.close();
    }
}
