package com.termux.zerocore.bean;

import com.termux.shared.termux.settings.properties.TermuxPropertyConstants;

public class ZTUserBean {
    // 是否打开ZT下载服务器
    private boolean isOpenDownloadFileServices = false;
    // 输入法调起侧边栏是否关闭
    private boolean inputMethodTriggerClose = false;
    // 美化设置关闭菜单
    private boolean styleTriggerOff = false;
    // 禁止工具箱显示
    private boolean isToolShow = false;
    // 强制使用此处小键盘设置规则模式
    private boolean forceUseNumpad = false;
    //是否输出显示LOG
    private boolean isOutputLOG = false;
    //是否显示雪花
    private boolean isSnowflakeShow = false;

    public boolean isSnowflakeShow() {
        return isSnowflakeShow;
    }

    public void setSnowflakeShow(boolean snowflakeShow) {
        isSnowflakeShow = snowflakeShow;
    }

    public boolean isRainShow() {
        return isRainShow;
    }

    public void setRainShow(boolean rainShow) {
        isRainShow = rainShow;
    }

    //是否显示下雨
    private boolean isRainShow = false;


    public boolean isOutputLOG() {
        return isOutputLOG;
    }

    public void setOutputLOG(boolean outputLOG) {
        isOutputLOG = outputLOG;
    }

    //小键盘规则
    private String numpad = TermuxPropertyConstants.DEFAULT_IVALUE_EXTRA_KEYS;

    public boolean isOpenDownloadFileServices() {
        return isOpenDownloadFileServices;
    }

    public void setOpenDownloadFileServices(boolean openDownloadFileServices) {
        isOpenDownloadFileServices = openDownloadFileServices;
    }

    public boolean isInputMethodTriggerClose() {
        return inputMethodTriggerClose;
    }

    public void setInputMethodTriggerClose(boolean inputMethodTriggerClose) {
        this.inputMethodTriggerClose = inputMethodTriggerClose;
    }

    public boolean isStyleTriggerOff() {
        return styleTriggerOff;
    }

    public void setStyleTriggerOff(boolean styleTriggerOff) {
        this.styleTriggerOff = styleTriggerOff;
    }

    public boolean isToolShow() {
        return isToolShow;
    }

    public void setToolShow(boolean toolShow) {
        isToolShow = toolShow;
    }

    public boolean isForceUseNumpad() {
        return forceUseNumpad;
    }

    public void setForceUseNumpad(boolean forceUseNumpad) {
        this.forceUseNumpad = forceUseNumpad;
    }

    public String getNumpad() {
        return numpad;
    }

    public void setNumpad(String numpad) {
        this.numpad = numpad;
    }
}
