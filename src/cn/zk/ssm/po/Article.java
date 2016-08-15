package cn.zk.ssm.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Article {
    private Integer id;

    private Integer secondcategoryid;

    private String name;

    private Date time;

    private Integer browse;

    private Integer review;

    private String html;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecondcategoryid() {
        return secondcategoryid;
    }

    public void setSecondcategoryid(Integer secondcategoryid) {
        this.secondcategoryid = secondcategoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}