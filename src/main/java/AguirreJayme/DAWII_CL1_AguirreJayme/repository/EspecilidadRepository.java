package AguirreJayme.DAWII_CL1_AguirreJayme.repository;

import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Especilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EspecilidadRepository extends JpaRepository<Especilidad, String> {
}
