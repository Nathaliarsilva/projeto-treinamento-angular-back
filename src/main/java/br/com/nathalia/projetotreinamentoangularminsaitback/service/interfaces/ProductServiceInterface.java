package br.com.nathalia.projetotreinamentoangularminsaitback.service.interfaces;

import br.com.nathalia.projetotreinamentoangularminsaitback.model.Product;

import java.util.List;
import java.util.Optional;

public interface  ProductServiceInterface {
    Product save(Product product);
    Optional<Product> getById(Long id);
    List<Product> getAll();
    Product update(Long id, Product product);
    void delete(Long id);
}
