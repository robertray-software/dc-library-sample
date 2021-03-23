package software.robertray.library.model.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.robertray.library.model.data.entity.Book;
import software.robertray.library.model.data.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
