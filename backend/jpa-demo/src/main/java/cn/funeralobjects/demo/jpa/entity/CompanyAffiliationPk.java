package cn.funeralobjects.demo.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:26 PM
 */
@Data
@Accessors(chain = true)
@Embeddable
public class CompanyAffiliationPk implements Serializable {

    private Integer id;
    private Integer paternalId;

}
