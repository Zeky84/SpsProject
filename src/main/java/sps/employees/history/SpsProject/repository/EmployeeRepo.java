package sps.employees.history.SpsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sps.employees.history.SpsProject.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    //Implementing query method to look by job position
    List<Employee> findByCurrentPosition(String currentPosition);

    List<Employee> findByName(String name);


//    The below method is to implements a QUERY METHOD WITH SPRING DATA JPA
    @Query("select e from Employee e" //all the OneToOne can be fetched and only one OneToMany or ManyToMany
    + " left join fetch e.address"
    + " left join  e.projectsOnCourse"
    + " left join  e.trainings"
    + " left join  fetch e.items")
    List<Employee> findAll(); //NOTE: If use only 'join' won't display all e, will display the e that have all tables with all the info.
    // join fetch will make the query just one time, and this is a very good approach, we don't want a fetch for every
    // employee because this will put the resources of the database server to it's limits
    }