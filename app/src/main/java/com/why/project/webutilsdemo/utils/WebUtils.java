package com.why.project.webutilsdemo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * Created HaiyuKing
 * Used  MD5加密（基于MessageDigest）
 */
public class WebUtils {
    
    /**
     * MD5加密，32位
     * param str - 加密前的字符串
     * http://hubingforever.blog.163.com/blog/static/171040579201210781650340/
     * <br/>1、生成实现指定摘要算法的 MessageDigest 对象，其中传入的参数指定计算消息摘要所使用的算法，常用的有"MD5"，"SHA"等。
     * <br/>2、生成要加密的字符串的字节类型数组数组
     * <br/>3、计算消息摘要，返回字节类型的数组
     * <br/>4、将计算结果(byte数组)转换为字符串
     * str - password
     * return 5f4dcc3b5aa765d61d8327deb882cf99
     * */
    public static String MD5(String str)
    {
        MessageDigest md5 = null;
        try
        {//生成实现指定摘要算法的 MessageDigest 对象，其中传入的参数指定计算消息摘要所使用的算法，常用的有"MD5"，"SHA"等。
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
        
        //生成要加密的字符串的字节类型数组数组
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
        {
            byteArray[i] = (byte) charArray[i];
        }

        //计算消息摘要，返回字节类型的数组
        byte[] md5Bytes = md5.digest(byteArray);
        
        //将计算结果(byte数组)转换为字符串
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++)
        {
            int val = (md5Bytes[i]) & 0xff;
            if (val < 16)
            {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 返回的结果跟上一个方法一致
     * */
    public static String MD5_2(String str)
    {
        MessageDigest md5 = null;
        try
        {//生成实现指定摘要算法的 MessageDigest 对象，其中传入的参数指定计算消息摘要所使用的算法，常用的有"MD5"，"SHA"等。
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }

        //生成要加密的字符串的字节类型数组数组
        byte[] byteArray1 = null;
		try {
			byteArray1 = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md5.update(byteArray1);
        //计算消息摘要，返回字节类型的数组
        byte[] md5Bytes = md5.digest();

        //将计算结果(byte数组)转换为字符串
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++)
        {
            int val = (md5Bytes[i]) & 0xff;
            if (val < 16)
            {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
}