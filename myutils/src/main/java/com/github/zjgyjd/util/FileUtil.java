package com.github.zjgyjd.util;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 文件处理工具
 * <p>
 * Author: zjgyjd
 * Created: 2018/10/13
 */
public final class FileUtil {


    private FileUtil() {
    }

    /**
     * 是否为Windows环境
     *
     * @return 是否为Windows环境
     */
    public static boolean isWindows() {
        Properties properties = System.getProperties();//获得系统属性
        String win = properties.getProperty("os.name");
        if (win.contains("Windows")) {//查看是否包含Windows字符
            return true;
        }
        return false;
    }

    /**
     * 列出目录文件<br>
     * 给定的绝对路径不能是压缩包中的路径
     *
     * @param path 目录绝对路径或者相对路径
     * @return 文件列表（包含目录）
     */
    public static File[] ls(String path) {
            File file = new File(path);
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    return files;
                }
            }
        return null;
    }

    /**
     * 目录是否为空
     *
     * @param dirPath 目录
     * @return 是否为空
     */
    public static boolean isDirEmpty(Path dirPath) {
        File file = dirPath.toFile();
        if (file.isDirectory()) {
            try {
                String[] s = file.list();
                if (s != null && s.length == 0) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    /**
     * 获取标准的绝对路径
     *
     * @param file 文件
     * @return 绝对路径
     */
    public static String getAbsolutePath(File file) {
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /**
     * 给定路径已经是绝对路径<br>
     * 此方法并没有针对路径做标准化
     *
     * @param path 需要检查的Path
     * @return 是否已经是绝对路径
     */
    public static boolean isAbsolutePath(String path) {
        File file = new File(path);
        if (file.isAbsolute()) {
            return true;
        }
        return false;
    }


    /**
     * 递归遍历目录以及子目录中的所有文件<br>
     * 如果提供file为文件，直接返回过滤结果
     *
     * @param path       当前遍历文件或目录的路径
     * @param fileFilter 文件过滤规则对象，选择要保留的文件，只对文件有效，不过滤目录
     * @return 文件列表
     */
    public static List<File> loopFiles(String path, FileFilter fileFilter) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return new ArrayList<>();
        }
        List<File> list = new ArrayList<>();
        if (file.isFile()) {
            if (fileFilter.accept(file)) {
                list.add(file);
            }
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                fileFilter.accept(f);
                if (f.isFile()) {
                    if (fileFilter.accept(f)) {
                        list.add(f);
                    }
                } else {
                    loopFiles(f.getPath(), fileFilter);
                }
            }
        }
        return list;
    }

    /**
     * 获取临时文件路径（绝对路径）
     *
     * @return 临时文件路径
     */
    public static String getTmpDirPath() {
        return System.getenv("TEMP");
    }

    /**
     * 获取用户路径（绝对路径）
     *
     * @return 用户路径
     */
    public static String getUserHomePath() {
        return System.getProperty("user.home");
    }

    /**
     * 判断文件是否存在，如果file为null，则返回false
     *
     * @param file 文件
     * @return 如果存在返回true
     */
    public static boolean exist(File file) {
        if (file.exists()) {
            return true;
        }
        return false;
    }


    /**
     * 指定文件最后修改时间
     *
     * @param file 文件
     * @return 最后修改时间
     */
    public static Date lastModifiedTime(File file) {
        if (file.exists()) {
            return new Date(file.lastModified());
        }
        return null;
    }


    /**
     * 计算目录或文件的总大小<br>
     * 当给定对象为文件时，直接调用 {@link File#length()}<br>
     * 当给定对象为目录时，遍历目录下的所有文件和目录，递归计算其大小，求和返回
     *
     * @param file 目录或文件
     * @return 总大小，bytes长度
     */
    public static long size(File file) {
        long sum = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            } else {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        sum = sum + size(f);
                    }
                    return sum;
                }
            }
        }
        return -1;
    }

    /**
     * 给定文件或目录的最后修改时间是否晚于给定时间
     *
     * @param file      文件或目录
     * @param reference 参照文件
     * @return 是否晚于给定时间
     */
    public static boolean newerThan(File file, File reference) {
        long a = file.lastModified();
        long b = reference.lastModified();
        if (a > b) {
            return true;
        }
        return false;
    }

    /**
     * 给定文件或目录的最后修改时间是否晚于给定时间
     *
     * @param file       文件或目录
     * @param timeMillis 做为对比的时间
     * @return 是否晚于给定时间
     */
    public static boolean newerThan(File file, long timeMillis) {

        if (file.lastModified() > timeMillis) {
            return true;
        }

        return false;
    }

    /**
     * 创建所给文件或目录的父目录
     *
     * @param file 文件或目录
     * @return 父目录
     */
    public static File mkParentDirs(File file) {
        if (!file.exists()) {
            return null;
        }
        File f = file.getParentFile();
        if (f == null) {
            System.out.println("父目录不存在");
            return null;
        }
        return f;
    }

    /**
     * 创建文件及其父目录，如果这个文件存在，直接返回这个文件<br>
     * 此方法不对File对象类型做判断，如果File不存在，无法判断其类型
     *
     * @param file 文件对象
     * @return 文件，若路径为null，返回null
     */
    public static File touch(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            return file;
        }
        File f = file.getParentFile();
        if (f == null) {
            try {
                if (file.createNewFile()) {
                    System.out.println("创建成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (!f.exists()) {
                if (f.mkdirs()) {
                    System.out.println("创建父目录成功");
                }
            }
        }
        try {
            if (file.createNewFile()) {
                System.out.println("创建成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    /**
     * 删除文件或者文件夹<br>
     * 注意：删除文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹<br>
     * 某个文件删除失败会终止删除操作
     *
     * @param file 文件对象
     * @return 成功与否
     */
    public static boolean del(File file) {
        //if(file.delete()){//目录要为空才能删除
        //  }
        if (file.delete()) {

        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                del(f);
            }
            if (file.isDirectory()) {
                file.delete();
            }
        }
        if (file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 清空文件夹<br>
     * 注意：清空文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹<br>
     * 某个文件删除失败会终止删除操作
     *
     * @param directory 文件夹
     * @return 成功与否
     */
    public static boolean clean(File directory) {
        if (directory.isDirectory()) {
            if (directory.delete()) {

            } else {
                File[] files = directory.listFiles();
                for (File f : files) {
                    del(f);
                    if (f.isDirectory()) {
                        directory.delete();
                    }
                }
            }
            if (directory.exists()) {
                return false;
            }
            return true;
        }
        return false;
    }


    /**
     * 移动文件或者目录
     *
     * @param src        源文件或者目录
     * @param dest       目标文件或者目录
     * @param isOverride 是否覆盖目标，只有目标为文件才覆盖
     */
    public static void move(File src, File dest, boolean isOverride) {
        if (!src.exists()) {
            System.out.println(src.getName() + "文件或目录不存在");
            return;
        }


        File fileTemp = new File(dest.getPath() + File.separator + src.getName());
        //dest只能为目录,但要判断src是否与目录中的文件重名
        if (src.isFile()) {//移动为文件时
            if (dest.isDirectory()) {
                File[] files = dest.listFiles();
                boolean name = false;
                if (files != null)
                    for (File f : files) {
                        if (f.isFile()) {
                            if (f.getName().equals(src.getName())) {
                                name = true;
                                fileTemp = f;
                                break;
                            }
                        }
                    }
                if (name) {//此时发生重名
                    if (isOverride) {//此时完成覆盖
                        try (FileReader in = new FileReader(src);
                             FileWriter out = new FileWriter(fileTemp)
                        ) {
                            fileMove(in, out);
                            System.out.println(src.getName() + "文件覆盖成功");
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(src.getName() + "文件名相同,不覆盖无法移动");
                    }

                } else {

                    try (FileReader in = new FileReader(src);
                         FileWriter out = new FileWriter(fileTemp)
                    ) {
                        fileMove(in, out);
                        System.out.println(src.getName() + "文件移动成功");
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("请输入目标目录:");
            }
        } else {//移动为目录时,此时fileTemp是个目录
            if (fileTemp.exists()) {//说明目录重复
                if (isOverride) {
                    del(fileTemp);//删除原来文件
                    move(src, dest, isOverride);//再次递归
                } else {
                    System.out.println(src.getName() + "目录名重复");
                }
            } else {
                if (fileTemp.mkdirs()) {//此时目录重新创建
                    File[] files = src.listFiles();
                    if (files != null && files.length != 0) {
                        //此时说明原目录有东西,将东西移动到现在目录
                        for (File f : files) {
                            move(f, fileTemp, isOverride);
                        }
                    }
                }
            }
        }
        if (src.isFile()) {
            del(src);
        } else {
            if (isDirEmpty(Paths.get(src.getPath()))) {
                del(src);
            }
        }
    }

    public static void fileMove(FileReader in, FileWriter out) throws IOException {
        char[] buffer = new char[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }


    /**
     * 修改文件或目录的文件名，不变更路径，只是简单修改文件名<br>
     * 重命名有两种模式：<br>
     * 1、isRetainExt为true时，保留原扩展名：
     *
     * <pre>
     * FileUtil.rename(file, "aaa", true) xx/xx.png =》xx/aaa.png
     * </pre>
     * <p>
     * 2、isRetainExt为false时，不保留原扩展名，需要在newName中
     *
     * <pre>
     * FileUtil.rename(file, "aaa.jpg", false) xx/xx.png =》xx/aaa.jpg
     * </pre>
     *
     * @param file        被修改的文件
     * @param newName     新的文件名，包括扩展名
     * @param isRetainExt 是否保留原文件的扩展名，如果保留，则newName不需要加扩展名
     * @param isOverride  是否覆盖目标文件
     * @return 目标文件
     */
    public static File rename(File file, String newName, boolean isRetainExt, boolean isOverride) {
        if (!file.exists()) {
            System.out.println("文件不存在");
            return null;
        }
        File tempFile =null;
        if (file.isFile()) {
            if (isRetainExt) {
                //如果会被修改拓展名
                tempFile = new File(file.getParent() + File.separator + newName);
            } else {
                //不更改文件拓展名
                int property = file.getName().lastIndexOf(".");
                StringBuilder tempName = new StringBuilder().append(file.getName()).delete(0, property);
                String name = newName + tempName;
                tempFile = new File(file.getParent() + File.separator + name);
            }
            try (FileReader in = new FileReader(file);
                 FileWriter out = new FileWriter(tempFile)
            ) {
                fileMove(in, out);
                System.out.println(file.getName() + "文件重命名成功");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//此时目录不能更改拓展名
            tempFile = new File(file.getParent() + File.separator + newName);
            if (tempFile.mkdirs()) {//创建目录
                File[] files = file.listFiles();
                if (files != null && files.length != 0) {
                    //此时说明原目录有东西,将东西移动到现在目录
                    for (File f : files) {
                        move(f,tempFile,true);
                    }
                }
            }
            System.out.println("目录重命名成功");
        }

        del(file);
        return tempFile;
    }


    /**
     * 文件路径是否相同<br>
     * 取两个文件的绝对路径比较，在Windows下忽略大小写，在Linux下不忽略。
     *
     * @param file1 文件1
     * @param file2 文件2
     * @return 文件路径是否相同
     */
    public static boolean pathEquals(File file1, File file2) {
       if(isWindows()){
          return file1.getAbsolutePath().equals(file2.getAbsolutePath());
       }else{
        return  file1.getAbsolutePath().toUpperCase().equals(file2.getAbsolutePath().toUpperCase());
       }
    }


    /**
     * 获取文件扩展名，扩展名不带“.”
     *
     * @param file 文件
     * @return 扩展名
     */
    public static String extName(File file) {
        if(!file.exists()||!file.isFile()){
        return null;
        }
        int property = file.getName().lastIndexOf(".");
        StringBuilder tempName = new StringBuilder().append(file.getName()).delete(property,file.getName().length());
        return tempName.toString();
    }


    /**
     * 获取指定层级的父路径
     *
     * <pre>
     * getParent(file("d:/aaa/bbb/cc/ddd", 0)) -> "d:/aaa/bbb/cc/ddd"
     * getParent(file("d:/aaa/bbb/cc/ddd", 2)) -> "d:/aaa/bbb"
     * getParent(file("d:/aaa/bbb/cc/ddd", 4)) -> "d:/"
     * getParent(file("d:/aaa/bbb/cc/ddd", 5)) -> null
     * </pre>
     *
     * @param file  目录或文件
     * @param level 层级
     * @return 路径File，如果不存在返回null
     */
    public static File getParent(File file, int level) {
        for (int i = level; i > 0; i--) {
            file =file.getParentFile();
        }
        return file;
    }

}
