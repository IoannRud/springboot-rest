package com.task.RestServer.service;

import com.task.RestServer.model.Laptop;

import java.util.List;

public interface ILaptopService {
    List<Laptop> findPaginatedLaptops(int pageNumber , int pageSize);
}
