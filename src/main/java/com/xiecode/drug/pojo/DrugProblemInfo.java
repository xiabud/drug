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
 * 问题药品表
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DrugProblemInfo implements Serializable {

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
     * 问题药品数量
     */
    private Integer dcount;

    /**
     * 药品单价
     */
    private Float dprice;

    /**
     * 出问题的原因
     */
    private String reason;

    /**
     * 操作的时间
     */
    private Date createTime;

    /**
     * 药品进货批号
     */
    @TableField("drugInNum")
    private String druginnum;


}
