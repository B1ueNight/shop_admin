package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.OrderInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    List<OrderInfoVO> getOrderList(String keyword, Integer offset);
    Integer getOrderCnt(String keyword);
}
