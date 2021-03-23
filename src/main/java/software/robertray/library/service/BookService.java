package software.robertray.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.model.data.repository.BookRepository;

@Component
public class BookService extends AbstractCrudService<Book, Long> {

    @Autowired
    public BookService(BookRepository repository) {
        super(repository);
    }
}
