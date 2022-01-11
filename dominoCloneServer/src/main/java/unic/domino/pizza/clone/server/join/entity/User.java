package unic.domino.pizza.clone.server.join.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
@Accessors(chain = true)
@IdClass(UserKey.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;
    @Id
    @Column(name = "user_email", nullable = false)
    private String userEmail;

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

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value={
            @JoinColumn(name="user_marketing_id")
    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private UserMarketing userMarketing;
}

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
class UserKey implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @EqualsAndHashCode.Include
    @Id
    private String userId;
    @EqualsAndHashCode.Include
    @Id
    private String userEmail;
}