package com.lyx.dao;

import com.lyx.entity.PayLog;
import org.springframework.stereotype.Repository;

/**
 * @author liao 2021/10/30
 */
@Repository
public interface PayLogDao {

    /**
     * 添加支付记录
     * @param payLog
     * @return
     */
    public Integer addPayLog(PayLog payLog);

}
