package com.springboot.departmentservice.service;

import com.springboot.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long id);

    DepartmentDto updateDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentDto);



    void deleteDepartment(Long id);
}
