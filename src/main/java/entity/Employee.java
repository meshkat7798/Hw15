package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends User {

    @Column(name = "employee_number")
    private String employeeNumber;


    public Employee(String firstName, String lastName, String userName, String password, String employeeNumber) {
        super(firstName, lastName, userName, password);
        this.employeeNumber = employeeNumber;
    }

    public Employee(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + getId() +'\'' +
                " employeeNumber='" + employeeNumber + '\'' +
                "} ";
    }
}