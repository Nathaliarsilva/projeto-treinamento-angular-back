package br.com.nathalia.projetotreinamentoangularminsaitback.service;

import br.com.nathalia.projetotreinamentoangularminsaitback.repository.ProductRepository;
import br.com.nathalia.projetotreinamentoangularminsaitback.service.interfaces.ProductServiceInterface;
import br.com.nathalia.projetotreinamentoangularminsaitback.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product produto) {
        return productRepository.save(produto);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> upProduct = productRepository.findById(id);

        if(upProduct.isPresent()) {
            Product newProduct = upProduct.get();
            newProduct.setBarCode(product.getBarCode());
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            return productRepository.save(newProduct);
        }
        return product;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.deleteById(id);
        }
    }

}
