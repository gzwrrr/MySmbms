package com.gzw.service.provider;

import com.gzw.pojo.Provider;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProviderServiceImplNew extends GeneralSqlService implements ProviderService {

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
        List<Provider> providerList = null;

        try (SqlSession sqlSession = sqlSessionFactory.openSession())
        {
            Provider provider = new Provider();
            provider.setProCode(proCode);
            provider.setProName(proName);

            providerList = sqlSession.selectList("mybatis.mapper.ProviderMapper.selectProvider", provider);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return providerList;
    }

    @Override
    public int deleteProviderById(String delId) {
        int id = 0;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            id = Integer.parseInt(delId);

            Provider provider = new Provider();
            provider.setId(id);

            sqlSession.delete("mybatis.mapper.ProviderMapper.deleteProvider",provider);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Provider getProviderById(String id) {
        Provider provider = null;

        try (SqlSession sqlSession = sqlSessionFactory.openSession())
        {
            Provider queryProvider = new Provider();
            queryProvider.setId(Integer.parseInt(id));

            provider = sqlSession.selectOne("mybatis.mapper.ProviderMapper.selectProvider", queryProvider);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return provider;
    }

    @Override
    public boolean modify(Provider provider) {
        if(provider.getId() == null){
            return false;
        }
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            if (sqlSession.selectOne("mybatis.mapper.ProviderMapper.selectProvider",provider) == null){
                return false;
            }
            sqlSession.update("mybatis.mapper.ProviderMapper.updateProvider",provider);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Test
    public void TestGetProviderList() {
        List<Provider> list = getProviderList("","GZ");
        for (Provider provider :
                list) {
            System.out.println(provider.getProName());
        }
    }

    @Test
    public void TestDeleteProvider(){
        deleteProviderById("0");
    }

    @Test
    public void TestModifyProvider(){
        Provider provider = new Provider();
        provider.setId(15);
        provider.setProContact("孙欣欣");

        System.out.println(modify(provider));
    }
}
