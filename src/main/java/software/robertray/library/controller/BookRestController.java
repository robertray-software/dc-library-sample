package software.robertray.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.robertray.library.controller.action.NewBookAction;
import software.robertray.library.controller.action.UpdateBookAction;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BookRestController extends AbstractCrudRestController<Book, Long> {

    @Autowired
    public BookRestController(BookService service) {
        super(service);
    }

    @PostMapping("")
    public Book create(@RequestBody NewBookAction action) {
        return super.create(action);
    }

    @Override
    @GetMapping("")
    public List<Book> list() {
        return super.list();
    }

    @Override
    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return super.get(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody UpdateBookAction body) {
        return super.update(id, body);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }

    @Override
    protected BookService getService() {
        return (BookService) super.getService();
    }
}
