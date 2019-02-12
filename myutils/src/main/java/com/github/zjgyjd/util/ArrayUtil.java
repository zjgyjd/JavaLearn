package com.github.zjgyjd.util;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;

import static java.lang.reflect.Array.*;

/**
 * Author: zjgyjd
 * Created: 2018/10/16
 */
public final class ArrayUtil {

    /**
     * 数组中元素未找到的下标，值为-1
     */
    public static final int INDEX_NOT_FOUND = -1;

    private ArrayUtil() {

    }


    /**
     * 数组是否为空
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 是否为空
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean isEmpty(final T... array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空<br>
     * 此方法会匹配单一对象，如果此对象为{@code null}则返回true<br>
     * 如果此对象为非数组，理解为此对象为数组的第一个元素，则返回false<br>
     * 如果此对象为数组对象，数组长度大于0情况下返回false，否则返回true
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(Object array) {
        if (array == null) {
            return true;
        }
        if (!(array instanceof Array) || 0 != getLength(array)) {
            return false;
        }
        return true;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final long... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final int... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final short... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final char... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final byte... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final double... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final float... array) {
        return isEmpty((Object) array);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final boolean... array) {
        return isEmpty((Object) array);
    }


    /**
     * 数组是否为非空
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 是否为非空
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean isNotEmpty(final T... array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空<br>
     * 此方法会匹配单一对象，如果此对象为{@code null}则返回false<br>
     * 如果此对象为非数组，理解为此对象为数组的第一个元素，则返回true<br>
     * 如果此对象为数组对象，数组长度大于0情况下返回true，否则返回false
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final Object array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final long... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final int... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final short... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final char... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final byte... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final double... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final float... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final boolean... array) {
        return !isEmpty((Object) array);
    }

    /**
     * 是否包含{@code null}元素
     *
     * @param <T>   数组元素类型
     * @param array 被检查的数组
     * @return 是否包含{@code null}元素
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean hasNull(T... array) {
        if (array != null) {
            for (T s : array
            ) {
                if (s == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 返回数组中第一个非空元素
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 非空元素，如果不存在非空元素或数组为空，返回{@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T> T firstNonNull(T... array) {
        if (array == null || array.length == 0) {
            return null;
        }
        for (T s : array
        ) {
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    /**
     * 新建一个空数组
     *
     * @param <T>     数组元素类型
     * @param newSize 大小
     * @return 空数组
     * @paramT componentType 元素类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> componentType, int newSize) {
        Object array = Array.newInstance(componentType, newSize);
        return (T[]) array;
    }

    /**
     * 新建一个空数组
     *
     * @param <T>     数组元素类型
     * @param newSize 大小
     * @return 空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(int newSize) {

        return (T[]) new Object[newSize];
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param array 数组对象
     * @return 元素类型
     */
    public static Class<?> getComponentType(Object array) {
        return array.getClass();
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param arrayClass 数组类
     * @return 元素类型
     */
    public static Class<?> getComponentType(Class<?> arrayClass) {
        return arrayClass.getComponentType();
    }

    /**
     * 根据数组元素类型，获取数组的类型<br>
     * 方法是通过创建一个空数组从而获取其类型
     *
     * @param componentType 数组元素类型
     * @return 数组类型
     */
    public static Class<?> getArrayType(Class<?> componentType) {
        Object re = Array.newInstance(componentType, 20);
        return re.getClass();
    }

    /**
     * 强转数组类型<br>
     * 强制转换的前提是数组元素类型可被强制转换<br>
     * 强制转换后会生成一个新数组
     *
     * @param type     数组类型或数组元素类型
     * @param arrayObj 原数组
     * @return 转换后的数组类型
     * @throws NullPointerException     提供参数为空
     * @throws IllegalArgumentException 参数arrayObj不是数组
     */
    public static Object[] cast(Class<?> type, Object arrayObj) throws NullPointerException, IllegalArgumentException {
        int len = Array.getLength(arrayObj);
        Object change = Array.newInstance(type, len);
        for (int i = 0; i < len; i++) {
            Array.set(change, i, Array.get(arrayObj, i));
        }
        return (Object[]) change;
    }

    /**
     * 将新元素添加到已有数组中<br>
     * 添加新元素会生成一个新的数组，不影响原数组
     *
     * @param <T>         数组元素类型
     * @param buffer      已有数组
     * @param newElements 新元素
     * @return 新数组
     */
    @SafeVarargs
    public static <T> T[] append(T[] buffer, T... newElements) {
        Object[] temp = new Object[buffer.length + newElements.length];
        for (int i = 0; i < buffer.length + newElements.length; i++) {
            if (i < buffer.length) {
                temp[i] = buffer[i];
            } else {
                temp[i] = newElements[i - buffer.length];
            }
        }

        return (T[]) temp;
    }

    /**
     * 将新元素添加到已有数组中<br>
     * 添加新元素会生成一个新的数组，不影响原数组
     *
     * @param <T>         数组元素类型
     * @param array       已有数组
     * @param newElements 新元素
     * @return 新数组
     */
    @SafeVarargs
    public static <T> Object append(Object array, T... newElements) {
        Object temp = Array.newInstance(array.getClass(), Array.getLength(array)
                + newElements.length);
        for (int i = 0; i < Array.getLength(array)
                + newElements.length; i++) {
            if (i < Array.getLength(array)) {
                Array.set(temp, i, Array.get(array, i));
            } else {
                Array.set(temp, i, newElements[i - Array.getLength(array)]);
            }
        }

        return temp;
    }


    /**
     * 将新元素插入到到已有数组中的某个位置<br>
     * 添加新元素会生成一个新的数组，不影响原数组<br>
     * 如果插入位置为为负数，从原数组从后向前计数，若大于原数组长度，则空白处用null填充
     *
     * @param <T>         数组元素类型
     * @param buffer      已有数组
     * @param index       插入位置，此位置为对应此位置元素之前的空档
     * @param newElements 新元素
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] insert(T[] buffer, int index, T... newElements) {
        int len = buffer.length + newElements.length;//7
        int flag = 0;
        if (index >= len) {
            len = len + (index - (len - 1));//7+15-6
        } else {
            if (index < 0) {//-7
                if (-index >= len) {//7>=7
                    len = len + (-index - (len - 1));//7+(7-6)=8
                }
            }
        }

        Object[] temp = new Object[len];
        int id = 0;
        for (int i = 0; i < len; i++) {
            if (index >= 0) {
                if (i == index || flag == 1) {
                    temp[i] = newElements[i - index];
                    flag = 1;
                    if ((i - index) == (newElements.length - 1)) {
                        flag = 2;
                    }
                } else {
                    if (flag != 2) {
                        if (i <= buffer.length - 1) {
                            temp[i] = buffer[i];
                        } else {
                            temp[i] = null;
                        }
                    } else {
                        temp[i] = buffer[index++];
                    }
                }
            } else {
                if (i == (len - 1) + index || flag == 1) {//7-7
                    int count = i - ((len - 1) + index);//0-0
                    if (count <= newElements.length - 1) {
                        temp[i] = newElements[count];
                        flag = 1;
                    } else if (i < (len - buffer.length) - 1) {
                        temp[i] = null;
                    } else {
                        flag = 2;
                    }

                } else {
                    if (flag != 2) {
                        temp[i] = buffer[i];
                        id = (len - 1) + index;
                    } else {
                        temp[i] = buffer[id];
                        ++id;
                    }
                }
            }
        }
        return (T[]) temp;
    }

    /**
     * 将新元素插入到到已有数组中的某个位置<br>
     * 添加新元素会生成一个新的数组，不影响原数组<br>
     * 如果插入位置为为负数，从原数组从后向前计数，若大于原数组长度，则空白处用null填充
     *
     * @param <T>         数组元素类型
     * @param array       已有数组
     * @param index       插入位置，此位置为对应此位置元素之前的空档
     * @param newElements 新元素
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object insert(Object array, int index, T... newElements) {
        Object[] temp = new Object[Array.getLength(array)];
        for (int i = 0; i < Array.getLength(array); i++) {
            temp[i] = Array.get(array, i);
        }
        return insert(temp, index, newElements);
    }

    /**
     * 生成一个新的重新设置大小的数组<br>
     * 调整大小后拷贝原数组到新数组下。扩大则占位前N个位置，缩小则截断
     *
     * @param <T>           数组元素类型
     * @param buffer        原数组
     * @param newSize       新的数组大小
     * @param componentType 数组元素类型
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] buffer, int newSize, Class<?> componentType) {
        T[] temp = (T[]) Array.newInstance(componentType, newSize);
        for (int i = 0; i < newSize; i++) {
            if (i < buffer.length) {
                Array.set(temp, i, buffer[i]);
            }
        }
        return temp;
    }

    /**
     * 生成一个新的重新设置大小的数组<br>
     * 新数组的类型为原数组的类型，调整大小后拷贝原数组到新数组下。扩大则占位前N个位置，缩小则截断
     *
     * @param <T>     数组元素类型
     * @param buffer  原数组
     * @param newSize 新的数组大小
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] buffer, int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < newSize; i++) {
            if (i < buffer.length) {
                temp[i] = buffer[i];
            }
        }
        return temp;
    }

    /**
     * 将多个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param <T>    数组元素类型
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    @SafeVarargs
    public static <T> T[] addAll(T[]... arrays) {
        int len = arrays.length;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                len = len + arrays[i].length;
            }
        }
        T[] temp = (T[]) new Object[len];
        len = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                for (int j = 0; j < arrays[i].length; j++) {
                    temp[len] = arrays[i][j];
                    len++;
                }
            }
        }
        return temp;
    }


    /**
     * 生成一个从0开始的数字列表<br>
     *
     * @param excludedEnd 结束的数字（不包含）
     * @return 数字列表
     */
    public static int[] range(int excludedEnd) {
        int[] temp = new int[excludedEnd];
        for (int i = 0; i < excludedEnd; i++) {
            temp[i] = i;
        }
        return temp;
    }

    /**
     * 生成一个数字列表<br>
     * 自动判定正序反序
     *
     * @param includedStart 开始的数字（包含）
     * @param excludedEnd   结束的数字（不包含）
     * @return 数字列表
     */
    public static int[] range(int includedStart, int excludedEnd) {
        int len = includedStart < excludedEnd ? excludedEnd - includedStart
                : includedStart - excludedEnd;

        if (len == 0) {
            return null;
        }

        int[] temp = new int[len];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = includedStart < excludedEnd ? includedStart++ : includedStart--;
        }
        return temp;
    }

