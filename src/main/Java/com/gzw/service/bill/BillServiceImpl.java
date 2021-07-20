package com.gzw.service.bill;

import com.gzw.pojo.Bill;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BillServiceImpl extends GeneralSqlService implements BillService{

    @Override
    public boolean add(Bill bill) {
        if (bill.getId() == null){
            return false;
        }
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Bill queryBill = new Bill();
            queryBill.setId(bill.getId());
            if(sqlSession.selectOne("mybatis.mapper.BillMapper.selectBill",queryBill) != null){
                return false;
            }
            sqlSession.insert("mybatis.mapper.BillMapper.insertBill", bill);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        List<Bill> billList = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            billList = sqlSession.selectList("mybatis.mapper.BillMapper.selectBill",bill);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return  billList;
    }

    @Override
    public boolean deleteBillById(String delId) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int id = Integer.parseInt(delId);
            Bill bill = new Bill();
            bill.setId(id);
            if(sqlSession.selectOne("mybatis.mapper.BillMapper.selectBill",bill) == null){
                return false;
            }
            sqlSession.delete("mybatis.mapper.BillMapper.deleteBill",bill);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Bill queryBill = new Bill();
            queryBill.setId(Integer.parseInt(id));

            bill = sqlSession.selectOne("mybatis.mapper.BillMapper.selectBill",queryBill);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bill;
    }

    @Override
    public boolean modify(Bill bill) {
        if (bill.getId() == null){
            return false;
        }
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Bill queryBill = new Bill();
            queryBill.setId(bill.getId());
            if(sqlSession.selectOne("mybatis.mapper.BillMapper.selectBill",queryBill) == null){
                return false;
            }

            sqlSession.update("mybatis.mapper.BillMapper.selectBill",bill);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Test
    public void TestAddBill(){
        BillService billService = new BillServiceImpl();
        Bill bill = new Bill();
        bill.setId(20);
        bill.setBillCode("10086");
        boolean result = billService.add(bill);
        System.out.println(result);
    }
}
