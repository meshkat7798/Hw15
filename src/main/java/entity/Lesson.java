package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuppressWarnings("unused")
@Entity
public class Lesson extends BaseEntity<Integer> {

    public static final String ENTITY_GRAPH = "reportCard_entity_graph";

    private String title;

    private Long unit;

    @Override
    public String toString() {
        return "Lesson{" +
                "id = " + getId() +'\'' +
                " title='" + title + '\'' +
                ", unit=" + unit +
                "} ";
    }
}