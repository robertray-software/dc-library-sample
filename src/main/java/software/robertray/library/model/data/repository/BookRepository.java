package software.robertray.library.model.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.robertray.library.model.data.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
