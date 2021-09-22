package ro.mihaimacrea.Project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mihaimacrea.Project1.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository <Country, Long> {
}
