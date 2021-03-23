package software.robertray.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import software.robertray.library.controller.action.AddBookToLibraryAction;
import software.robertray.library.controller.action.NewLibraryAction;
import software.robertray.library.controller.action.UpdateLibraryAction;
import software.robertray.library.model.data.entity.Library;
import software.robertray.library.service.LibraryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryRestController extends AbstractCrudRestController<Library, Long> {

    @Autowired
    public LibraryRestController(LibraryService service) {
        super(service);
    }

    @PostMapping("")
    public Library create(@RequestBody NewLibraryAction action) {
        return super.create(action);
    }

    @Override
    @GetMapping("")
    public List<Library> list() {
        return super.list();
    }

    @Override
    @GetMapping("/{id}")
    public Library get(@PathVariable Long id) {
        return super.get(id);
    }

    @PutMapping("/{id}")
    public Library update(@PathVariable Long id, @RequestBody UpdateLibraryAction body) {
        return super.update(id, body);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }

    @PostMapping("/{id}/books")
    public Library addBook(@PathVariable Long id, @RequestBody AddBookToLibraryAction action) {
        try {
            return this.getService().addBook(id, action);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }
    }

    @Override
    protected LibraryService getService() {
        return (LibraryService)super.getService();
    }
}
