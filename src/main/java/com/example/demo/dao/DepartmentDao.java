package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments=null;
    static {
        departments=new HashMap<Integer, Department>();

        departments.put(1,new Department(1,"教育部"));
        departments.put(2,new Department(2,"市场部"));
        departments.put(3,new Department(3,"教研部"));
        departments.put(4,new Department(4,"运营部"));
        departments.put(5,new Department(5,"后勤部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
