package com.codegym.demo.service.Nation;

import com.codegym.demo.Repository.INationRepository;
import com.codegym.demo.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class NationService implements INationService  {
    @Autowired
    INationRepository iNationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return iNationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return iNationRepository.findById(id);
    }

    @Override
    public void save(Nation nation) {
        iNationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
            iNationRepository.deleteById(id);
    }
}
