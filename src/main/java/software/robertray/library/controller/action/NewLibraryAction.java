package software.robertray.library.controller.action;

import lombok.Getter;
import software.robertray.library.model.data.entity.Library;
import software.robertray.library.service.AbstractCrudService;

public class NewLibraryAction implements NewEntityAction<Library, Long> {

    @Getter
    private String name;

    @Override
    public Library create(AbstractCrudService<Library, Long> service) {
        return new Library(name);
    }
}
