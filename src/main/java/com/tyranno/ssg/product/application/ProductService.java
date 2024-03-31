package com.tyranno.ssg.product.application;

import com.tyranno.ssg.category.dto.CategoryProductIdListDto;
import com.tyranno.ssg.product.dto.*;

public interface ProductService {


    ProductDetailDto productDetail(Long id);

    CategoryProductIdListDto productIdList(Long largeId, Long middleId, Long smallId, Long detailId, String sortCriterion);
    ProductInformationDto getProductInformation(Long productId);
    ProductThumDto getProductThumPriority1(Long productId);
    DiscountDto getDiscount(Long productId);
}
