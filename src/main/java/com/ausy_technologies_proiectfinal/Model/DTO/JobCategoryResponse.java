package com.ausy_technologies_proiectfinal.Model.DTO;

import com.ausy_technologies_proiectfinal.Model.DAO.JobCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobCategoryResponse extends BaseResponse {

    JobCategory jobcategory;

    public JobCategoryResponse(Boolean success, String successMessage, JobCategory jobcategory) {
        super(success, successMessage);
        this.jobcategory = jobcategory;
    }
}
