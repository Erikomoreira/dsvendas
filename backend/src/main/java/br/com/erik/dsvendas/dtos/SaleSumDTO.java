package br.com.erik.dsvendas.dtos;

import br.com.erik.dsvendas.entities.Seller;

import java.io.Serializable;

public class SaleSumDTO implements Serializable {

    private String sellerName;
    private Double soma;

    public SaleSumDTO() {
    }

    public SaleSumDTO(Seller seller, Double soma) {
        sellerName = seller.getName();
        this.soma = soma;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }
}
