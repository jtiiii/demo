package cn.funeralobjects.demo.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:24 PM
 */
@Entity
@Table(name = "t_company")
@Data
@Accessors(chain = true)
@Embeddable
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,length = 40, nullable = false)
    private String name;
    @Column(length = 11, nullable = false)
    private Integer parentId;
}
