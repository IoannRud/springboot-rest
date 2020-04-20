package com.task.RestServer.controller;

import com.task.RestServer.service.ILaptopService;
import com.task.RestServer.service.LaptopService;
import com.task.RestServer.model.Laptop;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Test task Rest api server")
@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ILaptopService iLaptopService;

    @ApiOperation(value = "Get list of laptops by page , one page contains 10 laptops. Index starts by zero.")
    @GetMapping("/page/{pageNumber}")
    public List<Laptop> getAllLaptops(@PathVariable int pageNumber ){
        int pageSize = 10;
        return iLaptopService.findPaginatedLaptops(pageNumber , pageSize);
    }

    @PostMapping("/add")
    public void addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
    }

    @PutMapping("/update")
    public void updateLaptop(@RequestBody Laptop laptop){
        laptopService.updateLaptop(laptop);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLaptop(@PathVariable long id){
        laptopService.deleteBook(id);
    }
}
