package software.robertray.library.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import software.robertray.library.controller.action.NewEntityAction;
import software.robertray.library.controller.action.UpdateEntityAction;
import software.robertray.library.model.data.entity.AbstractIdEntity;
import software.robertray.library.service.AbstractCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


public abstract class AbstractCrudRestController<E extends AbstractIdEntity, ID> {

    protected final AbstractCrudService<E, ID> service;

    public AbstractCrudRestController(AbstractCrudService<E, ID> service) {
        this.service = service;
    }

    public E create (final NewEntityAction<E, ID> action) {
        try {
            return this.getService().create(action);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid parameters"
            );
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }
    }

    public List<E> list() {
        return service.list();
    }

    public E get(final ID id) {
        Optional<E> opt = this.getService().get(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Entity not found"
            );
        }
    }

    public E update (final ID id, final UpdateEntityAction<E,ID> action)  {
        try {
            return this.getService().update(id, action);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid parameters"
            );
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }
    }

    public void delete(final ID id) {
        this.getService().delete(id);
    }

    protected AbstractCrudService<E, ID> getService() {
        return service;
    }
}
