package cn.funeralobjects.demo.jpa;

import cn.funeralobjects.demo.jpa.entity.Company;
import cn.funeralobjects.demo.jpa.repository.CompanyAffiliationRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyPathRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyRepository;
import cn.funeralobjects.demo.jpa.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    private CompanyPathRepository pathRepository;

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
    }

}
