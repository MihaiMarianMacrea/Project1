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
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COUNTRY_GEN")
    @SequenceGenerator(name="SEQ_COUNTRY_GEN", sequenceName = "country_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;

    @OneToMany
    private City city;
}
