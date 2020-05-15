package cn.funeralobjects.demo.jpa.entity;

import cn.funeralobjects.demo.jpa.converter.PathConverter;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:27 PM
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_company_path")
@NamedEntityGraph(name = "CompanyPath.withCompany", attributeNodes = {@NamedAttributeNode("company")})
public class CompanyPath implements Serializable {
    @Id
    private Integer id;
    @Column(unique = true, nullable = false)
    @Convert(converter = PathConverter.class)
    private List<Integer> path;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "id")
    private Company company;
}
