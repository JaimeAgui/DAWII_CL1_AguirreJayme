package AguirreJayme.DAWII_CL1_AguirreJayme.service;

import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Especilidad;
import AguirreJayme.DAWII_CL1_AguirreJayme.repository.EspecilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EspecilidadService {

    @Autowired
    private EspecilidadRepository EspecilidadRepository;
    public List<Especilidad> listarEspecilidad(){
        return EspecilidadRepository.findAll();
    }
    public void registrarEspecilidad(Especilidad especilidad){
        EspecilidadRepository.save(especilidad);
    }
    public void eliminarEspecilidad(Especilidad especilidad){EspecilidadRepository.deleteById(especilidad.getIdEsp());
    }

}
