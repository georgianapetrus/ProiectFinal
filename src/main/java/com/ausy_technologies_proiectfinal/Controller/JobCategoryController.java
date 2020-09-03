package com.ausy_technologies_proiectfinal.Controller;

import com.ausy_technologies_proiectfinal.Error.ErrorResponse;
import com.ausy_technologies_proiectfinal.Model.DAO.JobCategory;
import com.ausy_technologies_proiectfinal.Model.DTO.JobCategoryResponse;
import com.ausy_technologies_proiectfinal.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobcategory")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;


    @PostMapping("/addJobCategory")
    public ResponseEntity<JobCategoryResponse> addJobCategory(@RequestBody JobCategory jobCategory) {
        JobCategory jobCategoryAdded;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "addJobCategory");
        try {
            jobCategoryAdded = jobCategoryService.saveJobCategory(jobCategory);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
                    .body(new JobCategoryResponse(Boolean.FALSE, e.getErrorMessage(), null));
        }

        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders)
                .body(new JobCategoryResponse(Boolean.TRUE, "", jobCategory));
    }


    @GetMapping("/getAllJobCategory")
    public ResponseEntity<List<JobCategory>> getAllJobCategory() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getAllJobCategory");
        List<JobCategory> jobCategoryList;

        try {
            jobCategoryList = jobCategoryService.findAllJobCategory();
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategoryList);
    }


    @GetMapping("/getJobCategoryById/{id}")
    public ResponseEntity<JobCategory> getJobById(@PathVariable int id) {
        JobCategory jobCategory = null;

        try {
            jobCategory = jobCategoryService.findJobById(id);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "findJobById");

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategory);
    }


    @DeleteMapping("/deleteJobCategory/{id}")
    public ResponseEntity<String> deleteJobCategory(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "deleteJobCategory");
        try {
            jobCategoryService.deleteJobCategory(id);
        } catch (ErrorResponse e) {
            ErrorResponse.LogError(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Job not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("Job deleted!");
    }

}