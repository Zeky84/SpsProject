package sps.employees.history.SpsProject.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "trainings")
public class Training {
    private Long training_id;
    private String training_name;
    private List<Employee> employee_training = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Long training_id) {
        this.training_id = training_id;
    }

    @Column(length = 40)
    public String getTraining_name() {
        return training_name;
    }

    public void setTraining_name(String training_name) {
        this.training_name = training_name;
    }

    @ManyToMany(mappedBy = "trainings")
    public List<Employee> getEmployee_training() {
        return employee_training;
    }

    public void setEmployee_training(List<Employee> employee_training) {
        this.employee_training = employee_training;
    }
}
