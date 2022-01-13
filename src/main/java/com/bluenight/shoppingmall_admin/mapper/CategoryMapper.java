package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    List<CategoryVO> selectCategories(Integer offset);
}
