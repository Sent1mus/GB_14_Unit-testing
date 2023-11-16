//Задание 2.
// У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
// Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import book.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


public class Task_02 {

    BookRepository mockBookRepository;
    BookService bookService;

    @BeforeEach
    public void setup() {
        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    public void BookServiceTestFindById() {
        Book testBook = new Book("1", "Test Book", "Test Author");
        when(mockBookRepository.findById("1")).thenReturn(testBook);

        Book foundBook = bookService.findBookById("1");
        assertEquals(testBook, foundBook);
        Mockito.verify(mockBookRepository).findById("1");
    }

    @Test
    public void BookServiceTestFindAll() {
        List<Book> testBooks = Arrays.asList(
                new Book("1", "Test Book 1", "Test Author 1"),
                new Book("2", "Test Book 2", "Test Author 2")
        );
        when(mockBookRepository.findAll()).thenReturn(testBooks);

        List<Book> foundBooks = bookService.findAllBooks();
        assertEquals(testBooks, foundBooks);
        Mockito.verify(mockBookRepository).findAll();
    }
}
