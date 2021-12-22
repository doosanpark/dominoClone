package unic.domino.pizza.clone.server.join.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "user")
public class User {
    @EmbeddedId
    private UserId id;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zip_code", nullable = false)
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

    public String getCashRcptInfo() {
        return cashRcptInfo;
    }

    public void setCashRcptInfo(String cashRcptInfo) {
        this.cashRcptInfo = cashRcptInfo;
    }

    public Integer getCashRcpt() {
        return cashRcpt;
    }

    public void setCashRcpt(Integer cashRcpt) {
        this.cashRcpt = cashRcpt;
    }

    public String getCashRcptYn() {
        return cashRcptYn;
    }

    public void setCashRcptYn(String cashRcptYn) {
        this.cashRcptYn = cashRcptYn;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public Instant getLastChgdDtm() {
        return lastChgdDtm;
    }

    public void setLastChgdDtm(Instant lastChgdDtm) {
        this.lastChgdDtm = lastChgdDtm;
    }

    public String getExPwd() {
        return exPwd;
    }

    public void setExPwd(String exPwd) {
        this.exPwd = exPwd;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getAgreeCllctPrivtInfoYn() {
        return agreeCllctPrivtInfoYn;
    }

    public void setAgreeCllctPrivtInfoYn(String agreeCllctPrivtInfoYn) {
        this.agreeCllctPrivtInfoYn = agreeCllctPrivtInfoYn;
    }

    public String getBirthInfo() {
        return birthInfo;
    }

    public void setBirthInfo(String birthInfo) {
        this.birthInfo = birthInfo;
    }

    public Instant getAccntAvailPriod() {
        return accntAvailPriod;
    }

    public void setAccntAvailPriod(Instant accntAvailPriod) {
        this.accntAvailPriod = accntAvailPriod;
    }

    public String getAccntCertiYn() {
        return accntCertiYn;
    }

    public void setAccntCertiYn(String accntCertiYn) {
        this.accntCertiYn = accntCertiYn;
    }

    public Instant getModDtm() {
        return modDtm;
    }

    public void setModDtm(Instant modDtm) {
        this.modDtm = modDtm;
    }

    public Instant getRegDtm() {
        return regDtm;
    }

    public void setRegDtm(Instant regDtm) {
        this.regDtm = regDtm;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }
}