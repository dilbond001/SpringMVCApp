package com.javacodegeeks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacodegeeks.dao.EmployeeDAO;
import com.javacodegeeks.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeDAO dao;

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		dao.deleteEmployeeBySsn(ssn);
	}

	@Override
	public Employee findById(int id) {		
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 dao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee entity = dao.findById(employee.getId());
        if(entity!=null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setSsn(employee.getSsn());
        }
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		System.out.println("inside EmployeeServiceImpl-------");

		return dao.findAllEmployees();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
	}
	
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }

}
