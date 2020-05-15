package cn.funeralobjects.demo.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:26 PM
 */
@Entity
@Table(name = "t_company_affiliation")
@Data
@Accessors(chain = true)
@NamedEntityGraph(name = "CompanyAffiliation.withCompany", attributeNodes = {@NamedAttributeNode("company")})
public class CompanyAffiliation {
    @EmbeddedId
    private CompanyAffiliationPk pk;
    private Short gen;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paternal_id", insertable = false, updatable = false)
    @MapsId("paternalId")
    private Company paternal;

}
