package com.lk.template.comm.model;

import java.util.Date;

public class Bizfile {
    private Long id;

    private Long fileclassid;

    private String filename;

    private String filepath;

    private Long filesize;

    private String filetype;

    private String fileuuid;

    private String entityname;

    private String entityid;

    private String filter;

    private String channelcode;

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

    public Long getFileclassid() {
        return fileclassid;
    }

    public void setFileclassid(Long fileclassid) {
        this.fileclassid = fileclassid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFileuuid() {
        return fileuuid;
    }

    public void setFileuuid(String fileuuid) {
        this.fileuuid = fileuuid == null ? null : fileuuid.trim();
    }

    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String entityname) {
        this.entityname = entityname == null ? null : entityname.trim();
    }

    public String getEntityid() {
        return entityid;
    }

    public void setEntityid(String entityid) {
        this.entityid = entityid == null ? null : entityid.trim();
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter == null ? null : filter.trim();
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
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
}