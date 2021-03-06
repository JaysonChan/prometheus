package com.web.form.admin.menu;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jayson  <br/> 2016-01-18 17:13
 * @since v1.0
 */
public class AddForm {
    private Long parentId;

    @NotBlank(message = "请填写菜单名称")
    @Size(max = 256 , message = "菜单名称不能超过256个字符")
    private String name;

    @NotNull(message = "请选择菜单对应的资源")
    private Long resourceId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