    /**
     * 生成一个数字列表<br>
     * 自动判定正序反序
     *
     * @param includedStart 开始的数字（包含）
     * @param excludedEnd   结束的数字（不包含）
     * @param step          步进
     * @return 数字列表
     */
    public static int[] range(int includedStart, int excludedEnd, int step) {
        int len = includedStart < excludedEnd ? ((excludedEnd - includedStart) % step != 0 ? 1 : 0)
                + (excludedEnd - includedStart) / step
                : ((includedStart - excludedEnd) % step != 0 ? 1 : 0)
                + (includedStart - excludedEnd) / step;


        if (len == 0) {
            return null;
        }
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = includedStart;
            includedStart = includedStart < excludedEnd ? len + includedStart : len - includedStart;
        }
        return temp;
    }

    /**
     * 拆分byte数组为几个等份（最后一份可能小于len）
     *
     * @param array 数组
     * @param len   每个小节的长度
     * @return 拆分后的数组
     */
    public static byte[][] split(byte[] array, int len) {
        int line = (array.length % len != 0 ? 1 : 0);
        int row = array.length / len + line;
        byte[][] temp = new byte[row][];
        int flag = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (line = (array.length / len == i ? array.length % len : len)); j++) {
                temp[i] = new byte[line];
                temp[i][j] = array[flag];
                ++flag;
                if (flag == array.length) {
                    return temp;
                }
            }
        }
        return null;
    }


    /**
     * 映射键值（参考Python的zip()函数）<br>
     * 例如：<br>
     * keys = [a,b,c,d]<br>
     * values = [1,2,3,4]<br>
     * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
     * 如果两个数组长度不同，则只对应最短部分
     *
     * @param <K>     Key类型
     * @param <V>     Value类型
     * @param keys    键列表
     * @param values  值列表
     * @param isOrder 是否有序
     * @return Map
     */
    public static <K, V> Map<K, V> zip(K[] keys, V[] values, boolean isOrder) {
        //TODO
        return null;
    }

    /**
     * 映射键值（参考Python的zip()函数），返回Map无序<br>
     * 例如：<br>
     * keys = [a,b,c,d]<br>
     * values = [1,2,3,4]<br>
     * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
     * 如果两个数组长度不同，则只对应最短部分
     *
     * @param <K>    Key类型
     * @param <V>    Value类型
     * @param keys   键列表
     * @param values 值列表
     * @return Map
     */
    public static <K, V> Map<K, V> zip(K[] keys, V[] values) {
        //TODO
        return null;
    }


    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param <T>   数组类型
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static <T> int indexOf(T[] array, Object value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，忽略大小写，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOfIgnoreCase(CharSequence[] array, CharSequence value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].toString().toUpperCase().equals(value.toString().toUpperCase())) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param <T>   数组类型
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static <T> int lastIndexOf(T[] array, Object value) {
        int flag = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                flag = i;
            }
        }
        if (flag >= 0) {
            return flag;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 数组中是否包含元素
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static <T> boolean contains(T[] array, T value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }


    /**
     * 数组中是否包含元素，忽略大小写
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean containsIgnoreCase(CharSequence[] array, CharSequence value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i].toString().toUpperCase().equals(value.toString().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(long[] array, long value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(long[] array, long value) {
        int flag = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == (value)) {
                flag = i;
            }
        }
        if (flag >= 0) {
            return flag;
        }
        return INDEX_NOT_FOUND;

    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(long[] array, long value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(int[] array, int value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(int[] array, int value) {
        int flag = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == (value)) {
                flag = i;
            }
        }
        if (flag >= 0) {
            return flag;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(int[] array, int value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(short[] array, short value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(short[] array, short value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag >= 0) {
            return flag;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(short[] array, short value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(char[] array, char value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(char[] array, char value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag >= 0) {
            return flag;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(char[] array, char value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(byte[] array, byte value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(byte[] array, byte value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag < 0) {
            return INDEX_NOT_FOUND;
        }
        return flag;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(byte[] array, byte value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(double[] array, double value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(double[] array, double value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag < 0) {
            return INDEX_NOT_FOUND;
        }
        return flag;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(double[] array, double value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(float[] array, float value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(float[] array, float value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag < 0) {
            return INDEX_NOT_FOUND;
        }
        return flag;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(float[] array, float value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(boolean[] array, boolean value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(boolean[] array, boolean value) {
        int len = array.length;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                flag = i;
            }
        }
        if (flag < 0) {
            return INDEX_NOT_FOUND;
        }
        return flag;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean contains(boolean[] array, boolean value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------- Wrap and unwrap

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Integer[] wrap(int... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Integer[] temp = new Integer[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static int[] unWrap(Integer... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Long[] wrap(long... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Long[] temp = new Long[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static long[] unWrap(Long... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        long[] temp = new long[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Character[] wrap(char... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Character[] temp = new Character[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static char[] unWrap(Character... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        char[] temp = new char[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Byte[] wrap(byte... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Byte[] temp = new Byte[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static byte[] unWrap(Byte... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        byte[] temp = new byte[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Short[] wrap(short... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Short[] temp = new Short[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static short[] unWrap(Short... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        short[] temp = new short[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Float[] wrap(float... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Float[] temp = new Float[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static float[] unWrap(Float... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        float[] temp = new float[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Double[] wrap(double... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Double[] temp = new Double[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static double[] unWrap(Double... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        double[] temp = new double[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 将原始类型数组包装为包装类型
     *
     * @param values 原始类型数组
     * @return 包装类型数组
     */
    public static Boolean[] wrap(boolean... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        Boolean[] temp = new Boolean[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装类数组转为原始类型数组
     *
     * @param values 包装类型数组
     * @return 原始类型数组
     */
    public static boolean[] unWrap(Boolean... values) {
        if (values == null) {
            return null;
        }
        int len = values.length;
        boolean[] temp = new boolean[len];
        for (int i = 0; i < len; i++) {
            temp[i] = values[i];
        }
        return temp;
    }

    /**
     * 包装数组对象
     *
     * @param obj 对象，可以是对象数组或者基本类型数组
     * @return 包装类型数组或对象数组
     */
    public static Object[] wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        int len = Array.getLength(obj);
        Object[] temp = new Object[len];
        for (int i = 0; i < len; i++) {
            temp[i] = Array.get(obj, i);
        }
        return temp;
    }

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }

        return obj.getClass().isArray();
    }

    /**
     * 获取数组对象中指定index的值，支持负数，例如-1表示倒数第一个值
     *
     * @param <T>   数组元素类型
     * @param array 数组对象
     * @param index 下标，支持负数
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Object array, int index) {
        if (index >= 0) {
            return (T) Array.get(array, index);
        } else {
            return (T) Array.get(array, Array.getLength(array) + index);
        }
    }

    /**
     * 获取数组中指定多个下标元素值，组成新数组
     *
     * @param <T>     数组元素类型
     * @param array   数组
     * @param indexes 下标列表
     * @return 结果
     */
    public static <T> T[] getAny(Object array, int... indexes) {
        int len = indexes.length;
        Object temp = Array.newInstance(array.getClass().getComponentType(), len);
        for (int i = 0; i < len; i++) {
            Array.set(temp, i, Array.get(array, indexes[i]));
        }
        return (T[]) temp;
    }

    /**
     * 获取子数组
     *
     * @param array 数组
     * @param start 开始位置（包括）
     * @param end   结束位置（不包括）
     * @return 新的数组
     */
    public static Object[] sub(Object array, int start, int end) {
        int len = end - start;
        Object temp = Array.newInstance(array.getClass().getComponentType(), len);
        for (int i = 0; i < len; i++) {
            Array.set(temp, i, Array.get(array, start));
            ++start;
        }
        return (Object[]) temp;
    }

    /**
     * 获取子数组
     *
     * @param array 数组
     * @param start 开始位置（包括）
     * @param end   结束位置（不包括）
     * @param step  步进
     * @return 新的数组
     */
    public static Object[] sub(Object array, int start, int end, int step) {
        if (array == null) {
            return null;
        }
        int len = (end - start) / step + (end - start) % step != 0 ? 1 : 0;
        Object temp = Array.newInstance(array.getClass().getComponentType(), len);
        for (int i = 0; i < len; i++) {
            Array.set(temp, i, Array.get(array, start));
            ++start;
        }
        return (Object[]) temp;
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        int len = Array.getLength(obj);
        temp.append("[ ");
        for (int i = 0; i < len; i++) {
            temp.append(Array.get(obj, i)).append(" ");
        }
        temp.append("]");
        return temp.toString();
    }

    /**
     * 获取数组长度<br>
     * 如果参数为{@code null}，返回0
     *
     * <pre>
     * ArrayUtil.length(null)            = 0
     * ArrayUtil.length([])              = 0
     * ArrayUtil.length([null])          = 1
     * ArrayUtil.length([true, false])   = 2
     * ArrayUtil.length([1, 2, 3])       = 3
     * ArrayUtil.length(["a", "b", "c"]) = 3
     * </pre>
     *
     * @param array 数组对象
     * @return 数组长度
     * @throws IllegalArgumentException 如果参数不为数组，抛出此异常
     * @see Array#getLength(Object)
     */
    public static int length(Object array) throws IllegalArgumentException {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }


    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(long[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(int[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(short[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(char[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(byte[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(boolean[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(float[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(double[] array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static String join(Object array, CharSequence conjunction) {
        if (array == null) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        int len = Array.getLength(array);
        for (int i = 0; i < len; i++) {
            temp.append(Array.get(array,i)).append(conjunction.toString());

        }
        return temp.toString();
    }

    /**
     * {@link ByteBuffer} 转byte数组
     *
     * @param bytebuffer {@link ByteBuffer}
     * @return byte数组
     */
    public static byte[] toArray(ByteBuffer bytebuffer) {
    return bytebuffer.array();
    }

    /**
     * 将集合转为数组
     *
     * @param <T>           数组元素类型
     * @param collection    集合
     * @param componentType 集合元素类型
     * @return 数组
     */
    public static <T> T[] toArray(Collection<T> collection, Class<T> componentType) {
        return collection.toArray((T[])Array.newInstance(componentType
                ,collection.size()));
    }

    // ---------------------------------------------------------------------- remove

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param <T>   数组元素类型
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] remove(T[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static long[] remove(long[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static int[] remove(int[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static short[] remove(short[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static char[] remove(char[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static byte[] remove(byte[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static double[] remove(double[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static float[] remove(float[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static boolean[] remove(boolean[] array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中对应位置的元素<br>
     * copy from commons-lang
     *
     * @param array 数组对象，可以是对象数组，也可以原始类型数组
     * @param index 位置，如果位置小于0或者大于长度，返回原数组
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static Object remove(Object array, int index) throws IllegalArgumentException {
        //TODO
        return null;
    }

    // ---------------------------------------------------------------------- remove

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param <T>     数组元素类型
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static <T> T[] removeEle(T[] array, T element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static long[] removeEle(long[] array, long element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static int[] removeEle(int[] array, int element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static short[] removeEle(short[] array, short element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static char[] removeEle(char[] array, char element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static byte[] removeEle(byte[] array, byte element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static double[] removeEle(double[] array, double element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static float[] removeEle(float[] array, float element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 移除数组中指定的元素<br>
     * 只会移除匹配到的第一个元素 copy from commons-lang
     *
     * @param array   数组对象，可以是对象数组，也可以原始类型数组
     * @param element 要移除的元素
     * @return 去掉指定元素后的新数组或原数组
     * @throws IllegalArgumentException 参数对象不为数组对象
     */
    public static boolean[] removeEle(boolean[] array, boolean element) throws IllegalArgumentException {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param <T>                 数组元素类型
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static <T> T[] reverse(final T[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param <T>   数组元素类型
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static <T> T[] reverse(final T[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static long[] reverse(final long[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static long[] reverse(final long[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static int[] reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static int[] reverse(final int[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static short[] reverse(final short[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static short[] reverse(final short[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static char[] reverse(final char[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static char[] reverse(final char[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static byte[] reverse(final byte[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static byte[] reverse(final byte[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static double[] reverse(final double[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static double[] reverse(final double[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static float[] reverse(final float[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static float[] reverse(final float[] array) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array               数组，会变更
     * @param startIndexInclusive 其实位置（包含）
     * @param endIndexExclusive   结束位置（不包含）
     * @return 变更后的原数组
     */
    public static boolean[] reverse(final boolean[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //TODO
        return null;
    }

    /**
     * 反转数组，会变更原数组
     *
     * @param array 数组，会变更
     * @return 变更后的原数组
     */
    public static boolean[] reverse(final boolean[] array) {
        //TODO
        return null;
    }

    /**
     * 取最小值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static <T extends Comparable<? super T>> T min(T[] numberArray) {
        //TODO
        return null;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static long min(long... numberArray) {
        //TODO
        return -1L;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static int min(int... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static short min(short... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static char min(char... numberArray) {
        //TODO
        return '0';
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static byte min(byte... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static double min(double... numberArray) {
        //TODO
        return -1D;
    }

    /**
     * 取最小值
     *
     * @param numberArray 数字数组
     * @return 最小值
     */
    public static float min(float... numberArray) {
        //TODO
        return -1F;
    }

    /**
     * 取最大值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static <T extends Comparable<? super T>> T max(T[] numberArray) {
        //TODO
        return null;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static long max(long... numberArray) {
        //TODO
        return -1L;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static int max(int... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static short max(short... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static char max(char... numberArray) {
        //TODO
        return '0';
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static byte max(byte... numberArray) {
        //TODO
        return -1;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static double max(double... numberArray) {
        //TODO
        return -1D;
    }

    /**
     * 取最大值
     *
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static float max(float... numberArray) {
        //TODO
        return -1F;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static int[] swap(int[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static long[] swap(long[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static double[] swap(double[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static float[] swap(float[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static boolean[] swap(boolean[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static byte[] swap(byte[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static char[] swap(char[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static short[] swap(short[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param <T>    元素类型
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static <T> T[] swap(T[] array, int index1, int index2) {
        //TODO
        return null;
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array  数组对象
     * @param index1 位置1
     * @param index2 位置2
     * @return 交换后的数组，与传入数组为同一对象
     */
    public static Object swap(Object array, int index1, int index2) {
        //TODO
        return null;
    }
}
