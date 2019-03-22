package jit.wxs.service;

import jit.wxs.entity.SysRole;
import jit.wxs.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SysRoleService {
    @Resource
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    public int saveSysRole(String name){
        return roleMapper.saveSysRole(name);
    }
}
