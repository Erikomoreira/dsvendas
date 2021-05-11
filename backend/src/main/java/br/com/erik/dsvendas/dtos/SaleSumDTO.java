package br.com.erik.dsvendas.dtos;

import br.com.erik.dsvendas.entities.Seller;

import java.io.Serializable;

public class SaleSumDTO implements Serializable {

    private String sellerName;
    private Double sumAmount;

    public SaleSumDTO() {
    }

    public SaleSumDTO(Seller seller, Double sum) {
        sellerName = seller.getName();
        this.sumAmount = sum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }
}
