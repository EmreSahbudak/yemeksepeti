package com.bilgeadam.service;

import com.bilgeadam.controller.ProductController;
import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.entity.Product;
import com.bilgeadam.mapper.IProductMapper;
import com.bilgeadam.repository.IProductRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
    public String save(ProductSaveRequestDto dto){
        productRepository.save(IProductMapper.INSTANCE.toProduct(dto));
        return "Save Product Success";
    }
}
