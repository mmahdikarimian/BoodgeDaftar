package ir.dte.boodgedaftar.controller;

import ir.dte.boodgedaftar.dto.EdareKolViewDto;
import ir.dte.boodgedaftar.dto.EdareViewDto;
import ir.dte.boodgedaftar.model.Edare;
import ir.dte.boodgedaftar.model.EdareKol;
import ir.dte.boodgedaftar.service.BoodgeService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boodge")
public class BoodgeController {

    BoodgeService boodgeService;

    public BoodgeController(BoodgeService boodgeService)
    {
        this.boodgeService = boodgeService;
    }

    //region edare
    @GetMapping("/showalledare")
    public EdareViewDto getAllEdare()
    {
        return boodgeService.getAllEdare();
    }


    @GetMapping("/edaredetails/{edareURL}")
    public Edare getEdareDetails(@PathVariable String edareURL)
    {
        return boodgeService.getEdareDetails(edareURL);
    }

    //endregion

    //region edarekol

    @GetMapping("/showalledarekol")
    public EdareKolViewDto getAllEdareKol()
    {
        return boodgeService.getAllEdareKol();
    }
    @GetMapping("/edarekoldetails/{edareKolURL}")
    public EdareKol getEdareKolDetails(@PathVariable String edareKolURL)
    {
        return boodgeService.getEdareKolDetails(edareKolURL);
    }
    //endregion

    @GetMapping("/test")
    public String test(Authentication authentication)
    {
        return "hello hello" +authentication.getAuthorities();
    }

}
