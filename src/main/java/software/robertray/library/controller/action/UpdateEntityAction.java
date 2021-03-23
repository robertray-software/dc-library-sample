package software.robertray.library.controller.action;


import software.robertray.library.model.data.entity.AbstractIdEntity;
import software.robertray.library.service.AbstractCrudService;

public interface UpdateEntityAction<E extends AbstractIdEntity, ID> {

    E updateEntity(E entity, AbstractCrudService<E, ID> service);
}
