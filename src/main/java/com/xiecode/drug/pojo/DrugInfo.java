package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiecode.drug.common.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 药品信息
 * </p>
 *
 * @author xiewc
 * @since 2022-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DrugInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 生产时间
     */
    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productTime;

    /**
     * 保质期（月）
     */
    private String warrenty;

    /**
     * 药品编码
     */
    private String dnumber;

    /**
     * 药品价格
     */
    private Float price;

    /**
     * 库存
     */
    private Integer stock = 0;


    /**
    * 将生产时间转换成年月日
    * */
    @JsonIgnore
    @TableField(exist = false)
    private String productTimeSimpleDateFormat;
    public String getProductTimeSimpleDateFormat() {
        return DateUtil.dataConvert(productTime);
    }

}
