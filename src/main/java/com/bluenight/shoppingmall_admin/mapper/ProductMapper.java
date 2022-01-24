package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    List<ProductVO> selectProductList(String keyword, Integer offset);
    Integer selectProductCnt(String keyword, String type);
    ProductVO selectProductBySeq(Integer seq);
    void insertProduct(ProductVO data);
    void updateProduct(ProductVO data);
    void deleteProduct(Integer seq);
}
