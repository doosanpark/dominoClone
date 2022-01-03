package unic.domino.pizza.clone.server.join.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
public class UserId implements Serializable {
    private static final long serialVersionUID = 8404557011841513470L;
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, id, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserId entity = (UserId) o;
        return Objects.equals(this.userEmail, entity.userEmail) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.userId, entity.userId);
    }
}