package software.robertray.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.robertray.library.controller.action.AddBookToLibraryAction;
import software.robertray.library.controller.action.NewBookAction;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.model.data.entity.Library;
import software.robertray.library.model.data.repository.LibraryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class LibraryService extends AbstractCrudService<Library, Long> {

    private final BookService bookService;

    @Autowired
    public LibraryService(LibraryRepository repository, BookService bookService) {
        super(repository);
        this.bookService = bookService;
    }

    public Library addBook(Long id, AddBookToLibraryAction action) {
        Optional<Library> libraryOpt = repository.findById(id);
        if (libraryOpt.isPresent()) {
            Optional<Book> bookOpt = bookService.get(action.getBookId());
            if (bookOpt.isPresent()) {
                Library entity = libraryOpt.get();
                entity.getBooks().add(bookOpt.get());
                return repository.save(entity);
            } else {
                throw new EntityNotFoundException("Could not find the Book with id: " + action.getBookId());
            }
        } else {
            throw new EntityNotFoundException("Could not find the Library with id: " + id);
        }
    }
}
