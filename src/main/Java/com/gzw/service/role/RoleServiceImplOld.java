package com.gzw.service.role;

import com.gzw.dao.BaseBao;
import com.gzw.dao.role.RoleDao;
import com.gzw.dao.role.RoleDaoImpl;
import com.gzw.pojo.Role;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class RoleServiceImplOld implements RoleService {


    private RoleDao roleDao;

    public RoleServiceImplOld(){
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseBao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return roleList;
    }

    @Test
    public void test(){
        RoleServiceImplOld roleService = new RoleServiceImplOld();
        List<Role> roleList = roleService.getRoleList();
        System.out.println(Arrays.toString(roleList.toArray()));
    }
}
