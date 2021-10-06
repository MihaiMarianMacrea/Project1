package ro.mihaimacrea.Project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mihaimacrea.Project1.entity.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Long> {
    List<Company> findByOrderByCityCountryNameAscNameAsc();

    List<Company> findByIdIn(List<Long> companyIds);
}
