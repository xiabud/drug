package com.xiecode.drug.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysInfo {
    private String javaVersion = "";
    private String OS = "";
    private String OSUser = "";
    private String OSFrame = "";
    private String systemLib = "";
    private String bVersion = "";

}
