//package com.hh.userservice.other;
//
//import com.miduchina.common.pojo.ContentPojo;
//import com.sjqx.pojo.view.TestRequestView;
//import com.sjqx.pojo.view.TestResultView;
//import com.sjqx.component.SourceHandleService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.miduchina.common.pojo.AuthorPojo;
//import com.miduchina.common.pojo.CommentPojo;
//import com.miduchina.common.pojo.ConvergePojo;
//import com.sjqx.asyc.SourceTaskAsync;
//import com.sjqx.constant.GlobalConstant;
//import com.sjqx.init.InitLoadSource;
//import com.sjqx.plus.WebContent;
//import com.sjqx.pojo.view.RequestView;
//import com.sjqx.pojo.result.ResultView;
//import com.sjqx.util.VerifyUtil;
//import com.xd.tools.ownutils.DateUtils;
//import com.xd.tools.ownutils.Lz4Util;
//
///**
// * @author LiYuhang
// * @version 0.1
// * @application
// * @Date 2021/1/5 17:13
// */
//@RestController
//@Slf4j
//@RequestMapping(value = "/source")
//@Api(value = "来源分类接口v", tags = "来源分类接口")
//public class SourceClassification {
//
//
//    @Autowired
//    InitLoadSource initLoad;
//
//    @Autowired
//    private SourceTaskAsync taskAsync;
//
//
//    @Resource(name = "asyncServiceExecutor")
//    private TaskExecutor asyncServiceExecutor;
//
//    /**
//     * 评论新对象来源分类接口
//     * @param requestView
//     * @param result
//     * @return ResultView
//     */
//    @PostMapping(value = "/classify")
//    @ApiOperation(value = "来源分类接口", notes = "来源分类API")
//    @ApiResponses({@ApiResponse(code = 0000, message = "success"), @ApiResponse(code = 9999, message = "error"), @ApiResponse(code = 2222, message = "loading")})
//    public ResultView classify(@RequestBody @Valid RequestView requestView, BindingResult result) {
//        if (result.hasErrors()) {
//            String errMsg = VerifyUtil.getAllErrorMessage(result);
//            log.error(" liyuhang:参数错误，{} ,requestView:{},",errMsg,requestView);
//            return ResultView.errorMsg(errMsg + " ！！ ");
//        }
//        long start = System.currentTimeMillis();
//        if (StringUtils.isNotBlank(requestView.getJson())) {
//            try {
//                String temp = Lz4Util.uncompressAndGunzip(requestView.getJson());
//                List<ConvergePojo> convergePojoList = JSON.parseArray(temp, ConvergePojo.class);
//                CountDownLatch countDownLatch = new CountDownLatch(convergePojoList.size());
//                Vector<ConvergePojo> vector = new Vector<>(convergePojoList.size());
//                for (ConvergePojo convergePojo : convergePojoList) {
//                    WebContent content = commentCastToWebContent(convergePojo);
//                    ConvergePojo resPojo = castToSjqxPojo(convergePojo);
//                    taskAsync.handle(resPojo.getCleanProcessId(), requestView.getToken(), resPojo, content, countDownLatch,convergePojo);
//                    vector.add(resPojo);
//                }
//                // 最多等待100 s
//                countDownLatch.await(1000 * 100, TimeUnit.MILLISECONDS);
//                String resJson = JSON.toJSONStringWithDateFormat(vector, DateUtils.FORMAT_LONG);
//                String compress = Lz4Util.compress(resJson);
//                long spend = GlobalConstant.requestTime(start);
//                log.info("api success! size:{} ,use:{} milliseconds ",vector.size(), spend);
//                return ResultView.success(compress);
//            } catch (Exception e) {
//                log.error(" liyuhang:解析异常,==={}==={}===请求参数{}",  e.getMessage(), e.getCause(),JSON.toJSON(requestView), e);
//            }
//        }
//        return ResultView.errorMsg("处理失败！！ ");
//    }
//
//    /**
//     * 内容新对象来源分类接口
//     * @param requestView
//     * @param result
//     * @return ResultView
//     */
//    @PostMapping(value = "/contentClassify")
//    @ApiOperation(value = "内容对象来源分类接口", notes = "内容对象来源分类API")
//    @ApiResponses({@ApiResponse(code = 0000, message = "success"), @ApiResponse(code = 9999, message = "error"), @ApiResponse(code = 2222, message = "loading")})
//    public ResultView contentClassify(@RequestBody @Valid RequestView requestView, BindingResult result) {
//        String token = requestView.getToken();
//        if (result.hasErrors()) {
//            String errMsg = VerifyUtil.getAllErrorMessage(result);
//            log.error(" liyuhang:参数错误，{} ,requestView:{},",errMsg,requestView);
//            return ResultView.errorMsg(errMsg + " ！！ 请求Id:" + token);
//        }
//        long start = System.currentTimeMillis();
//        if (StringUtils.isNotBlank(requestView.getJson())) {
//            try {
//                String temp = Lz4Util.uncompressAndGunzip(requestView.getJson());
//                List<ConvergePojo> convergePojoList = JSON.parseArray(temp, ConvergePojo.class);
//                CountDownLatch countDownLatch = new CountDownLatch(convergePojoList.size());
//                Vector<ConvergePojo> vector = new Vector<>(convergePojoList.size());
//                for (ConvergePojo convergePojo : convergePojoList) {
//                    WebContent content = contentCastToWebContent(convergePojo);
//                    ConvergePojo resPojo = castToSjqxPojo(convergePojo);
//                    taskAsync.contentHandle(resPojo.getCleanProcessId(),  resPojo, content, countDownLatch,convergePojo,false);
//                    vector.add(resPojo);
//                }
//                // 最多等待100 s
//                countDownLatch.await(1000 * 100, TimeUnit.MILLISECONDS);
//
//                String resJson = JSON.toJSONStringWithDateFormat(vector, DateUtils.FORMAT_LONG);
//                String compress = Lz4Util.compress(resJson);
//                long spend = GlobalConstant.requestTime(start);
//                log.info("api success! size:{} ,use:{} milliseconds ",vector.size(), spend);
//                return ResultView.success(compress);
//            } catch (Exception e) {
//                log.error(" liyuhang:解析异常,token:{}==={}==={}===请求参数{}", token, e.getMessage(), e.getCause(),JSON.toJSON(requestView), e);
//            }
//        }
//        return ResultView.errorMsg("处理失败！！ 请求Id:" + token);
//    }
//
//
//    /**
//     * @Description:
//     * @Author: LiYuhang
//     * @Date 2021/3/30 17:37  云湖接口，只用 一级二级三级分类
//     * @param request
//     * @param result
//     * @return com.sjqx.result.ResultView
//     */
//    @PostMapping(value = {"/test","/apiClassificationFilter"})
//    @ApiOperation(value = "来源分类单一对象结果测试接口", notes = "来源分类数据验证API")
//    @ApiResponses({@ApiResponse(code = 0000, message = "success"), @ApiResponse(code = 9999, message = "error"), @ApiResponse(code = 2222, message = "loading")})
//    public ResultView test(@RequestBody @Valid TestRequestView request,BindingResult result) throws Exception{
//        String tranceId = GlobalConstant.getTranceId();
//        if (result.hasErrors()) {
//            String errMsg = VerifyUtil.getAllErrorMessage(result);
//            log.error("参数错误，request : {},{}",request.toString(),errMsg);
//            return ResultView.errorMsg(errMsg + " ！！ 请求Id:" + tranceId);
//        }
//        log.debug("request:{}",JSON.toJSONString(request));
//        WebContent content=new WebContent();
//        BeanUtils.copyProperties(request,content);
//        content.setCrawlerCaptureWebsite(request.getCaptureWebsite());
//        content.setCaptureWebsite(request.getCaptureWebsite());
//        content.setCaptureWebsiteNew(request.getCaptureWebsite());
//        TestResultView res=new TestResultView();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        taskAsync.test(content,request,res,countDownLatch);
//        log.debug("response:{}",JSON.toJSONString(request));
//        countDownLatch.await();
//        return ResultView.success(res);
//    }
//
//
//    @PostMapping(value = "/contentVerify")
//    @ApiOperation(value = "内容对象来源分类接口数据验证", notes = "内容对象来源分类API")
//    @ApiResponses({@ApiResponse(code = 0000, message = "success"), @ApiResponse(code = 9999, message = "error"), @ApiResponse(code = 2222, message = "loading")})
//    public String contentVerify(@RequestBody String json) {
//        long start = System.currentTimeMillis();
//        if (StringUtils.isNotBlank(json)) {
//            try {
//                List<ConvergePojo> convergePojoList = JSON.parseArray(json, ConvergePojo.class);
//                CountDownLatch countDownLatch = new CountDownLatch(convergePojoList.size());
//                Vector<ConvergePojo> vector = new Vector<>(convergePojoList.size());
//                for (ConvergePojo convergePojo : convergePojoList) {
//                    WebContent content = contentCastToWebContent(convergePojo);
//                    ConvergePojo resPojo = castToSjqxPojo(convergePojo);
//                    taskAsync.contentHandle(resPojo.getCleanProcessId(),  resPojo, content, countDownLatch,convergePojo,false);
//                    vector.add(resPojo);
//                }
//                // 最多等待100 s
//                countDownLatch.await(1000 * 100, TimeUnit.MILLISECONDS);
//
//                String resJson = JSON.toJSONStringWithDateFormat(vector, DateUtils.FORMAT_LONG);
//                log.info("verify  success! size:{} ,use:{} milliseconds ",vector.size(), GlobalConstant.requestTime(start));
//                return resJson ;
//            } catch (Exception e) {
//                log.error("liyuhang: 捕捉到异常 {} {}, 异常栈信息:","",GlobalConstant.getMethodName(),e);
//            }
//        }
//        return "error";
//    }
//
//
//    @RequestMapping(value = "refresh",method = {RequestMethod.POST,RequestMethod.GET})
//    @ApiOperation(value = "来源分类刷新词库接口", notes = "来源分类刷新词库API")
//    @ApiResponses({@ApiResponse(code = 0000, message = "重新加载成功", responseContainer = "123"), @ApiResponse(code = 2222, message = "loading")})
//    public ResultView refresh() {
//        if (SourceHandleService.loading) {
//            return ResultView.loading();
//        }
//        long start = System.currentTimeMillis();
//        log.info("来源分类  refresh 开始 ");
//        try {
//            SourceHandleService.load(asyncServiceExecutor);
//        } catch (Exception e) {
//            log.error("initLoad error..{},{}", e.getMessage(), e);
//        }
//        long spend = GlobalConstant.requestTime(start);
//        log.info("来源分类 refresh 结束，耗时 {}", spend);
//        return ResultView.success("重新加载成功,耗时:" + spend + "ms");
//    }
//
//
//
//
//
//
//    /******************************************私有方法**************************************************************************/
//
//    /**
//     * 分析部门 给一串json 每个pojo 有一个 cleanProcesId 根据cleanProcesId new 新对象 把处理之后的结果返还回去
//     * 评论新对象
//     * @param convergePojo
//     * @return
//     */
//
//    private ConvergePojo castToSjqxPojo(ConvergePojo convergePojo) {
//        ConvergePojo resPojo = new ConvergePojo();
//        resPojo.setCleanProcessId(convergePojo.getCleanProcessId());
//        return resPojo;
//    }
//
//    /**
//     * 简化代码 用自己的WebContent 处理逻辑 处理完之后，set 进新对象里
//     * 内容新对象
//     * @param convergePojo 新对象
//     * @return WebContent 老对象统一处理对象
//     */
//    private WebContent contentCastToWebContent(ConvergePojo convergePojo) {
//        WebContent content = new WebContent();
//        content.setCleanProcessId(convergePojo.getCleanProcessId());
//        ContentPojo contentPojo = convergePojo.getContentPojo();
//        String webPageUrl="";String parentUrl=""; String crawlerOriginType="";String sjcjCaptureWebsite="";String crawlerCaptureWebsite="";
//        if (contentPojo != null) {
//            webPageUrl = ifNullOrElse(contentPojo.getSjqxWebpageUrl(),"");//
//            parentUrl = ifNullOrElse(contentPojo.getSjcjParentUrl(),"");// 父Url
//            crawlerOriginType =ifNullOrElse(contentPojo.getSjcjOriginType(),"");// 爬虫原始类型
//            sjcjCaptureWebsite = ifNullOrElse(contentPojo.getSjcjCaptureWebsite(),"");// 数据采集抓取website
//            crawlerCaptureWebsite=ifNullOrElse(contentPojo.getSjcjCaptureWebsite(),"");
//        }
//        AuthorPojo authorContentPojo = convergePojo.getAuthorContentPojo();// 评论用户对象
//        Integer verifyType=0;
//        String author="" ;
//        String authorAccount="";
//        if (authorContentPojo != null){
//            verifyType = authorContentPojo.getSjcjVerifiedType() == null ? -1 : authorContentPojo.getSjcjVerifiedType();
//            author = ifNullOrElse(authorContentPojo.getSjcjNickName(),"");// 作者
//            authorAccount = ifNullOrElse(authorContentPojo.getSjcjAuthorAccount(),"");// 作者账户
//        }
//        content.setWebpageUrl(webPageUrl);
//        content.setParentUrl(parentUrl);
//        content.setTitle(ifNullOrElse(contentPojo.getSjcjTitle(),""));
//        content.setContent(ifNullOrElse(contentPojo.getSjcjContent(),""));
//        content.setCrawlerCaptureWebsite(crawlerCaptureWebsite);
//        content.setCrawlerOriginType(crawlerOriginType);
//        content.setCaptureWebsite(sjcjCaptureWebsite);
//        content.setCrawlerCaptureWebsite(sjcjCaptureWebsite);
//        content.setCaptureWebsiteNew(sjcjCaptureWebsite);
//        content.setAuthorAccount(authorAccount);
//        content.setOriginAuthorId(authorAccount);
//        content.setAuthor(author);
//        content.setVerified_type(String.valueOf(verifyType));
//        return content;
//    }
//
//
//    /**
//     * 评论新对象数据转换
//     * @param convergePojo
//     * @return WebContent 老对象统一处理对象
//     */
//    private WebContent commentCastToWebContent(ConvergePojo convergePojo) {
//        WebContent content = new WebContent();
//
//        content.setCleanProcessId(convergePojo.getCleanProcessId());
//        CommentPojo commentPojo = convergePojo.getCommentPojo();
//        String webPageUrl="";String parentUrl=""; String crawlerOriginType="";String sjcjCaptureWebsite="";String crawlerCaptureWebsite="";
//        if (commentPojo != null) {
//            webPageUrl = ifNullOrElse(commentPojo.getSjqxWebpageUrl(),"");//
//            parentUrl = ifNullOrElse(commentPojo.getSjcjParentUrl(),"");// 父Url
//            crawlerOriginType =ifNullOrElse(commentPojo.getSjcjOriginType(),"");// 爬虫原始类型
//            sjcjCaptureWebsite = ifNullOrElse(commentPojo.getSjcjCaptureWebsite(),"");// 数据采集抓取website
//            crawlerCaptureWebsite=ifNullOrElse(commentPojo.getSjcjCaptureWebsite(),"");
//
//            //采集类型微博时， 特殊处理
//            if(StringUtils.isBlank(webPageUrl)){
//                if(convergePojo.getContentPojo() != null ){
//                    webPageUrl=ifNullOrElse(convergePojo.getContentPojo().getSjcjUrl(),"");//
//                }
//                if(StringUtils.isBlank(webPageUrl)){
//                    if(convergePojo.getContentPojo() != null){
//                        webPageUrl=ifNullOrElse(convergePojo.getContentPojo().getSjqxWebpageUrl(),"");//
//                    }
//                }
//            }
//
//            //wx评论时，兼容采集来源类
//            if(StringUtils.isBlank(crawlerOriginType)){
//                if(convergePojo.getContentPojo() != null ){
//                    crawlerOriginType=ifNullOrElse(convergePojo.getContentPojo().getSjcjOriginType(),"");//
//                }
//            }
//        }
//
//        AuthorPojo authorCommentPojo = convergePojo.getAuthorCommentPojo();// 评论用户对象
//        Integer verifyType=0;
//        String author="" ;
//        String authorAccount="";
//        if (authorCommentPojo != null){
//            verifyType = authorCommentPojo.getSjcjVerifiedType() == null ? -1 : authorCommentPojo.getSjcjVerifiedType();
//            author = ifNullOrElse(authorCommentPojo.getSjcjNickName(),"");// 作者
//            authorAccount = ifNullOrElse(authorCommentPojo.getSjcjAuthorAccount(),"");// 作者账户
//        }
//        content.setContent(ifNullOrElse(commentPojo.getSjcjContent(),""));
//
//        content.setWebpageUrl(webPageUrl);
//        content.setParentUrl(parentUrl);
//        content.setCrawlerCaptureWebsite(crawlerCaptureWebsite);
//        content.setCrawlerOriginType(crawlerOriginType);
//        content.setCaptureWebsite(sjcjCaptureWebsite);
//        content.setCrawlerCaptureWebsite(sjcjCaptureWebsite);
//        content.setCaptureWebsiteNew(sjcjCaptureWebsite);
//        content.setAuthorAccount(authorAccount);
//        content.setOriginAuthorId(authorAccount);
//        content.setAuthor(author);
//        content.setVerified_type(String.valueOf(verifyType));
//        return content;
//    }
//
//
//    private String ifNullOrElse(String target, String orElse) {
//        return target == null ? orElse : target;
//    }
//
//
//
//}
