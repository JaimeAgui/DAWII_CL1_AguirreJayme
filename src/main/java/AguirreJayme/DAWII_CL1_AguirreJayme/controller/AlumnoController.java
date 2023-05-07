package AguirreJayme.DAWII_CL1_AguirreJayme.controller;


import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Alumno;
import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Especilidad;
import AguirreJayme.DAWII_CL1_AguirreJayme.model.request.AlumnoRequest;
import AguirreJayme.DAWII_CL1_AguirreJayme.model.response.ResultadoResponse;
import AguirreJayme.DAWII_CL1_AguirreJayme.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/lista")
    public String lista(Model model){
        model.addAttribute("listaAlumno", alumnoService.listarAlumno());
        return "frmMantAlumno";
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody
                                             AlumnoRequest aluRequest){
        String mensaje = "alumno registrada correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno= new Alumno();

            objAlumno.setIdalumno(aluRequest.getIdalumno());
            objAlumno.setApealumno(aluRequest.getApealumno());
            objAlumno.setNomalumno(aluRequest.getNomalumno());
            objAlumno.setProce(aluRequest.getProce());
            Especilidad objespec = new Especilidad();
            objespec.setNomesp(aluRequest.getIdesp());

            objAlumno.setEspecilidad(objespec);
            alumnoService.registrarAlumno(objAlumno);
        }catch (Exception ex){
            mensaje = "alumno no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarSala(@RequestBody
                                          AlumnoRequest aluRequest){
        String mensaje = "alumno eliminada correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(aluRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "alumno no eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumno")
    @ResponseBody
    public List<Alumno> listarAlumno(){return alumnoService.listarAlumno();}


}
