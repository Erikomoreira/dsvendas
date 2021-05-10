package br.com.erik.dsvendas.services;

import br.com.erik.dsvendas.dtos.SaleDTO;
import br.com.erik.dsvendas.dtos.SaleSucessDTO;
import br.com.erik.dsvendas.dtos.SaleSumDTO;
import br.com.erik.dsvendas.entities.Sale;
import br.com.erik.dsvendas.repositories.SaleRepository;
import br.com.erik.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll(); //salva no cache, para evitar novas buscas
        Page<Sale> result = repository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
      return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSucessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();
    }
}
