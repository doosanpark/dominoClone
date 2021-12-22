package unic.domino.pizza.clone.server.join.vo;

import lombok.Data;
import unic.domino.pizza.clone.server.join.entity.UserIdDto;

import java.io.Serializable;
import java.time.Instant;

@Data
public class UserVO implements Serializable {
    private final UserIdDto id;
    private final String userPassword;
    private final String phoneNumber;
    private final String address;
    private final Integer zipCode;
    private final Instant regDtm;
    private final Instant modDtm;
    private final String accntCertiYn;
    private final Instant accntAvailPriod;
    private final String birthInfo;
    private final String agreeCllctPrivtInfoYn;
    private final String userLevel;
    private final String exPwd;
    private final Instant lastChgdDtm;
    private final String modId;
    private final String regId;
    private final String cashRcptYn;
    private final Integer cashRcpt;
    private final String cashRcptInfo;
}
