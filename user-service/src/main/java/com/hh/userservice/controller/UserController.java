package com.hh.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.hh.userservice.annotation.UserStatus;
import com.hh.userservice.config.SpringApplicationUtils;
import com.hh.userservice.config.UserEnum;
import com.hh.userservice.pojo.UserBean;
import com.hh.userservice.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @UserStatus
    private String status;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public void getUserStatus() throws Exception{
        Class<UserController> userControllerClass = UserController.class;
        Field statusField = userControllerClass.getDeclaredField("status");
        UserStatus annotation1 = statusField.getAnnotation(UserStatus.class);
        System.out.println(annotation1.value());
        AnnotatedType annotatedType = statusField.getAnnotatedType();
        Type type = annotatedType.getType();
        System.out.println(type);
        Annotation[] annotations = statusField.getAnnotations();

        System.out.println(UserEnum.valueOf("AGE"));
        System.out.println(UserEnum.valueOf("USERNAME"));
        System.out.println(UserEnum.valueOf("PASSWORD"));
        System.out.println(UserEnum.USERNAME.getName());
        UserEnum[] values = UserEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].name().equals("AGE")) {
                System.out.println(values[i].getName());
            }
        }


    }


    @RequestMapping(value = "/aware", method = RequestMethod.GET)
    @ResponseBody
    public void testGetAware() {
        UserBean userBean = (UserBean) SpringApplicationUtils.getBean("userBean");
        System.out.println(userBean.toString());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public List<UserBean> test(){
        List<UserBean> userList = userService.findAllUserBean();
        return userList;
    }

    @RequestMapping(value = "toIndex", method = RequestMethod.GET)
    public String toMain(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute("verifyCode"));

        return "index";
    }



    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody String json, HttpServletRequest request){
        JSONObject returnJsonObject = new JSONObject();

        JSONObject jsonObject = JSONObject.parseObject(json);

        String verifyCode = jsonObject.getString("verifyCode");
        if (verifyCode != null && !"".equals(verifyCode)) {
            String sessionVerify = request.getSession().getAttribute("verifyCode").toString();
            if (!sessionVerify.equals(verifyCode)) {
                returnJsonObject.put("code", -1);
                returnJsonObject.put("message","验证码输入错误");
                return returnJsonObject;
            }
        }

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String rememberMeString = jsonObject.getString("rememberMe");
        boolean rememberMe = false;
        if (rememberMeString != null && !"".equals(rememberMeString)) {
            if ("true".equals(rememberMeString)) {
                rememberMe = true;
            }
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password,rememberMe);
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e) {
            e.printStackTrace();
        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
        }
        returnJsonObject.put("code",0);
        returnJsonObject.put("message","登录成功");
        return returnJsonObject;
    }

    /**
     * 验证码图片
     *
     * @return
     */
    @RequestMapping(value = "/toVerifyCode", method = RequestMethod.GET)
    public void identifyingCodePic(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setContentType("image/jpeg/jpg/png");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            int width = 60, height = 20;
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            Random random = new Random();
            g.setColor(getRandColor(200, 250));
            g.fillRect(0, 0, width, height);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            g.setColor(getRandColor(160, 200));
            for (int i = 0; i < 155; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                g.drawLine(x, y, x + xl, y + yl);
            }
            String sRand = "";
            for (int i = 0; i < 4; i++) {
                String rand = String.valueOf(random.nextInt(10));
                sRand += rand;
                g.setColor(new Color(20 + random.nextInt(110), 20 + random
                        .nextInt(110), 20 + random.nextInt(110)));
                g.drawString(rand, 13 * i + 6, 16);
            }
            // 将认证码存入SESSION
            request.getSession().setAttribute("verifyCode", sRand);
            g.dispose();
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "JPEG", os);
            os.flush();
            os.close();
            os = null;
            response.flushBuffer();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 得到颜色
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/toLogout",method = RequestMethod.GET)
    public String toLogout() {
        Session session = SecurityUtils.getSubject().getSession();
        if (session != null) {
            SecurityUtils.getSubject().getSession().stop();
        }
        return "logout";
    }
}
