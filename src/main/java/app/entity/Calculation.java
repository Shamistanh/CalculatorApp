package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "operation")
    private String operation;

    @Column(name = "res")
    private Double res;

    @Column(name = "status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status;

    @ManyToOne
    @JoinTable(name = "calc_user",
            joinColumns = { @JoinColumn(
                    name = "c_id",
                    referencedColumnName = "c_id"
            ) },
            inverseJoinColumns = { @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "usr_id"
            ) }
    )
    private XUser xUser;

}