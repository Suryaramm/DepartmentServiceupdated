package com.springboot.departmentservice.mapper;


import com.springboot.departmentservice.dto.DepartmentDto;
import com.springboot.departmentservice.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartment_name(),
                department.getDepartment_description(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartment_name(),
                departmentDto.getDepartment_description(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
