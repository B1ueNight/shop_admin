package com.bluenight.shoppingmall_admin.api;

import com.bluenight.shoppingmall_admin.data.ManufacturerVO;
import com.bluenight.shoppingmall_admin.mapper.ManufacturerMapper;

import org.springframework.beans.factory.annotation.Autowired;
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
