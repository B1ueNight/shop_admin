package com.bluenight.shoppingmall_admin.mapper;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.LoginVO;
import com.bluenight.shoppingmall_admin.data.MemberVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    List<MemberVO> getMemberList(String keyword, String type, Integer offset);
    Integer getMemberCnt(String keyword, String type);
    MemberVO getMemberBySeq(Integer seq);
    void insertmember(MemberVO data);
    void updatemember(MemberVO data);
    void deletemember(Integer seq);
    
    Integer isExistEmail(String email);
    MemberVO memberLogin(LoginVO login);
}
