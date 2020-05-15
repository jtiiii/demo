package cn.funeralobjects.demo.jpa.repository;

import cn.funeralobjects.demo.jpa.entity.CompanyAffiliation;
import cn.funeralobjects.demo.jpa.entity.CompanyAffiliationPk;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:33 PM
 */
public interface CompanyAffiliationRepository extends JpaRepository<CompanyAffiliation, CompanyAffiliationPk> {

    @EntityGraph("CompanyAffiliation.withCompany")
    List<CompanyAffiliation> findAllByPk_PaternalId(Integer paternalId);
}
