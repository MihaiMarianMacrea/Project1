package ro.mihaimacrea.Project1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE_GEN")
    @SequenceGenerator(name="SEQ_EMPLOYEE_GEN", sequenceName = "employee_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer salary;
    private Boolean isActive;
    @ManyToOne
    private Company company;

}
