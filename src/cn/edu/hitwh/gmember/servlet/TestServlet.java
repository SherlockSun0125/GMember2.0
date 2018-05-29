package cn.edu.hitwh.gmember.servlet;

import cn.itcast.servlet.BaseServlet;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

//注解的方式声明servlet的路径
@WebServlet("/TestServlet")
@MultipartConfig
public class TestServlet extends BaseServlet {

    public String uploadImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取文件描述信息
            String desc=req.getParameter("desc");
            //获取上传的文件
            Part part=req.getPart("file");
            //获取请求的信息
            String name=part.getHeader("content-disposition");
            //System.out.println(name);//测试使用
            //System.out.println(desc);//

            //获取上传文件的目录
            String root=req.getServletContext().getRealPath("/upload/company/img");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
            //String filename=root+"\\"+UUID.randomUUID().toString()+str;
            String fname="";
            fname="17862700872"+str;

            req.setAttribute("fname",fname);

            String filename=root+"\\"+fname;
            System.out.println("测试产生新的文件名："+filename);

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            req.setAttribute("info", "上传文件成功");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("info", "上传文件失败");
        }

        return "f:/upload.jsp";

    }
}