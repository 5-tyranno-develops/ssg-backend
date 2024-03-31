package com.tyranno.ssg.product.presentation;

import com.tyranno.ssg.category.application.CategoryService;
import com.tyranno.ssg.category.dto.CategoryProductIdListDto;
import com.tyranno.ssg.global.ResponseEntity;
import com.tyranno.ssg.product.application.ProductService;
import com.tyranno.ssg.product.dto.DiscountDto;
import com.tyranno.ssg.product.dto.ProductDetailDto;
import com.tyranno.ssg.product.dto.ProductInformationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "상품", description = "상품 API")
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Operation(summary = "상품 상세페이지", description = "상품 상세페이지를 열기")
    @GetMapping("/detail/{productId}")
    public ResponseEntity<ProductDetailDto> productDetail(@PathVariable Long productId) {
        log.info("productDetail 실행");
        log.info(productId.toString());

        ProductDetailDto productDetailDto = productService.productDetail(productId);

        return new ResponseEntity<>(productDetailDto);
    }

    @Operation(summary = "상품 ID 리스트", description = "상품 ID 리스트를 받아오기")
    @GetMapping("/productList")
    public ResponseEntity<?> ProductIdList(
            @RequestParam(required = false) Long largeId,
            @RequestParam(required = false) Long middleId,
            @RequestParam(required = false) Long smallId,
            @RequestParam(required = false) Long detailId,
            @RequestParam(defaultValue = "5") String sortCriterion
    ) {
        CategoryProductIdListDto categoryProductIdListDto = productService.productIdList(largeId,middleId,smallId,detailId,sortCriterion);
        return new ResponseEntity<>(categoryProductIdListDto);
    }

    @Operation(summary = "리스트용 상품 정보", description = "상품 ID로 상품정보")
    @GetMapping("/productInformation/{productId}")
    public ResponseEntity<?> ProductInformation(@PathVariable Long productId) {
        ProductInformationDto productDto = productService.getProductInformation(productId);
        return new ResponseEntity<>(productDto);
    }

    @Operation(summary = "리스트용 할인 정보", description = "상품 ID로 할인정보")
    @GetMapping("/discountInformation/{productId}")
    public ResponseEntity<?> getDiscountInformation(@PathVariable Long productId) {
        DiscountDto discountDto = productService.getDiscount(productId);
        return new ResponseEntity<>(discountDto);
    }

}