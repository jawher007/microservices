package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.client.CarsServiceClient;
import com.mycompany.myapp.domain.Owner;
import com.mycompany.myapp.repository.OwnerRepository;
import com.mycompany.myapp.service.OwnerService;
import com.mycompany.myapp.service.dto.OwnerDTO;
import com.mycompany.myapp.service.mapper.OwnerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Owner}.
 */
@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;
    @Autowired
    CarsServiceClient carsServiceClient ;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;

    }

    @Override
    public OwnerDTO save(OwnerDTO ownerDTO) {
        log.debug("Request to save Owner : {}", ownerDTO);
        Owner owner = ownerMapper.toEntity(ownerDTO);
        owner = ownerRepository.save(owner);
        return ownerMapper.toDto(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OwnerDTO> findAll() {
        log.debug("Request to get all Owners");
       log.info(" zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz \n \n"+carsServiceClient.getAllCars().toString()+"\n \n zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz") ;
        return ownerRepository.findAll().stream()
            .map(ownerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<OwnerDTO> findOne(Long id) {
        log.debug("Request to get Owner : {}", id);
        return ownerRepository.findById(id)
            .map(ownerMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Owner : {}", id);
        ownerRepository.deleteById(id);
    }
}
