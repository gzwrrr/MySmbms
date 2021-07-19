package com.gzw.service.provider;

import com.gzw.pojo.Provider;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProviderServiceImpl extends GeneralSqlService implements ProviderService {

    @Override
    public boolean add(Provider provider) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.insert("mybatis.mapper.ProviderMapper.insertProvider", provider);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        return null;
    }

    @Override
    public int deleteProviderById(String delId) {
        return 0;
    }

    @Override
    public Provider getProviderById(String id) {
        return null;
    }

    @Override
    public boolean modify(Provider provider) {
        return false;
    }

    @Test
    public void TestAddProvider() {
        Provider provider = new Provider();
        provider.setId(14);
        provider.setProCode("GZ_10086");

        add(provider);
    }
}
