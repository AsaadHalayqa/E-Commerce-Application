package edu.bzu.app.eCommerceapi.service;

import edu.bzu.app.eCommerceapi.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(long id);

    ProductDto updateProduct(ProductDto productDto, long id);

    void deleteProductById(long id);

}
