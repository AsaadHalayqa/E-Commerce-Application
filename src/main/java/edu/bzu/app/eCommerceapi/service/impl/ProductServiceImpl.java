package edu.bzu.app.eCommerceapi.service.impl;

import edu.bzu.app.eCommerceapi.dto.CategoryDto;
import edu.bzu.app.eCommerceapi.dto.ProductDto;
import edu.bzu.app.eCommerceapi.entity.Product;
import edu.bzu.app.eCommerceapi.exception.ResourceNotFoundException;
import edu.bzu.app.eCommerceapi.repository.ProductRepository;
import edu.bzu.app.eCommerceapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // convert DTO to entity
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);

        // convert entity to DTO
        ProductDto productResponse = mapToDTO(newProduct);
        return productResponse;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("product", "id", id));
        return mapToDTO(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        // get product by id from the database
        Product product = productRepository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("product", "id", id));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategoryId(productDto.getCategoryId());

        Product updateProduct = productRepository.save(product);
        return mapToDTO(updateProduct);
    }

    @Override
    public void deleteProductById(long id) {
        // get product by id from the database
        Product product = productRepository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("product", "id", id));
        productRepository.delete(product);
    }


    // convert Entity into DTO
    private ProductDto mapToDTO(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategoryId());

        return  productDto;
    }
    // convert DTO to entity
    private Product mapToEntity(ProductDto productDto){
        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategoryId(productDto.getCategoryId());

        return product;
    }

}
