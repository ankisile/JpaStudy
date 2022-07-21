package com.example.bunjang.service;

import com.example.bunjang.dto.ProductReqDTO;
import com.example.bunjang.entity.Product;
import com.example.bunjang.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public void register(ProductReqDTO productReqDTO) {
        Product product = Product.builder()
                .title(productReqDTO.getTitle())
                .category(productReqDTO.getCategory())
                .explanation(productReqDTO.getExplanation())
                .address(productReqDTO.getAddress())
                .price(productReqDTO.getPrice())
                .build();

        productRepository.save(product);
    }
}