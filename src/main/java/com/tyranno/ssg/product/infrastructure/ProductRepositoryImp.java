package com.tyranno.ssg.product.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tyranno.ssg.category.domain.QCategory;
import com.tyranno.ssg.product.application.ProductService;
import com.tyranno.ssg.product.domain.Product;
import com.tyranno.ssg.product.domain.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImp extends QuerydslRepositorySupport {

    private final ProductService productService;
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImp(ProductService productService, JPAQueryFactory jpaQueryFactory) {
        super(Product.class);
        this.productService = productService;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Product> getProductList(Long largeId, Long middleId,
                                        Long smallId, Long detailId, String sortCriterion) {
        QCategory category = QCategory.category;
        return jpaQueryFactory.select(category.product)
                .from(category)
                .where(category.largeId.eq(largeId))
                .fetch();
    }
}
