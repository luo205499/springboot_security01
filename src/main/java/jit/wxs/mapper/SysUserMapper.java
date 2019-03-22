package jit.wxs.mapper;

import jit.wxs.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ${lcl}
 * @Title: SysUserRoleServiceImpl
 * @ProjectName springboot_security02
 * @Description: TODO
 * @date 2019/3/7 000722:41
 */
@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where id = #{id}")
    SysUser selectById(Integer id);

    @Select("select * from sys_user where name = #{name}")
    SysUser selectByName(String name);

    @Insert("insert into sys_user (name,password) values (#{name},#{password})")
    int saveSysUser(SysUser sysUser);

    @Select("select * from sys_user where id = #{id}")
    List<SysUser> listByUserId(Integer userId);
}
