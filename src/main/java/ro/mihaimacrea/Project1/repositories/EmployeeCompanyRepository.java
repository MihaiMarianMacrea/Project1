package ro.mihaimacrea.Project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import ro.mihaimacrea.Project1.entity.EmployeeCompany;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeCompanyRepository extends JpaRepository <EmployeeCompany, Long> {
    List<EmployeeCompany> findByEmployeeId(Long employeeId);

    @Modifying
    @Transactional
    void deleteByEmployeeId(Long employeeId);
}
