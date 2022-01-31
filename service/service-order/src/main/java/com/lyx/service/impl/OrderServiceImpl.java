package com.lyx.service.impl;

import com.lyx.client.CourseClient;
import com.lyx.client.UserClient;
import com.lyx.dao.OrderDao;
import com.lyx.entity.CourseInfoOrderVo;
import com.lyx.entity.Order;
import com.lyx.entity.UcenterMemberOrder;
import com.lyx.service.OrderService;
import com.lyx.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liao 2021/10/30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private CourseClient courseClient;

    @Autowired
    private OrderDao orderDao;

    @Override
    public String createOrder(String courseId, String memberId) {
        UcenterMemberOrder orderInfo = userClient.getOrderInfo(memberId);
        CourseInfoOrderVo course = courseClient.getCourseOrderInfoById(courseId);
        Order order = new Order();
        order.setEmail(orderInfo.getEmail());
        order.setNickname(orderInfo.getNickname());
        order.setMemberId(memberId);
        order.setCourseCover(course.getCover());
        order.setCourseId(courseId);
        order.setCourseTitle(course.getTitle());
        order.setTeacherName(course.getName());
        order.setTotalFee(course.getPrice());
        order.setStatus(0);//支付状态：（ 0：已支付，1：未支付 ）
        order.setPayType(1);//支付类型： 1：微信 ， 2：支付宝
        order.setOrderNo(OrderNoUtil.getOrderNo()); //订单号
        orderDao.addOrder(order);
        return order.getOrderNo();
    }

    @Override
    public Order getOrderByOrderId(String orderNo) {
        return orderDao.getOrderByOrderId(orderNo);
    }

    @Override
    public Integer updateById(Order order) {
        return orderDao.updateById(order);
    }
}
