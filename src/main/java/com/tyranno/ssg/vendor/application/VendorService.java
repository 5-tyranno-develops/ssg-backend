package com.tyranno.ssg.vendor.application;

import com.tyranno.ssg.vendor.domain.VendorProduct;
import com.tyranno.ssg.vendor.dto.VendorDto;
import com.tyranno.ssg.vendor.dto.VendorProductDto;

import java.util.Optional;

public interface VendorService {
    VendorProductDto getVendorByProductId(Long productId);
    VendorDto findById(Long id);
}
