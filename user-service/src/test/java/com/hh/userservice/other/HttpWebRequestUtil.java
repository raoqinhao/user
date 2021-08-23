//package com.hh.userservice.other;
//
//import com.alibaba.fastjson.JSON;
//import com.miduchina.common.pojo.ConvergePojo;
//import com.sjqx.constant.GlobalConstant;
//import com.xd.tools.ownutils.DateUtils;
//import com.xd.tools.ownutils.Lz4Util;
//import lombok.extern.slf4j.Slf4j;
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author LiYuhang
// * @version 0.1
// * @application
// * @Date 2021/5/21 11:25
// * @Description TODO
// */
//@Slf4j
//public abstract class HttpWebRequestUtil {
//
//    /**
//     * 封装通用新对象lz4压缩字符串处理 需要自己实现{@link HttpWebRequestUtil#businessSourceClassify(ConvergePojo,CountDownLatch,ConvergePojo)} }
//     * @param lz4Json
//     * @param token
//     * @param start
//     * @return
//     */
//    public  String sourceClassify(String lz4Json,String token,long start){
//        try {
//            String temp = Lz4Util.uncompressAndGunzip(lz4Json);
//            List<ConvergePojo> convergePojoList = JSON.parseArray(temp, ConvergePojo.class);
//            CountDownLatch countDownLatch = new CountDownLatch(convergePojoList.size());
//            Vector<ConvergePojo> vector = new Vector<>(convergePojoList.size());
//            for (ConvergePojo convergePojo : convergePojoList) {
//                ConvergePojo resPojo = castToSjqxPojo(convergePojo);
//                businessSourceClassify(resPojo,countDownLatch,convergePojo);
//                vector.add(resPojo);
//            }
//            // 最多等待100 s
//            countDownLatch.await(1000 * 100, TimeUnit.MILLISECONDS);
//            String resJson = JSON.toJSONStringWithDateFormat(vector, DateUtils.FORMAT_LONG);
//            String compress = Lz4Util.compress(resJson);
//            log.info("api  success! size:{} ,use:{} milliseconds ",vector.size(), GlobalConstant.requestTime(start));
//            return compress ;
//        } catch (Exception e) {
//            log.error("liyuhang: 顶级异常 token:{} {} {}, 异常栈信息:",token,GlobalConstant.getMethodName(),e);
//        }
//        return "";
//    }
//
//
//    public abstract  void businessSourceClassify(ConvergePojo resPojo,CountDownLatch countDownLatch,ConvergePojo convergePojo) ;
//
//
//
//
//    /**
//     * 分析部门 给一串json 每个pojo 有一个 cleanProcesId 根据cleanProcesId new 新对象 把处理之后的结果返还回去
//     * 评论新对象
//     * @param convergePojo
//     * @return
//     */
//
//     static ConvergePojo castToSjqxPojo(ConvergePojo convergePojo) {
//        ConvergePojo resPojo = new ConvergePojo();
//        resPojo.setCleanProcessId(convergePojo.getCleanProcessId());
//        return resPojo;
//    }
//
//}
