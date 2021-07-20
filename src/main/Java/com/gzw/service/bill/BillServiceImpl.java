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
        return null;
    }

    @Override
    public boolean deleteBillById(String delId) {
        return false;
    }

    @Override
    public Bill getBillById(String id) {
        return null;
    }

    @Override
    public boolean modify(Bill bill) {
        return false;
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
