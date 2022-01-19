package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.ManufacturerVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManufacturerMapper {
    List<ManufacturerVO> selectManufacturerList(String keyword, Integer offset);
    Integer selectManutacturerCnt(String keyword);
    ManufacturerVO selectManufacturerBySeq(Integer seq);
    void interfaceManufacturer(ManufacturerVO data);
    void updateManufacturer(ManufacturerVO data);
    void deleteManufacturer(Integer seq);
}
