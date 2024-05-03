package it.itsvil.biblioteca.servicetest;

import it.itsvil.biblioteca.model.Book;
import it.itsvil.biblioteca.repository.BookRepository;
import it.itsvil.biblioteca.services.implementation.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    public void insertBookValid() {
        Book book = new Book();
        book.setIsbn("124");
        book.setTitle("Vita Nova");
        book.setAuthor("Dante Alighieri");
        when(bookRepository.save(book)).thenReturn(readFromFile());
        Book created= bookService.insertnewBook(writeIntoFile(book));
        assertEquals(book, created);

    }

    @Test
    public void updateBookValid() {
        Book book = new Book();
        book.setIsbn("124");
        book.setTitle("Vita nova");
        book.setAuthor("Dante Alighieri");

        when(bookRepository.updateTitleByIsbn(book.getIsbn(), book.getTitle())).thenReturn(readFromFile());
        Book created= bookService.updateBook(updateIntoFile(book));
        assertEquals(book, created);
    }

    @Test
    public void deleteBookValid() {
        Book book = new Book();
        book.setIsbn("124");
        book.setTitle("Vita Nova");
        book.setAuthor("Dante Alighieri");

        boolean deleted = bookService.deleteBook(book);
        assertEquals(deleted,deleteFromFile(readFromFile()));
    }

    @Test
    public void selectWithValidId() {
        Book book = new Book();
        book.setIsbn("124");
        book.setTitle("Vita Nova");
        book.setAuthor("Dante Alighieri");

        when(bookRepository.save(book)).thenReturn(readFromFile());

        Book read = bookService.selectBook(readFromFile());

        assertEquals(book,read);
    }

    private Book writeIntoFile(Book book) {
        if(!checkExists(book)){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB", true))) {
                writer.write(String.valueOf(new StringBuilder(book.getIsbn()).append(",").append(book.getTitle()).append(",").append(book.getAuthor())));
                writer.newLine();
                writer.flush();
                return book;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private Book readFromFile() {
        Book book = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\books"))) {
            String line;
            
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    book = new Book(isbn, title,author);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return book;
    }

    private boolean checkExists(Book book) {
        Map<String, Book> bookMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    Book bookTemp = new Book(isbn, title,author);
                    bookMap.put(isbn, bookTemp);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(bookMap.containsKey(book.getIsbn()))
            return true;
        return false;
    }

    private Book updateIntoFile(Book book) {
        List<String> lines = new ArrayList<>();
        Book updatedBook = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    if (isbn.equals(book.getIsbn())) {

                        line = book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor();

                        updatedBook = new Book(isbn, book.getTitle(), book.getAuthor());
                    }
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return updatedBook;
    }

    private static boolean deleteFromFile(Book book) {
        List<String> lines = new ArrayList<>();
        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String isbn = parts[0].trim();
                    if (!isbn.equals(book.getIsbn())) {
                        lines.add(line);
                    } else {
                        deleted = true;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\booksDB"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return deleted;
    }
}
