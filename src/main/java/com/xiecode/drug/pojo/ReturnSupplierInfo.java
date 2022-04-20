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
 * 退回给供应商表
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReturnSupplierInfo implements Serializable {

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
    private Integer dcount;

    /**
     * 药品进货批号
     */
    @TableField("drugInNum")
    private String druginnum;

    /**
     * 供应商名称
     */
    private String supplierName;


    /**
     * 退货原因
     */
    private String reason;

    /**
     * 退货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    /**
     * 操作时间转换为年月日
     */
    @TableField(exist = false)
    private String createTimeStr;
    public String getCreateTimeStr() {
        return DateUtil.dataConvert(createTime);
    }


}
