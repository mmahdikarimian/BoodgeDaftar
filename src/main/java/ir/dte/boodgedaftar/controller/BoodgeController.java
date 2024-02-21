package ir.dte.boodgedaftar.controller;

import ir.dte.boodgedaftar.dto.EdareKolViewDto;
import ir.dte.boodgedaftar.dto.EdareViewDto;
import ir.dte.boodgedaftar.model.Edare;
import ir.dte.boodgedaftar.model.EdareKol;
import ir.dte.boodgedaftar.service.BoodgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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


    @GetMapping("/edaredetails/{edareName}")
    public Edare getEdareDetails(@PathVariable String edareName)
    {
        return boodgeService.getEdareDetails(edareName);
    }

    //endregion

    //region edarekol

    @GetMapping("/showalledarekol")
    public EdareKolViewDto getAllEdareKol()
    {
        return boodgeService.getAllEdareKol();
    }
    @GetMapping("/edarekoldetails/{edareKolName}")
    public EdareKol getEdareKolDetails(@PathVariable String edareKolName)
    {
        return boodgeService.getEdareKolDetails(edareKolName);
    }
    //endregion

}
