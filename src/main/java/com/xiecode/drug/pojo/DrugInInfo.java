package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xiewc
 * @since 2022-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DrugInInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String name;

    /**
     * 药品供应商
     */
    private String supplier;

    /**
     * 药品保质期（月）
     */
    private String warranty;

    /**
     * 药品进货批号
     */
    @TableField("drugInNum")
    private String druginnum;

    /**
     * 药品进货金额
     */
    @TableField("drugInPrice")
    private Float druginprice = Float.valueOf(0);

    /**
     * 药品进货数量
     */
    @TableField("drugCount")
    private Integer drugcount = 0;

    /**
     * 药品退货数量
     */
    @TableField("drugRetuen")
    private Integer drugretuen = 0;

    /**
     * 药品退货金额
     */
    @TableField("drugOutPrice")
    private Float drugoutprice = Float.valueOf(0);


    /**
     * 药品进货时间
     */
    @TableField("inTime")
    private Date intime;

    /**
     * 药品退货时间
     */
    @TableField("outTime")
    private Date outtime;


}
