package br.com.erik.dsvendas.controllers;

import br.com.erik.dsvendas.dtos.SaleDTO;
import br.com.erik.dsvendas.dtos.SaleSucessDTO;
import br.com.erik.dsvendas.dtos.SaleSumDTO;
import br.com.erik.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
        List<SaleSumDTO> page = service.amountGroupedBySeller();
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/sucess-by-seller")
    public ResponseEntity<List<SaleSucessDTO>> successGroupedBySeller(){
        List<SaleSucessDTO> page = service.successGroupedBySeller();
        return ResponseEntity.ok(page);
    }
}
