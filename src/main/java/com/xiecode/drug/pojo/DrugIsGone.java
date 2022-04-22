package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class DrugIsGone implements Serializable {

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
