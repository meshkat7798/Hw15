package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Term {

    private Integer year;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "mid_term")
    private MidTerm midTerm;

}
