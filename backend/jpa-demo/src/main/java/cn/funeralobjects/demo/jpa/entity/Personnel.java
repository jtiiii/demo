package cn.funeralobjects.demo.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

/**
 * @author FuneralObjects
 * Create date: 2020/5/18 10:02 AM
 */
@Entity
@Table(name = "t_personnel")
@Data
@Accessors(chain = true)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "t_dept_person",
            joinColumns = @JoinColumn(name = "personnel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    private Set<Department> departments;
}
