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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CITY_GEN")
    @SequenceGenerator(name="SEQ_CITY_GEN", sequenceName = "city_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;
    private Long population;

    @ManyToOne
    private Country country;
}
