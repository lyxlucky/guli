package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liao 2021/10/30
 */
@Data
public class PayLog {

    private String id = snowFlakeUtils.getSnow().toString();

    private String orderNo;

    private Date payTime;

    private BigDecimal totalFee;

    private String transactionId;

    private String tradeState;

    private Integer payType;

    private String attr;

    private Integer isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

}
