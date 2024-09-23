package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 附件分类表
 * @Author: liwu3
 * @Date: 2024/09/23 11:39
 */
public class SysAttachmentCategory implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 父级ID
     */
    private Integer pid;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类目录
     */
    private String enname;

    private static final long serialVersionUID = 1L;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", enname=").append(enname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}