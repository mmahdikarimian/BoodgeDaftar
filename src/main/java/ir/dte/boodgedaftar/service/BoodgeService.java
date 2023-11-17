package ir.dte.boodgedaftar.service;

import ir.dte.boodgedaftar.data.BoodgeDatabase;
import ir.dte.boodgedaftar.model.Edare;
import ir.dte.boodgedaftar.model.EdareKol;
import org.springframework.stereotype.Service;

@Service
public class BoodgeService {

    BoodgeDatabase boodgeDatabase;

    public BoodgeService(BoodgeDatabase boodgeDatabase){
        this.boodgeDatabase = boodgeDatabase;
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


}
