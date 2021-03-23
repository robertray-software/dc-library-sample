package software.robertray.library.controller.action;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;
import software.robertray.library.model.data.entity.Library;
import software.robertray.library.service.AbstractCrudService;

public class UpdateLibraryAction implements UpdateEntityAction<Library, Long> {

    @Getter
    @Setter
    private String name;

    @Override
    public Library updateEntity(Library entity, AbstractCrudService<Library, Long> service) {
        if (StringUtils.hasLength(this.getName())) {
            entity.setName(this.getName());
        }
        return entity;
    }
}
