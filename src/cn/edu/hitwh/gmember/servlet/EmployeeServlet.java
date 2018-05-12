package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.service.IEmployeeService;
import cn.edu.hitwh.gmember.serviceImp.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService=new EmployeeServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String emppwd = req.getParameter("emppwd");
        System.out.println("+++++++++++++++++++" + empid);
        System.out.println("+++++++++++++++++++" + emppwd);
        Employee employee = new Employee();
        employee.setEmp_id(empid);
        employee.setEmp_pwd(emppwd);
        Employee employeeLogin = employeeService.login(employee);
        if (employeeLogin == null) {
            req.getSession().setAttribute("msgEmployeeLogin", "账号或密码错误！请重新输入！");
            resp.sendRedirect(req.getContextPath() + "/employeeLogin.jsp");
        } else {
            req.getSession().setAttribute("msgEmployeeLogin", "");
            req.getSession().setAttribute("Employee", employeeLogin);
            resp.sendRedirect(req.getContextPath() + "/encryptWeb/employee/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
