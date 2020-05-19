package cn.funeralobjects.demo.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

/**
 * @author FuneralObjects
 * Create date: 2020/5/18 9:53 AM
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "t_dept_person",
            inverseJoinColumns = @JoinColumn(name = "personnel_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    private Set<Personnel> departments;
}
