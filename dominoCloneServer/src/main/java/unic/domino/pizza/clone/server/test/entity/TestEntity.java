package unic.domino.pizza.clone.server.test.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

@Entity
@Table(name="tb_notice")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    @SerializedName(value = "notice_id")
    @Expose
    private Integer noticeId;

    @Column(name="title", nullable = false)
    @Expose
    private String title;

    @Column(name="content", nullable = false)
    @Expose
    private String content;

    @Column(name="reg_date", nullable = false)
    @SerializedName(value = "reg_date")
    @Expose
    private String regDate;

    @Column(name="del_yn", nullable = false)
    @Expose(serialize = false, deserialize = false)
    private String delYn;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }
}