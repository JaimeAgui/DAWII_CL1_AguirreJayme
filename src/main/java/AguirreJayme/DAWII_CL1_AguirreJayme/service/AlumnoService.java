package AguirreJayme.DAWII_CL1_AguirreJayme.service;

import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Alumno;
import AguirreJayme.DAWII_CL1_AguirreJayme.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<Alumno> listarAlumno(){return alumnoRepository.findAll();
    }
    public  void registrarAlumno(Alumno alumno){alumnoRepository.save(alumno);
    }
    public void eliminarAlumno(String IdAlumno){alumnoRepository.deleteById(IdAlumno);
    }

}
