package com.tyranno.ssg.vendor.dto;

import com.tyranno.ssg.vendor.domain.Vendor;
import com.tyranno.ssg.vendor.domain.VendorProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VendorProductDto {
    private Long vendorId;
    private Long productId;

    public static VendorProductDto FromEntity(VendorProduct vendorProduct) {
        return VendorProductDto.builder()
                .productId(vendorProduct.getProduct().getId())
                .vendorId(vendorProduct.getVendor().getId())
                .build();
    }
}
