package ir.dte.boodgedaftar.dto;

import ir.dte.boodgedaftar.model.EdareKolViewModel;

import java.math.BigDecimal;
import java.util.List;

public class EdareKolViewDto {


    private BigDecimal mosavabSum = BigDecimal.ZERO;
    private BigDecimal takhsisSum = BigDecimal.ZERO;
    private BigDecimal amalkardSum = BigDecimal.ZERO;
    private BigDecimal amalkardNameDaryaftySum = BigDecimal.ZERO;
    private List<EdareKolViewModel> edareKolViewModelList;

    public BigDecimal getMosavabSum() {
        return mosavabSum;
    }

    public void setMosavabSum(BigDecimal mosavabSum) {
        this.mosavabSum = mosavabSum;
    }

    public BigDecimal getTakhsisSum() {
        return takhsisSum;
    }

    public void setTakhsisSum(BigDecimal takhsisSum) {
        this.takhsisSum = takhsisSum;
    }

    public BigDecimal getAmalkardSum() {
        return amalkardSum;
    }

    public void setAmalkardSum(BigDecimal amalkardSum) {
        this.amalkardSum = amalkardSum;
    }

    public BigDecimal getAmalkardNameDaryaftySum() {
        return amalkardNameDaryaftySum;
    }

    public void setAmalkardNameDaryaftySum(BigDecimal amalkardNameDaryaftySum) {
        this.amalkardNameDaryaftySum = amalkardNameDaryaftySum;
    }

    public List<EdareKolViewModel> getEdareKolViewModelList() {
        return edareKolViewModelList;
    }

    public void setEdareKolViewModelList(List<EdareKolViewModel> edareKolViewModelList) {
        this.edareKolViewModelList = edareKolViewModelList;
    }
}
