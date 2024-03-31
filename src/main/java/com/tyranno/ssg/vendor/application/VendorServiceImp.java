package com.tyranno.ssg.vendor.application;

import com.tyranno.ssg.global.GlobalException;
import com.tyranno.ssg.global.ResponseStatus;
import com.tyranno.ssg.vendor.dto.VendorDto;
import com.tyranno.ssg.vendor.dto.VendorProductDto;
import com.tyranno.ssg.vendor.infrastructure.VendorProductRepository;
import com.tyranno.ssg.vendor.infrastructure.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class VendorServiceImp implements VendorService{
    private final VendorRepository vendorRepository;
    private final VendorProductRepository vendorProductRepository;
    @Autowired
    public VendorServiceImp(VendorRepository vendorRepository, VendorProductRepository vendorProductRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorProductRepository = vendorProductRepository;
    }

    @Override // vendorProduct 테이블에서 productId로 vendorId를 찾기
    public VendorProductDto getVendorByProductId(Long productId) {
        return vendorProductRepository.findByProductId(productId)
                .map(VendorProductDto::FromEntity)
                .orElseThrow(() -> new GlobalException(ResponseStatus.NO_EXIST_VENDORPRODUCT));
    }

    @Override // vendor에서 vendorId로 조회
    public VendorDto findById(Long productId) {
        Long id = getVendorByProductId(productId).getVendorId();
        return vendorRepository.findById(id)
                .map(VendorDto::FromEntity)
                .orElseThrow(() -> new GlobalException(ResponseStatus.NO_EXIST_VENDOR));
    }

}
