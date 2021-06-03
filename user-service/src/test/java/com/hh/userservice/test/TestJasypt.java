package com.hh.userservice.test;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @ClassName TestJasypt
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/3/24 13:28
 * @Version 1.0
 **/
public class TestJasypt {

    /**
     * Jasypt生成加密结果
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待加密值
     * @return
     */
    public static String encryptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.encrypt(value);
        return result;
    }

    /**
     * 解密
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待解密密文
     * @return
     */
    public static String decyptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.decrypt(value);
        return result;
    }

    /**
     * @param password salt
     * @return
     */
    public static SimpleStringPBEConfig cryptOr(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args) {
        // 加密
//        System.out.println(encryptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7", "root@1234"));
//        System.out.println(decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7","Thdxj5ThWP8u0R0cREX3cxW/BhbegWOi"));

        // 加密
        System.out.println(encryptPwd("123","salt"));
        System.out.println(decyptPwd("123","dVojD/TWVUue/rsH1ZMacQ=="));
        System.out.println(decyptPwd("123","ho2F0DrgmTwJXM+ZozaF2w=="));

        // 解密
//        mysql@1234
//        System.out.println(decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7", "bgWQ4OfVCUJ1ExsqNhGV+KKBgpx8alv+"));

//        root@1234
//        System.out.println(decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7", "tdHzge8YvviOJaiV/+P6uQ9wgB44D1aH"));
    }

}
