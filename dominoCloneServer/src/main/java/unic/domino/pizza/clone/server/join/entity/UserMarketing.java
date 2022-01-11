package unic.domino.pizza.clone.server.join.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user_marketing")
public class UserMarketing {
    @Id
    @Column(name = "user_marketing_id", nullable = false, length = 50)
    private String userId;
    @Column(name = "is_email")
    private boolean isEmail;
    @Column(name = "is_sms")
    private boolean isSms;
    @Column(name = "is_address")
    private boolean isAddress;
}
