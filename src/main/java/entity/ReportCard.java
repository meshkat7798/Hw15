package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
//@NamedEntityGraphs(value = {
//        @NamedEntityGraph(
//                name = ReportCard.ENTITY_GRAPH,
//                attributeNodes = {
//                        @NamedAttributeNode(value = "course")
//                }
//        )
//}
//)
//@NamedEntityGraphs(
//        value = {
//                @NamedEntityGraph(
//                        name = ReportCard.ENTITY_GRAPH,
//                        attributeNodes = {
//                                @NamedAttributeNode(value = "course", subgraph = "course_subgraph")
//                        },
//                        subgraphs = {
//                                @NamedSubgraph(
//                                        name = "course_subgraph",
//                                        attributeNodes = {
//                                                @NamedAttributeNode(
//                                                        value = "lesson"
//                                                ),
//                                        }
//                                )
//                        }
//                )
//        }
//)
@SuppressWarnings("unused")
@Setter
@ToString
@Getter
@Table(name = "report_card")
@Entity
public class ReportCard extends BaseEntity<Integer> {

    public static final String ENTITY_GRAPH = "reportCard_entity_graph";

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Course course;

    private Double mark;

    @Column(name = "is_pass", columnDefinition = "Boolean default false")
    private Boolean isPass;

}