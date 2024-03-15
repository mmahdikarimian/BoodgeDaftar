package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Edare {
    private String name;
    private String edareURL;
    private String edareKol;
    private BigDecimal takhsis = BigDecimal.ZERO;
    private BigDecimal mosavab = BigDecimal.ZERO;
    private BigDecimal amalkard = BigDecimal.ZERO;
    private BigDecimal amalkardNameDaryafti = BigDecimal.ZERO;
    private BigDecimal gharardad = BigDecimal.ZERO;

    private List<Faaliat> faaliatList = new ArrayList<>();

    public List<Faaliat> getFaaliatList() {
        return faaliatList;
    }

    public void setFaaliatList(List<Faaliat> faaliatList) {
        this.faaliatList = faaliatList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdareKol() {
        return edareKol;
    }

    public void setEdareKol(String edareKol) {
        this.edareKol = edareKol;
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

    public BigDecimal getAmalkardNameDaryafti() {
        return amalkardNameDaryafti;
    }

    public void setAmalkardNameDaryafti(BigDecimal amalkardNameDaryafti) {
        this.amalkardNameDaryafti = amalkardNameDaryafti;
    }
    public BigDecimal getGharardad() {
        return gharardad;
    }

    public void setGharardad(BigDecimal gharardad) {
        this.gharardad = gharardad;
    }

    public String getEdareURL() {
        return edareURL;
    }

    public void setEdareURL(String edareURL) {
        this.edareURL = edareURL;
    }

    @Override
    public String toString() {
        return "Edare{" +
                "name='" + name + '\'' +
                ", edareURL='" + edareURL + '\'' +
                ", edareKol='" + edareKol + '\'' +
                ", takhsis=" + takhsis +
                ", mosavab=" + mosavab +
                ", amalkard=" + amalkard +
                ", amalkardNameDaryafti=" + amalkardNameDaryafti +
                ", gharardad=" + gharardad +
                ", faaliatList=" + faaliatList +
                '}';
    }
}
