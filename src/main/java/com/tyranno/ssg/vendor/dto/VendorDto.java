package com.tyranno.ssg.vendor.dto;

import com.tyranno.ssg.users.domain.Users;
import com.tyranno.ssg.users.dto.UsersInfoDto;
import com.tyranno.ssg.vendor.domain.Vendor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDto {
    private Long vendorId;
    private String vendorName;
    private String vendorImageUrl;

    public static VendorDto FromEntity(Vendor vendor) {
        return VendorDto.builder()
                .vendorId(vendor.getId())
                .vendorName(vendor.getVendorName())
                .vendorImageUrl(vendor.getVendorImageUrl())
                .build();
    }
}
