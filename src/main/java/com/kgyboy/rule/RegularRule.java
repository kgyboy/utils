package com.kgyboy.rule;

/**
 * author yang
 * time 2019-01-25
 */
public enum RegularRule {
    /*
    验证手机号
     */
    REGEX_MOBILE(1001, "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$"),
    /*
    验证邮箱
     */
    REGEX_EMAIL(1002, "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"),
    /*
    验证汉字
     */
    REGEX_CHINESE(1003, "^[\u4e00-\u9fa5]{0,}$"),
    /*
    验证身份证
     */
    REGEX_IDCARD(1004, "(^\\d{18}$)|(^\\d{15}$)"),
    /*
    验证IP地址
     */
    REGEX_IP_ADDR(1005, "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)"),
    /*
    验证数字
     */
    REGEX_NUMBER(1006, "^-?\\d+$"),
    /*
    验证小数
     */
    REGEX_DECIMAL(1007, "^-?\\d+.\\d+$"),
    /*
    是否包含数字
     */
    REGEX_CONTAIN_NUMBER(1008, "\\d+")


    ;

    public static String getReg(int index){
        RegularRule[] rules = RegularRule.values();
        for (RegularRule rule: rules) {
            if (rule.getIndex() == index)
                return rule.getReg();
        }
        return null;
    }

    private int index;
    private String reg;

    RegularRule(int index, String reg) {
        this.index = index;
        this.reg = reg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
