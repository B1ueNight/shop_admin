package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.ProductDataVO;
import com.bluenight.shoppingmall_admin.data.ProductDescImageVO;
import com.bluenight.shoppingmall_admin.data.ProductDescVO;
import com.bluenight.shoppingmall_admin.data.ProductImageVO;
import com.bluenight.shoppingmall_admin.data.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    List<ProductDataVO> selectProductList(String keyword, Integer offset, Integer seller_seq);

    ProductVO selectProductBySeq(Integer seq);
    String selectProductDescription(Integer seq);

    Integer selectProductCnt(String keyword, Integer seller_seq);
    void insertProductInfo(ProductDataVO data);
    void insertProductImage(ProductImageVO data);
    void insertProductDescription(ProductDescVO data);
    void insertProductDescImage(ProductDescImageVO descImgVO);

    List<String> selectProductImgNames(Integer seq);
    List<String> selectProductDescImgNames(Integer seq);

    void deleteProduct(Integer seq);
    void deleteProductImage(String fileName);
    void deleteDetailProductImage(String fileName);

    void updateProductInfo(ProductDataVO data);
    void updateProdDetailDesc(String desc, Integer seq);
    void deleteProductImageBySeq(Integer seq);
    void deleteProductDetailImageBySeq(Integer seq);
}
