package it.itsvil.biblioteca.services.implementation;

import it.itsvil.biblioteca.model.Book;
import it.itsvil.biblioteca.repository.BookRepository;
import it.itsvil.biblioteca.services.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {


    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book insertnewBook(Book book) {
        Book result = new Book();
        if (book!=null && book.getAuthor()!=null && book.getTitle()!=null && book.getIsbn()!=null
        && !book.getIsbn().isEmpty() && !book.getTitle().isEmpty() && !book.getAuthor().isEmpty() ){
            result = bookRepository.save(book);
            return result;
        }
        return  null;
    }

    @Override
    public Book updateBook(Book book) {
        if (book!=null)
            return bookRepository.updateTitleByIsbn(book.getIsbn(),book.getTitle());
        return  null;
    }

    @Override
    public boolean deleteBook(Book book) {
        if(book!=null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }

    @Override
    public Book selectBook(Book book) {
        if (book!=null)
            book = bookRepository.findByIsbn(book.getIsbn());
        return book;
    }


}
