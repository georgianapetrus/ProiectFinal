package com.ausy_technologies_proiectfinal.Model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_category")
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String jobName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "jobCategory",cascade = CascadeType.ALL)
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "JobCategories{" +
                "id=" + id +
                ", name='" + jobName + '\'' +
                '}';
    }
}