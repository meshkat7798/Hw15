package service.dto;

import entity.Teacher;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TeacherPaySlip implements Serializable {

        private Teacher teacher;

        private Long teachingUnits;

        private double salary;

}