package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账单信息表
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SaleInfo implements Serializable {

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
     * 药品编码
     */
    private String dnumber;

    /**
     * 销售数量
     */
    private Integer count;

    /**
     * 总金额
     */
    private Float total;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;


}
