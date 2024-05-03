package it.itsvil.biblioteca.controller;

import it.itsvil.biblioteca.dto.InsertNewBookDto;
import it.itsvil.biblioteca.entity.Book;
import it.itsvil.biblioteca.service.interf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookcontroller")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/insertNewBook")
    public ResponseEntity<String> saveBook(@Validated @RequestBody InsertNewBookDto request)
    {
        Book bookAdded = bookService.saveBook(request);
        if (bookAdded != null)
        {
            return new ResponseEntity<>("Book added successfully ", HttpStatus.CREATED);
        }else
        {
            return new ResponseEntity<>("Invalid book addition", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/GetAllBooks")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> books = bookService.getAllBooks();
        if (books == null)
        {
            System.out.println("There isn't any book");
        }
        return ResponseEntity.ok(books);

    }

    @GetMapping("/getBookByName")
    public ResponseEntity<Book> getBookByName(@RequestParam String title)
    {
        if (title == null || title.equals(" "))
        {
            System.out.println("Invalid parameters");
        }

        Book book = bookService.getBookByName(title);

        return ResponseEntity.ok(book);

    }

    @PostMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam Long id)
    {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            System.out.println("Prodotto non trovato");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}