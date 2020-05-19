package cn.funeralobjects.demo.jpa.repository;

import cn.funeralobjects.demo.jpa.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:32 PM
 */
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {

    Optional<Company> findFirstByName(String name);
}
