package sps.employees.history.SpsProject.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    private Long employee_id;
    private String name;
    private String lastname;
    private String birthDay;
    private String startingPosition;
    private String currentPosition;
    private List<CompanyItem> items = new ArrayList<>(); //OneToMany
    private List<Project> projectsOnCourse = new ArrayList<>(); //ManyToMany
    private List<Training>  trainings = new ArrayList<>(); //ManyToMany
    private Address address; //OneToOne

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 20)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }


    @Column(length = 20)
    public String getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(String startingPosition) {
        this.startingPosition = startingPosition;
    }

    @Column(length = 15)
    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    @OneToMany(mappedBy = "employee")
    public List<CompanyItem> getItems() {
        return items;
    }

    public void setItems(List<CompanyItem> items) {
        this.items = items;
    }

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    public List<Project> getProjectsOnCourse() {
        return projectsOnCourse;
    }

    public void setProjectsOnCourse(List<Project> projectsOnCourse) {
        this.projectsOnCourse = projectsOnCourse;
    }

    @ManyToMany
    @JoinTable(name = "employee_training",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @OneToOne(mappedBy = "employee")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
