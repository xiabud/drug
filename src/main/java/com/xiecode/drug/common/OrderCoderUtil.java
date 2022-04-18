package com.xiecode.drug.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderCoderUtil {

    /**
     * 订单类别头
     */
    private static final String ORDER_CODE = "药DIP";
    /**
     * 退货类别头
     */
    private static final String RETURN_ORDER = "药DOP";
    /**
     * 退款类别头
     */
    private static final String REFUND_ORDER = "药DUP";
    /**
     * 未付款重新支付别头
     */
    private static final String AGAIN_ORDER = "药DNP";
    /**
     * 随即编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};
    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 4;


    /**
     * 生成订单单号编码
     *
     * @param userId
     */
    public static String getOrderCode(Long userId) {
        return ORDER_CODE + getCode(userId);
    }


    /**
     * 生成退货单号编码
     *
     * @param userId
     */
    public static String getReturnCode(Long userId) {
        return RETURN_ORDER + getCode(userId);
    }


    /**
     * 生成退款单号编码
     *
     * @param userId
     */
    public static String getRefundCode(Long userId) {
        return REFUND_ORDER + getCode(userId);
    }

    /**
     * 未付款重新支付
     *
     * @param userId
     */
    public static String getAgainCode(Long userId) {
        return AGAIN_ORDER + getCode(userId);
    }


    /**
     * 更具id进行加密+加随机数组成固定长度编码
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("MMddHH");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     *
     * @param n 长度
     */
    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     * 生成不带类别标头的编码
     *
     * @param userId
     */
    private static synchronized String getCode(Long userId) {
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }

}
