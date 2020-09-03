package com.ausy_technologies_proiectfinal.Repository;

import com.ausy_technologies_proiectfinal.Model.DAO.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {

    @Override
    List<JobCategory> findAll();

    @Override
    Optional<JobCategory> findById(Integer integer);

    //Optional<JobCategory> findByName(String name);

    void deleteById(int id);
}