package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xiewc
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SellIsGone implements Serializable {

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
     * 供应商
     */
    private String supplier;

    /**
     * 进货批号
     */
    @TableField("drugInNum")
    private String druginnum;

    /**
     * 销售数量
     */
    @TableField("sellNnum")
    private Integer sellnnum;

    /**
     * 退货数量
     */
    @TableField("returnNum")
    private Integer returnnum;

    /**
     * 销售率
     */
    @TableField("sellRate")
    private Float sellrate;


}
