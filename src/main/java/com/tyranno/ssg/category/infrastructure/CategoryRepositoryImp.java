package com.tyranno.ssg.category.infrastructure;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tyranno.ssg.category.application.CategoryService;
import com.tyranno.ssg.category.domain.Category;
import com.tyranno.ssg.category.domain.QCategory;
import com.tyranno.ssg.product.domain.Product;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImp extends QuerydslRepositorySupport {
    private final CategoryService categoryService;
    private final JPAQueryFactory jpaQueryFactory;

    public CategoryRepositoryImp(CategoryService categoryService, JPAQueryFactory jpaQueryFactory) {
        super(Category.class);
        this.categoryService = categoryService;
        this.jpaQueryFactory = jpaQueryFactory;
    }
    public List<Long> getProductIdList(Long largeId, Long middleId,
                                        Long smallId, Long detailId, String sortCriterion) {
        QCategory category = QCategory.category;
        return jpaQueryFactory.select(category.product.id)
                .from(category)
                .where(
                        largeIdEq(category, largeId),
                        middleIdEq(category, middleId),
                        smallIdEq(category, smallId),
                        detailIdEq(category, detailId))
                .fetch();
    }

    private BooleanExpression largeIdEq(QCategory category, Long largeId) {
        if (largeId == null) {
            return null;
        }
        return category.largeId.eq(largeId);
    }
    private BooleanExpression middleIdEq(QCategory category, Long middleId) {
        if (middleId == null) {
            return null;
        }
        return category.middleId.eq(middleId);
    }
    private BooleanExpression smallIdEq(QCategory category, Long smallId) {
        if (smallId == null) {
            return null;
        }
        return category.smallId.eq(smallId);
    }
    private BooleanExpression detailIdEq(QCategory category, Long detailId) {
        if (detailId == null) {
            return null;
        }
        return category.detailId.eq(detailId);
    }

}
