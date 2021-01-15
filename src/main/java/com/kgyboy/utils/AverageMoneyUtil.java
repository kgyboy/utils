package com.kgyboy.utils;

import java.math.BigDecimal;

/**
 * @ClassName AverageMoneyUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2020/11/25
 */
public class AverageMoneyUtil {

    public static BigDecimal[] averMoney(int consumerNum, BigDecimal totalMoney) {
        BigDecimal[] consumerAmt = new BigDecimal[consumerNum];// 每个消费码应承担订单金额
        BigDecimal factConsumeAmt = new BigDecimal("0");// 每个消费码实际费用（不含零头）

        //商品购买总数量
        int count = consumerAmt.length;

        for(int i = 0; i < count; i++) {
            //求每个消费码的承担金额=分摊金额/商品购买总数量
            consumerAmt[i] = totalMoney.divide(new BigDecimal(count), 2, BigDecimal.ROUND_DOWN); //截掉精度之后的小数位的值

            //实际分摊承担总金额---小数点截取后的总金额
            factConsumeAmt = factConsumeAmt.add(consumerAmt[i]);
        }
        // 零头 = 分摊实际承担金额-待分摊金额
        BigDecimal repairOddmentAmt = factConsumeAmt.subtract(totalMoney);

        // 算出要参与分摊零头的消费码-截掉精度后的小数位的值累加后的每个值假设最大也只可能为0.00999999999999999999无限接近0.01
        int repair_int = repairOddmentAmt.multiply(new BigDecimal("100")).abs().intValue();
        // 把订单金额零头分摊到每个消费码上，如果参与零头的消费码数量大于零或者小于总消费码数量，则进行分摊，否则报错
        if( (repair_int < count) && (repair_int > 0) ) {
            // 如果零头小于零，则说明有repair_int个消费码承担的金额少一分钱0.01,需要加一分钱
            if( repairOddmentAmt.compareTo(new BigDecimal("0")) < 0 ) {
                for(int i = 0; i < repair_int; i++) {
                    consumerAmt[i] = consumerAmt[i].add(new BigDecimal("0.01"));
                }
            }else {
                // 如果零头大于零，则说明有repair_int个分户承担的金额多一分钱0.01,需要减去一分钱
                for(int i = 0; i < repair_int; i++) {
                    consumerAmt[i] = consumerAmt[i].subtract(new BigDecimal("0.01"));
                }
            }
        }else if( repair_int == 0 ) {
            // 零头如果为零，不需要处理
        }else{
            //消费码金额非法操作，返回null
            return null;
        }
        return consumerAmt;
    }
    public static BigDecimal[] averPoint(int consumerNum,BigDecimal totalMoney) {
        BigDecimal[] consumerAmt = new BigDecimal[consumerNum];// 每个消费码应承担订单金额
        BigDecimal factConsumeAmt = new BigDecimal("0");// 每个消费码实际费用（不含零头）

        //待分摊金额
        //商品购买总数量
        int count = consumerAmt.length;

        for(int i = 0; i < count; i++) {
            //求每个消费码的承担金额=分摊金额/商品购买总数量
            consumerAmt[i] = totalMoney.divide(new BigDecimal(count), 0, BigDecimal.ROUND_DOWN); //截掉精度之后的小数位的值

            //实际分摊承担总金额---小数点截取后的总金额
            factConsumeAmt = factConsumeAmt.add(consumerAmt[i]);
        }
        // 零头 = 分摊实际承担金额-待分摊金额
        BigDecimal repairOddmentAmt = factConsumeAmt.subtract(totalMoney);

        // 算出要参与分摊零头的消费码-截掉精度后的小数位的值累加后的每个值假设最大也只可能为0.00999999999999999999无限接近0.01
        int repair_int = repairOddmentAmt.multiply(new BigDecimal("1")).abs().intValue();
        // 把订单金额零头分摊到每个消费码上，如果参与零头的消费码数量大于零或者小于总消费码数量，则进行分摊，否则报错
        if( (repair_int < count) && (repair_int > 0) ) {
            // 如果零头小于零，则说明有repair_int个消费码承担的金额少一分钱0.01,需要加一分钱
            if( repairOddmentAmt.compareTo(new BigDecimal("0")) < 0 ) {
                for(int i = 0; i < repair_int; i++) {
                    consumerAmt[i] = consumerAmt[i].add(new BigDecimal("1"));
                }
            }else {
                // 如果零头大于零，则说明有repair_int个分户承担的金额多一分钱0.01,需要减去一分钱
                for(int i = 0; i < repair_int; i++) {
                    consumerAmt[i] = consumerAmt[i].subtract(new BigDecimal("1"));
                }
            }
        }else if( repair_int == 0 ) {
            // 零头如果为零，不需要处理
        }else{
            //消费码金额非法操作，返回null
            return null;
        }
        return consumerAmt;
    }

}
