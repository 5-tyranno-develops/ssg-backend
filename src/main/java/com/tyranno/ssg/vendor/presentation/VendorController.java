package com.tyranno.ssg.vendor.presentation;

import com.tyranno.ssg.global.ResponseEntity;
import com.tyranno.ssg.product.dto.ProductDetailDto;
import com.tyranno.ssg.vendor.application.VendorService;
import com.tyranno.ssg.vendor.dto.VendorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Tag(name ="판매자", description = "vendor API")
@RequestMapping("/api/v1/vendor")
@Slf4j
public class VendorController {
    private final VendorService vendorService;

    @Operation(summary = "Vendor 정보", description = "productId에 대한 vendor정보 불러오기")
    @GetMapping("/detail/{productId}")
    public ResponseEntity<?> getVendorDetail(@PathVariable(value = "productId") Long productId) {

        return new ResponseEntity<>(vendorService.findById(productId));
    }
}
