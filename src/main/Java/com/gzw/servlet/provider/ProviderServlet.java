package com.gzw.servlet.provider;

import com.gzw.pojo.Provider;
import com.gzw.service.provider.ProviderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProviderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("query".equals(method))
         this.query(req,resp);
         else if("add".equals(method))
             this.add(req,resp);
         else if("delprovider".equals(method))
             this.delete(req,resp);

    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws  ServletException ,IOException{
        Object[] paras = req.getParameterValues("paras");
//        System.out.println(Arrays.toString(paras));

        Provider provider = new Provider();
        provider.setProvider(paras,req,resp);
        ProviderServiceImpl providerService = new ProviderServiceImpl();

        boolean flag=providerService.add(provider);
        if(flag==true)
            req.setAttribute("message","添加成功！");
        else  req.setAttribute("message","添加失败请重试");
        req.getRequestDispatcher("provideradd.jsp").forward(req,resp);
    }
    private boolean delete(HttpServletRequest req, HttpServletResponse resp) throws  ServletException ,IOException
    {

     List<Provider >providers=query(req,resp);
     Provider provider= providers.get(0);
        ProviderServiceImpl providerService = new ProviderServiceImpl();
       int flag=providerService.deleteProviderById( provider.getId().toString());
        if(flag!=0)
            return true;
        else return  false;
    }

    private  List<Provider> query(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        String queryProCode = req.getParameter("queryProCode");
        String queryProName = req.getParameter("queryProName");
        String pageIndexinfo = req.getParameter("pageIndex");

    List<Provider> providerList;
        // 英文一个queryCode或queryName只能确定一个供应商
        // 有且只能查到一个供应商
        int currentPageNo = 1;
        //全部页面只有第一页
        int totalPageCount=1;
        //查询结果只能为1
        int totalCount = 1;
        if(pageIndexinfo!=null)
            currentPageNo=Integer.parseInt(pageIndexinfo);
        if(queryProCode==null)
            queryProCode="";
        if(queryProName==null)
            queryProCode="";
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        providerList=providerService.getProviderList(queryProName,queryProCode);

        req.setAttribute("providerList",providerList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.getRequestDispatcher("providerlist.jsp").forward(req,resp);
return  providerList;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
