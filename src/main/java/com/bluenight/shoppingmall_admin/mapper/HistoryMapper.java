package com.bluenight.shoppingmall_admin.mapper;

import com.bluenight.shoppingmall_admin.data.MemberProductHistoryVO;
import com.bluenight.shoppingmall_admin.data.PageConnnecthistoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    void insertpageConnectHistory(PageConnnecthistoryVO data);
    void insertMemberProductHistory(MemberProductHistoryVO data);
    
}
