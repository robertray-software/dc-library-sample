package software.robertray.library.model.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "book")
public class Book extends AbstractIdEntity {

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    public Book(String title) {
        super();
        this.title = title;
    }
}

