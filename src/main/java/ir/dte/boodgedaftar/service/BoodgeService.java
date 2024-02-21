package ir.dte.boodgedaftar.service;

import ir.dte.boodgedaftar.data.BoodgeDatabase;
import ir.dte.boodgedaftar.dto.EdareKolViewDto;
import ir.dte.boodgedaftar.dto.EdareViewDto;
import ir.dte.boodgedaftar.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoodgeService {

    BoodgeDatabase boodgeDatabase;

    public BoodgeService(BoodgeDatabase boodgeDatabase)
    {
        this.boodgeDatabase = boodgeDatabase;
    }


    //region edare
    public EdareViewDto getAllEdare()
    {
        EdareViewDto edareViewDto = new EdareViewDto();
        List<EdareViewModel> edareViewModels = new ArrayList<>();
        List<Faaliat> faaliatList = boodgeDatabase.faaliatList;
        List<Faaliat> tempFaaliat = new ArrayList<>();
        for (String edare : boodgeDatabase.edareHa)
        {
            for (Faaliat faaliat : faaliatList)
            {
                if (faaliat.edare.equals(edare))
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

        return edareViewDto;
    }

    public Edare getEdareDetails(String edareName){
        for(Edare edare : boodgeDatabase.edareList)
        {
            if (edare.getName().equals(edareName))
            {
                return edare;
            }
        }
        return null;
    }

    //endregion

    //region edarekol
    public EdareKolViewDto getAllEdareKol()
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

        return edareKolViewDto;
    }

    public EdareKol getEdareKolDetails(String edareKolName)
    {
        for (EdareKol edareKol : boodgeDatabase.edareKolList)
        {
            if (edareKol.getName().equals(edareKolName))
            {
                return edareKol;
            }
        }

        return null;
    }
    //endregion


}
