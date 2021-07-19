package com.gzw.service.role;

import com.gzw.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private static final String configPath = "mybatis/mybatis-config.xml";
    private SqlSessionFactory sqlSessionFactory;

    public RoleServiceImpl() throws IOException{
        // 读取配置文件
        InputStream config  = Resources.getResourceAsStream(configPath);
        // 通过配置文件构建SqlSessionFactory
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    }

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
