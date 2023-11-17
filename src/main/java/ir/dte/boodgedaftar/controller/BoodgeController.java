package ir.dte.boodgedaftar.controller;

import ir.dte.boodgedaftar.data.BoodgeDatabase;
import ir.dte.boodgedaftar.dto.EdareKolViewDto;
import ir.dte.boodgedaftar.dto.EdareViewDto;
import ir.dte.boodgedaftar.model.*;
import ir.dte.boodgedaftar.service.BoodgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boodge")
public class BoodgeController {

    @Autowired
    BoodgeDatabase boodgeDatabase;
    BoodgeService boodgeService;

    public BoodgeController(BoodgeService boodgeService){
        this.boodgeService = boodgeService;
    }


    @GetMapping("/showalledare")
    public ModelAndView getAllEdare(Map<String, Object> model)
    {
        EdareViewDto edareViewDto = new EdareViewDto();
        List<EdareViewModel> edareViewModels = new ArrayList<>();
        List<Faaliat> faaliatList = boodgeDatabase.faaliatList;
        List<Faaliat> tempFaaliat = new ArrayList<>();
        for (String edare : boodgeDatabase.edareHa)
        {
            for (Faaliat faaliat : faaliatList)
            {
                    if (faaliat.edare == edare)
                        tempFaaliat.add(faaliat);
            }

            EdareViewModel edareViewModel = new EdareViewModel();
            edareViewModel.edareName = edare;
            for (Faaliat faaliat : tempFaaliat)
            {
                edareViewModel.takhsis = edareViewModel.takhsis.add(faaliat.takhsisSate);
                edareViewModel.mosavab = edareViewModel.mosavab.add( faaliat.mosavabSate);
                edareViewModel.pardakhti = edareViewModel.pardakhti.add(faaliat.amalkardNameDaryafti);
                edareViewModel.amalkard = edareViewModel.amalkard.add(faaliat.amalkardSate);
                edareViewModel.amalkardNameDaryafti = edareViewModel.amalkardNameDaryafti.add(faaliat.amalkardNameDaryafti);
                edareViewModel.gharardad = edareViewModel.gharardad.add(faaliat.gharardad);
                edareViewDto.setMosavabSum(edareViewDto.getMosavabSum().add(faaliat.mosavabSate));
                edareViewDto.setTakhsisSum(edareViewDto.getTakhsisSum().add(faaliat.takhsisSate));
                edareViewDto.setAmalkardSum(edareViewDto.getAmalkardSum().add(faaliat.amalkardSate));
                edareViewDto.setAmalkardNameDaryaftiSum(edareViewDto.getAmalkardNameDaryaftiSum().add(faaliat.amalkardNameDaryafti));
            }

            edareViewModels.add(edareViewModel);

            tempFaaliat.clear();
        }
        edareViewDto.setEdareViewModelList(edareViewModels);


        model.put("edare", edareViewDto);
        System.out.println(Arrays.toString(edareViewDto.getEdareViewModelList().toArray()));
        return new ModelAndView("views/boodge/showAllEdare");
    }


    @GetMapping("/showalledarekol")
    public ModelAndView getAllEdareKol(Map<String, Object> model)
    {
        EdareKolViewDto edareKolViewDto = new EdareKolViewDto();
        List<EdareKolViewModel> edareKolViewModels = new ArrayList<>();
        List<Faaliat> tempFaaliat = new ArrayList<>();
        List<Faaliat> faaliatList = boodgeDatabase.faaliatList;




        for (String edareKol : boodgeDatabase.edareKols)
        {
            for (Faaliat faaliat : faaliatList)
            {
                if (edareKol.equals(faaliat.edareKol))
                    tempFaaliat.add(faaliat);
            }




            EdareKolViewModel edareKolViewModel = new EdareKolViewModel();
            edareKolViewModel.edareKolName = edareKol;
            for (Faaliat faaliat : tempFaaliat)
            {
                edareKolViewModel.takhsis = edareKolViewModel.takhsis.add(faaliat.takhsisSate);
                edareKolViewModel.mosavab = edareKolViewModel.mosavab.add(faaliat.mosavabSate);
                edareKolViewModel.amalkardNameDaryafty = edareKolViewModel.amalkardNameDaryafty.add(faaliat.amalkardNameDaryafti);
                edareKolViewModel.amalkard = edareKolViewModel.amalkard.add(faaliat.amalkardSate);
                edareKolViewModel.gharardad = edareKolViewModel.gharardad.add(faaliat.gharardad);
                edareKolViewDto.setMosavabSum(edareKolViewDto.getMosavabSum().add(faaliat.mosavabSate));
                edareKolViewDto.setTakhsisSum(edareKolViewDto.getTakhsisSum().add(faaliat.takhsisSate));
                edareKolViewDto.setAmalkardSum(edareKolViewDto.getAmalkardSum().add(faaliat.amalkardSate));
                edareKolViewDto.setAmalkardNameDaryaftySum(edareKolViewDto.getAmalkardNameDaryaftySum().add(faaliat.amalkardNameDaryafti));
            }

            edareKolViewModels.add(edareKolViewModel);

            tempFaaliat.clear();
        }
        edareKolViewDto.setEdareKolViewModelList(edareKolViewModels);

        model.put("edarekol", edareKolViewDto);
        System.out.println(Arrays.toString(edareKolViewDto.getEdareKolViewModelList().toArray()));

        return new ModelAndView("views/boodge/showAllEdareKol");
    }

    @GetMapping("/edarekoldetails/{edareKolName}")
    public ModelAndView getEdareKolDetails(Map<String, Object> model, @PathVariable String edareKolName)
    {
        EdareKol edareKol = boodgeService.getEdareKolDetails(edareKolName);
        model.put("edarekol", edareKol);

        return new ModelAndView("views/boodge/showEdareKolDetails");
    }

    @GetMapping("/edaredetails/{edareName}")
    public ModelAndView getEdareDetails(Map<String, Object> model, @PathVariable String edareName)
    {
        Edare edare = boodgeService.getEdareDetails(edareName);
        model.put("edare", edare);

        return new ModelAndView("views/boodge/showEdareDetails");
    }


    @GetMapping("/test")
    public ModelAndView getById(Map<String, Object> model) {

        BigDecimal b1 = new BigDecimal("18999.999");
        MathContext m = new MathContext(3, RoundingMode.HALF_UP);
        BigDecimal b2 = b1.round(m);
        System.out.println(b2 + "------>" +b2);
        model.put("message", "hello");

        return new ModelAndView( "test");
    }

}
