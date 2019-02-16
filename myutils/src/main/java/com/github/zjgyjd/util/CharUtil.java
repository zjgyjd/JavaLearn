package com.github.zjgyjd.util;

/**
 * Author: secondriver
 * Created: 2018/10/16
 */
public final class CharUtil {
    
    public static final char SPACE = ' ';
    public static final char TAB = '	';
    public static final char DOT = '.';
    public static final char SLASH = '/';
    public static final char BACKSLASH = '\\';
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char UNDERLINE = '_';
    public static final char DASHED = '-';
    public static final char COMMA = ',';
    public static final char DELIM_START = '{';
    public static final char DELIM_END = '}';
    public static final char BRACKET_START = '[';
    public static final char BRACKET_END = ']';
    public static final char COLON = ':';
    public static final char DOUBLE_QUOTES = '"';
    public static final char SINGLE_QUOTE = '\'';
    public static final char AMP = '&';
    
    private CharUtil() {
    }
    
    
    /**
     * 是否为ASCII字符，ASCII字符位于0~127之间
     *
     * <pre>
     *   CharUtil.isAscii('a')  = true
     *   CharUtil.isAscii('A')  = true
     *   CharUtil.isAscii('3')  = true
     *   CharUtil.isAscii('-')  = true
     *   CharUtil.isAscii('\n') = true
     *   CharUtil.isAscii('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符处
     * @return true表示为ASCII字符，ASCII字符位于0~127之间
     */
    public static boolean isAscii(char ch) {
        int check = ch;
        if(check <= 127){
            return true;
        }
        return false;
    }
    
    /**
     * 是否为可见ASCII字符，可见字符位于32~126之间
     *
     * <pre>
     *   CharUtil.isAsciiPrintable('a')  = true
     *   CharUtil.isAsciiPrintable('A')  = true
     *   CharUtil.isAsciiPrintable('3')  = true
     *   CharUtil.isAsciiPrintable('-')  = true
     *   CharUtil.isAsciiPrintable('\n') = false
     *   CharUtil.isAsciiPrintable('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符处
     * @return true表示为ASCII可见字符，可见字符位于32~126之间
     */
    public static boolean isAsciiPrintable(char ch) {
        return (int) ch >= 32 && (int) ch <= 126;
    }
    
    /**
     * 是否为ASCII控制符（不可见字符），控制符位于0~31和127
     *
     * <pre>
     *   CharUtil.isAsciiControl('a')  = false
     *   CharUtil.isAsciiControl('A')  = false
     *   CharUtil.isAsciiControl('3')  = false
     *   CharUtil.isAsciiControl('-')  = false
     *   CharUtil.isAsciiControl('\n') = true
     *   CharUtil.isAsciiControl('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为控制符，控制符位于0~31和127
     */
    public static boolean isAsciiControl(final char ch) {
        return !isAsciiPrintable(ch);
    }
    
    /**
     * 判断是否为字母（包括大写字母和小写字母）<br>
     * 字母包括A~Z和a~z
     *
     * <pre>
     *   CharUtil.isLetter('a')  = true
     *   CharUtil.isLetter('A')  = true
     *   CharUtil.isLetter('3')  = false
     *   CharUtil.isLetter('-')  = false
     *   CharUtil.isLetter('\n') = false
     *   CharUtil.isLetter('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为字母（包括大写字母和小写字母）字母包括A~Z和a~z
     */
    public static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }
    
    /**
     * <p>
     * 判断是否为大写字母，大写字母包括A~Z
     * </p>
     *
     * <pre>
     *   CharUtil.isLetterUpper('a')  = false
     *   CharUtil.isLetterUpper('A')  = true
     *   CharUtil.isLetterUpper('3')  = false
     *   CharUtil.isLetterUpper('-')  = false
     *   CharUtil.isLetterUpper('\n') = false
     *   CharUtil.isLetterUpper('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为大写字母，大写字母包括A~Z
     */
    public static boolean isLetterUpper(final char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    
    /**
     * <p>
     * 检查字符是否为小写字母，小写字母指a~z
     * </p>
     *
     * <pre>
     *   CharUtil.isLetterLower('a')  = true
     *   CharUtil.isLetterLower('A')  = false
     *   CharUtil.isLetterLower('3')  = false
     *   CharUtil.isLetterLower('-')  = false
     *   CharUtil.isLetterLower('\n') = false
     *   CharUtil.isLetterLower('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为小写字母，小写字母指a~z
     */
    public static boolean isLetterLower(final char ch) {
        return ch >= 'a' && ch <= 'z';
    }
    
    /**
     * <p>
     * 检查是否为数字字符，数字字符指0~9
     * </p>
     *
     * <pre>
     *   CharUtil.isNumber('a')  = false
     *   CharUtil.isNumber('A')  = false
     *   CharUtil.isNumber('3')  = true
     *   CharUtil.isNumber('-')  = false
     *   CharUtil.isNumber('\n') = false
     *   CharUtil.isNumber('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为数字字符，数字字符指0~9
     */
    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    /**
     * 是否为16进制规范的字符，判断是否为如下字符
     * <pre>
     * 1. 0~9
     * 2. a~f
     * 4. A~F
     * </pre>
     *
     * @param c 字符
     * @return 是否为16进制规范的字符
     */
    public static boolean isHexChar(char c) {
        return c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || c >= '0' && c <= '9';
    }
    
    /**
     * 是否为字符或数字，包括A~Z、a~z、0~9
     *
     * <pre>
     *   CharUtil.isLetterOrNumber('a')  = true
     *   CharUtil.isLetterOrNumber('A')  = true
     *   CharUtil.isLetterOrNumber('3')  = true
     *   CharUtil.isLetterOrNumber('-')  = false
     *   CharUtil.isLetterOrNumber('\n') = false
     *   CharUtil.isLetterOrNumber('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为字符或数字，包括A~Z、a~z、0~9
     */
    public static boolean isLetterOrNumber(final char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9';
    }
    
    
    /**
     * 给定类名是否为字符类，字符类包括：
     *
     * <pre>
     * Character.class
     * char.class
     * </pre>
     *
     * @param clazz 被检查的类
     * @return true表示为字符类
     */
    public static boolean isCharClass(Class<?> clazz) {
        return clazz.getName().equals(Character.class.getName())||clazz.getName().equals(char.class.getName());
    }
    
    /**
     * 给定对象对应的类是否为字符类，字符类包括：
     *
     * <pre>
     * Character.class
     * char.class
     * </pre>
     *
     * @param value 被检查的对象
     * @return true表示为字符类
     */
    public static boolean isChar(Object value) {
        //TODO
        return false;
    }
    
    /**
     * 是否空白符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     *
     * @param c 字符
     * @return 是否空白符
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     */
    public static boolean isBlankChar(char c) {
        //TODO
        return false;
    }
    
    /**
     * 是否空白符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     *
     * @param c 字符
     * @return 是否空白符
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     */
    public static boolean isBlankChar(int c) {
        //TODO
        return false;
    }
    
    
    /**
     * 是否为Windows或者Linux（Unix）文件分隔符<br>
     * Windows平台下分隔符为\，Linux（Unix）为/
     *
     * @param c 字符
     * @return 是否为Windows或者Linux（Unix）文件分隔符
     */
    public static boolean isFileSeparator(char c) {
        //TODO
        return false;
    }
    
    /**
     * 比较两个字符是否相同
     *
     * @param c1         字符1
     * @param c2         字符2
     * @param ignoreCase 是否忽略大小写
     * @return 是否相同
     */
    public static boolean equals(char c1, char c2, boolean ignoreCase) {
        //TODO
        return false;
    }
}
