package AguirreJayme.DAWII_CL1_AguirreJayme.controller;

import AguirreJayme.DAWII_CL1_AguirreJayme.model.bd.Especilidad;
import AguirreJayme.DAWII_CL1_AguirreJayme.service.EspecilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/especilidad")
public class EspecilidadController {

    @Autowired
    private EspecilidadService especilidadService;

    @GetMapping("/listarEspecilidad")
    @ResponseBody
    public List<Especilidad> listarEstados(){
        return especilidadService.listarEspecilidad();
    }

}
