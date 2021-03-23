package software.robertray.library.controller.action;


import software.robertray.library.model.data.entity.AbstractIdEntity;
import software.robertray.library.service.AbstractCrudService;

public interface NewEntityAction<E extends AbstractIdEntity, ID> {

    E create(AbstractCrudService<E, ID> service);

}
