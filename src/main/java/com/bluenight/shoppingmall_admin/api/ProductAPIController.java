package com.bluenight.shoppingmall_admin.api;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bluenight.shoppingmall_admin.data.ProductDescImageVO;
import com.bluenight.shoppingmall_admin.data.ProductImageVO;
import com.bluenight.shoppingmall_admin.data.ProductRequest;
import com.bluenight.shoppingmall_admin.data.ProductResponse;
import com.bluenight.shoppingmall_admin.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductAPIController {
    @Value("${spring.servlet.multipart.location}")
    String path;

    @Autowired ProductMapper mapper;
    @PostMapping("/add")
    public Map<String, Object> postAddProcut(@RequestBody ProductRequest data) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.insertProductInfo(data.getP_data());
        Integer seq = data.getP_data().getPi_seq();
        // System.out.println(seq);
        for(ProductImageVO imgVO : data.getP_img_list()) {
            imgVO.setPii_pi_seq(seq);
            mapper.insertProductImage(imgVO);
        }
        data.getP_desc().setPdd_pi_seq(seq);
        mapper.insertProductDescription(data.getP_desc());
        for(ProductDescImageVO descImgVO : data.getP_desc_img_list()){
            descImgVO.setPddi_pi_seq(seq);
            mapper.insertProductDescImage(descImgVO);
        }

        resultMap.put("status", true);
        resultMap.put("message", "????????? ?????????????????????.");

        return resultMap;
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam Integer seq){
        List<String> prodImgList = mapper.selectProductImgNames(seq);
        List<String> prodDescImgList = mapper.selectProductDescImgNames(seq);

        for(String url : prodImgList){
        System.out.println(url);
        if(!url.equals("default.jpg")) {
            String filePath = path+"/product/"+url;
            File deleteFile = new File(filePath);
            if(deleteFile.exists()){
                deleteFile.delete();
            }
        }
    }
        for(String url : prodDescImgList) {
        System.out.println(url);
        if(!url.equals("default.jpg")) {
            String filePath = path+"/product/"+url;
            File deleteFile = new File(filePath);
            if(deleteFile.exists()){
                deleteFile.delete();
                }
            }
        }
        mapper.deleteProduct(seq);
        return "????????? ?????????????????????.";
    }

    @GetMapping("/select_one")
    public ProductResponse getProduct(@RequestParam Integer seq) {
        ProductResponse pRes = new ProductResponse();

        pRes.setP_img_list(mapper.selectProductImgNames(seq));
        pRes.setP_desc_img_list(mapper.selectProductDescImgNames(seq));
        pRes.setP_data(mapper.selectProductBySeq(seq));
        pRes.setP_desc(mapper.selectProductDescription(seq));

        return pRes;
    }

    @DeleteMapping("/delete_img/{type}")
    public String deleteProductImage(@PathVariable String type, @RequestParam String fileName) {
        if(type.equals("basic")) {
            mapper.deleteProductImage(fileName);
        }
        if(type.equals("detail")){
            mapper.deleteDetailProductImage(fileName);
        }
        return "???????????? ?????????????????????.";
    }

    @PatchMapping("/update")
    public String updateProduct(@RequestBody ProductRequest data){

        Integer seq = data.getP_data().getPi_seq();

        mapper.deleteProductImageBySeq(seq);
        mapper.deleteProductDetailImageBySeq(seq);

        for(ProductImageVO img : data.getP_img_list()) {
            mapper.insertProductImage(img);
        }
        for(ProductDescImageVO img : data.getP_desc_img_list()) {
            mapper.insertProductDescImage(img);
        }

        mapper.updateProductInfo(data.getP_data());
        mapper.updateProdDetailDesc(data.getP_desc().getPdd_content(), seq);

        return "????????? ?????????????????????.";
    }


}
