package com.github.zjgyjd.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

/**
 * 数字工具类<br>
 * 对于精确值计算应该使用 {@link BigDecimal}<br>
 * JDK7中<strong>BigDecimal(double val)</strong>构造方法的结果有一定的不可预知性，例如：
 *
 * <pre>
 * new BigDecimal(0.1)
 * </pre>
 * <p>
 * 表示的不是<strong>0.1</strong>而是<strong>0.1000000000000000055511151231257827021181583404541015625</strong>
 *
 * <p>
 * 这是因为0.1无法准确的表示为double。因此应该使用<strong>new BigDecimal(String)</strong>。
 * </p>
 * 相关介绍：
 * <ul>
 * <li>http://www.oschina.net/code/snippet_563112_25237</li>
 * <li>https://github.com/venusdrogon/feilong-core/wiki/one-jdk7-bug-thinking</li>
 * </ul>
 * <p>
 * Author: zjgyjd
 * Created: 2018/10/16
 */
public final class NumberUtil {
    /**
     * 默认除法运算精度
     */
    private static final int DEFAULT_DIV_SCALE = 10;

    private NumberUtil() {

    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static double add(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static double add(float v1, double v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static double add(double v1, float v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v2));
        BigDecimal b2 = new BigDecimal(Double.toString(v1));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();

    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static double add(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();

    }

    /**
     * 提供精确的加法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 和
     */
    public static BigDecimal add(Number v1, Number v2) {
        if (v1 == null || v2 == null) {
            return BigDecimal.valueOf(0);
        }
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被加值
     * @return 和
     */
    public static BigDecimal add(Number... values) {
        BigDecimal sum = BigDecimal.valueOf(0);
        int len = values.length;
        if (values.length != 0 && !ArrayUtil.hasNull(values)) {
            for (int i = 0; i < len; i++) {
                sum = sum.add(new BigDecimal(values[i].toString()));
            }
        }
        return sum;
    }

    /**
     * 提供精确的加法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被加值
     * @return 和
     */
    public static BigDecimal add(String... values) {
        BigDecimal sum = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (int i = 0; i < len; i++) {
                sum = sum.add(new BigDecimal(values[i]));
            }
        }
        return sum;
    }

    /**
     * 提供精确的加法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被加值
     * @return 和
     */
    public static BigDecimal add(BigDecimal... values) {
        BigDecimal sum = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (BigDecimal value : values) {
                sum = sum.add(value);
            }
        }
        return sum;
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static double sub(float v1, float v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.subtract(value2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static double sub(float v1, double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.subtract(value2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static double sub(double v1, float v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.subtract(value2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static double sub(double v1, double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.subtract(value2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static double sub(Double v1, Double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.subtract(value2).doubleValue();
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 差
     */
    public static BigDecimal sub(Number v1, Number v2) {
        BigDecimal value1 = new BigDecimal(v1.toString());
        BigDecimal value2 = new BigDecimal(v2.toString());
        return value1.subtract(value2);
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被减值
     * @return 差
     */
    public static BigDecimal sub(Number... values) {
        BigDecimal sub = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (int i = 0; i < len; i++) {
                sub = sub.subtract(new BigDecimal(values[i].toString()));
            }
        }
        return sub;
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被减值
     * @return 差
     */
    public static BigDecimal sub(String... values) {
        BigDecimal sub = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (int i = 0; i < len; i++) {
                sub = sub.subtract(new BigDecimal(values[i]));
            }
        }
        return sub;
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被减值
     * @return 差
     */
    public static BigDecimal sub(BigDecimal... values) {
        BigDecimal sub = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (BigDecimal value : values) {
                sub = sub.subtract(value);
            }
        }
        return sub;
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double mul(float v1, float v2) {
        BigDecimal mul1 = BigDecimal.valueOf(v1);
        BigDecimal mul2 = BigDecimal.valueOf(v2);
        return mul1.multiply(mul2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double mul(float v1, double v2) {
        BigDecimal mul1 = BigDecimal.valueOf(v1);
        BigDecimal mul2 = BigDecimal.valueOf(v2);
        return mul1.multiply(mul2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double mul(double v1, float v2) {
        BigDecimal mul1 = BigDecimal.valueOf(v1);
        BigDecimal mul2 = BigDecimal.valueOf(v2);
        return mul1.multiply(mul2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double mul(double v1, double v2) {
        BigDecimal mul1 = BigDecimal.valueOf(v1);
        BigDecimal mul2 = BigDecimal.valueOf(v2);
        return mul1.multiply(mul2).doubleValue();
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double mul(Double v1, Double v2) {
        BigDecimal mul1 = BigDecimal.valueOf(v1);
        BigDecimal mul2 = BigDecimal.valueOf(v2);
        return mul1.multiply(mul2).doubleValue();
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static BigDecimal mul(Number v1, Number v2) {
        BigDecimal mul1 = new BigDecimal(v1.toString());
        BigDecimal mul2 = new BigDecimal(v2.toString());
        return mul1.multiply(mul2);
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     */
    public static BigDecimal mul(Number... values) {
        BigDecimal mul = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (Number value : values) {
                mul.multiply(new BigDecimal(value.toString()));
            }
        }
        return mul;
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal value1 = new BigDecimal(v1);
        BigDecimal value2 = new BigDecimal(v2);
        return value1.multiply(value2);
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     */
    public static BigDecimal mul(String... values) {
        BigDecimal mul = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (String value : values) {
                mul.multiply(new BigDecimal(value));
            }
        }
        return mul;
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     */
    public static BigDecimal mul(BigDecimal... values) {
        BigDecimal mul = BigDecimal.valueOf(0);
        int len = values.length;
        if (len != 0 && !ArrayUtil.hasNull(values)) {
            for (BigDecimal value : values) {
                mul.multiply(value);
            }
        }
        return mul;
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(float v1, float v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(float v1, double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, float v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(Double v1, Double v2) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static BigDecimal div(Number v1, Number v2) {
        BigDecimal value1 = new BigDecimal(v1.toString());
        BigDecimal value2 = new BigDecimal(v2.toString());
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div;
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static BigDecimal div(String v1, String v2) {
        BigDecimal value1 = new BigDecimal(v1);
        BigDecimal value2 = new BigDecimal(v2);
        BigDecimal div = value1.divide(value2, 10,
                BigDecimal.ROUND_HALF_UP);
        return div;
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static double div(float v1, float v2, int scale) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static double div(float v1, double v2, int scale) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static double div(double v1, float v2, int scale) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static double div(Double v1, Double v2, int scale) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        BigDecimal div = value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
        return div.doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static BigDecimal div(Number v1, Number v2, int scale) {
        BigDecimal value1 = new BigDecimal(v1.toString());
        BigDecimal value2 = new BigDecimal(v2.toString());
        return value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，如果为负值，取绝对值
     * @return 两个参数的商
     */
    public static BigDecimal div(String v1, String v2, int scale) {
        BigDecimal value1 = new BigDecimal(v1);
        BigDecimal value2 = new BigDecimal(v2);
        return value1.divide(value2, Math.abs(scale),
                BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static double div(float v1, float v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static double div(float v1, double v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static double div(double v1, float v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static double div(Double v1, Double v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = BigDecimal.valueOf(v1);
        BigDecimal value2 = BigDecimal.valueOf(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static BigDecimal div(Number v1, Number v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = new BigDecimal(v1.toString());
        BigDecimal value2 = new BigDecimal(v2.toString());
        return value1.divide(value2, Math.abs(scale),
                roundingMode);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static BigDecimal div(String v1, String v2, int scale, RoundingMode roundingMode) {
        BigDecimal value1 = new BigDecimal(v1);
        BigDecimal value2 = new BigDecimal(v2);
        return value1.divide(value2, Math.abs(scale),
                roundingMode);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
        return v1.divide(v2, Math.abs(scale),
                roundingMode);
    }

    // ------------------------------------------------------------------------------------------- round

    /**
     * 保留固定位数小数<br>
     * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
     * 例如保留2位小数：123.456789 =》 123.46
     *
     * @param v     值
     * @param scale 保留小数位数
     * @return 新值
     */
    public static BigDecimal round(double v, int scale) {
        BigDecimal value = BigDecimal.valueOf(v);
        return value.setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留固定位数小数<br>
     * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
     * 例如保留2位小数：123.456789 =》 123.46
     *
     * @param v     值
     * @param scale 保留小数位数
     * @return 新值
     */
    public static String roundStr(double v, int scale) {
        BigDecimal value = BigDecimal.valueOf(v);
        return value.setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 保留固定位数小数<br>
     * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
     * 例如保留2位小数：123.456789 =》 123.46
     *
     * @param numberStr 数字值的字符串表现形式
     * @param scale     保留小数位数
     * @return 新值
     */
    public static BigDecimal round(String numberStr, int scale) {
        BigDecimal value = new BigDecimal(numberStr);
        return value.setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留固定位数小数<br>
     * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
     * 例如保留2位小数：123.456789 =》 123.46
     *
     * @param number 数字值
     * @param scale  保留小数位数
     * @return 新值
     */
    public static BigDecimal round(BigDecimal number, int scale) {
        return number.setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留固定位数小数<br>
     * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
     * 例如保留2位小数：123.456789 =》 123.46
     *
     * @param numberStr 数字值的字符串表现形式
     * @param scale     保留小数位数
     * @return 新值
     */
    public static String roundStr(String numberStr, int scale) {
        BigDecimal value = new BigDecimal(numberStr);
        return value.setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 保留固定位数小数<br>
     * 例如保留四位小数：123.456789 =》 123.4567
     *
     * @param v            值
     * @param scale        保留小数位数
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 新值
     */
    public static BigDecimal round(double v, int scale, RoundingMode roundingMode) {
        BigDecimal value = BigDecimal.valueOf(v);
        return value.setScale(scale, roundingMode);
    }

    /**
     * 保留固定位数小数<br>
     * 例如保留四位小数：123.456789 =》 123.4567
     *
     * @param v            值
     * @param scale        保留小数位数
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 新值
     */
    public static String roundStr(double v, int scale, RoundingMode roundingMode) {
        BigDecimal value = BigDecimal.valueOf(v);
        return value.setScale(scale, roundingMode).toString();
    }

    /**
     * 保留固定位数小数<br>
     * 例如保留四位小数：123.456789 =》 123.4567
     *
     * @param numberStr    数字值的字符串表现形式
     * @param scale        保留小数位数，如果传入小于0，则默认0
     * @param roundingMode 保留小数的模式 {@link RoundingMode}，如果传入null则默认四舍五入
     * @return 新值
     */
    public static BigDecimal round(String numberStr, int scale, RoundingMode roundingMode) {
        BigDecimal value = new BigDecimal(numberStr);
        return value.setScale(scale, roundingMode);
    }

    /**
     * 保留固定位数小数<br>
     * 例如保留四位小数：123.456789 =》 123.4567
     *
     * @param number       数字值
     * @param scale        保留小数位数，如果传入小于0，则默认0
     * @param roundingMode 保留小数的模式 {@link RoundingMode}，如果传入null则默认四舍五入
     * @return 新值
     */
    public static BigDecimal round(BigDecimal number, int scale, RoundingMode roundingMode) {
        return number.setScale(scale, roundingMode);
    }

    /**
     * 保留固定位数小数<br>
     * 例如保留四位小数：123.456789 =》 123.4567
     *
     * @param numberStr    数字值的字符串表现形式
     * @param scale        保留小数位数
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 新值
     */
    public static String roundStr(String numberStr, int scale, RoundingMode roundingMode) {
        BigDecimal value = new BigDecimal(numberStr);
        return value.setScale(scale, roundingMode).toString();
    }

    /**
     * 四舍六入五成双计算法
     * <p>
     * 四舍六入五成双是一种比较精确比较科学的计数保留法，是一种数字修约规则。
     * </p>
     *
     * <pre>
     * 算法规则:
     * 四舍六入五考虑，
     * 五后非零就进一，
     * 五后皆零看奇偶，
     * 五前为偶应舍去，
     * 五前为奇要进一。
     * </pre>
     *
     * @param number 需要科学计算的数据
     * @param scale  保留的小数位
     * @return 结果
     */
    public static BigDecimal roundHalfEven(Number number, int scale) {
        String temp = number.toString();
        int point = temp.indexOf('.');
        StringBuilder fine = new StringBuilder();
        fine.append(temp);

        if (point == -1) {
            point = temp.length();
            fine.append('.');
        }

        int len = point + scale + 2 - temp.length();
        int done = 0;


        if (len >= 0) {
            for (int i = 0; i <= len; i++) {
                fine.append('0');
            }
        }
        String end = fine.toString();

        fine.delete(0, end.length());
        fine.append(end, 0, point + scale);

        char flag0 = end.charAt(point + scale);
        char flag1 = (char) (end.charAt(point + scale) + 1);


        if (end.charAt(point + scale + 1) > '5') {
            fine.append(flag1);
        } else if (end.charAt(point + scale + 1) == '5') {
            boolean s = false;
            for (int i = point + scale + 2; i < end.length(); i++) {
                if (end.charAt(i) != '0') {
                    s = true;
                }
            }
            if (s) {
                fine.append(flag1);
            } else if ((end.charAt(point + scale) - '0') % 2 != 0) {
                fine.append(flag1);
            } else {
                fine.append(flag0);
            }
        } else {
            fine.append(flag0);
        }


        return new BigDecimal(fine.toString());
    }

    /**
     * 四舍六入五成双计算法
     * <p>
     * 四舍六入五成双是一种比较精确比较科学的计数保留法，是一种数字修约规则。
     * </p>
     *
     * <pre>
     * 算法规则:
     * 四舍六入五考虑，
     * 五后非零就进一，
     * 五后皆零看奇偶，
     * 五前为偶应舍去，
     * 五前为奇要进一。
     * </pre>
     *
     * @param value 需要科学计算的数据
     * @param scale 保留的小数位
     * @return 结果
     */
    public static BigDecimal roundHalfEven(BigDecimal value, int scale) {
        String temp = value.toString();
        int point = temp.indexOf('.');
        StringBuilder fine = new StringBuilder();
        fine.append(temp);

        if (point == -1) {
            point = temp.length();
            fine.append('.');
        }

        int len = point + scale + 2 - temp.length();
        int done = 0;


        if (len >= 0) {
            for (int i = 0; i <= len; i++) {
                fine.append('0');
            }
        }
        String end = fine.toString();

        fine.delete(0, end.length());
        fine.append(end, 0, point + scale);

        char flag0 = end.charAt(point + scale);
        char flag1 = (char) (end.charAt(point + scale) + 1);


        if (end.charAt(point + scale + 1) > '5') {
            fine.append(flag1);
        } else if (end.charAt(point + scale + 1) == '5') {
            boolean s = false;
            for (int i = point + scale + 2; i < end.length(); i++) {
                if (end.charAt(i) != '0') {
                    s = true;
                }
            }
            if (s) {
                fine.append(flag1);
            } else if ((end.charAt(point + scale) - '0') % 2 != 0) {
                fine.append(flag1);
            } else {
                fine.append(flag0);
            }
        } else {
            fine.append(flag0);
        }


        return new BigDecimal(fine.toString());
    }

    /**
     * 保留固定小数位数，舍去多余位数
     *
     * @param number 需要科学计算的数据
     * @param scale  保留的小数位
     * @return 结果
     */
    public static BigDecimal roundDown(Number number, int scale) {
        String target = number.toString();
        int point = target.indexOf('.');
        StringBuilder fine = new StringBuilder();
        fine.append(target);

        if (point == -1) {
            point = target.length();
            fine.append('.');
        }

        int len = point + scale - target.length();
        int allLen = target.length();

        if (len >= 0) {
            for (int i = 0; i <= len; i++) {
                fine.append('0');
                allLen++;
            }
        }

        fine.delete(point + scale + 1, allLen);
        String end = fine.toString();
        return new BigDecimal(end);
    }

    /**
     * 保留固定小数位数，舍去多余位数
     *
     * @param value 需要科学计算的数据
     * @param scale 保留的小数位
     * @return 结果
     */
    public static BigDecimal roundDown(BigDecimal value, int scale) {
        String target = value.toString();
        int point = target.indexOf('.');
        StringBuilder fine = new StringBuilder();
        fine.append(target);

        if (point == -1) {
            point = target.length();
            fine.append('.');
        }

        int len = point + scale - target.length();
        int allLen = target.length();

        if (len >= 0) {
            for (int i = 0; i <= len; i++) {
                fine.append('0');
                allLen++;
            }
        }

        fine.delete(point + scale + 1, allLen);
        String end = fine.toString();
        return new BigDecimal(end);
    }

    // ------------------------------------------------------------------------------------------- decimalFormat

    /**
     * 格式化double<br>
     * 对 {@link DecimalFormat} 做封装<br>
     *
     * @param pattern 格式 格式中主要以 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置。<br>
     *                <ul>
     *                <li>0 =》 取一位整数</li>
     *                <li>0.00 =》 取一位整数和两位小数</li>
     *                <li>00.000 =》 取两位整数和三位小数</li>
     *                <li># =》 取所有整数部分</li>
     *                <li>#.##% =》 以百分比方式计数，并取两位小数</li>
     *                <li>#.#####E0 =》 显示为科学计数法，并取五位小数</li>
     *                <li>,### =》 每三位以逗号进行分隔，例如：299,792,458</li>
     *                <li>光速大小为每秒,###米 =》 将格式嵌入文本</li>
     *                </ul>
     * @param value   值
     * @return 格式化后的值
     */
    public static String decimalFormat(String pattern, double value) {
        return new DecimalFormat(pattern).format(value);
    }

    /**
     * 格式化double<br>
     * 对 {@link DecimalFormat} 做封装<br>
     *
     * @param pattern 格式 格式中主要以 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置。<br>
     *                <ul>
     *                <li>0 =》 取一位整数</li>
     *                <li>0.00 =》 取一位整数和两位小数</li>
     *                <li>00.000 =》 取两位整数和三位小数</li>
     *                <li># =》 取所有整数部分</li>
     *                <li>#.##% =》 以百分比方式计数，并取两位小数</li>
     *                <li>#.#####E0 =》 显示为科学计数法，并取五位小数</li>
     *                <li>,### =》 每三位以逗号进行分隔，例如：299,792,458</li>
     *                <li>光速大小为每秒,###米 =》 将格式嵌入文本</li>
     *                </ul>
     * @param value   值
     * @return 格式化后的值
     */
    public static String decimalFormat(String pattern, long value) {
        return new DecimalFormat(pattern).format(value);
    }

    /**
     * 格式化金额输出，每三位用逗号分隔
     *
     * @param value 金额
     * @return 格式化后的值
     */
    public static String decimalFormatMoney(double value) {
        String select = Double.toString(value);
        int point = select.indexOf('.');
        if (point == -1) {
            return new DecimalFormat(",###").format(value);
        }
        return new DecimalFormat(",###.00").format(value);
    }

    /**
     * 格式化百分比，小数采用四舍五入方式
     *
     * @param number 值
     * @param scale  保留小数位数
     * @return 百分比
     */
    public static String formatPercent(double number, int scale) {
        StringBuilder pattern = new StringBuilder();
        if (scale <= 0) {
            pattern.append('#').append('%');
        } else {
            pattern.append('#').append('.');
            for (int i = 0; i < scale; i++) {
                pattern.append('#');
            }
            pattern.append('%');
        }
        return new DecimalFormat(pattern.toString()).format(number);
    }

    // ------------------------------------------------------------------------------------------- isXXX

    /**
     * 是否为数字
     *
     * @param str 字符串值
     * @return 是否为数字
     */
    public static boolean isNumber(String str) {
        int len = str.length();
        int flag = 0;


        int i = 0;
        boolean isSix = false;
        boolean iseight = false;
        if (str.charAt(0) == '0') {
            if (str.charAt(1) == 'x') {
                i = 2;
                isSix = true;
            } else {
                i = 1;
                iseight = true;
            }
        }

        while (i < len) {
            if (str.charAt(i) == '.') {
                if (flag == 0) {
                    flag = 1;
                    i++;
                    continue;
                } else {
                    return false;
                }
            }
            if (!Character.isDigit(str.charAt(i))) {
                if (isSix
                        && str.charAt(i) >= 'a'
                        && str.charAt(i) <= 'z'
                        && str.charAt(i) >= 'A'
                        && str.charAt(i) <= 'Z') {
                    continue;
                }
                return false;
            } else {
                if (iseight && str.charAt(i) >= '8') {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    /**
     * 判断String是否是整数<br>
     * 支持8、10、16进制
     *
     * @param s String
     * @return 是否为整数
     */
    public static boolean isInteger(String s) {
        try {
            int i = Integer.decode(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是Long类型<br>
     * 支持8、10、16进制
     *
     * @param s String
     * @return 是否为{@link Long}类型
     */
    public static boolean isLong(String s) {
        try {
            long i = Long.decode(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是浮点数
     *
     * @param s String
     * @return 是否为{@link Double}类型
     */
    public static boolean isDouble(String s) {
        try {
            double i = Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是质数<br>
     * 质数表的质数又称素数。指整数在一个大于1的自然数中,除了1和此整数自身外,没法被其他自然数整除的数。
     *
     * @param n 数字
     * @return 是否是质数
     */
    public static boolean isPrimes(int n) {
        int temp = (int) Math.sqrt(n);
        for (int i = 2; i < temp; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ------------------------------------------------------------------------------------------- generateXXX

    /**
     * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
     *
     * @param begin 最小数字（包含该数）
     * @param end   最大数字（不包含该数）
     * @param size  指定产生随机数的个数
     * @return 随机int数组
     */
    public static int[] generateRandomNumber(int begin, int end, int size) {
        if (end - begin < size) {
            throw new RuntimeException();
        }
        Random temp = new Random();
        int[] result = new int[size];
        int i = 0;
        while (i < size) {
            boolean done = false;
            int s = temp.ints(begin, end).findFirst().getAsInt();
            for (int j = 0; j < i; j++) {
                if (result[j] == s) {
                    done = true;
                    break;
                }
            }
            if (!done) {
                result[i] = s;
                ++i;
            }
        }
        return result;
    }

    /**
     * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
     *
     * @param begin 最小数字（包含该数）
     * @param end   最大数字（不包含该数）
     * @param size  指定产生随机数的个数
     * @return 随机int数组
     */
    public static Integer[] generateBySet(int begin, int end, int size) {
        if (end - begin < size) {
            throw new RuntimeException();
        }
        Random temp = new Random();
        Integer[] result = new Integer[size];
        int i = 0;
        while (i < size) {
            boolean done = false;
            int s = temp.ints(begin, end).findFirst().getAsInt();
            for (int j = 0; j < i; j++) {
                if (result[j] == s) {
                    done = true;
                    break;
                }
            }
            if (!done) {
                result[i] = s;
                ++i;
            }
        }
        return result;
    }

    // ------------------------------------------------------------------------------------------- range

    /**
     * 从0开始给定范围内的整数列表，步进为1
     *
     * @param stop 结束（包含）
     * @return 整数列表
     */
    public static int[] range(int stop) {
        int[] list = new int[stop + 1];
        for (int i = 0; i < stop + 1; i++) {
            list[i] = i;
        }
        return list;
    }

    /**
     * 给定范围内的整数列表，步进为1
     *
     * @param start 开始（包含）
     * @param stop  结束（包含）
     * @return 整数列表
     */
    public static int[] range(int start, int stop) {
        int len = stop - start + 1;
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = start;
            ++start;
        }
        return list;
    }

    /**
     * 给定范围内的整数列表
     *
     * @param start 开始（包含）
     * @param stop  结束（包含）
     * @param step  步进
     * @return 整数列表
     */
    public static int[] range(int start, int stop, int step) {
        int len = (stop - start + 1) / step +
                ((stop - start + 1) % step != 0 ? 1 : 0);
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = start;
            start += step;
        }
        return list;
    }

    /**
     * 将给定范围内的整数添加到已有集合中，步进为1
     *
     * @param start  开始（包含）
     * @param stop   结束（包含）
     * @param values 集合
     * @return 集合
     */
    public static Collection<Integer> appendRange(int start, int stop, Collection<Integer> values) {
        int len = stop - start + 1;
        for (int i = 0; i < len; i++) {
            values.add(start);
            ++start;
        }
        return values;
    }

    /**
     * 将给定范围内的整数添加到已有集合中
     *
     * @param start  开始（包含）
     * @param stop   结束（包含）
     * @param step   步进
     * @param values 集合
     * @return 集合
     */
    public static Collection<Integer> appendRange(int start, int stop, int step, Collection<Integer> values) {
        int len = (stop - start + 1) / step +
                ((stop - start + 1) % step != 0 ? 1 : 0);
        for (int i = 0; i < len; i++) {
            values.add(start);
            start += step;
        }
        return values;
    }

    // ------------------------------------------------------------------------------------------- others

    /**
     * 计算阶乘
     * <p>
     * n! = n * (n-1) * ... * end
     * </p>
     *
     * @param start 阶乘起始
     * @param end   阶乘结束
     * @return 结果
     */
    public static long factorial(long start, long end) {
        long times = start - end + 1;
        long factor = 1;
        for (int i = 0; i < times; i++) {
            factor *= start;
            --start;
        }
        return factor;
    }

    /**
     * 计算阶乘
     * <p>
     * n! = n * (n-1) * ... * 2 * 1
     * </p>
     *
     * @param n 阶乘起始
     * @return 结果
     */
    public static long factorial(long n) {
        return factorial(n, 1);
    }

    /**
     * 平方根算法<br>
     * 推荐使用 {@link Math#sqrt(double)}
     *
     * @param x 值
     * @return 平方根
     */
    public static long sqrt(long x) {
        return x * x;
    }

    /**
     * 可以用于计算双色球、大乐透注数的方法<br>
     * 比如大乐透35选5可以这样调用processMultiple(7,2); 就是数学中的：C72=7*6/2*1
     *
     * @param selectNum 选中小球个数
     * @param minNum    最少要选中多少个小球
     * @return 注数
     */
    public static int processMultiple(int selectNum, int minNum) {
        int sum1 = 1;
        int sum2 = 1;
        int times = minNum;
        for (int i = 0; i < minNum; i++) {
            sum1 *= selectNum;
            --selectNum;
            sum2 *= times;
            --times;
        }
        return sum1 / sum2;
    }

    /**
     * 最大公约数
     *
     * @param m 第一个值
     * @param n 第二个值
     * @return 最大公约数
     */
    public static int divisor(int m, int n) {
        int temp = m;
        if (n > m) {
            m = n;
            n = temp;
        }
        while ((temp = m % n) != 0) {
            m = n;
            n = temp;
        }
        return n;
    }

    /**
     * 最小公倍数
     *
     * @param m 第一个值
     * @param n 第二个值
     * @return 最小公倍数
     */
    public static int multiple(int m, int n) {
        return m * n / divisor(m, n);
    }

    /**
     * 获得数字对应的二进制字符串
     *
     * @param number 数字
     * @return 二进制字符串
     */
    public static String getBinaryStr(Number number) {
        String temp = number.toString();
        int s = Integer.valueOf(temp);
        StringBuilder test = new StringBuilder();
        do {
            test.append(s & 1);
            s = s >> 1;
        } while (s != 0);
        return test.toString();
    }

    /**
     * 二进制转int
     *
     * @param binaryStr 二进制字符串
     * @return int
     */
    public static int binaryToInt(String binaryStr) {
        int temp = Integer.valueOf(binaryStr);
        StringBuilder test = new StringBuilder();
        do {
            test.append(temp & 1);
            temp = temp >> 1;
        } while (temp != 0);
        return Integer.valueOf(test.toString());
    }

    /**
     * 二进制转long
     *
     * @param binaryStr 二进制字符串
     * @return long
     */
    public static long binaryToLong(String binaryStr) {
        long test = Long.valueOf(binaryStr);
        StringBuilder temp = new StringBuilder();
        do {
            temp.append(test & 1);
            test = test >> 1;
        } while (test != 0);
        return Long.valueOf(temp.toString());
    }

    // ------------------------------------------------------------------------------------------- compare

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y返回-1，x> y返回1
     * @see Character#compare(char, char)
     */
    public static int compare(char x, char y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y返回-1，x> y返回1
     * @see Double#compare(double, double)
     */
    public static int compare(double x, double y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y返回-1，x> y返回1
     * @see Integer#compare(int, int)
     */
    public static int compare(int x, int y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y返回-1，x> y返回1
     * @see Long#compare(long, long)
     */
    public static int compare(long x, long y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y返回-1，x> y返回1
     * @see Short#compare(short, short)
     */
    public static int compare(short x, short y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较两个值的大小
     *
     * @param x 第一个值
     * @param y 第二个值
     * @return x==y返回0，x< y 返回-1，x> y返回1
     * @see Byte#compare(byte, byte)
     */
    public static int compare(byte x, byte y) {
        if (x > y) {
            return 1;
        } else if (x == y) {
            return 0;
        }
        return -1;
    }

    /**
     * 比较大小，参数1 &gt; 参数2 返回true
     *
     * @param bigNum1 数字1
     * @param bigNum2 数字2
     * @return 是否大于
     */
    public static boolean isGreater(BigDecimal bigNum1, BigDecimal bigNum2) {
        return bigNum1.compareTo(bigNum2) > 0;
    }

    /**
     * 比较大小，参数1 &gt;= 参数2 返回true
     *
     * @param bigNum1 数字1
     * @param bigNum2 数字2
     * @return 是否大于等于
     */
    public static boolean isGreaterOrEqual(BigDecimal bigNum1, BigDecimal bigNum2) {
        return bigNum1.compareTo(bigNum2) >= 0;
    }

    /**
     * 比较大小，参数1 &lt; 参数2 返回true
     *
     * @param bigNum1 数字1
     * @param bigNum2 数字2
     * @return 是否小于
     */
    public static boolean isLess(BigDecimal bigNum1, BigDecimal bigNum2) {
        return bigNum1.compareTo(bigNum2) < 0;
    }

    /**
     * 比较大小，参数1&lt;=参数2 返回true
     *
     * @param bigNum1 数字1
     * @param bigNum2 数字2
     * @return 是否小于等于
     */
    public static boolean isLessOrEqual(BigDecimal bigNum1, BigDecimal bigNum2) {
        return bigNum1.compareTo(bigNum2) <= 0;
    }

    /**
     * 比较大小，值相等 返回true<br>
     * 此方法通过调用{@link BigDecimal#compareTo(BigDecimal)}方法来判断是否相等<br>
     * 此方法判断值相等时忽略精度的，既0.00 == 0
     *
     * @param bigNum1 数字1
     * @param bigNum2 数字2
     * @return 是否相等
     */
    public static boolean equals(BigDecimal bigNum1, BigDecimal bigNum2) {
        return bigNum1.compareTo(bigNum2) == 0;
    }

    /**
     * 比较两个字符是否相同
     *
     * @param c1         字符1
     * @param c2         字符2
     * @param ignoreCase 是否忽略大小写
     * @return 是否相同
     * @see CharUtil#equals(char, char, boolean)
     */
    public static boolean equals(char c1, char c2, boolean ignoreCase) {
        if (ignoreCase) {
            if (c1 >= 'a' && c1 <= 'z') {
                c1 = (char) (c1 + 32);
            }
            if (c2 >= 'a' && c2 <= 'z') {
                c2 = (char) (c2 + 32);
            }
        }
        return c1 == c2;
    }

    /**
     * 取最小值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(Comparable[])
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> T min(T... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(long...)
     */
    public static long min(long... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(int...)
     */
    public static int min(int... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(short...)
     */
    public static short min(short... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(double...)
     */
    public static double min(double... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     * @see ArrayUtil#min(float...)
     */
    public static float min(float... numberArray) {
        return ArrayUtil.min(numberArray);
    }

    /**
     * 取最大值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(Comparable[])
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> T max(T... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(long...)
     */
    public static long max(long... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(int...)
     */
    public static int max(int... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(short...)
     */
    public static short max(short... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(double...)
     */
    public static double max(double... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     * @see ArrayUtil#max(float...)
     */
    public static float max(float... numberArray) {
        return ArrayUtil.max(numberArray);
    }

    /**
     * 数字转字符串<br>
     * 调用{@link Number#toString()}，并去除尾小数点儿后多余的0
     *
     * @param number       A Number
     * @param defaultValue 如果number参数为{@code null}，返回此默认值
     * @return A String.
     */
    public static String toStr(Number number, String defaultValue) {
        if (number == null) {
            return defaultValue;
        }

        String temp = number.toString();
        int point = temp.indexOf('.');
        int index = temp.length() - 1;
        if (point >= 0) {
            for (int i = temp.length() - 1; i >= point; i--) {
                if (temp.charAt(i) != '0') {
                    index = i + 1;
                    break;
                }
            }
        }
        return temp.substring(0, index);
    }

    /**
     * 数字转字符串<br>
     * 调用{@link Number#toString()}，并去除尾小数点儿后多余的0
     *
     * @param number A Number
     * @return A String.
     */
    public static String toStr(Number number) {
        return toStr(number, "0");
    }


    /**
     * 检查是否为有效的数字<br>
     * 检查Double和Float是否为无限大，或者Not a Number<br>
     * 非数字类型和Null将返回false
     *
     * @param obj 被检查类型
     * @return 检查结果，非数字类型和Null将返回false
     */
    public static boolean isValidIfNumber(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof Number;
    }

    /**
     * 数字转{@link BigDecimal}
     *
     * @param number 数字
     * @return {@link BigDecimal}
     */
    public static BigDecimal toBigDecimal(Number number) {
        //TODO
        return null;
    }

    /**
     * 数字转{@link BigDecimal}
     *
     * @param number 数字
     * @return {@link BigDecimal}
     */
    public static BigDecimal toBigDecimal(String number) {
        return new BigDecimal(number);
    }


    /**
     * 计算等份个数
     *
     * @param total 总数
     * @param part  每份的个数
     * @return 分成了几份
     */
    public static int count(int total, int part) {
        return total / part + total % part != 0 ? 1 : 0;
    }

    /**
     * 空转0
     *
     * @param decimal {@link BigDecimal}，可以为{@code null}
     * @return {@link BigDecimal}参数为空时返回0的值
     */
    public static BigDecimal null2Zero(BigDecimal decimal) {
        if (decimal == null) {
            return BigDecimal.valueOf(0);
        }
        return decimal;
    }

    /**
     * 如果给定值为0，返回1，否则返回原值
     *
     * @param value 值
     * @return 1或非0值
     */
    public static int zero2One(int value) {
        if (value == 0) {
            return 1;
        }
        return value;
    }

    /**
     * 创建{@link BigInteger}，支持16进制、10进制和8进制，如果传入空白串返回null<br>
     * from Apache Common Lang
     *
     * @param str 数字字符串
     * @return {@link BigInteger}
     */
    public static BigInteger newBigInteger(String str) {
        try {
            return new BigInteger(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 判断两个数字是否相邻，例如1和2相邻，1和3不相邻<br>
     * 判断方法为做差取绝对值判断是否为1
     *
     * @param number1 数字1
     * @param number2 数字2
     * @return 是否相邻
     */
    public static boolean isBeside(long number1, long number2) {
        if (number1 - number2 == 1 || number1 - number2 == -1) {
            return true;
        }
        return false;
    }

    /**
     * 判断两个数字是否相邻，例如1和2相邻，1和3不相邻<br>
     * 判断方法为做差取绝对值判断是否为1
     *
     * @param number1 数字1
     * @param number2 数字2
     * @return 是否相邻
     */
    public static boolean isBeside(int number1, int number2) {
        if (number1 - number2 == 1 || number1 - number2 == -1) {
            return true;
        }
        return false;

    }

    /**
     * 把给定的总数平均分成N份，返回每份的个数<br>
     * 当除以分数有余数时每份+1
     *
     * @param total     总数
     * @param partCount 份数
     * @return 每份的个数
     */
    public static int partValue(int total, int partCount) {
        return total / partCount + total % partCount != 1 ? 1 : 0;
    }

    /**
     * 把给定的总数平均分成N份，返回每份的个数<br>
     * 如果isPlusOneWhenHasRem为true，则当除以分数有余数时每份+1，否则丢弃余数部分
     *
     * @param total               总数
     * @param partCount           份数
     * @param isPlusOneWhenHasRem 在有余数时是否每份+1
     * @return 每份的个数
     */
    public static int partValue(int total, int partCount, boolean isPlusOneWhenHasRem) {
        if(isPlusOneWhenHasRem){
            return total / partCount + total % partCount != 1 ? 1 : 0;
        }else{
            return total / partCount;
        }
    }

    /**
     * 提供精确的幂运算
     *
     * @param number 底数
     * @param n      指数
     * @return 幂的积
     */
    public static BigDecimal pow(Number number, int n) {
        BigDecimal temp = new BigDecimal(number.toString());

         return temp.pow(n);
    }

    /**
     * 提供精确的幂运算
     *
     * @param number 底数
     * @param n      指数
     * @return 幂的积
     */
    public static BigDecimal pow(BigDecimal number, int n) {
        return number.pow(n);
    }

    /**
     * 解析转换数字字符串为int型数字，规则如下：
     *
     * <pre>
     * 1、0x开头的视为16进制数字
     * 2、0开头的视为8进制数字
     * 3、其它情况按照10进制转换
     * 4、空串返回0
     * 5、.123形式返回0（按照小于0的小数对待）
     * 6、123.56截取小数点之前的数字，忽略小数部分
     * </pre>
     *
     * @param number 数字，支持0x开头、0开头和普通十进制
     * @return int
     * @throws NumberFormatException 数字格式异常
     */
    public static int parseInt(String number) throws NumberFormatException {
        int point = number.indexOf('.');
       if(point > 0){
          number = number.substring(0,point);
       }else if(point == 0){
           number = "0";
       }
       return Integer.decode(number);
    }

    /**
     * 解析转换数字字符串为long型数字，规则如下：
     *
     * <pre>
     * 1、0x开头的视为16进制数字
     * 2、0开头的视为8进制数字
     * 3、空串返回0
     * 4、其它情况按照10进制转换
     * </pre>
     *
     * @param number 数字，支持0x开头、0开头和普通十进制
     * @return long
     */
    public static long parseLong(String number) {
        int point = number.indexOf('.');
        if(point > 0){
            number = number.substring(0,point);
        }else if(point == 0){
            number = "0";
        }
        return Long.decode(number);
    }

    /**
     * 将指定字符串转换为{@link Number} 对象
     *
     * @param numberStr Number字符串
     * @return Number对象
     */
    public static Number parseNumber(String numberStr) {
        return new BigDecimal(numberStr);
    }


    private static int mathSubnode(int selectNum, int minNum) {
        if (selectNum == minNum) {
            return 1;
        } else {
            return selectNum * mathSubnode(selectNum - 1, minNum);
        }
    }

    private static int mathNode(int selectNum) {
        if (selectNum == 0) {
            return 1;
        } else {
            return selectNum * mathNode(selectNum - 1);
        }
    }
}