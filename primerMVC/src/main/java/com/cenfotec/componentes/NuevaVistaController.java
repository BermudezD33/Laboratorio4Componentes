package com.cenfotec.componentes;

import com.cenfotec.componentes.beans.PrimerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class NuevaVistaController {

    /**
     * Handles requests for the application home page.
     */

    private static final Logger logger = LoggerFactory.getLogger(com.cenfotec.componentes.HomeController.class);

    @Autowired
    private PrimerBean primerBean;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/NuevaVista", method = RequestMethod.GET)
    public String nuevaVista(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        primerBean = new PrimerBean();
        primerBean.setName("Daniel");
        primerBean.setApellido("Bermudez");

        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("nombre", primerBean);
        model.addAttribute("apellido", primerBean);


        return "nuevaVista";
    }

}


