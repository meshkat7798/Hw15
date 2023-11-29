package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public class User extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String userName;

    private String password;

    public User( String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}