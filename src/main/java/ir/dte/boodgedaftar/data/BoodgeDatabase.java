package ir.dte.boodgedaftar.data;

import ir.dte.boodgedaftar.model.Edare;
import ir.dte.boodgedaftar.model.EdareKol;
import ir.dte.boodgedaftar.model.Faaliat;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("boodgeData")
public class BoodgeDatabase {
    Workbook workbook = null;
    Sheet sheet = null;

    public List<Faaliat> faaliatList = new ArrayList<>();
    public List<Edare> edareList = new ArrayList<>();
    public List<EdareKol> edareKolList = new ArrayList<>();
    public List<String> edareHa = new ArrayList<>();

    public List<String> edareKols = new ArrayList<>();

    public BoodgeDatabase() throws IOException, InvalidFormatException {

        Resource resource = new ClassPathResource("static/files/database.xlsx");
        FileInputStream fileInputStream =
                new FileInputStream(resource.getFile());
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Faaliat faaliat = new Faaliat();
            if (row.getCell(0) == null)
                break;
            faaliat.id = new BigDecimal(row.getCell(0).getNumericCellValue());
            faaliat.title = row.getCell(1).getStringCellValue();
            faaliat.edareKol = row.getCell(2).getStringCellValue();
            faaliat.edare = row.getCell(3).getStringCellValue();
            if(faaliat.edare.contains("/"))
            {
                StringBuilder edare = new StringBuilder(faaliat.edare);
                edare.setCharAt(edare.indexOf("/"), '-');
                faaliat.edare = edare.toString();
            }
            faaliat.type = row.getCell(4).getStringCellValue();
            faaliat.ghotb = row.getCell(5).getStringCellValue();
            faaliat.miz = row.getCell(6).getStringCellValue();
            faaliat.amalkardNameDaryafti = new BigDecimal(row.getCell(7).getNumericCellValue());
            faaliat.gharardad = new BigDecimal(row.getCell(8).getNumericCellValue());
            faaliat.baghimandeGharardad = new BigDecimal(row.getCell(9).getNumericCellValue());
            faaliat.amalkardNameHayeDaryaftiVaBaghimandeGharardad = new BigDecimal(row.getCell(10).getNumericCellValue());
            try {
                faaliat.ghabelTakhsismenhayeBaghimandehGharardad = new BigDecimal(row.getCell(11).getNumericCellValue());
            }catch (Exception e){
                faaliat.ghabelTakhsismenhayeBaghimandehGharardad = BigDecimal.ZERO;
            }
            faaliat.ghanoon = new BigDecimal(row.getCell(12).getNumericCellValue());
            try {
                faaliat.mosavabSate = new BigDecimal(row.getCell(13).getNumericCellValue());
            }catch (Exception e){
                faaliat.mosavabSate = BigDecimal.ZERO;
            }
            faaliat.takhsisSate = new BigDecimal(row.getCell(14).getNumericCellValue());
            faaliat.amalkardSate = new BigDecimal(row.getCell(15).getNumericCellValue());
            faaliat.amalkardTaahodi = new BigDecimal(row.getCell(16).getNumericCellValue());
            faaliat.amalkardKol = new BigDecimal(row.getCell(17).getNumericCellValue());
            try {
                faaliat.ghabelTakhsis = new BigDecimal(row.getCell(18).getNumericCellValue());
            }catch (Exception e){
                faaliat.ghabelTakhsis = BigDecimal.ZERO;
            }
            faaliatList.add(faaliat);
        }


        //estekhraje edare ha az faaliatList (be soorat code anjam shod chon emkane copy kardan be soorate dasti nabood)
        for (Faaliat faaliat : faaliatList)
        {
            if (!edareHa.contains(faaliat.edare))
                edareHa.add(faaliat.edare);
        }

        for (String edare : edareHa){
            Edare newEdare = new Edare();
            newEdare.setName(edare);
            for (Faaliat faaliat : faaliatList) {
                if (faaliat.edare.equals(edare)){
                    newEdare.setEdareKol(faaliat.edareKol);
                    newEdare.getFaaliatList().add(faaliat);
                    newEdare.setTakhsis(newEdare.getTakhsis().add(faaliat.takhsisSate));
                    newEdare.setMosavab(newEdare.getMosavab().add(faaliat.mosavabSate));
                    newEdare.setAmalkard(newEdare.getAmalkard().add(faaliat.amalkardSate));
                    newEdare.setAmalkardNameDaryafti(newEdare.getAmalkardNameDaryafti().add(faaliat.amalkardNameDaryafti));
                    newEdare.setGharardad(newEdare.getGharardad().add(faaliat.gharardad));
                }
            }
            edareList.add(newEdare);
        }

        //estekhraje edare kol ha az faaliatList (be soorat code anjam shod chon emkane copy kardan be soorate dasti nabood)
        for (Faaliat faaliat : faaliatList)
        {
            if (!edareKols.contains(faaliat.edareKol)) {
                edareKols.add(faaliat.edareKol);
            }
        }

        for (String edareKol :edareKols) {
            EdareKol newedareKol = new EdareKol();
            newedareKol.setName(edareKol);
            for(Edare edare : edareList){
                if (edare.getEdareKol().equals(edareKol)){
                    newedareKol.getEdareList().add(edare);
                    newedareKol.setTakhsis(newedareKol.getTakhsis().add(edare.getTakhsis()));
                    newedareKol.setMosavab(newedareKol.getMosavab().add(edare.getMosavab()));
                    newedareKol.setAmalkard(newedareKol.getAmalkard().add(edare.getAmalkard()));
                    newedareKol.setAmalkardNameDaryafty(newedareKol.getAmalkardNameDaryafty().add(edare.getAmalkardNameDaryafti()));
                    newedareKol.setGharardad(newedareKol.getGharardad().add(edare.getGharardad()));
                }
            }
            edareKolList.add(newedareKol);
        }

        System.out.println("\n\n\n======================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
        for (Faaliat faaliat : faaliatList)
        {
            System.out.println(faaliat.toString() + "\n" +
                    "======================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
        }
        System.out.println("\n\n\n===============\n"+"count is :"+ faaliatList.size()+ "\n===============");
    }


}

