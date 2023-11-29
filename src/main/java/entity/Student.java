package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph
@Getter
@Setter
@ToString
@Entity
public class Student extends User{

    @Column(name = "student_number")
    private String studentNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private Set<ReportCard> reportCards;

    public Student(String firstName, String lastName, String userName, String password, String studentNumber) {
        super(firstName, lastName, userName, password);
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id = "+getId()+
                " studentNumber = '" + studentNumber + '\'' +
                ", reportCards = " + reportCards +
                '}';
    }
}