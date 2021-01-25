package com.lk.template.comm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Fileclass {
    private Long id;

    private String classname;

    private String entityname;

    private Date createtime;

    private String creator;

    private Date modifytime;

    private String modifier;

    private String delflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String entityname) {
        this.entityname = entityname == null ? null : entityname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag == null ? null : delflag.trim();
    }

    @Override
    public String toString() {
        return "Fileclass{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", entityname='" + entityname + '\'' +
                ", createtime=" + createtime +
                ", creator='" + creator + '\'' +
                ", modifytime=" + modifytime +
                ", modifier='" + modifier + '\'' +
                ", delflag='" + delflag + '\'' +
                '}';
    }
}