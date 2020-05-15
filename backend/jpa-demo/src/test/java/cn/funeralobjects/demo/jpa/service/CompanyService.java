package cn.funeralobjects.demo.jpa.service;

import cn.funeralobjects.demo.jpa.entity.Company;
import cn.funeralobjects.demo.jpa.entity.CompanyAffiliation;
import cn.funeralobjects.demo.jpa.entity.CompanyAffiliationPk;
import cn.funeralobjects.demo.jpa.entity.CompanyPath;
import cn.funeralobjects.demo.jpa.repository.CompanyAffiliationRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyPathRepository;
import cn.funeralobjects.demo.jpa.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author FuneralObjects
 * Create date: 2020/5/15 3:25 PM
 */
@Service
@Transactional(readOnly = true)
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private CompanyAffiliationRepository companyAffiliationRepository;

    @Resource
    private CompanyPathRepository companyPathRepository;


    @Transactional(rollbackFor = Exception.class)
    public Company saveCompany(String name, Integer parentId){
        CompanyPath parentPath = companyPathRepository.findById(parentId).orElseThrow(IllegalArgumentException::new);
        Company company = companyRepository.save(new Company().setName(name).setParentId(parentId));
        saveCompanyOther(company.getId(), parentPath.getPath());
        return company;
    }

    @Transactional(rollbackFor = Exception.class)
    public Company saveCompany(String name){
        Company company = companyRepository.save(new Company().setName(name).setParentId(0));
        List<Integer> parentPath = Collections.singletonList(0);
        saveCompanyOther(company.getId(), parentPath);
        return company;
    }

    private void saveCompanyOther(Integer id, List<Integer> parentPath ){
        List<Integer> idPath = new ArrayList<>(parentPath.size() + 1);
        idPath.addAll(parentPath);
        idPath.add(id);
        companyPathRepository.save(new CompanyPath().setId(id).setPath(idPath));
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<CompanyAffiliation> affiliations = parentPath.stream().filter( pid -> !pid.equals(0)).map( pid -> new CompanyAffiliation()
                .setPk(new CompanyAffiliationPk().setId(id).setPaternalId(pid))
                .setGen((short) atomicInteger.incrementAndGet())
                .setCompany(new Company().setId(id))
                .setPaternal(new Company().setId(pid))
        ).collect(Collectors.toList());
        companyAffiliationRepository.saveAll(affiliations);
    }


}
