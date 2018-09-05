package com.ldlywt.hello.bean;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SettingBean implements Serializable {
    private int id;
    private String name;
    private int resourceId;

    public SettingBean(int id, String name, int resourceId) {
        this.id = id;
        this.name = name;
        this.resourceId = resourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(@DrawableRes int resourceId) {
        this.resourceId = resourceId;
    }
}
