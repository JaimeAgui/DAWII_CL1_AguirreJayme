package AguirreJayme.DAWII_CL1_AguirreJayme.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Especialidad")
public class Especilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdEsp;

    @Column(name = "NomEsp")
    private String NomEsp;

    @JsonManagedReference
    @OneToMany
    private List<Alumno> listasala = new ArrayList<>();
}
