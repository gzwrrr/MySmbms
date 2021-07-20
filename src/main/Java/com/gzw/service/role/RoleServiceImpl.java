package com.gzw.service.role;

import com.gzw.pojo.Role;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RoleServiceImpl extends GeneralSqlService implements RoleService {

    @Override
    public List<Role> getRoleList() {
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 将查询到的信息放到列表
        List<Role> roleList = sqlSession.selectList("mybatis.mapper.RoleMapper.selectAllRole");
        // 提交并关闭
        sqlSession.commit();
        sqlSession.close();
        return roleList;
    }

    @Test
    public void test(){
        List<Role> roleList = getRoleList();
        for (Role role: roleList) {
            System.out.println(role.getRoleName());
        }
    }
}
