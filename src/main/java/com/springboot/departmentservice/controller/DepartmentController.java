package com.springboot.departmentservice.controller;

import com.springboot.departmentservice.dto.DepartmentDto;
import com.springboot.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
@PostMapping
    public ResponseEntity<DepartmentDto>  saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment= departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> listAllTasks=departmentService.getAllDepartments();
        return new ResponseEntity<>(listAllTasks,HttpStatus.OK);
    }
//    @GetMapping("{id}")
//    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id){
//            DepartmentDto department = departmentService.getDepartmentById(id);
//        return new ResponseEntity<>(department, HttpStatus.OK);
//    }

    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long id,
                                              @RequestBody  DepartmentDto departmentDto){
        departmentDto.setId(id);
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("department successfully deleted!", HttpStatus.OK);
    }
    @GetMapping("code/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode){
      DepartmentDto departmentDto=  departmentService.getDepartmentByCode(departmentCode);
      return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
