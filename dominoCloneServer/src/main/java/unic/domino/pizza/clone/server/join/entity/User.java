package unic.domino.pizza.clone.server.join.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class User {
    @EmbeddedId
    private UserId id;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "reg_dtm")
    private Instant regDtm;

    @Column(name = "mod_dtm")
    private Instant modDtm;

    @Column(name = "accnt_certi_yn", nullable = false, length = 45)
    private String accntCertiYn;

    @Column(name = "accnt_avail_priod", nullable = false)
    private Instant accntAvailPriod;

    @Column(name = "birth_info", nullable = false, length = 45)
    private String birthInfo;

    @Column(name = "agree_cllct_privt_info_yn", nullable = false, length = 1)
    private String agreeCllctPrivtInfoYn;

    @Column(name = "user_level", nullable = false, length = 45)
    private String userLevel;

    @Column(name = "ex_pwd", length = 45)
    private String exPwd;

    @Column(name = "last_chgd_dtm")
    private Instant lastChgdDtm;

    @Column(name = "mod_id", length = 50)
    private String modId;

    @Column(name = "reg_id", length = 50)
    private String regId;

    @Column(name = "cash_rcpt_yn", length = 1)
    private String cashRcptYn;

    @Column(name = "cash_rcpt")
    private Integer cashRcpt;

    @Column(name = "cash_rcpt_info", length = 45)
    private String cashRcptInfo;
}