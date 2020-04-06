package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    private static Integer initid=6;

    @Autowired
    private  DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer, Employee>();

        employees.put(1,new Employee(1,"A","jizhidehd@gmail.com",1,new Department(1,"教育部")));
        employees.put(2,new Employee(2,"B","jizhidehd@gmail.com",0,new Department(2,"市场部")));
        employees.put(3,new Employee(3,"C","jizhidehd@gmail.com",1,new Department(3,"教研部")));
        employees.put(4,new Employee(4,"D","jizhidehd@gmail.com",0,new Department(4,"运营部")));
        employees.put(5,new Employee(5,"E","jizhidehd@gmail.com",1,new Department(5,"后勤部")));
    }

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
