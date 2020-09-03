package com.ausy_technologies_proiectfinal.Model.DTO;

import com.ausy_technologies_proiectfinal.Model.DAO.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeResponse extends BaseResponse {

    Employee employee;

    public EmployeeResponse(Boolean success, String successMessage, Employee employee) {
        super(success, successMessage);
        this.employee = employee;
    }
}
