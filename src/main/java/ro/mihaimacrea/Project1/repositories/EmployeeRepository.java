package ro.mihaimacrea.Project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mihaimacrea.Project1.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
