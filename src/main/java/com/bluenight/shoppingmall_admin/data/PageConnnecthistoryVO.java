package com.bluenight.shoppingmall_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class PageConnnecthistoryVO {
    private Integer pch_seq;
    private Integer pch_mi_seq;
    private String pch_url;
    private Double pch_interval;
    private Date pch_reg_dt;
}
