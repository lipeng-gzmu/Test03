package com.lipeng.springboot.controller;

import com.lipeng.springboot.dao.DepartmentDao;
import com.lipeng.springboot.dao.EmployeeDao;
import com.lipeng.springboot.entities.Department;
import com.lipeng.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String emp(Model model){
        Collection<Employee> list = employeeDao.getAll();
        model.addAttribute("emps",list);
        return "/emp/list";
    }
    //添加页面
    @GetMapping("/emp")
    public String addPage(Model model){
        Collection<Department> list = departmentDao.getDepartments();
        model.addAttribute("depts",list);
        return "/emp/add";

    }

    //添加操作
    @PostMapping("/addEmp")
    public String add(Employee employee){
        employeeDao.save(employee);
        //redirect:代表的是重定向到一个地址，/代表的是当前项目下
        //forword：转发到一个地址
        return "redirect:/emps";
    }

    //使用restFul方格传值查询员工进行回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")  Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //这个添加页面和修改页面合二为一使用
        return  "/emp/add";
    }
    //修改页面
    @PutMapping("/addEmp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return  "redirect:/emps";
    }
}
