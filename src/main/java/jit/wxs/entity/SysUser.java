package jit.wxs.entity;

import java.io.Serializable;

/**
 * @author ${lcl}
 * @Title: SysUser
 * @ProjectName springboot_security02
 * @Description: TODO
 * @date 2019/3/7 000722:33
 */
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
