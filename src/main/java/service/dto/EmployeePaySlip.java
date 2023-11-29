package service.dto;

import entity.Employee;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class EmployeePaySlip implements Serializable {

    private Employee employee ;

    private double salary;

}