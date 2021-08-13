package com.codegym.demo.Repository;

import com.codegym.demo.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface INationRepository extends PagingAndSortingRepository<Nation,Long> {
}
