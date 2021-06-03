package com.hh.userservice.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;
import org.assertj.core.internal.Bytes;
import org.junit.Test;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName TestFilterString
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/5/19 11:03
 * @Version 1.0
 **/
public class TestFilterString {


    @Test
    public void dealWithCompanyName() {
        String names = "测试建筑,中国科学院上海硅酸盐研究所,新亚商务大厦,上海久川物业管理有限公司-天山大厦,上海虹桥雅高美爵酒店,上海广慈敬老院," +
                "上海多媒体产业园发展有限公司,北京世邦魏理仕物业管理有限公司上海分公司（利星行广场）,中华人民共和国名誉主席宋庆龄陵园管理处," +
                "上海文化广播影视集团有限公司广播大厦,上海服装（集团）有限公司,东方国际大厦,古北SOHO广场,华闻国际大厦,长宁区工人文化宫," +
                "绿地商务大厦,兆丰世贸大厦,佳都大厦,兆丰环球大厦,上海电影广场,上海博物馆,疾控中心1/2号楼,上海亭枫商务酒店有限公司," +
                "银统大厦（北楼）,亨通国际大厦,上海龙柏饭店有限公司,花园大厦,上海名豪餐饮管理有限公司,上海颐养第一敬老院,虹桥东方国信商务广场," +
                "上海红桥宾馆有限公司,大众金融大厦,来福士,盛高国际大厦,虹桥南丰城,上海馥邦购物中心有限公司,SOHO天山广场,云都虹桥大厦," +
                "华山医院分部,天会商务广场,上海市工人疗养院,舜元科创大厦,上海市现代职业技术学校新渔校区,民俗文化中心,海益商务大厦,尚嘉中心," +
                "申亚时代广场,嘉宁国际大厦,上海日航饭店,舜元企业发展大厦,兆益科技园,同达创业大厦,辽油大厦,春秋国际大厦," +
                "鑫达大厦,"+
                "九华广场,"+
                "金福第三养老院,"+
                "长宁精神卫生中心,"+
                "汇金百货虹桥店,"+
                "上海血液中心,"+
                "嘉虹酒店（虹桥机场店）,"+
                "虹桥商务大厦,"+
                "上海市长宁区人民法院,"+
                "上海世贸商城,"+
                "光华中西医结合医院,"+
                "刘海粟美术馆,"+
                "汉庭上海天山西路店,"+
                "汉庭酒店(虹桥机场店）,"+
                "上海索菲亚电子机械有限公司,"+
                "中山国际广场,"+
                "虹桥艺术中心,"+
                "西郊宾馆,"+
                "缤谷文化休闲广场,"+
                "魔方公寓_哈密路店,"+
                "中海油大厦,"+
                "海世轩公馆,"+
                "上海电力医院,"+
                "环东华时尚休闲中心,"+
                "银统大厦（南楼）,"+
                "龙之梦大酒店,"+
                "上海洲际房地产,"+
                "上海扬子江万丽大酒店,"+
                "上海君丽大酒店管理有限公司,"+
                "农商行龙柏大楼（格林东方酒店）,"+
                "天山停车场（多层）,"+
                "中国科学院上海微系统与信息技术研究所,"+
                "华联发展大厦,"+
                "博世投资,"+
                "虹桥国际商务花园尚品都汇,"+
                "上海市总工会幼儿园,"+
                "出师表大酒店,"+
                "上海利嘉宾馆有限公司,"+
                "格林豪泰长宁酒店（上海）有限公司,"+
                "新虹桥中心大厦,"+
                "古北财富中心,"+
                "汤泉国际,"+
                "美居酒店,"+
                "光华大厦,"+
                "百盛优客城市广场,"+
                "旭辉虹桥国际广场,"+
                "上海市长宁区逸仙程桥敬老院,"+
                "上海宁电投大厦,"+
                "玫瑰坊商业街,"+
                "上海德必易园多媒体发展有限公司,"+
                "上海驿居虹桥酒店有限公司,"+
                "万都中心,"+
                "太阳广场";
        String[] split = names.split(",");
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);
    }


    @Test
    public void testCom() {
        String str = "541517,"+
                "541518,"+
                "541519,"+
                "541521,"+
                "541522,"+
                "541523,"+
                "541524,"+
                "541525,"+
                "541526,"+
                "541527,"+
                "541528,"+
                "541529,"+
                "541530,"+
                "541531,"+
                "541533,"+
                "541534,"+
                "541535,"+
                "541537,"+
                "541538,"+
                "541539,"+
                "541540,"+
                "541541,"+
                "541543,"+
                "541544,"+
                "541545,"+
                "541546,"+
                "541547,"+
                "541548,"+
                "541549,"+
                "541550,"+
                "541551,"+
                "541552,"+
                "541553,"+
                "541554,"+
                "541555,"+
                "541556,"+
                "541557,"+
                "541558,"+
                "541559,"+
                "541560,"+
                "541561,"+
                "541562,"+
                "541563,"+
                "541564,"+
                "541565,"+
                "541566,"+
                "541567,"+
                "541568,"+
                "541569,"+
                "541570,"+
                "541571,"+
                "541572,"+
                "541573,"+
                "541574,"+
                "541575,"+
                "541576,"+
                "541577,"+
                "541578,"+
                "541579,"+
                "541580,"+
                "541581,"+
                "541582,"+
                "541583,"+
                "541584,"+
                "541585,"+
                "541586,"+
                "541587,"+
                "541588,"+
                "541589,"+
                "541590,"+
                "541591,"+
                "541592,"+
                "541593";

        String[] split = str.split(",");
        System.out.println(split.length);
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);
    }

    @Test
    public void testStr() {
        String buildingIds = "847143457053999104,"+
                "847144640338460672,"+
                "847157011136118784,"+
                "847157011207421952,"+
                "847159175795441664,"+
                "847159369731670016,"+
                "847160524868157440,"+
                "847162491870904320,"+
                "847164393702555648,"+
                "847164393757081600,"+
                "847164393857744896,"+
                "847164393903882240,"+
                "847164393945825280,"+
                "847164393991962624,"+
                "847164394033905664,"+
                "847164394075848704,"+
                "847164394121986048,"+
                "847169583256174592,"+
                "847172731614003200,"+
                "847180107918344192,"+
                "847180552678146048,"+
                "847180552728477696,"+
                "847180552770420736,"+
                "847215305204695040,"+
                "847404977176444928,"+
                "847405264893116416,"+
                "847408725420408832,"+
                "847409284986699776,"+
                "847409895031439360,"+
                "847413147009548288,"+
                "847413734765756416,"+
                "847420503072178176,"+
                "847423778886516736,"+
                "847423819042783232,"+
                "847423819147640832,"+
                "847423819281858560,"+
                "847426325097480192,"+
                "847428579120644096,"+
                "847429675075502080,"+
                "847429675121639424,"+
                "847429921662828544,"+
                "847430519607001088,"+
                "847432435594428416,"+
                "847432793557303296,"+
                "847434524810805248,"+
                "847434586471268352,"+
                "847436437891579904,"+
                "847436437933522944,"+
                "847436437975465984,"+
                "847441373232627712,"+
                "847442192875126784,"+
                "847443270937083904,"+
                "847445230071316480,"+
                "847445230121648128,"+
                "847445230171979776,"+
                "847445230213922816,"+
                "847445230264254464,"+
                "847445230306197504,"+
                "847445230348140544,"+
                "847445230394277888,"+
                "847445230436220928,"+
                "847445230490746880,"+
                "847445230532689920,"+
                "847445230578827264,"+
                "847445230620770304,"+
                "847445230666907648,"+
                "847445230708850688,"+
                "847445230750793728,"+
                "847445230792736768,"+
                "847445230834679808,"+
                "847445230876622848,"+
                "847445230918565888,"+
                "847445230960508928,"+
                "847445231002451968,"+
                "847447731097042944,"+
                "847449498593525760,"+
                "847462435521560576,"+
                "847462944923975680,"+
                "847468777003024384,"+
                "847473041733582848,"+
                "847473041775525888,"+
                "847473041817468928,"+
                "847473041855217664,"+
                "847473041926520832,"+
                "847473041972658176,"+
                "847473042018795520,"+
                "847473042060738560,"+
                "847473042106875904,"+
                "847473042148818944,"+
                "847473042190761984,"+
                "847473042232705024,"+
                "847473042299813888,"+
                "847473042354339840,"+
                "847473042408865792,"+
                "847473042463391744,"+
                "847483759325347840,"+
                "847483759367290880,"+
                "847483759413428224,"+
                "847483759459565568,"+
                "847483759505702912,"+
                "847483759547645952,"+
                "847483759593783296,"+
                "847493697825144832,"+
                "847509369338724352,"+
                "847509369397444608,"+
                "847509369439387648,"+
                "847509369519079424,"+
                "847513539257040896,"+
                "847520409988366336,"+
                "847540186207223808,"+
                "847541017522470912,"+
                "847543440198598656,"+
                "847545549715406848,"+
                "847557134718599168,"+
                "847753781222309888,"+
                "847753781264252928,"+
                "847774589525164032,"+
                "847776236313772032,"+
                "847776298381082624,"+
                "847776298423025664,"+
                "847777023773376512,"+
                "847777104140435456,"+
                "847777104182378496,"+
                "847781383311982592,"+
                "847783308023562240,"+
                "847822473993912320,"+
                "847822474040049664,"+
                "847827433624174592,"+
                "847827433661923328,"+
                "847827433699672064,"+
                "847828556795871232,"+
                "847831048325693440,"+
                "847832477727719424,"+
                "847835198472060928,"+
                "847838885164613632,"+
                "847839136835436544,"+
                "847840201374957568,"+
                "847858800034578432,"+
                "847880141404110848,"+
                "847880141446053888,"+
                "847880141487996928,"+
                "847933656038113280";


        String[] split = buildingIds.split(",");
        System.out.println(split.length);
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);
    }



    @Test
    public void testCompanyName() {
        String names = "光启城时尚购物中心,"+
                "汇阳广场,"+
                "凯科置业（上海）有限公司,"+
                "上海铂铼特酒店有限公司,"+
                "上海漕河泾开发区物业管理有限公司,"+
                "上海漕河泾开发区物业管理有限公司-凤凰园,"+
                "上海漕河泾开发区物业管理有限公司虹钦园管理处漕河泾软件大厦,"+
                "上海漕河泾开发区物业管理有限公司绿洲分公司（光启楼）,"+
                "上海电影艺术发展有限公司,"+
                "上海枫林生物医药发展有限公司,"+
                "上海高力国际物业服务有限公司,"+
                "上海航新房地产有限公司,"+
                "上海华太物业管理有限公司,"+
                "上海华鑫物业管理顾问有限公司（华鑫天地））,"+
                "上海华鑫物业管理顾问有限公司（怡虹科技园））,"+
                "上海华鑫物业管理顾问有限公司徐汇分公司（华鑫商务中心）,"+
                "上海环贸广场,"+
                "上海汇金百货有限公司,"+
                "上海汇银物业管理有限公司（汇银广场),"+
                "上海汇银物业管理有限公司（建汇大厦）,"+
                "上海汇州企业管理有限公司,"+
                "上海嘉镱企业管理有限公司,"+
                "上海嘉英物业管理有限公司,"+
                "上海健康医学院附属卫生学校,"+
                "上海凯健华展养老院有限公司,"+
                "上海龙华古寺,"+
                "上海龙群酒店管理有限公司,"+
                "上海美华妇儿医院有限公司,"+
                "上海启胜物业管理服务有限公司-国贸汇广场,"+
                "上海深长城物业管理有限公司,"+
                "上海市漕河泾开发区宝石园20号楼,"+
                "上海市衡山（集团）衡山宾馆有限公司,"+
                "上海市机械工业学校,"+
                "上海市美罗城商业管理有限公司,"+
                "上海市宁国禅寺,"+
                "上海市上海中学,"+
                "上海市信息管理学校（罗香校区）,"+
                "上海新汇房产开发有限公司/上海和汇房产开发有限公司,"+
                "上海徐汇华太物业管理有限公司,"+
                "上海徐汇区悦颐养老院,"+
                "上海御华物业管理有限公司,"+
                "伟恒通（上海）有限公司兆丰环球大厦物业管理处,"+
                "长城物业集团股份有限公司上海分公司,"+
                "中国科学院上海学术活动";
        String[] split = names.split(",");
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);
    }


    @Test
    public void testJDCompanyName() {
        String names = "阿里巴巴物联网技术有限公司,"+
                "保利国际广场,"+
                "华润（上海）房地产开发有限公司,"+
                "华泰中心,"+
                "江桥万达广场,"+
                "区府第二办公楼,"+
                "上海保利茂佳房地产开发有限公司,"+
                "上海大学嘉定校区,"+
                "上海丰庄茶业市场经营管理有限公司,"+
                "上海冠辕投资管理有限公司喜来登香伦酒店,"+
                "上海国际汽车城发展有限公司,"+
                "上海华瞻商业经营管理有限公司,"+
                "上海汇锦置业有限公司,"+
                "上海纪联物业管理有限公司,"+
                "上海嘉宝安石置业有限公司,"+
                "上海嘉淳城市服务管理有限公司,"+
                "上海嘉乐房地产开发有限公司,"+
                "上海嘉亭荟房地产发展有限公司,"+
                "上海南翔大润发商贸有限公司,"+
                "上海普寿嘉供应链管理有限公司,"+
                "上海师范大学天华学院,"+
                "上海市嘉定区机关事务管理局,"+
                "上海同济物业管理有限公司,"+
                "上海颐康家园,"+
                "上海驿岛酒店管理有限公司,"+
                "上海永斌物业管理有限公司,"+
                "上海御泰实业有限公司,"+
                "希杰储运(上海)有限公司,"+
                "中国农业银行股份有限公司上海嘉定支行";
        String[] split = names.split(",");
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);

    }

    @Test
    public void testCompanyId() {
        String companyIds = "541535," +
                "541586,"+
                "541534,"+
                "541563,"+
                "541581,"+
                "541551,"+
                "541558,"+
                "541543,"+
                "541555,"+
                "541538,"+
                "541579,"+
                "541546,"+
                "541578,"+
                "541577,"+
                "541576,"+
                "541540,"+
                "541519,"+
                "541591,"+
                "541583,"+
                "541544,"+
                "541552,"+
                "541528,"+
                "541559,"+
                "541567,"+
                "541539,"+
                "541593,"+
                "541556,"+
                "541553,"+
                "541560,"+
                "541549,"+
                "541550,"+
                "541541,"+
                "541565,"+
                "541548,"+
                "541584,"+
                "541587,"+
                "541547,"+
                "541568,"+
                "541582,"+
                "541569,"+
                "541561,"+
                "541562";
        String[] split = companyIds.split(",");
        String collect = Arrays.stream(split).collect(Collectors.joining("','", "('", "')"));
        System.out.println(collect);
    }


    @Test
    public void filter() throws Exception{
        String fighterImages = "[{'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-001.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-002.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-003.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-004.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-005.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-006.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-007.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-008.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-009.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-010.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-011.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-012.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-013.jpg'}, {'image': '//img.ivsky.com/img/tupian/t/201612/13/junshi_zhandouji-014.jpg'}]\n";
        JSONArray jsonArray = JSONArray.parseArray(fighterImages);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String image = jsonObject.getString("image");
            System.out.println(image);
        }
    }


    @Test
    public void testFilterPlantInfo() {
        String plantArrayStr = "[{'key': 'https://www.ivsky.com\">天堂图片网</a></div><ul id=\"menu\"><li><a href=\"/\">首页</a></li><li><a href=\"/tupian/\">图片大全</a></li><li><a href=\"/bizhi/\">桌面壁纸</a></li></ul><div id=\"search\"><div class=\"inp\"><input type=\"text\" id=\"ser_inp\" class=\"ser_inp\" /></div><div class=\"inp-btn\"><input type=\"submit\" value=\"\" id=\"ser_btn\" class=\"ser_btn\" /></div></div><div id=\"login\"></div></div><div class=\"hbg\"></div></div><div class=\"box\"><div id=\"alltop\"><script>dy(\"alltop\");</script></div><div id=\"tplisttop1\"><script>dy(\"tplisttop1\");</script></div><div id=\"tplisttop2\"><script>dy(\"tplisttop2\");</script></div></div><div class=\"box\"><div class=\"pos\"><a href=\\'https://www.ivsky.com/\\'>首页</a> > <a href=\\'/tupian/\\'>图片大全</a> > <a href=\"/tupian/zhiwu_sucai_t36136/\">植物素材图片</a> 共30张 </div><div class=\"left\"><div class=\"sort\"><ul class=\"tpmenu\"><li class=\"s1\"><a href=\"/tupian/', 'value': '图片大全 - 唯美图片 - 好看的图片\">所有图片</a></li><li class=\"s2\"><a href=\"/tupian/ziranfengguang/'}, {'key': '/tupian/chengshilvyou/', 'value': '城市旅游图片 - 世界各国城市图片\">城市旅游</a></li><li class=\"s4\"><a href=\"/tupian/dongwutupian/'}, {'key': '/tupian/zhiwuhuahui/', 'value': '植物花卉图片 - 花图片 - 花草图片 - 植物图片\">植物花卉</a></li><li class=\"s6\"><a href=\"/tupian/haiyangshijie/'}, {'key': '/tupian/renwutupian/', 'value': '人物图片 - 人物图片大全\">人物图片</a></li><li class=\"s8\"><a href=\"/tupian/meishishijie/'}, {'key': '/tupian/wupin/', 'value': '物品物件大全 - 生活用品 - 学习用品图片\">物品物件</a></li><li class=\"s10\"><a href=\"/tupian/yundongtiyu/'}, {'key': '/tupian/jiaotongyunshu/', 'value': '公路铁路运输 - 桥梁码头图片 - 车船飞机图片\">交通运输</a></li><li class=\"s12\"><a href=\"/tupian/jianzhuhuanjing/'}, {'key': '/tupian/jiaju/', 'value': '家居装饰设计图片 - 装修效果图 - 时尚家居图片\">装饰装修</a></li><li class=\"s14\"><a href=\"/tupian/guanggaosheji/'}, {'key': '/tupian/jieritupian/', 'value': '中国传统节日图片 - 国外知名节日图片\">节日图片</a></li><li class=\"s16\"><a href=\"/tupian/shejisucai/'}, {'key': '/tupian/yishu/', 'value': '艺术 - 绘画 - 民族艺术\">艺术绘画</a></li><li class=\"s18\"><a href=\"/tupian/katongtupian/'}, {'key': '/tupian/qita/', 'value': '其他类别图片\">其他类别</a></li></ul></div><div class=\"sline'}, {'key': '/tupian/xianhua_t60/\"  title=\"鲜花图片_鲜花图片大全\">鲜花</a> <a href=\"/tupian/huahui_t12/\"  title=\"花卉图片_花卉图片大全\">花卉</a> <a href=\"/tupian/huaduo_t1182/\"  title=\"花朵图片_花朵图片大全\">花朵</a> <a href=\"/tupian/huahuan_t1338/\"  title=\"花环图片\">花环</a> <a href=\"/tupian/huashu_t2512/\"  title=\"花束图片\">花束</a> <a href=\"/tupian/huadetexie_t19470/\"  title=\"花的特写图片\">花的特写</a> <a href=\"/tupian/huatian_t12080/\"  title=\"花田图片\">花田</a> <a href=\"/tupian/huacong_t4339/\"  title=\"花丛图片\">花丛</a> <a href=\"/tupian/huaban_t2511/\"  title=\"花瓣图片\">花瓣</a> <a href=\"/tupian/yehua_t1506/\"  title=\"野花图片\">野花</a> <a href=\"/tupian/yezi_t1077/\"  title=\"叶子图片\">叶子</a> <a href=\"/tupian/lvye_t28/\"  title=\"绿叶图片\">绿叶</a> <a href=\"/tupian/nenya_t1429/\"  title=\"嫩芽图片\">嫩芽</a> <a href=\"/tupian/yuanyi_t3408/\"  title=\"园艺图片\">园艺</a> <a href=\"/tupian/penjing_t916/\"  title=\"盆景图片\">盆景</a> <a href=\"/tupian/penzai_t928/\"  title=\"盆栽图片\">盆栽</a> <a href=\"/tupian/huayi_t4184/\"  title=\"花艺图片\">花艺</a> <a href=\"/tupian/meigui_t267/\"  title=\"玫瑰图片\">玫瑰</a> <a href=\"/tupian/yujinxiang_t77/\"  title=\"郁金香图片\">郁金香</a> <a href=\"/tupian/kangnaixin_t59/\"  title=\"康乃馨图片\">康乃馨</a> <a href=\"/tupian/shuixianhua_t11840/\"  title=\"水仙花图片\">水仙花</a> <a href=\"/tupian/xiangrikui_t139/\"  title=\"向日葵图片\">向日葵</a> <a href=\"/tupian/hehua_t860/\"  title=\"荷花图片_荷花图片大全\">荷花</a> <a href=\"/tupian/lianhua_t935/\"  title=\"莲花图片\">莲花</a> <a href=\"/tupian/juhua_t18/\"  title=\"菊花图片_菊花图片大全\">菊花</a> <a href=\"/tupian/yinghua_t838/\"  title=\"樱花图片\">樱花</a> <a href=\"/tupian/baihehua_t8597/\"  title=\"百合花图片\">百合花</a> <a href=\"/tupian/pugongying_t1170/\"  title=\"蒲公英图片\">蒲公英</a> <a href=\"/tupian/meihua_t839/\"  title=\"梅花图片_梅花图片大全\">梅花</a> <a href=\"/tupian/hudielan_t8600/\"  title=\"蝴蝶兰图片\">蝴蝶兰</a> <a href=\"/tupian/xingyuncao_t19471/\"  title=\"幸运草图片\">幸运草</a> <a href=\"/tupian/huahuacaocao_t19472/\"  title=\"花花草草图片\">花花草草</a> <a href=\"/tupian/guanmu_t19473/\"  title=\"灌木图片\">灌木</a> <a href=\"/tupian/shumu_t868/\"  title=\"树木图片\">树木</a> <a href=\"/tupian/shuye_t1076/\"  title=\"树叶图片\">树叶</a> <a href=\"/tupian/songshu_t5313/\"  title=\"松树图片\">松树</a> <a href=\"/tupian/shupi_t2710/\"  title=\"树皮图片\">树皮</a> <a href=\"/tupian/shuzhi_t8582/\"  title=\"树枝图片\">树枝</a> <a href=\"/tupian/shugan_t3061/\"  title=\"树干图片\">树干</a> <a href=\"/tupian/fengye_t1075/\"  title=\"枫叶图片\">枫叶</a> <a href=\"/tupian/yeshu_t118/\"  title=\"椰树图片\">椰树</a> <a href=\"/tupian/guoshu_t3917/\"  title=\"果树图片\">果树</a> <a href=\"/tupian/nongzuowu_t19475/\"  title=\"农作物图片\">农作物</a> <a href=\"/tupian/zhulin_t993/\"  title=\"竹林图片\">竹林</a> <a href=\"/tupian/zhuzi_t995/\"  title=\"竹子图片\">竹子</a> <a href=\"/tupian/qitazhongleidezhiwu_t19476/\"  title=\"其他种类的植物图片\">其他种类的植物</a> <a href=\"/tupian/weimeizhiwu_t19696/\"  title=\"唯美植物图片\">唯美植物</a> <div class=\"s_xg\"><h1>植物素材图片大全</h1> <a href=\"/tupian/yezi_t1077/', 'value': '叶子图片\">叶子</a> <a href=\"/tupian/lvye_t28/'}, {'key': '/tupian/shuye_t1076/', 'value': '树叶图片\">树叶</a> <a href=\"/tupian/qiuji_t3374/'}, {'key': '/tupian/fengye_t1075/', 'value': '枫叶图片\">枫叶</a> <a href=\"/tupian/luoye_t3375/'}, {'key': '/tupian/fengye_v37808/pic_613663.html', 'value': '枫叶透明背景PNG图片 3696x2316'}, {'key': '/tupian/fengye_v37808/pic_613663.html', 'value': '枫叶透明背景PNG图片'}, {'key': '/tupian/fengye_v37808/pic_613664.html', 'value': '枫叶透明背景PNG图片 2778x2174'}, {'key': '/tupian/fengye_v37808/pic_613664.html', 'value': '枫叶透明背景PNG图片'}, {'key': '/tupian/fengye_v37808/pic_613665.html', 'value': '枫叶透明背景PNG图片 3625x1843'}, {'key': '/tupian/fengye_v37808/pic_613665.html', 'value': '枫叶透明背景PNG图片'}, {'key': '/tupian/fengye_v37808/pic_613666.html', 'value': '枫叶透明背景PNG图片 2800x2037'}, {'key': '/tupian/fengye_v37808/pic_613666.html', 'value': '枫叶透明背景PNG图片'}, {'key': '/tupian/fengye_v37808/pic_613667.html', 'value': '枫叶透明背景PNG图片 2690x1990'}, {'key': '/tupian/fengye_v37808/pic_613667.html', 'value': '枫叶透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613702.html', 'value': '叶子透明背景PNG图片 2686x2818'}, {'key': '/tupian/yezi_v37811/pic_613702.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613703.html', 'value': '叶子透明背景PNG图片 2565x2574'}, {'key': '/tupian/yezi_v37811/pic_613703.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613704.html', 'value': '叶子透明背景PNG图片 2800x1895'}, {'key': '/tupian/yezi_v37811/pic_613704.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613705.html', 'value': '叶子透明背景PNG图片 2600x1922'}, {'key': '/tupian/yezi_v37811/pic_613705.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613706.html', 'value': '叶子透明背景PNG图片 3331x2587'}, {'key': '/tupian/yezi_v37811/pic_613706.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613707.html', 'value': '叶子透明背景PNG图片 1591x2624'}, {'key': '/tupian/yezi_v37811/pic_613707.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613708.html', 'value': '叶子透明背景PNG图片 3528x2225'}, {'key': '/tupian/yezi_v37811/pic_613708.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613709.html', 'value': '叶子透明背景PNG图片 3160x2093'}, {'key': '/tupian/yezi_v37811/pic_613709.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613710.html', 'value': '叶子透明背景PNG图片 2800x2386'}, {'key': '/tupian/yezi_v37811/pic_613710.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613711.html', 'value': '叶子透明背景PNG图片 2800x2379'}, {'key': '/tupian/yezi_v37811/pic_613711.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613712.html', 'value': '叶子透明背景PNG图片 2752x2608'}, {'key': '/tupian/yezi_v37811/pic_613712.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613713.html', 'value': '叶子透明背景PNG图片 2107x1994'}, {'key': '/tupian/yezi_v37811/pic_613713.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613714.html', 'value': '叶子透明背景PNG图片 2663x2165'}, {'key': '/tupian/yezi_v37811/pic_613714.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613715.html', 'value': '叶子透明背景PNG图片 2749x2225'}, {'key': '/tupian/yezi_v37811/pic_613715.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/yezi_v37811/pic_613716.html', 'value': '叶子透明背景PNG图片 2565x2388'}, {'key': '/tupian/yezi_v37811/pic_613716.html', 'value': '叶子透明背景PNG图片'}, {'key': '/tupian/muqinjie_t61/', 'value': '母亲节图片\">母亲节图片</a><a href=\"/tupian/yingsuhua_t181/'}, {'key': '/tupian/lianhua_t935/', 'value': '莲花图片\">莲花图片</a><a href=\"/tupian/huaduo_t1182/'}, {'key': '/tupian/kangnaixin_t59/', 'value': '康乃馨图片\">康乃馨图片</a><a href=\"/tupian/sansejin_t22635/'}, {'key': '/tupian/xianhua_t60/', 'value': '鲜花图片_鲜花图片大全\">鲜花图片</a><a href=\"/tupian/dingxianghua_t28269/'}, {'key': '/tupian/yinghua_t838/', 'value': '樱花图片\">樱花图片</a><a href=\"/tupian/xiangrikui_t139/'}, {'key': '/tupian/mudanhua_t20874/', 'value': '牡丹花图片_牡丹花图片大全\">牡丹花图片</a><a href=\"/tupian/meiguihua_t1152/'}, {'key': '/tupian/taohua_t1434/', 'value': '桃花图片_桃花图片大全\">桃花图片</a><a href=\"/tupian/pugongying_t1170/'}, {'key': '/tupian/hehua_t860/', 'value': '荷花图片_荷花图片大全\">荷花图片</a><a href=\"/tupian/meihua_t839/'}, {'key': '/tupian/juhua_t18/', 'value': '菊花图片_菊花图片大全\">菊花图片</a><a href=\"/tupian/baihehua_t8597/'}, {'key': '/tupian/yujinxiang_t77/', 'value': '郁金香图片\">郁金香图片</a><a href=\"/tupian/yehua_t1506/'}, {'key': '/tupian/meigui_t267/', 'value': '玫瑰图片\">玫瑰图片</a><a href=\"/tupian/huahui_t12/'}, {'key': '/tupian/zhuzi_t995/', 'value': '竹子图片\">竹子图片</a><a href=\"/tupian/huaihua_t22806/'}, {'key': '/tupian/huashu_t2512/', 'value': '花束图片\">花束图片</a><a href=\"/tupian/chuju_t8599/'}, {'key': '/tupian/fengye_t1075/', 'value': '枫叶图片\">枫叶图片</a><a href=\"/tupian/zhulin_t993/'}, {'key': '/tupian/xinghua_t19767/', 'value': '杏花图片\">杏花图片</a><a href=\"/tupian/mumianhua_t20282/'}, {'key': '/tupian/huaduo_t1182/', 'value': '花朵图片大全\">花朵图片</a><a href=\"/tupian/huahui_t12/'}, {'key': '/tupian/xianhua_t60/', 'value': '鲜花图片大全\">鲜花图片</a><a href=\"/tupian/juhua_t18/'}, {'key': '/tupian/hehua_t860/', 'value': '荷花图片大全\">荷花图片</a><a href=\"/tupian/taohua_t1434/'}, {'key': '/tupian/meiguihua_t1152/', 'value': '玫瑰花图片大全\">玫瑰花图片</a><a href=\"/tupian/meihua_t839/'}, {'key': '/tupian/mudanhua_t20874/', 'value': '牡丹花图片大全\">牡丹花图片</a><a href=\"/tupian/shuiguo_sucai_t36134/'}, {'key': '/tupian/junlei_sucai_t36135/', 'value': '菌类素材图片大全\">菌类素材图片</a><a href=\"/tupian/zhiwu_sucai_t36136/'}, {'key': '/tupian/songya_t36137/', 'value': '松鸦图片大全\">松鸦图片</a><a href=\"/tupian/zhongxingniao_t36138/'}, {'key': '/tupian/baihua_lancuiniao_t36139/', 'value': '白化蓝翠鸟图片大全\">白化蓝翠鸟图片</a><div><b>手机版：</b><a href=\"https://m.ivsky.com/tupian/zhiwu_sucai_t36136/'}]";
        JSONArray plantArray = JSONArray.parseArray(plantArrayStr);
        JSONArray filterPlantArray = plantArray.stream().filter(e -> StringUtils.endsWith(((JSONObject) e).getString("key"), ".html")).collect(Collectors.toCollection(JSONArray::new));
//        filterPlantArray.forEach(e -> {
//            JSONObject jsonObject = (JSONObject) e;
//            System.out.println(jsonObject.getString("key") + ":" + jsonObject.getString("value"));
//        });
//        System.out.println("--------------");
        Map<String, String> plantMap = filterPlantArray.stream().collect(Collectors.toMap(e -> ((JSONObject) e).getString("key"), k -> ((JSONObject) k).getString("value"), (e1, e2) -> e2));
        plantMap.forEach((key,value) -> {
            System.out.println("https://www.ivsky.com" + key +":" + value);
        });

    }

    @Test
    public void testFilterCarInfo() {
        List<String> imagesUrl = new ArrayList<>();
        String carArrayStr = "[{'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-001.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-002.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-003.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-004.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-005.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/t/201506/22/sportsca-006.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201508/24/aventador_lp700_4-002.jpg', 'title': '兰博基尼Aventador LP700-4图片'}, {'image': '//img.ivsky.com/img/tupian/m/201609/14/bmw-004.png', 'title': '宝马透明背景PNG图片'}, {'image': '//img.ivsky.com/img/tupian/m/201609/14/qiche_biaozhi-012.png', 'title': '知名品牌汽车标志透明背景PNG图片'}, {'image': '//img.ivsky.com/img/tupian/m/201609/14/qiche_dianping-001.png', 'title': '汽车电瓶透明背景PNG图片'}, {'image': '//img.ivsky.com/img/tupian/m/201506/30/reventon-006.jpg', 'title': '兰博基尼跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201506/22/sportsca-005.jpg', 'title': '跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201505/25/maikelalun_chaoji_paoche-001.jpg', 'title': '麦克拉伦超级跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201505/27/baoshijie_918_saidao-005.jpg', 'title': '保时捷918赛道图片'}, {'image': '//img.ivsky.com/img/tupian/m/201506/18/falali_paoche-001.jpg', 'title': '法拉利跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201506/18/ferrari-006.jpg', 'title': '法拉利Ferrari跑车图片'}, {'image': '//img.ivsky.com/img/tupian/m/201612/27/shishang_de_qichedeng-001.jpg', 'title': '时尚的汽车灯图片'}, {'image': '//img.ivsky.com/img/tupian/m/201803/31/bmw_i8-010.jpg', 'title': '宝马i8的图片'}, {'image': '//img.ivsky.com/img/tupian/m/201007/31/nissan-004.jpg', 'title': '跑车图片'}]\n";
        JSONArray plantArray = JSONArray.parseArray(carArrayStr);
        plantArray.forEach(e -> {
            JSONObject carJsonObject = (JSONObject) e;
            String image = carJsonObject.getString("image");
            System.out.print("https:" + image+",");
            imagesUrl.add("https:" + image);
        });
//        System.out.println(imagesUrl.toString());
    }


}
