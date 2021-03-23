package software.robertray.library.model.data.entity;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class AbstractIdEntity implements Comparable<AbstractIdEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @EqualsAndHashCode.Include
    @NotNull
    private Long id;

    @Override
    public int compareTo(AbstractIdEntity other) {
        return getId().compareTo(other.getId());
    }

}