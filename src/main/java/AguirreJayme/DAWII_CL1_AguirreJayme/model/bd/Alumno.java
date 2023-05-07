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
    private String idalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "nomalumno")
    private String nomalumno;
    @Column(name = "proce")
    private String proce;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especilidad especilidad;

}
