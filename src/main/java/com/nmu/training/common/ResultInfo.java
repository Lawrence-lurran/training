package com.nmu.training.common;

import lombok.AllArgsConstructor;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/6 7:08 下午
 */

@AllArgsConstructor
public enum ResultInfo {
    /**
     * 页面没有找到
     */
    NOT_FOUND("404","页面没有找到"),
    SUCCESS("200","操作成功"),
    GlOBAL_ERROR("101","系统繁忙"),
    MY_ERROR("102","自定义异常");
    ;

    /**
     * 状态码
     */
    private String code;
    /**
     * 状态信息
     */
    private String massage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
