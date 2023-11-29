package service;

import entity.Employee;
import service.dto.EmployeePaySlip;

@SuppressWarnings("unused")
public interface EmployeeService extends UserService<Employee> {

    EmployeePaySlip showPaySlip();

}