package sps.employees.history.SpsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sps.employees.history.SpsProject.domain.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {
}
