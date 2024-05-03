package it.itsvil.biblioteca.services.interfaces;

import it.itsvil.biblioteca.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookServiceInterface {
    Book insertnewBook(Book book);

    Book updateBook(Book book);

    boolean deleteBook(Book book);

    Book selectBook(Book book);
}
