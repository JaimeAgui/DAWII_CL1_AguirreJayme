package AguirreJayme.DAWII_CL1_AguirreJayme.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdAlumno;
    @Column(name = "ApeAlumno")
    private String ApeAlumno;
    @Column(name = "NomAlumno")
    private String NomAlumno;
    @Column(name = "IdEsp")
    private String IdEsp;
    @Column(name = "Proce")
    private String Proce;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idestado")
    private Especilidad estado;

}
