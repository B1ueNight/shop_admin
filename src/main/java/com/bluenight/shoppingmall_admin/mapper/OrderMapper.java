package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.OrderManageInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    List<OrderManageInfoVO> selectOrderManagedInfo(Integer seq, Integer offset);
    Integer selectOrderManagedInfoCount(Integer seq);
    void updateOrderStatus(Integer seq, String delivery_no);
}
