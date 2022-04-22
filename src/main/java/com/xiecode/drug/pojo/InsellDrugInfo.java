package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InsellDrugInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String dname;

    /**
     * 入库编号
     */
    @TableField("InNum")
    private String innum;

    /**
     * 药品在售数量
     */
    private Integer sellcount;

    /**
     * 药品保质期
     */
    private Integer warranty;

    /**
     * 生产日期
     */
    @TableField("pTime")
    private LocalDateTime ptime;

    /**
     * 已销售数量
     */
    @TableField("sellNum")
    private Integer sellnum = 0;

    /**
     * 退货数量
     */
    @TableField("returnNum")
    private Integer returnnum = 0;

    /**
     * 销售金额
     */
    private Float outprice = (float) 0d;

    /**
     * 退货金额
     */
    private Float inprice = (float) 0d;

}
