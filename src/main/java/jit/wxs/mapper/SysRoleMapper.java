package jit.wxs.mapper;

import jit.wxs.entity.SysRole;
import jit.wxs.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ${lcl}
 * @Title: SysRoleServiceImpl
 * @ProjectName springboot_security02
 * @Description: TODO
 * @date 2019/3/7 000722:38
 */
@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Integer id);

    @Insert("insert into sys_role (name) values (#{name})")
    int saveSysRole(String name);
}
