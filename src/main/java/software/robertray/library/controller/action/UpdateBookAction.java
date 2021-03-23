package software.robertray.library.controller.action;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.service.AbstractCrudService;

public class UpdateBookAction implements UpdateEntityAction<Book, Long> {

    @Getter
    @Setter
    private String title;

    @Override
    public Book updateEntity(Book entity, AbstractCrudService<Book, Long> service) {
        if (StringUtils.hasLength(this.getTitle())) {
            entity.setTitle(this.getTitle());
        }
        return entity;
    }
}
