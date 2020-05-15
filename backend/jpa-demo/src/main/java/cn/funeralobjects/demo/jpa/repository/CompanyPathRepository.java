package cn.funeralobjects.demo.jpa.repository;

import cn.funeralobjects.demo.jpa.entity.CompanyPath;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:36 PM
 */
public interface CompanyPathRepository extends JpaRepository<CompanyPath, Integer> {

    @Override
    @EntityGraph("CompanyPath.withCompany")
    List<CompanyPath> findAll();

    @Override
    @EntityGraph("CompanyPath.withCompany")
    List<CompanyPath> findAll(Sort sort);

    @Override
    @EntityGraph("CompanyPath.withCompany")
    List<CompanyPath> findAllById(Iterable<Integer> integers);

    @Override
    @EntityGraph("CompanyPath.withCompany")
    <S extends CompanyPath> List<S> findAll(Example<S> example);

    @Override
    @EntityGraph("CompanyPath.withCompany")
    <S extends CompanyPath> List<S> findAll(Example<S> example, Sort sort);

    @Override
    @EntityGraph("CompanyPath.withCompany")
    Page<CompanyPath> findAll(Pageable pageable);

    @Override
    @EntityGraph("CompanyPath.withCompany")
    <S extends CompanyPath> Page<S> findAll(Example<S> example, Pageable pageable);
}
