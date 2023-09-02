package com.springboot.departmentservice.service.iml;

import com.springboot.departmentservice.dto.DepartmentDto;
import com.springboot.departmentservice.entity.Department;
import com.springboot.departmentservice.mapper.DepartmentMapper;
import com.springboot.departmentservice.repository.DepartmentRepository;
import com.springboot.departmentservice.service.DepartmentService;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

            List<Department> users = departmentRepository.findAll();
        return users.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());

//        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());

//            return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
//                    .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).get();


        return DepartmentMapper.mapToDepartmentDto(department);

    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {

      Department exitDepartment=departmentRepository.findById(departmentDto.getId()).get();
        exitDepartment.setDepartment_name(departmentDto.getDepartment_name());
        exitDepartment.setDepartment_description(departmentDto.getDepartment_description());
        exitDepartment.setDepartmentCode(departmentDto.getDepartmentCode());
        Department updateDepartment=departmentRepository.save(exitDepartment);
        return DepartmentMapper.mapToDepartmentDto(updateDepartment);
        //return modelMapper.map(updatedUser, UserDto.class);
//        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentDto) {
        Department department=departmentRepository.findByDepartmentCode(departmentDto);

        DepartmentDto departmentDto1=new DepartmentDto(
                department.getId(),
                department.getDepartment_name(),
                department.getDepartment_description(),
                department.getDepartmentCode()
        );
        return departmentDto1;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


}
