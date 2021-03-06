package com.bluenight.shoppingmall_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bluenight.shoppingmall_admin.data.ManufacturerVO;
import com.bluenight.shoppingmall_admin.mapper.ManufacturerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerAPIController {
    @Autowired ManufacturerMapper mapper;

    @GetMapping("/list")
    public Map<String,Object> selectManufacturerList(@RequestParam @Nullable String keyword, @RequestParam @Nullable Integer offset){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(keyword == null) keyword = "%%";
        else keyword = "%"+keyword+"%";

        if(offset == null) offset = 0;

        Integer cnt = mapper.selectManutacturerCnt(keyword);
        Integer page = (cnt/10) + (cnt%10 > 0? 1:0);

        resultMap.put("list", mapper.selectManufacturerList(keyword, offset, 10));
        resultMap.put("page", page);

        return resultMap;
    }

    @GetMapping("/select_one")
    public ManufacturerVO seleManufacturerBySeq(@RequestParam Integer seq) {
        return mapper.selectManufacturerBySeq(seq);
    }
    @PostMapping("/add")
        public String insertManufacturer(@RequestBody ManufacturerVO data){
            mapper.interfaceManufacturer(data);
            return "제조사가 추가 되었습니다.";
        }
    @PatchMapping("/update")
        public String patchManufacturerupdate(@RequestBody ManufacturerVO data){
            mapper.updateManufacturer(data);
            return "제조사 정보가 수정되었습니다.";
        }
    @DeleteMapping("/delete")
        public String deleteManufacturer(@RequestParam Integer seq){
            mapper.deleteManufacturer(seq);
            return "제조사가 삭제 되었습니다.";
        }
}
