package unic.domino.pizza.clone.server.join.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserIdDto implements Serializable {
    private final Integer id;
    private final String userId;
    private final String userEmail;
}
