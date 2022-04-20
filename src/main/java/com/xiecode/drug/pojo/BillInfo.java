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
 * 销售记录
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BillInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商名称
     */
    private String sname;

    /**
     * 药品名称
     */
    private String dname;

    /**
     * 药品数量
     */
    private Integer count;

    /**
     * 总金额
     */
    private Float total;

    /**
     * 药品进货批号
     */
    @TableField("drugInNum")
    private String druginnum;

    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;

    /**
     * 将进货时间转换成年月日
     */
    @TableField(exist = false)
    private String buyTimeSimpleDateFormat;
    public String getBuyTimeSimpleDateFormat() {
        return DateUtil.dataConvert(buyTime);
    }


}
