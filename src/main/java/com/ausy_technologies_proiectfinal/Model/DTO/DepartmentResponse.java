package com.ausy_technologies_proiectfinal.Model.DTO;

import com.ausy_technologies_proiectfinal.Model.DAO.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentResponse extends BaseResponse {

    Department department;

    public DepartmentResponse(Boolean success, String successMessage, Department department) {
        super(success, successMessage);
        this.department = department;
    }
}
