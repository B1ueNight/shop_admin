package com.bluenight.shoppingmall_admin.controller;

import java.util.List;

import com.bluenight.shoppingmall_admin.data.CategoryVO;
import com.bluenight.shoppingmall_admin.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired CategoryMapper mapper;
    
    @GetMapping("/manage/category")
    public String getManageCategory(@RequestParam @Nullable Integer offset,
    @RequestParam @Nullable String keyword,
    @RequestParam @Nullable String type,
    Model model) {
        model.addAttribute("keyword", keyword);
        if(offset == null) offset = 0;
        if(keyword == null) keyword = "%%";
        else keyword = "%"+keyword+"%";
        
        List<CategoryVO> list = mapper.selectCategories(offset, keyword, type);
        model.addAttribute("list", list);
        model.addAttribute("cnt", mapper.selectCategoryCnt(keyword, type));
        model.addAttribute("type", type);
        model.addAttribute("offset", offset);

        Integer cnt = mapper.selectCategoryCnt(keyword, type);

        Integer page = (cnt/12)+(cnt%10>0?1:0);
        model.addAttribute("page", page);

        return "/manage/category";
    }
}
