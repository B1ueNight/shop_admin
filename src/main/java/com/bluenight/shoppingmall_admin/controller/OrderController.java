package com.bluenight.shoppingmall_admin.controller;

import com.bluenight.shoppingmall_admin.mapper.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired OrderMapper mapper;
    @GetMapping("/list")
    public String getOrderList(@RequestParam @Nullable Integer seq, @RequestParam @Nullable Integer offset, Model model){

        if(seq == null) seq = 0;
        if(offset == null) offset = 0;

        Integer cnt = mapper.selectOrderManagedInfoCount(seq);
        Integer page = (cnt /10) + (cnt%10>0? 1:0);
        model.addAttribute("list", mapper.selectOrderManagedInfo(seq, offset));
        model.addAttribute("page", page);
        model.addAttribute("offset", offset);

        return "/order/list";
    }
}
