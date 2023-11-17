package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EdareKol {
    private String name;
    private BigDecimal takhsis = BigDecimal.ZERO;
    private BigDecimal mosavab = BigDecimal.ZERO;
    private BigDecimal amalkard = BigDecimal.ZERO;
    private BigDecimal amalkardNameDaryafty = BigDecimal.ZERO;
    private BigDecimal gharardad = BigDecimal.ZERO;

    private List<Edare> edareList = new ArrayList<>();

    public List<Edare> getEdareList() {
        return edareList;
    }

    public void setEdareList(List<Edare> edareList) {
        this.edareList = edareList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTakhsis() {
        return takhsis;
    }

    public void setTakhsis(BigDecimal takhsis) {
        this.takhsis = takhsis;
    }

    public BigDecimal getMosavab() {
        return mosavab;
    }

    public void setMosavab(BigDecimal mosavab) {
        this.mosavab = mosavab;
    }

    public BigDecimal getAmalkard() {
        return amalkard;
    }

    public void setAmalkard(BigDecimal amalkard) {
        this.amalkard = amalkard;
    }

    public BigDecimal getAmalkardNameDaryafty() {
        return amalkardNameDaryafty;
    }

    public void setAmalkardNameDaryafty(BigDecimal amalkardNameDaryafty) {
        this.amalkardNameDaryafty = amalkardNameDaryafty;
    }


    public BigDecimal getGharardad() {
        return gharardad;
    }

    public void setGharardad(BigDecimal gharardad) {
        this.gharardad = gharardad;
    }
}
