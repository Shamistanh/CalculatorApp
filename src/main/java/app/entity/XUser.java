package app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class XUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "xUser")
    private List<Calculation> calcs;


}
