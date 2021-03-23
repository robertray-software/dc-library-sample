package software.robertray.library.controller.action;

import lombok.Getter;
import lombok.Setter;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.service.AbstractCrudService;

public class NewBookAction implements NewEntityAction<Book, Long> {

    @Getter
    @Setter
    private String title;

    @Override
    public Book create(AbstractCrudService<Book, Long> service) {
        return new Book(title);
    }
}
