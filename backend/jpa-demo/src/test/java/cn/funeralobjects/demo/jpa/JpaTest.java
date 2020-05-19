package cn.funeralobjects.demo.jpa;

import cn.funeralobjects.demo.jpa.entity.Company;
import cn.funeralobjects.demo.jpa.entity.CompanyPath;
import cn.funeralobjects.demo.jpa.repository.CompanyAffiliationRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyPathRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyRepository;
import cn.funeralobjects.demo.jpa.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.Arrays;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:38 PM
 */
@SpringBootTest(classes = JpaTestApplication.class, properties = "application.yml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTest {

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private CompanyAffiliationRepository companyAffiliationRepository;

    @Resource
    private CompanyPathRepository companyPathRepository;

    @Resource
    private CompanyService companyService;

    @Test
    public void saveTest() {
        Company tencent = companyService.saveCompany("tencent");
        Company yuewen = companyService.saveCompany("yuewen", tencent.getId());
        Company qidian = companyService.saveCompany("qidian", yuewen.getId());

    }

    @Test
    public void findTest() {
        companyRepository.findFirstByName("tencent")
                .map(tencent -> companyAffiliationRepository.findAllByPk_PaternalId(tencent.getId()))
                .ifPresent(paternals -> {
                    paternals.forEach(affiliation -> System.out.println(affiliation.getCompany().getName()));
                });

        companyRepository.findAll((Specification<Company>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), "qidian"))
                .stream()
                .map(Company::getName)
                .forEach(System.out::println);

        companyPathRepository.findAll((Specification<CompanyPath>) (root, query, criteriaBuilder) -> {
            Join<CompanyPath, Company> join = root.join("company", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), "qidian");
        }).forEach(companyPath -> {
            System.out.println(Arrays.toString(companyPath.getPath().toArray()));
        });


//        companyService.findTest(1);
//        System.out.println("--- test ---");
//        companyService.findTest(1);

    }

}
