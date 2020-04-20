package com.task.RestServer.service;

import com.task.RestServer.model.Laptop;
import com.task.RestServer.repository.ILaptopJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService implements ILaptopService {

    @Autowired
    private ILaptopJpaRepository iLaptopJpaRepository;

    @Override
    public List<Laptop> findPaginatedLaptops(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber , pageSize);
        Page<Laptop> laptopPage = iLaptopJpaRepository.findAll(pageable);

        return laptopPage.getContent();
    }

    public void addLaptop(Laptop laptop){
        iLaptopJpaRepository.save(laptop);
    }

    public void updateLaptop(Laptop laptop) {
            Optional<Laptop> optionalLaptop = iLaptopJpaRepository.findById(laptop.getId());
            if (optionalLaptop.isPresent()) {

                Laptop newLaptop = optionalLaptop.get();
                newLaptop.setId(laptop.getId());
                newLaptop.setDescription(laptop.getDescription());
                newLaptop.setPrice(laptop.getPrice());

                iLaptopJpaRepository.save(newLaptop);
            } else {
                throw new EntityNotFoundException("Laptop not found");
            }
        }

    public void deleteBook(long id){
        Optional<Laptop> optionalLaptop = iLaptopJpaRepository.findById(id);
        if (optionalLaptop.isPresent()){
            iLaptopJpaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Laptop not found by given id");
        }
    }
}
