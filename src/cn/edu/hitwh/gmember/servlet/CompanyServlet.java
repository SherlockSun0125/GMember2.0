package cn.edu.hitwh.gmember.servlet;


import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.service.IAdminService;
import cn.edu.hitwh.gmember.service.ICompanyService;
import cn.edu.hitwh.gmember.serviceImp.AdminServiceImp;
import cn.edu.hitwh.gmember.serviceImp.CompanyServiceImp;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@MultipartConfig
public class CompanyServlet extends BaseServlet {
    private DateTools dateTools=new DateTools();
    private ICompanyService companyService=new CompanyServiceImp();
    private IAdminService adminService=new AdminServiceImp();

    public String findAllCompanys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean<Company> companyPageBean=companyService.findAllCompanies();

        req.setAttribute("companyPageBean",companyPageBean);

        return "f:/enterprise.jsp";
    }

    public String findCompanyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int comid=Integer.parseInt(req.getParameter("comid"));

        Company company=companyService.findCompanyById(comid);

        req.setAttribute("company",company);

        return "f:/enterpriseIntro.jsp";
    }

    /*
    管理员用
     */
    public String adminFindAllComanies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);

        PageBean<Company> companyPageBean=companyService.adminFindAllCompanies(currentPage);

        companyPageBean.setTotalPages(companyPageBean.getTotalPages());
        companyPageBean.setCurrentPage(currentPage);
        companyPageBean.setUrl(url);

        req.setAttribute("pb",companyPageBean);

        return "f:/encryptWeb/admin/enterprises.jsp";
    }

    public String adminFindCompaniesByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        int comtypeid=Integer.parseInt(req.getParameter("comtypeid"));

        PageBean<Company> companyPageBean=companyService.adminFindCompaniesByType(comtypeid,currentPage);


        companyPageBean.setUrl(url);
        req.setAttribute("pb",companyPageBean);

        return "f:/encryptWeb/admin/enterprises.jsp";
    }

    public String adminFindCompanyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int comid=Integer.parseInt(req.getParameter("comid"));

        Company company=companyService.findCompanyById(comid);

        req.setAttribute("company",company);

        return "f:/encryptWeb/admin/companyDetail.jsp";
    }

    public String addCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String comname=req.getParameter("comname");
            int comtype=Integer.parseInt(req.getParameter("comtype"));
            String cominfo=req.getParameter("content");

            Date date=new Date();
            String comtime=dateTools.date2Str(date);

            //获取上传的文件
            Part part=req.getPart("comimg");
            //获取请求的信息
            String name=part.getHeader("content-disposition");

            //获取上传文件的目录
            String root=req.getServletContext().getRealPath("/upload/company/img");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            if (str.equals(".png")||str.equals(".jpg")){
                //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
                String fname="";
                fname= UUID.randomUUID().toString()+str;

//                req.setAttribute("fname",fname);

                String filename=root+"\\"+fname;
//                String filename=root+"\\"+ UUID.randomUUID().toString()+str;
                System.out.println("测试产生新的文件名："+filename);

                //上传文件到指定目录，不想上传文件就不调用这个
                part.write(filename);

                Company company=new Company();
                company.setCom_name(comname);
                company.setComtype_id(comtype);
                company.setCom_info(cominfo);
                company.setCom_time(comtime);
                company.setCom_img(fname);

                System.out.println("来自servlet层的问候company.toString()："+company.toString());

                Integer comid=companyService.addCompany(company);

                if (comid==null){
                    req.setAttribute("msgAddCompany","公司增加失败！");
                }else {
                    Company newCompany=companyService.findCompanyById(comid);

                    req.setAttribute("company",newCompany);

                    req.setAttribute("msgAddCompany","公司增加成功");
                }
            }else{
                req.setAttribute("msgAddCompany", "上传文件失败！请上传.png或.jpg格式图片！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msgAddCompany", "公司增加失败！");
        }

        return "f:/encryptWeb/admin/companyDetail.jsp";
    }

    public String toUpdateCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int comid=Integer.parseInt(req.getParameter("comid"));
        Company company=companyService.findCompanyById(comid);

        req.setAttribute("company",company);
        return "f:/encryptWeb/admin/companyProfile.jsp";
    }

    public String updateCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int comid=Integer.parseInt(req.getParameter("comid"));
            String comname=req.getParameter("comname");
            int comtype=Integer.parseInt(req.getParameter("comtype"));
            String cominfo=req.getParameter("content");

            Date date=new Date();
            String comtime=dateTools.date2Str(date);

            //获取上传的文件
            Part part=req.getPart("comimg");
            //获取请求的信息
            String name=part.getHeader("content-disposition");

            //获取上传文件的目录
            String root=req.getServletContext().getRealPath("/upload/company/img");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            if (str.equals(".png")||str.equals(".jpg")){
                //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
                String fname="";
                fname= UUID.randomUUID().toString()+str;

//                req.setAttribute("fname",fname);

                String filename=root+"\\"+fname;
//                String filename=root+"\\"+ UUID.randomUUID().toString()+str;
                System.out.println("测试产生新的文件名："+filename);

                //上传文件到指定目录，不想上传文件就不调用这个
                part.write(filename);

                Company company=companyService.findCompanyById(comid);
                company.setCom_name(comname);
                company.setComtype_id(comtype);
                company.setCom_info(cominfo);
                company.setCom_time(comtime);
                company.setCom_img(fname);

                System.out.println("来自servlet层的问候company.toString()："+company.toString());

                companyService.updateCompany(company);

                Company newCompany=companyService.findCompanyById(comid);

                req.setAttribute("company",newCompany);
                req.setAttribute("msgUpdateCompany", "公司信息修改成功！");

            }else{
                req.setAttribute("msgUpdateCompany", "上传文件失败！请上传.png或.jpg格式图片！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msgUpdateCompany", "公司信息修改失败！");
        }

        return "f:/encryptWeb/admin/companyDetail.jsp";
    }

    public String deleteCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);

        int comid=Integer.parseInt(req.getParameter("comid"));
        Company company=companyService.findCompanyById(comid);
        String comname=company.getCom_name();

        companyService.deleteCompany(comid);

        PageBean<Company> companyPageBean=new PageBean<>();
        companyPageBean=companyService.adminFindAllCompanies(currentPage);
        companyPageBean.setUrl(url);
        companyPageBean.setCurrentPage(currentPage);
        companyPageBean.setTotalPages(companyPageBean.getTotalPages());

        req.setAttribute("pb",companyPageBean);
        req.setAttribute("msgDeleteCompany","公司\""+comname+"\"已删除");
        return "f:/encryptWeb/admin/enterprises.jsp";
    }

        //得到当前页
    private int getCurrentPage(HttpServletRequest req){
        int currentPage=1;
        String param=req.getParameter("currentPage");
        System.out.println("转换前的currentPage=param+"+param);
        if(param!=null && !param.trim().isEmpty()){ //trim() 方法用于删除字符串的头尾空白符
            try{
                currentPage=Integer.parseInt(param);
                System.out.println("转换后的currentPage="+currentPage);
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
        return currentPage;
    }

    //获取URL
    private String getUrl(HttpServletRequest req){
        String url=req.getRequestURI()+"?"+req.getQueryString();
        //如果URL中存在currentPage参数，截取掉
        int index=url.lastIndexOf("&currentPage=");
        if(index!=-1){
            url=url.substring(0,index);
        }
        return url;
    }
}
