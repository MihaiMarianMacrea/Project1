package ro.mihaimacrea.Project1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COUNTRY_GEN")
    @SequenceGenerator(name="SEQ_COUNTRY_GEN", sequenceName = "country_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;
}
