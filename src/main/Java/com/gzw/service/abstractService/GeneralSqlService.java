package com.gzw.service.abstractService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public abstract class GeneralSqlService {
    protected static final String configPath = "mybatis/mybatis-config.xml";
    protected SqlSessionFactory sqlSessionFactory;

    public GeneralSqlService() {
        // 读取配置文件
        InputStream config  = null;
        try {
            config = Resources.getResourceAsStream(configPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 通过配置文件构建SqlSessionFactory
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    }
}
