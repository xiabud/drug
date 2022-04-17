package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiecode.drug.common.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 收到退货表
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReturnGoodsInfo implements Serializable {

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
     * 数量
     */
    private Integer count;

    /**
     * 退货原因
     */
    private String reason;

    /**
     * 总金额
     */
    private Float total;

    /**
     * 操作的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateTime;

    /**
     * 操作时间转换为年月日
     */

    @TableField(exist = false)
    private String operateTimeStr;
    public String getOperateTimeStr() {
        return DateUtil.dataConvert(operateTime);
    }

}
