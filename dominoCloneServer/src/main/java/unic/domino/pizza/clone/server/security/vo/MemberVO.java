package unic.domino.pizza.clone.server.security.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import unic.domino.pizza.clone.server.security.entity.Member;

@Getter
@Setter
public class MemberVO {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;

    public Member toEntity() {
        return new Member(id, name, account, password);
    }
//getter,setter 생략
}