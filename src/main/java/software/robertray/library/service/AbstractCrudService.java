package software.robertray.library.service;

import org.springframework.data.jpa.repository.JpaRepository;
import software.robertray.library.controller.action.NewEntityAction;
import software.robertray.library.controller.action.UpdateEntityAction;
import software.robertray.library.model.data.entity.AbstractIdEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class AbstractCrudService<E extends AbstractIdEntity, ID> {

    protected final JpaRepository<E, ID> repository;

    public AbstractCrudService(JpaRepository<E, ID> repository) {
        this.repository = repository;
    }

    public E create(NewEntityAction<E, ID> action) throws EntityNotFoundException {
        E entity = action.create(this);
        return repository.save(entity);
    }

    public Optional<E> get(final ID id) {
        return repository.findById(id);
    }

    public List<E> list() {
        List<E> entities = repository.findAll();
        entities.sort(AbstractIdEntity::compareTo);
        return entities;
    }

    public E update (final ID id, final UpdateEntityAction<E,ID> action)  {
        Optional<E> opt = repository.findById(id);
        if (opt.isPresent()) {
            E entity = action.updateEntity(opt.get(), this);
            return repository.save(entity);
        } else {
            throw new EntityNotFoundException("Could not find the entity with id: " + id);
        }
    }

    public void delete(final ID id) {
        E existing = repository.getOne(id);
        repository.delete(existing);
    }
}
