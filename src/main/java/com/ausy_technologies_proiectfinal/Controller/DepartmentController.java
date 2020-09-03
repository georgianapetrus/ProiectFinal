package com.ausy_technologies_proiectfinal.Controller;

import com.ausy_technologies_proiectfinal.Error.ErrorResponse;
import com.ausy_technologies_proiectfinal.Model.DAO.Department;
import com.ausy_technologies_proiectfinal.Model.DTO.DepartmentResponse;
import com.ausy_technologies_proiectfinal.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentResponse> addDepartment(@RequestBody Department department) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "saveDepartment");
        Department departmentAdded;
        try {
            departmentAdded = this.departmentService.saveDepartment(department);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
                    .body(new DepartmentResponse(Boolean.FALSE, e.getErrorMessage(), null));
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders)
                .body(new DepartmentResponse(Boolean.TRUE, "", departmentAdded));
    }


    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Department department = null;
        try {
            department = departmentService.findDepartmentById(id);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "findDepartmentById");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(department);
    }


    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departmentList = new ArrayList<Department>();

        try {
            departmentList = departmentService.findAllDepartments();
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "findAllDepartments");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentList);
    }


    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "deleteDepartment");
        try {
            departmentService.deleteDepartment(id);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Department not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("Department deleted!");
    }
}