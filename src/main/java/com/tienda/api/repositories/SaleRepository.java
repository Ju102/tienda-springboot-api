package com.tienda.api.repositories;

import com.tienda.api.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {

    // Equivalente a: _context.Sales.Where(v => v.IdUsuario == userId).Include(v => v.Producto).ToList()
    List<Sale> findByUserId(Integer userId);
}
