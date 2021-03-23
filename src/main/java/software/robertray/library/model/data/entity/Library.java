package software.robertray.library.model.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "library")
public class Library extends AbstractIdEntity {

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "library_books",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

    public Library(String name) {
        super();
        this.name = name;
        this.books = new HashSet<>();
    }
}
