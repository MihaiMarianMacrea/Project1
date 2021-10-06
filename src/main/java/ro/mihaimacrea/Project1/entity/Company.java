package ro.mihaimacrea.Project1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPANY_GEN")
    @SequenceGenerator(name="SEQ_COMPANY_GEN", sequenceName = "company_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;
    private String description;
    private Long revenues;
    private Boolean isActive;  // atentie ->  boolean vs Boolean la generarea de getteri setteri
    private LocalDate incorporationDate;
    @ManyToOne
    private City city;

//    public Boolean getActive() {    //th:field = "*{active}"
//        return isActive;
//    }

//    public boolean isActive() {
//        return isActive;
//    }
}
