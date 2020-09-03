package com.ausy_technologies_proiectfinal.Repository;

import com.ausy_technologies_proiectfinal.Model.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Override
    List<Employee> findAll();

    @Override
    Optional<Employee> findById(Integer integer);
}