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
import java.util.Arrays;
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
            faaliat.id = BigDecimal.valueOf(row.getCell(0).getNumericCellValue());
            faaliat.title = row.getCell(1).getStringCellValue();
            faaliat.edareKol = row.getCell(2).getStringCellValue();
            if (faaliat.edareKol.contains("فضای مجازی"))
            {
                faaliat.edareKolURL = "majazi";
            }else if (faaliat.edareKol.contains("معاونت"))
            {
                faaliat.edareKolURL = "moavenat";
            }else if (faaliat.edareKol.contains("امور اجرایی"))
            {
                faaliat.edareKolURL = "ejraii";
            }else if (faaliat.edareKol.contains("هنر و رسانه"))
            {
                faaliat.edareKolURL = "honarvarasaneh";
            }
            faaliat.edare = row.getCell(3).getStringCellValue();
            if (faaliat.edare.contains("آموزش"))
            {
                faaliat.edareURL = "amoozesh";
            } else if (faaliat.edare.contains("تصویری"))
            {
                faaliat.edareURL = "tasviri";
            } else if (faaliat.edare.contains("تولیدات رسانه ای"))
            {
                faaliat.edareURL = "tolidatrasaneh";
            } else if (faaliat.edare.contains("هنرهای تجسمی"))
            {
                faaliat.edareURL = "tajasomi";
            } else if (faaliat.edare.contains("پشتیبانی و تعاملات رسانه ای"))
            {
                faaliat.edareURL = "poshtibanivataamolat";
            } else if (faaliat.edare.contains("مشاوره و تامین محتوا"))
            {
                faaliat.edareURL = "moshaverehvatamin";
            } else if (faaliat.edare.contains("انجمن ها"))
            {
                faaliat.edareURL = "anjoman";
            } else if (faaliat.edare.contains("اداره نشریات"))
            {
                faaliat.edareURL = "nashriat";
            } else if (faaliat.edare.contains("اداره هنرهای ادبی"))
            {
                faaliat.edareURL = "adabi";
            } else if (faaliat.edare.contains("هزینه اداری عمومی"))
            {
                faaliat.edareURL  = "edarivaomoomi";
            } else if (faaliat.edare.contains("اداره فناوری اطلاعات"))
            {
                faaliat.edareURL = "fanavari";
            } else if (faaliat.edare.contains("اداره عرضه محصولات فرهنگی هنری"))
            {
                faaliat.edareURL = "arzeh";
            } else if (faaliat.edare.contains("واحد کتابخانه"))
            {
                faaliat.edareURL =  "ketabkhaneh";
            } else if (faaliat.edare.contains("حوزه معاونت"))
            {
                faaliat.edareURL = "moavenat";
            } else if (faaliat.edare.contains("گروه برنامه و بودجه"))
            {
                faaliat.edareURL = "boodge";
            } else if (faaliat.edare.contains("مدیریت راهبردی"))
            {
                faaliat.edareURL = "rahbordi";
            } else if (faaliat.edare.contains("اداره تولید و تامین برنامه و محتوای فضای مجازی"))
            {
                faaliat.edareURL = "tolidvatamin";
            } else if (faaliat.edare.contains("اداره پایش و رصد فضای مجازی"))
            {
                faaliat.edareURL = "payeshvarasad";
            } else if (faaliat.edare.contains("اداره جذب و توسعه فعالان فضای مجازی"))
            {
                faaliat.edareURL = "jazbvatoseeh";
            } else if (faaliat.edare.contains("اداره همکاری های فضای مجازی"))
            {
                faaliat.edareURL = "hamkariha";
            } else if (faaliat.edare.contains("اداره کل فضای مجازی"))
            {
                faaliat.edareURL = "edarekolfazamajazi";
            }

            if(faaliat.edare.contains("/"))
            {
                StringBuilder edare = new StringBuilder(faaliat.edare);
                edare.setCharAt(edare.indexOf("/"), '-');
                faaliat.edare = edare.toString();
            }
            faaliat.type = row.getCell(4).getStringCellValue();
            faaliat.ghotb = row.getCell(5).getStringCellValue();
            faaliat.miz = row.getCell(6).getStringCellValue();
            faaliat.amalkardNameDaryafti = BigDecimal.valueOf(row.getCell(7).getNumericCellValue());
            faaliat.gharardad = BigDecimal.valueOf(row.getCell(8).getNumericCellValue());
            faaliat.baghimandeGharardad = BigDecimal.valueOf(row.getCell(9).getNumericCellValue());
            faaliat.amalkardNameHayeDaryaftiVaBaghimandeGharardad = BigDecimal.valueOf(row.getCell(10).getNumericCellValue());
            try {
                faaliat.ghabelTakhsismenhayeBaghimandehGharardad = BigDecimal.valueOf(row.getCell(11).getNumericCellValue());
            }catch (Exception e){
                faaliat.ghabelTakhsismenhayeBaghimandehGharardad = BigDecimal.ZERO;
            }
            faaliat.ghanoon = BigDecimal.valueOf(row.getCell(12).getNumericCellValue());
            try {
                faaliat.mosavabSate = BigDecimal.valueOf(row.getCell(13).getNumericCellValue());
            }catch (Exception e){
                faaliat.mosavabSate = BigDecimal.ZERO;
            }
            faaliat.takhsisSate = BigDecimal.valueOf(row.getCell(14).getNumericCellValue());
            faaliat.amalkardSate = BigDecimal.valueOf(row.getCell(15).getNumericCellValue());
            faaliat.amalkardTaahodi = BigDecimal.valueOf(row.getCell(16).getNumericCellValue());
            faaliat.amalkardKol = BigDecimal.valueOf(row.getCell(17).getNumericCellValue());
            try {
                faaliat.ghabelTakhsis = BigDecimal.valueOf(row.getCell(18).getNumericCellValue());
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

            if (newEdare.getName().contains("آموزش"))
            {
                newEdare.setEdareURL("amoozesh");
            } else if (newEdare.getName().contains("تصویری"))
            {
                newEdare.setEdareURL("tasviri");
            } else if (newEdare.getName().contains("تولیدات رسانه ای"))
            {
                newEdare.setEdareURL("tolidatrasaneh");
            } else if (newEdare.getName().contains("هنرهای تجسمی"))
            {
                newEdare.setEdareURL("tajasomi");
            } else if (newEdare.getName().contains("پشتیبانی و تعاملات رسانه ای"))
            {
                newEdare.setEdareURL("poshtibanivataamolat");
            } else if (newEdare.getName().contains("مشاوره و تامین محتوا"))
            {
                newEdare.setEdareURL("fmoshaverehvatamin");
            } else if (newEdare.getName().contains("انجمن ها"))
            {
                newEdare.setEdareURL("anjoman");
            } else if (newEdare.getName().contains("اداره نشریات"))
            {
                newEdare.setEdareURL("nashriat");
            } else if (newEdare.getName().contains("اداره هنرهای ادبی"))
            {
                newEdare.setEdareURL("adabi");
            } else if (newEdare.getName().contains("هزینه اداری عمومی"))
            {
                newEdare.setEdareURL("edarivaomoomi");
            } else if (newEdare.getName().contains("اداره فناوری اطلاعات"))
            {
                newEdare.setEdareURL("fanavari");
            } else if (newEdare.getName().contains("اداره عرضه محصولات فرهنگی هنری"))
            {
                newEdare.setEdareURL("arzeh");
            } else if (newEdare.getName().contains("واحد کتابخانه"))
            {
                newEdare.setEdareURL("ketabkhaneh");
            } else if (newEdare.getName().contains("حوزه معاونت"))
            {
                newEdare.setEdareURL("moavenat");
            } else if (newEdare.getName().contains("گروه برنامه و بودجه"))
            {
                newEdare.setEdareURL("boodge");
            } else if (newEdare.getName().contains("مدیریت راهبردی"))
            {
                newEdare.setEdareURL("rahbordi");
            } else if (newEdare.getName().contains("اداره تولید و تامین برنامه و محتوای فضای مجازی"))
            {
                newEdare.setEdareURL("tolidvatamin");
            } else if (newEdare.getName().contains("اداره پایش و رصد فضای مجازی"))
            {
                newEdare.setEdareURL("payeshvarasad");
            } else if (newEdare.getName().contains("اداره جذب و توسعه فعالان فضای مجازی"))
            {
                newEdare.setEdareURL("jazbvatoseeh");
            } else if (newEdare.getName().contains("اداره همکاری های فضای مجازی"))
            {
                newEdare.setEdareURL("hamkariha");
            } else if (newEdare.getName().contains("اداره کل فضای مجازی"))
            {
                newEdare.setEdareURL("edarekolfazamajazi");
            }

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

            if (newedareKol.getName().contains("فضای مجازی"))
            {
                newedareKol.setEdarekolUrl("majazi");
            }else if (newedareKol.getName().contains("معاونت"))
            {
                newedareKol.setEdarekolUrl("moavenat");
            }else if (newedareKol.getName().contains("امور اجرایی"))
            {
                newedareKol.setEdarekolUrl("ejraii");
            }else if (newedareKol.getName().contains("هنر و رسانه"))
            {
                newedareKol.setEdarekolUrl("honarvarasaneh");
            }

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

        System.out.println(edareKolList.toString());

        System.out.println("\n\n\n======================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
        for (Faaliat faaliat : faaliatList)
        {
            System.out.println(faaliat.toString() + "\n" +
                    "======================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
        }
        System.out.println("\n\n\n===============\n"+"count is :"+ faaliatList.size()+ "\n===============");
    }


}

