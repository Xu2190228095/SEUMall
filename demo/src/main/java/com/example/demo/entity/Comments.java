package com.example.demo.entity;

public class Comments {
    private Integer id;
    private Integer cid;
    private Integer pid;
    private Integer score;
    private String comment;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", cid=" + cid +
                ", pid=" + pid +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
