package com.ausy_technologies_proiectfinal.Service;

import com.ausy_technologies_proiectfinal.Error.ErrorResponse;
import com.ausy_technologies_proiectfinal.Model.DAO.JobCategory;
import com.ausy_technologies_proiectfinal.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryService {

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategory saveJobCategory(JobCategory jobCategory){

        if(jobCategory.getJobName() != null && !jobCategory.getJobName().trim().isEmpty()) {
            return this.jobCategoryRepository.save(jobCategory);
        }
        else {
            throw new ErrorResponse("Job name is null or empty!",400);
        }
    }


    public List<JobCategory> findAllJobCategory(){
        List<JobCategory> jobCategoryList =  jobCategoryRepository.findAll();
        return jobCategoryList;
    }


    public JobCategory findJobById(int id){
        if(!this.jobCategoryRepository.findById(id).isPresent()) {
            throw new ErrorResponse("Job not found!",404);
        }

        return this.jobCategoryRepository.findById(id).get();
    }


    public void deleteJobCategory(int id){
        JobCategory jobCategory = null;
        try {
            jobCategory = jobCategoryRepository.findById(id).get();
        } catch (RuntimeException e) {
            throw new ErrorResponse(e.getMessage(),404);
        }
        jobCategoryRepository.delete(jobCategory);
    }

}