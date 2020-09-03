package com.ausy_technologies_proiectfinal.Service;

import com.ausy_technologies_proiectfinal.Error.ErrorResponse;
import com.ausy_technologies_proiectfinal.Model.DAO.Department;
import com.ausy_technologies_proiectfinal.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department findDepartmentById(int id){
        if(!this.departmentRepository.findById(id).isPresent()) {
            throw new ErrorResponse("Department not found!",404);
        }
        return this.departmentRepository.findById(id).get();
    }


    public Department saveDepartment(Department department){
        if (department.getDepartmentName() != null && !department.getDepartmentName().trim().isEmpty()) {
            return departmentRepository.save(department);
        }

        else
        {
            throw new ErrorResponse("Department name is null or empty!",400);
        }
    }


    public List<Department> findAllDepartments(){
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList;

    }


    public void deleteDepartment(int id){
        Department department;
        try {
            department = departmentRepository.findById(id).get();
        } catch (RuntimeException e) {
            throw new ErrorResponse(e.getMessage(),404);
        }
        departmentRepository.delete(department);
    }

}