package jit.wxs.service;

import jit.wxs.entity.SysUser;
import jit.wxs.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SysUserService {
    @Resource
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
    public List<SysUser> listByUserId(Integer userId) {
        return userMapper.listByUserId(userId);
    }
    public int saveSysUser(SysUser sysUser) {
        encryptPassword(sysUser);
        return userMapper.saveSysUser(sysUser);
    }

    /**
     * 加密密码
     */
    private SysUser encryptPassword(SysUser userEntity){
        String password = userEntity.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userEntity.setPassword(password);
        return userEntity;
    }

}
