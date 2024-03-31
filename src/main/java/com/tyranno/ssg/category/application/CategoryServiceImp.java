package com.tyranno.ssg.category.application;

import com.tyranno.ssg.category.domain.CategoryDetail;
import com.tyranno.ssg.category.domain.CategoryLarge;
import com.tyranno.ssg.category.domain.CategoryMiddle;
import com.tyranno.ssg.category.domain.CategorySmall;
import com.tyranno.ssg.category.dto.*;
import com.tyranno.ssg.category.infrastructure.*;
import com.tyranno.ssg.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryLargeRepository categoryLargeRepository;
    private final CategoryMiddleRepository categoryMiddleRepository;
    private final CategorySmallRepository categorySmallRepository;
    private final CategoryDetailRepository categoryDetailRepository;

//    @Override
//    public CategoryProductIdListDto getProductIdByCategory() {
//
//    }

    @Override
    public List<LargeCategoryDto> getLargeCategory(){ // largeCategory 조회
        List<CategoryLarge> LargeCategories = categoryLargeRepository.findAll();
        List<LargeCategoryDto> larges = new ArrayList<>();

        for (CategoryLarge largeCategory : LargeCategories) {
            LargeCategoryDto dto = LargeCategoryDto.builder()
                    .largeId(largeCategory.getId())
                    .largeName(largeCategory.getLargeName())
                    .largeImageUrl(largeCategory.getLargeImageUrl())
                    .build();
            larges.add(dto);
        }
        return larges;
    }

    @Override
    public List<MiddleCategoryDto> getMiddleCategory(Long largeId){ // middleCategory 조회
        List<CategoryMiddle> MiddleCategories = categoryMiddleRepository.findByCategoryLargeId(largeId);
        List<MiddleCategoryDto> middles = new ArrayList<>();

        for (CategoryMiddle middleCategory : MiddleCategories) {
            MiddleCategoryDto dto = MiddleCategoryDto.builder()
                    .middleId(middleCategory.getId())
                    .middleName(middleCategory.getMiddleName())
                    .middleImageUrl(middleCategory.getMiddleImageUrl())
                    .build();
            middles.add(dto);
        }
        return middles;
    }

    @Override
    public List<SmallCategoryDto> getSmallCategory(Long middleId){ // smallCategory 조회
        List<CategorySmall> SmallCategories = categorySmallRepository.findByCategoryMiddleId(middleId);
        List<SmallCategoryDto> smalls = new ArrayList<>();

        for (CategorySmall smallCategory : SmallCategories) {
            SmallCategoryDto dto = SmallCategoryDto.builder()
                    .smallId(smallCategory.getId())
                    .smallName(smallCategory.getSmallName())
                    .build();
            smalls.add(dto);
        }
        return smalls;
    }

    @Override
    public List<DetailCategoryDto> getDetailCategory(Long smallId){ // detailCategory 조회
        List<CategoryDetail> DetailCategories = categoryDetailRepository.findByCategorySmallId(smallId);
        List<DetailCategoryDto> details = new ArrayList<>();

        for (CategoryDetail detailCategory : DetailCategories) {
            DetailCategoryDto dto = DetailCategoryDto.builder()
                    .detailId(detailCategory.getId())
                    .detailName(detailCategory.getDetailName())
                    .build();
            details.add(dto);
        }
        return details;
    }
}
