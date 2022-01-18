package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    List<CategoryVO> selectCategories(Integer offset, String keyword, String type);
    Integer selectCategoryCnt(String keyword, String type);
    List<CategoryVO> selectRootCategories();
    List<CategoryVO> selectChildCategories(Integer parent_seq);
    void insertCategory(CategoryVO data);
    void updateCategory(CategoryVO data);
    void deleteCategory(Integer seq);

    CategoryVO selectCategoryBySeq(Integer Seq);
}
