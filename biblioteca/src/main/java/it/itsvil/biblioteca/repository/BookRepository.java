package it.itsvil.biblioteca.repository;

import it.itsvil.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findByIsbn(String isbn);

    @Query("UPDATE Book b SET b.title = :newTitle WHERE b.isbn = :isbn")
    Book updateTitleByIsbn(String isbn, String newTitle);
}

