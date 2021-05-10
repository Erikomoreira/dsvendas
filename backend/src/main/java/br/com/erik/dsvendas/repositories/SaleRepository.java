package br.com.erik.dsvendas.repositories;

import br.com.erik.dsvendas.dtos.SaleSucessDTO;
import br.com.erik.dsvendas.dtos.SaleSumDTO;
import br.com.erik.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new br.com.erik.dsvendas.dtos.SaleSumDTO(obj.seller, sum(obj.amount)) "
    + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new br.com.erik.dsvendas.dtos.SaleSucessDTO(obj.seller, sum(obj.visited), sum(obj.deals)) "
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSucessDTO> successGroupedBySeller();
}
