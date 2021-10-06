package ro.mihaimacrea.Project1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE_COMPANY_GEN")
    @SequenceGenerator(name="SEQ_EMPLOYEE_COMPANY_GEN", sequenceName = "employee_company_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Employee employee;

}
