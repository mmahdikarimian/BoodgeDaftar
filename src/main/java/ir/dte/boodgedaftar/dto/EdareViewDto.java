package ir.dte.boodgedaftar.dto;

import ir.dte.boodgedaftar.model.EdareViewModel;

import java.math.BigDecimal;
import java.util.List;

public class EdareViewDto {


    private BigDecimal mosavabSum = BigDecimal.ZERO;
    private BigDecimal takhsisSum = BigDecimal.ZERO;
    private BigDecimal amalkardSum = BigDecimal.ZERO;
    private BigDecimal amalkardNameDaryaftiSum = BigDecimal.ZERO;
    private List<EdareViewModel> edareViewModelList;

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

    public List<EdareViewModel> getEdareViewModelList() {
        return edareViewModelList;
    }

    public void setEdareViewModelList(List<EdareViewModel> edareViewModelList) {
        this.edareViewModelList = edareViewModelList;
    }

    public BigDecimal getAmalkardSum() {
        return amalkardSum;
    }

    public void setAmalkardSum(BigDecimal amalkardSum) {
        this.amalkardSum = amalkardSum;
    }

    public BigDecimal getAmalkardNameDaryaftiSum() {
        return amalkardNameDaryaftiSum;
    }

    public void setAmalkardNameDaryaftiSum(BigDecimal amalkardNameDaryaftiSum) {
        this.amalkardNameDaryaftiSum = amalkardNameDaryaftiSum;
    }

    @Override
    public String toString() {
        return "EdareViewDto{" +
                "mosavabSum=" + mosavabSum +
                ", takhsisSum=" + takhsisSum +
                ", amalkardSum=" + amalkardSum +
                ", amalkardNameDaryaftiSum=" + amalkardNameDaryaftiSum +
                ", edareViewModelList=" + edareViewModelList +
                '}';
    }
}
