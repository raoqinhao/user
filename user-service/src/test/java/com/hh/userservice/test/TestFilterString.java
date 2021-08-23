package com.hh.userservice.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;
import org.assertj.core.internal.Bytes;
import org.junit.Test;
import org.thymeleaf.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public void testCompanyString() {
        String aliasCompany = "来福士广场,"+
                "虹桥南丰城,"+
                "上海世界贸易商城,"+
                "缤谷广场,"+
                "上海多媒体广场,"+
                "凯德龙之梦购物中心,"+
                "合生汇,"+
                "嘉亭荟城市生活广场,"+
                "嘉定宝龙广场,"+
                "嘉定大融城,"+
                "江桥万达广场,"+
                "环贸广场,"+
                "光启城,"+
                "上海美罗文化娱乐有限公司,"+
                "绿地缤纷城,"+
                "古北财富中心(高岛屋),"+
                "南翔印象城,"+
                "嘉定日月光中心,"+
                "凯德七宝购物广场,"+
                "七宝宝龙广场,"+
                "上海唐镇阳光天地,"+
                "上海百联南桥购物中心有限公司,"+
                "龙湖天街购物中心,"+
                "青浦绿地缤纷城,"+
                "上海百联川沙购物中心有限公司,"+
                "上海恒生万鹂广场,"+
                "永业购物中心,"+
                "临港宝龙广场,"+
                "上海红星美凯龙楷恒家居有限公司,"+
                "三林印象城,"+
                "永乐广场,"+
                "青浦宝龙广场（二期）,"+
                "崇明万达广场,"+
                "白玉兰广场,"+
                "凯德虹口龙之梦,"+
                "百联曲阳购物中心,"+
                "上海环球港,"+
                "虹桥古玩城,"+
                "亿亿佰广场,"+
                "上海证大喜玛拉雅中心,"+
                "长风大悦城,"+
                "百联中环购物广场,"+
                "浦东嘉里城大厦,"+
                "星荟中心,"+
                "夏都小镇,"+
                "禹洲商业广场,"+
                "汇智商业广场,"+
                "长泰国际广场,"+
                "LCM置汇旭辉广场,"+
                "青浦万达茂,"+
                "新田360广场,"+
                "保利悦活城,"+
                "第一八佰伴,"+
                "上海百联世纪购物中心,"+
                "森兰花园城,"+
                "世纪汇,"+
                "日月光中心广场,"+
                "森宏购物广场,"+
                "凯德晶萃,"+
                "森兰商都,"+
                "金谊广场,"+
                "爱琴海,"+
                "上海元祖梦世界中心,"+
                "红太阳广场,"+
                "上海宝杨宝龙广场,"+
                "宝乐汇生活时尚中心,"+
                "上海国金中心,"+
                "金桥国际商业广场,"+
                "上海金虹桥商业广场,"+
                "百联滨江,"+
                "红星美凯龙,"+
                "上海北上海生活广场,"+
                "虹桥天地,"+
                "绿地全球商品贸易港,"+
                "百联又一城,"+
                "虎城嘉年华,"+
                "宝山花园城,"+
                "中原城市广场,"+
                "七宝万科广场,"+
                "万达广场（上海颛桥店）,"+
                "上坤上街,"+
                "经纬汇,"+
                "龙湖北城天街,"+
                "亿丰时代广场,"+
                "周浦万达广场,"+
                "沪客隆商场,"+
                "周浦绿地缤纷广场,"+
                "保利悦活荟,"+
                "上海百联金山购物中心有限公司,"+
                "上海正大乐城百货有限公司,"+
                "华润万家,"+
                "金茂大厦,"+
                "万象城,"+
                "鹿都国际商业广场,"+
                "上海环球金融中心,"+
                "尚悦中心,"+
                "上海世博百联商业有限公司,"+
                "金地广场,"+
                "松江万达商业广场,"+
                "飞航广场,"+
                "九亭.U天地,"+
                "东鼎购物中心,"+
                "开元地中海商业广场,"+
                "第一百货商业中心,"+
                "世茂国际广场,"+
                "新理想广场,"+
                "亚繁亚乐城,"+
                "徐汇日月光中心,"+
                "上海国际珠宝城,"+
                "南方购物中心,"+
                "万达广场（上海马桥店）,"+
                "中庚漫游城,"+
                "浦江生活广场,"+
                "置业广场,"+
                "新华联购物中心,"+
                "万达广场（上海浦江店）,"+
                "金山万达广场,"+
                "龙之梦购物中心（莘庄店）,"+
                "龙盛国际商业广场,"+
                "莘庄维璟印象城,"+
                "仲盛世界商场,"+
                "易家中心,"+
                "万达广场,"+
                "东鼎大厦,"+
                "博隆（虹桥）商业广场,"+
                "合生汇,"+
                "上海悠方,"+
                "星宝购物广场,"+
                "上海新世界大丸百货,"+
                "新世界城,"+
                "青浦吾悦广场,"+
                "复地活力城,"+
                "乐购（惠南店）,"+
                "上海南站汇金百货有限公司,"+
                "十六铺综合项目,"+
                "正大广场,"+
                "梅赛德斯奔驰文化中心,"+
                "红星美凯龙家居博览中心,"+
                "龙之梦购物中心,"+
                "文峰商业广场,"+
                "上海证大外滩国际金融服务中心置业有限公司（BFC）,"+
                "上海光大会展中心有限公司,"+
                "上海港汇房地产开发有限公司,"+
                "汇宝购物中心,"+
                "龙湖闵行天街,"+
                "晶耀前滩,"+
                "中冶祥腾,"+
                "罗宾森广场,"+
                "百联嘉定购物中心,"+
                "中信泰富万达广场,"+
                "信业购物中心,"+
                "上海百联西郊购物中心,"+
                "宝山万达广场,"+
                "陆家嘴中心,"+
                "长江国际生活广场,"+
                "国家会展中心（上海）,"+
                "东方懿德城,"+
                "上海中心大厦,"+
                "悦达889广场,"+
                "久光百货,"+
                "晶品购物中心,"+
                "嘉地中心大厦,"+
                "静安大融城商业1号楼,"+
                "静安体育中心,"+
                "协信星光广场,"+
                "大宁国际商业广场,"+
                "梅龙镇广场（伊势丹）,"+
                "上海嘉里中心,"+
                "上海静安大悦城,"+
                "嘉里企业广场（一、二、三期）,"+
                "上海商城,"+
                "兴业太古汇商场,"+
                "上海恒隆广场,"+
                "大宁音乐广场-A座,"+
                "静安国际中心";

        String excelCompany = "上海国金中心,"+
                "禹洲商业广场,"+
                "乐购（惠南店）,"+
                "红星美凯龙家居博览中心,"+
                "文峰商业广场,"+
                "梅赛德斯奔驰文化中心,"+
                "上海世博百联商业有限公司,"+
                "晶耀前滩,"+
                "上海百联川沙购物中心有限公司,"+
                "汇智商业广场,"+
                "长泰国际广场,"+
                "上海唐镇阳光天地,"+
                "上海恒生万鹂广场,"+
                "森兰商都,"+
                "森兰花园城,"+
                "临港宝龙广场,"+
                "周浦万达广场,"+
                "周浦绿地缤纷广场,"+
                "亿丰时代广场,"+
                "森宏购物广场,"+
                "三林印象城,"+
                "金谊广场,"+
                "东方懿德城,"+
                "复地活力城,"+
                "永乐广场,"+
                "上海百联世纪购物中心,"+
                "世纪汇,"+
                "尚悦中心,"+
                "正大广场,"+
                "第一八佰伴,"+
                "金茂大厦,"+
                "陆家嘴中心,"+
                "上海环球金融中心,"+
                "金桥国际商业广场,"+
                "LCM置汇旭辉广场,"+
                "上海证大喜玛拉雅中心,"+
                "浦东嘉里城大厦,"+
                "第一百货商业中心,"+
                "世茂国际广场,"+
                "新世界城,"+
                "上海新世界大丸百货,"+
                "日月光中心广场,"+
                "凯德晶萃,"+
                "上海证大外滩国际金融服务中心置业有限公司（BFC）,"+
                "十六铺综合项目,"+
                "上海正大乐城百货有限公司,"+
                "上海南站汇金百货有限公司,"+
                "上海光大会展中心有限公司,"+
                "上海美罗文化娱乐有限公司,"+
                "上海港汇房地产开发有限公司,"+
                "环贸广场,"+
                "徐汇日月光中心,"+
                "光启城,"+
                "绿地缤纷城,"+
                "上海百联西郊购物中心,"+
                "缤谷广场,"+
                "上海金虹桥商业广场,"+
                "龙之梦购物中心,"+
                "上海多媒体广场,"+
                "虹桥南丰城,"+
                "来福士广场,"+
                "上海世界贸易商城,"+
                "古北财富中心(高岛屋),"+
                "上海静安大悦城,"+
                "悦达889广场,"+
                "大宁国际商业广场,"+
                "协信星光广场,"+
                "静安体育中心,"+
                "久光百货,"+
                "晶品购物中心,"+
                "兴业太古汇商场,"+
                "上海商城,"+
                "上海嘉里中心,"+
                "上海恒隆广场,"+
                "静安大融城商业1号楼,"+
                "大宁音乐广场-A座,"+
                "梅龙镇广场（伊势丹）,"+
                "嘉地中心大厦,"+
                "嘉里企业广场（一、二、三期）,"+
                "静安国际中心,"+
                "长风大悦城,"+
                "亿亿佰广场,"+
                "百联中环购物广场,"+
                "上海环球港,"+
                "白玉兰广场,"+
                "星荟中心,"+
                "凯德虹口龙之梦,"+
                "百联曲阳购物中心,"+
                "合生汇,"+
                "万达广场,"+
                "百联又一城,"+
                "百联滨江,"+
                "中原城市广场,"+
                "上海悠方,"+
                "汇宝购物中心,"+
                "莘庄维璟印象城,"+
                "仲盛世界商场,"+
                "龙之梦购物中心（莘庄店）,"+
                "七宝万科广场,"+
                "凯德七宝购物广场,"+
                "七宝宝龙广场,"+
                "新华联购物中心,"+
                "虹桥天地,"+
                "龙湖天街购物中心,"+
                "爱琴海,"+
                "万象城,"+
                "南方购物中心,"+
                "浦江生活广场,"+
                "新田360广场,"+
                "万达广场（上海颛桥店）,"+
                "星宝购物广场,"+
                "置业广场,"+
                "龙盛国际商业广场,"+
                "龙湖闵行天街,"+
                "虹桥古玩城,"+
                "上海国际珠宝城,"+
                "万达广场（上海浦江店）,"+
                "中庚漫游城,"+
                "万达广场（上海马桥店）,"+
                "上坤上街,"+
                "红太阳广场,"+
                "宝山花园城,"+
                "上海北上海生活广场,"+
                "保利悦活荟,"+
                "长江国际生活广场,"+
                "宝山万达广场,"+
                "宝乐汇生活时尚中心,"+
                "上海宝杨宝龙广场,"+
                "沪客隆商场,"+
                "经纬汇,"+
                "虎城嘉年华,"+
                "华润万家,"+
                "龙湖北城天街,"+
                "红星美凯龙,"+
                "嘉定大融城,"+
                "保利悦活城,"+
                "中信泰富万达广场,"+
                "嘉定宝龙广场,"+
                "嘉定日月光中心,"+
                "江桥万达广场,"+
                "百联嘉定购物中心,"+
                "罗宾森广场,"+
                "嘉亭荟城市生活广场,"+
                "南翔印象城,"+
                "中冶祥腾,"+
                "信业购物中心,"+
                "鹿都国际商业广场,"+
                "飞航广场,"+
                "新理想广场,"+
                "亚繁亚乐城,"+
                "金地广场,"+
                "九亭.U天地,"+
                "松江万达商业广场,"+
                "东鼎购物中心,"+
                "东鼎大厦,"+
                "开元地中海商业广场,"+
                "易家中心,"+
                "上海百联金山购物中心有限公司,"+
                "金山万达广场,"+
                "上海红星美凯龙楷恒家居有限公司,"+
                "上海百联南桥购物中心有限公司,"+
                "青浦宝龙广场（二期）,"+
                "上海元祖梦世界中心,"+
                "永业购物中心,"+
                "绿地全球商品贸易港,"+
                "夏都小镇,"+
                "博隆（虹桥）商业广场,"+
                "青浦绿地缤纷城,"+
                "青浦万达茂,"+
                "青浦吾悦广场,"+
                "崇明万达广场,"+
                "上海中心大厦,"+
                "国家会展中心（上海）";

        String[] aliasSplitCompanyArray = aliasCompany.split(",");
        String[] excelSplitCompanyArray = excelCompany.split(",");
        Set<String> aliasHashSet = new HashSet<>();


        List<String> aliasCompanyList = new ArrayList<>();
        List<String> excelCompanyList = new ArrayList<>();
        for (int i = 0; i < aliasSplitCompanyArray.length; i++) {
            aliasCompanyList.add(aliasSplitCompanyArray[i]);
            aliasHashSet.add(aliasSplitCompanyArray[i]);
        }
        for (int i = 0; i < excelSplitCompanyArray.length; i++) {
            excelCompanyList.add(excelSplitCompanyArray[i]);
        }
//        aliasCompanyList.removeAll(excelCompanyList);
//        aliasCompanyList.forEach(e -> System.out.print(e + ","));
        System.out.println("-------------");
        Map<String,Integer> map = new HashMap<>();
        for(String str:aliasCompanyList){
            Integer i = 1; //定义一个计数器，用来记录重复数据的个数
            if(map.get(str) != null){
                i=map.get(str)+1;
            }
            map.put(str,i);
        }
        System.out.println("重复数据的个数："+map.toString());


        System.out.print("重复的数据为：");
        for(String s:map.keySet()){
            if(map.get(s) > 1){
                System.out.print(s+" ");
            }
        }
        System.out.println("--------------");
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < aliasCompanyList.size(); i++) {
            int x = 0;
            if (hashMap.get(aliasCompanyList.get(i)) != null) {
                x = hashMap.get(aliasCompanyList.get(i)) + 1;
            }
            hashMap.put(aliasCompanyList.get(i), x);
        }
        hashMap.forEach((key,value) -> System.out.println(key + " " + value));
        // 静安大融城商业2号楼,静安大融城商业3号楼,静安大融城商业4号楼,静安大融城商业5号楼,大宁音乐广场-B座,大宁音乐广场-C座,大宁音乐广场-D座,大宁音乐广场-E座,大宁音乐广场-F座,大宁音乐广场-G座,大宁音乐广场-I座,大宁音乐广场-J座,大宁音乐广场-H座,浦东机场,虹桥机场,上海站,上海南站,虹桥火车站
    }




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

    @Test
    public void testCode() {
        String codes = "25,"+
                "30,"+
                "31,"+
                "32,"+
                "33,"+
                "34,"+
                "35,"+
                "36,"+
                "37,"+
                "40,"+
                "41,"+
                "42,"+
                "43,"+
                "44,"+
                "50,"+
                "51,"+
                "52,"+
                "53,"+
                "61,"+
                "62,"+
                "69,"+
                "74,"+
                "78,"+
                "79,"+
                "10,"+
                "11,"+
                "12,"+
                "13,"+
                "16,"+
                "17,"+
                "18,"+
                "23,"+
                "1,"+
                "1,"+
                "1,"+
                "16,"+
                "17,"+
                "18";



        List arr = new ArrayList(){};

    }


    @Test
    public void dealWithLOLData() {
        String path = "http://ossweb-img.qq.com/images/lol/web201310/skin/big266000.jpg";

        String names = "Jax,Sona,Tristana,Yuumi,Varus,Kaisa,Fiora,Singed,TahmKench,Leblanc,Thresh,Karma,Jhin,Rumble,Udyr,LeeSin,Yorick,Ornn,Kayn,Neeko,Kassadin,Sivir,MissFortune,Senna,Draven,Yasuo,Kayle,Shaco,Renekton,Hecarim,Fizz,KogMaw,Maokai,Lissandra,Jinx,Urgot,Fiddlesticks,Galio,Pantheon,Talon,Gangplank,Sett,Ezreal,Gnar,Teemo,Annie,Mordekaiser,Azir,Kennen,Riven,Chogath,Aatrox,Poppy,Taliyah,Illaoi,Pyke,Heimerdinger,Alistar,XinZhao,Lucian,Volibear,Sejuani,Nidalee,Garen,Leona,Zed,Blitzcrank,Rammus,Velkoz,Caitlyn,Trundle,Kindred,Quinn,Ekko,Nami,Swain,Aphelios,Sylas,Taric,Syndra,Rakan,Skarner,Braum,Veigar,Xerath,Corki,Nautilus,Ahri,Jayce,Darius,Tryndamere,Janna,Elise,Vayne,Brand,Zoe,Graves,Soraka,Xayah,Karthus,Vladimir,Zilean,Katarina,Shyvana,Warwick,Ziggs,Kled,Khazix,Olaf,TwistedFate,Nunu,Qiyana,Rengar,Bard,Irelia,Ivern,MonkeyKing,Ashe,Kalista,Akali,Vi,Amumu,Lulu,Morgana,Nocturne,Diana,AurelionSol,Zyra,Viktor,Cassiopeia,Nasus,Twitch,DrMundo,Orianna,Evelynn,RekSai,Lux,Sion,Camille,MasterYi,Ryze,Malphite,Anivia,Shen,JarvanIV,Malzahar,Zac,Gragas";

        String dataString = "{\"keys\":{\"266\":\"Aatrox\",\"103\":\"Ahri\",\"84\":\"Akali\",\"12\":\"Alistar\",\"32\":\"Amumu\",\"34\":\"Anivia\",\"1\":\"Annie\",\"523\":\"Aphelios\",\"22\":\"Ashe\",\"136\":\"AurelionSol\",\"268\":\"Azir\",\"432\":\"Bard\",\"53\":\"Blitzcrank\",\"63\":\"Brand\",\"201\":\"Braum\",\"51\":\"Caitlyn\",\"164\":\"Camille\",\"69\":\"Cassiopeia\",\"31\":\"Chogath\",\"42\":\"Corki\",\"122\":\"Darius\",\"131\":\"Diana\",\"119\":\"Draven\",\"36\":\"DrMundo\",\"245\":\"Ekko\",\"60\":\"Elise\",\"28\":\"Evelynn\",\"81\":\"Ezreal\",\"9\":\"Fiddlesticks\",\"114\":\"Fiora\",\"105\":\"Fizz\",\"3\":\"Galio\",\"41\":\"Gangplank\",\"86\":\"Garen\",\"150\":\"Gnar\",\"79\":\"Gragas\",\"104\":\"Graves\",\"120\":\"Hecarim\",\"74\":\"Heimerdinger\",\"420\":\"Illaoi\",\"39\":\"Irelia\",\"427\":\"Ivern\",\"40\":\"Janna\",\"59\":\"JarvanIV\",\"24\":\"Jax\",\"126\":\"Jayce\",\"202\":\"Jhin\",\"222\":\"Jinx\",\"145\":\"Kaisa\",\"429\":\"Kalista\",\"43\":\"Karma\",\"30\":\"Karthus\",\"38\":\"Kassadin\",\"55\":\"Katarina\",\"10\":\"Kayle\",\"141\":\"Kayn\",\"85\":\"Kennen\",\"121\":\"Khazix\",\"203\":\"Kindred\",\"240\":\"Kled\",\"96\":\"KogMaw\",\"7\":\"Leblanc\",\"64\":\"LeeSin\",\"89\":\"Leona\",\"127\":\"Lissandra\",\"236\":\"Lucian\",\"117\":\"Lulu\",\"99\":\"Lux\",\"54\":\"Malphite\",\"90\":\"Malzahar\",\"57\":\"Maokai\",\"11\":\"MasterYi\",\"21\":\"MissFortune\",\"62\":\"MonkeyKing\",\"82\":\"Mordekaiser\",\"25\":\"Morgana\",\"267\":\"Nami\",\"75\":\"Nasus\",\"111\":\"Nautilus\",\"518\":\"Neeko\",\"76\":\"Nidalee\",\"56\":\"Nocturne\",\"20\":\"Nunu\",\"2\":\"Olaf\",\"61\":\"Orianna\",\"516\":\"Ornn\",\"80\":\"Pantheon\",\"78\":\"Poppy\",\"555\":\"Pyke\",\"246\":\"Qiyana\",\"133\":\"Quinn\",\"497\":\"Rakan\",\"33\":\"Rammus\",\"421\":\"RekSai\",\"58\":\"Renekton\",\"107\":\"Rengar\",\"92\":\"Riven\",\"68\":\"Rumble\",\"13\":\"Ryze\",\"113\":\"Sejuani\",\"235\":\"Senna\",\"875\":\"Sett\",\"35\":\"Shaco\",\"98\":\"Shen\",\"102\":\"Shyvana\",\"27\":\"Singed\",\"14\":\"Sion\",\"15\":\"Sivir\",\"72\":\"Skarner\",\"37\":\"Sona\",\"16\":\"Soraka\",\"50\":\"Swain\",\"517\":\"Sylas\",\"134\":\"Syndra\",\"223\":\"TahmKench\",\"163\":\"Taliyah\",\"91\":\"Talon\",\"44\":\"Taric\",\"17\":\"Teemo\",\"412\":\"Thresh\",\"18\":\"Tristana\",\"48\":\"Trundle\",\"23\":\"Tryndamere\",\"4\":\"TwistedFate\",\"29\":\"Twitch\",\"77\":\"Udyr\",\"6\":\"Urgot\",\"110\":\"Varus\",\"67\":\"Vayne\",\"45\":\"Veigar\",\"161\":\"Velkoz\",\"254\":\"Vi\",\"112\":\"Viktor\",\"8\":\"Vladimir\",\"106\":\"Volibear\",\"19\":\"Warwick\",\"498\":\"Xayah\",\"101\":\"Xerath\",\"5\":\"XinZhao\",\"157\":\"Yasuo\",\"83\":\"Yorick\",\"350\":\"Yuumi\",\"154\":\"Zac\",\"238\":\"Zed\",\"115\":\"Ziggs\",\"26\":\"Zilean\",\"142\":\"Zoe\",\"143\":\"Zyra\"},\"data\":{\"Aatrox\":{\"id\":\"Aatrox\",\"key\":\"266\",\"name\":\"\\u6697\\u88d4\\u5251\\u9b54\",\"title\":\"\\u4e9a\\u6258\\u514b\\u65af\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Aatrox.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":0,\"y\":0,\"w\":48,\"h\":48}},\"Ahri\":{\"id\":\"Ahri\",\"key\":\"103\",\"name\":\"\\u4e5d\\u5c3e\\u5996\\u72d0\",\"title\":\"\\u963f\\u72f8\",\"tags\":[\"Mage\",\"Assassin\"],\"image\":{\"full\":\"Ahri.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":48,\"y\":0,\"w\":48,\"h\":48}},\"Akali\":{\"id\":\"Akali\",\"key\":\"84\",\"name\":\"\\u79bb\\u7fa4\\u4e4b\\u523a\",\"title\":\"\\u963f\\u5361\\u4e3d\",\"tags\":[\"Assassin\"],\"image\":{\"full\":\"Akali.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":96,\"y\":0,\"w\":48,\"h\":48}},\"Alistar\":{\"id\":\"Alistar\",\"key\":\"12\",\"name\":\"\\u725b\\u5934\\u914b\\u957f\",\"title\":\"\\u963f\\u5229\\u65af\\u5854\",\"tags\":[\"Tank\",\"Support\"],\"image\":{\"full\":\"Alistar.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":144,\"y\":0,\"w\":48,\"h\":48}},\"Amumu\":{\"id\":\"Amumu\",\"key\":\"32\",\"name\":\"\\u6b87\\u4e4b\\u6728\\u4e43\\u4f0a\",\"title\":\"\\u963f\\u6728\\u6728\",\"tags\":[\"Tank\",\"Mage\"],\"image\":{\"full\":\"Amumu.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":192,\"y\":0,\"w\":48,\"h\":48}},\"Anivia\":{\"id\":\"Anivia\",\"key\":\"34\",\"name\":\"\\u51b0\\u6676\\u51e4\\u51f0\",\"title\":\"\\u827e\\u5c3c\\u7ef4\\u4e9a\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Anivia.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":240,\"y\":0,\"w\":48,\"h\":48}},\"Annie\":{\"id\":\"Annie\",\"key\":\"1\",\"name\":\"\\u9ed1\\u6697\\u4e4b\\u5973\",\"title\":\"\\u5b89\\u59ae\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Annie.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":288,\"y\":0,\"w\":48,\"h\":48}},\"Aphelios\":{\"id\":\"Aphelios\",\"key\":\"523\",\"name\":\"\\u6b8b\\u6708\\u4e4b\\u8083\",\"title\":\"\\u5384\\u6590\\u7409\\u65af\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Aphelios.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":336,\"y\":0,\"w\":48,\"h\":48}},\"Ashe\":{\"id\":\"Ashe\",\"key\":\"22\",\"name\":\"\\u5bd2\\u51b0\\u5c04\\u624b\",\"title\":\"\\u827e\\u5e0c\",\"tags\":[\"Marksman\",\"Support\"],\"image\":{\"full\":\"Ashe.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":384,\"y\":0,\"w\":48,\"h\":48}},\"AurelionSol\":{\"id\":\"AurelionSol\",\"key\":\"136\",\"name\":\"\\u94f8\\u661f\\u9f99\\u738b\",\"title\":\"\\u5965\\u745e\\u5229\\u5b89\\u00b7\\u7d22\\u5c14\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"AurelionSol.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":432,\"y\":0,\"w\":48,\"h\":48}},\"Azir\":{\"id\":\"Azir\",\"key\":\"268\",\"name\":\"\\u6c99\\u6f20\\u7687\\u5e1d\",\"title\":\"\\u963f\\u5179\\u5c14\",\"tags\":[\"Mage\",\"Marksman\"],\"image\":{\"full\":\"Azir.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":0,\"y\":48,\"w\":48,\"h\":48}},\"Bard\":{\"id\":\"Bard\",\"key\":\"432\",\"name\":\"\\u661f\\u754c\\u6e38\\u795e\",\"title\":\"\\u5df4\\u5fb7\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Bard.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":48,\"y\":48,\"w\":48,\"h\":48}},\"Blitzcrank\":{\"id\":\"Blitzcrank\",\"key\":\"53\",\"name\":\"\\u84b8\\u6c7d\\u673a\\u5668\\u4eba\",\"title\":\"\\u5e03\\u91cc\\u8328\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Blitzcrank.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":96,\"y\":48,\"w\":48,\"h\":48}},\"Brand\":{\"id\":\"Brand\",\"key\":\"63\",\"name\":\"\\u590d\\u4ec7\\u7130\\u9b42\",\"title\":\"\\u5e03\\u5170\\u5fb7\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Brand.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":144,\"y\":48,\"w\":48,\"h\":48}},\"Braum\":{\"id\":\"Braum\",\"key\":\"201\",\"name\":\"\\u5f17\\u96f7\\u5c14\\u5353\\u5fb7\\u4e4b\\u5fc3\",\"title\":\"\\u5e03\\u9686\",\"tags\":[\"Support\",\"Tank\"],\"image\":{\"full\":\"Braum.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":192,\"y\":48,\"w\":48,\"h\":48}},\"Caitlyn\":{\"id\":\"Caitlyn\",\"key\":\"51\",\"name\":\"\\u76ae\\u57ce\\u5973\\u8b66\",\"title\":\"\\u51ef\\u7279\\u7433\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Caitlyn.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":240,\"y\":48,\"w\":48,\"h\":48}},\"Camille\":{\"id\":\"Camille\",\"key\":\"164\",\"name\":\"\\u9752\\u94a2\\u5f71\",\"title\":\"\\u5361\\u871c\\u5c14\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Camille.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":288,\"y\":48,\"w\":48,\"h\":48}},\"Cassiopeia\":{\"id\":\"Cassiopeia\",\"key\":\"69\",\"name\":\"\\u9b54\\u86c7\\u4e4b\\u62e5\",\"title\":\"\\u5361\\u897f\\u5965\\u4f69\\u5a05\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Cassiopeia.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":336,\"y\":48,\"w\":48,\"h\":48}},\"Chogath\":{\"id\":\"Chogath\",\"key\":\"31\",\"name\":\"\\u865a\\u7a7a\\u6050\\u60e7\",\"title\":\"\\u79d1\\u52a0\\u65af\",\"tags\":[\"Tank\",\"Mage\"],\"image\":{\"full\":\"Chogath.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":384,\"y\":48,\"w\":48,\"h\":48}},\"Corki\":{\"id\":\"Corki\",\"key\":\"42\",\"name\":\"\\u82f1\\u52c7\\u6295\\u5f39\\u624b\",\"title\":\"\\u5e93\\u5947\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Corki.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":432,\"y\":48,\"w\":48,\"h\":48}},\"Darius\":{\"id\":\"Darius\",\"key\":\"122\",\"name\":\"\\u8bfa\\u514b\\u8428\\u65af\\u4e4b\\u624b\",\"title\":\"\\u5fb7\\u83b1\\u5384\\u65af\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Darius.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":0,\"y\":96,\"w\":48,\"h\":48}},\"Diana\":{\"id\":\"Diana\",\"key\":\"131\",\"name\":\"\\u768e\\u6708\\u5973\\u795e\",\"title\":\"\\u9edb\\u5b89\\u5a1c\",\"tags\":[\"Fighter\",\"Mage\"],\"image\":{\"full\":\"Diana.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":48,\"y\":96,\"w\":48,\"h\":48}},\"Draven\":{\"id\":\"Draven\",\"key\":\"119\",\"name\":\"\\u8363\\u8000\\u884c\\u5211\\u5b98\",\"title\":\"\\u5fb7\\u83b1\\u6587\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Draven.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":96,\"y\":96,\"w\":48,\"h\":48}},\"DrMundo\":{\"id\":\"DrMundo\",\"key\":\"36\",\"name\":\"\\u7956\\u5b89\\u72c2\\u4eba\",\"title\":\"\\u8499\\u591a\\u533b\\u751f\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"DrMundo.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":144,\"y\":96,\"w\":48,\"h\":48}},\"Ekko\":{\"id\":\"Ekko\",\"key\":\"245\",\"name\":\"\\u65f6\\u95f4\\u523a\\u5ba2\",\"title\":\"\\u827e\\u514b\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"Ekko.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":192,\"y\":96,\"w\":48,\"h\":48}},\"Elise\":{\"id\":\"Elise\",\"key\":\"60\",\"name\":\"\\u8718\\u86db\\u5973\\u7687\",\"title\":\"\\u4f0a\\u8389\\u4e1d\",\"tags\":[\"Mage\",\"Fighter\"],\"image\":{\"full\":\"Elise.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":240,\"y\":96,\"w\":48,\"h\":48}},\"Evelynn\":{\"id\":\"Evelynn\",\"key\":\"28\",\"name\":\"\\u75db\\u82e6\\u4e4b\\u62e5\",\"title\":\"\\u4f0a\\u8299\\u7433\",\"tags\":[\"Assassin\",\"Mage\"],\"image\":{\"full\":\"Evelynn.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":288,\"y\":96,\"w\":48,\"h\":48}},\"Ezreal\":{\"id\":\"Ezreal\",\"key\":\"81\",\"name\":\"\\u63a2\\u9669\\u5bb6\",\"title\":\"\\u4f0a\\u6cfd\\u745e\\u5c14\",\"tags\":[\"Marksman\",\"Mage\"],\"image\":{\"full\":\"Ezreal.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":336,\"y\":96,\"w\":48,\"h\":48}},\"Fiddlesticks\":{\"id\":\"Fiddlesticks\",\"key\":\"9\",\"name\":\"\\u672b\\u65e5\\u4f7f\\u8005\",\"title\":\"\\u8d39\\u5fb7\\u63d0\\u514b\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Fiddlesticks.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":384,\"y\":96,\"w\":48,\"h\":48}},\"Fiora\":{\"id\":\"Fiora\",\"key\":\"114\",\"name\":\"\\u65e0\\u53cc\\u5251\\u59ec\",\"title\":\"\\u83f2\\u5965\\u5a1c\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Fiora.png\",\"sprite\":\"champion0.png\",\"group\":\"champion\",\"x\":432,\"y\":96,\"w\":48,\"h\":48}},\"Fizz\":{\"id\":\"Fizz\",\"key\":\"105\",\"name\":\"\\u6f6e\\u6c50\\u6d77\\u7075\",\"title\":\"\\u83f2\\u5179\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"Fizz.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":0,\"y\":0,\"w\":48,\"h\":48}},\"Galio\":{\"id\":\"Galio\",\"key\":\"3\",\"name\":\"\\u6b63\\u4e49\\u5de8\\u50cf\",\"title\":\"\\u52a0\\u91cc\\u5965\",\"tags\":[\"Tank\",\"Mage\"],\"image\":{\"full\":\"Galio.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":48,\"y\":0,\"w\":48,\"h\":48}},\"Gangplank\":{\"id\":\"Gangplank\",\"key\":\"41\",\"name\":\"\\u6d77\\u6d0b\\u4e4b\\u707e\",\"title\":\"\\u666e\\u6717\\u514b\",\"tags\":[\"Fighter\"],\"image\":{\"full\":\"Gangplank.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":96,\"y\":0,\"w\":48,\"h\":48}},\"Garen\":{\"id\":\"Garen\",\"key\":\"86\",\"name\":\"\\u5fb7\\u739b\\u897f\\u4e9a\\u4e4b\\u529b\",\"title\":\"\\u76d6\\u4f26\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Garen.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":144,\"y\":0,\"w\":48,\"h\":48}},\"Gnar\":{\"id\":\"Gnar\",\"key\":\"150\",\"name\":\"\\u8ff7\\u5931\\u4e4b\\u7259\",\"title\":\"\\u7eb3\\u5c14\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Gnar.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":192,\"y\":0,\"w\":48,\"h\":48}},\"Gragas\":{\"id\":\"Gragas\",\"key\":\"79\",\"name\":\"\\u9152\\u6876\",\"title\":\"\\u53e4\\u62c9\\u52a0\\u65af\",\"tags\":[\"Fighter\",\"Mage\"],\"image\":{\"full\":\"Gragas.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":240,\"y\":0,\"w\":48,\"h\":48}},\"Graves\":{\"id\":\"Graves\",\"key\":\"104\",\"name\":\"\\u6cd5\\u5916\\u72c2\\u5f92\",\"title\":\"\\u683c\\u96f7\\u798f\\u65af\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Graves.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":288,\"y\":0,\"w\":48,\"h\":48}},\"Hecarim\":{\"id\":\"Hecarim\",\"key\":\"120\",\"name\":\"\\u6218\\u4e89\\u4e4b\\u5f71\",\"title\":\"\\u8d6b\\u5361\\u91cc\\u59c6\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Hecarim.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":336,\"y\":0,\"w\":48,\"h\":48}},\"Heimerdinger\":{\"id\":\"Heimerdinger\",\"key\":\"74\",\"name\":\"\\u5927\\u53d1\\u660e\\u5bb6\",\"title\":\"\\u9ed1\\u9ed8\\u4e01\\u683c\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Heimerdinger.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":384,\"y\":0,\"w\":48,\"h\":48}},\"Illaoi\":{\"id\":\"Illaoi\",\"key\":\"420\",\"name\":\"\\u6d77\\u517d\\u796d\\u53f8\",\"title\":\"\\u4fc4\\u6d1b\\u4f0a\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Illaoi.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":432,\"y\":0,\"w\":48,\"h\":48}},\"Irelia\":{\"id\":\"Irelia\",\"key\":\"39\",\"name\":\"\\u5200\\u950b\\u821e\\u8005\",\"title\":\"\\u827e\\u745e\\u8389\\u5a05\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Irelia.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":0,\"y\":48,\"w\":48,\"h\":48}},\"Ivern\":{\"id\":\"Ivern\",\"key\":\"427\",\"name\":\"\\u7fe0\\u795e\",\"title\":\"\\u827e\\u7fc1\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Ivern.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":48,\"y\":48,\"w\":48,\"h\":48}},\"Janna\":{\"id\":\"Janna\",\"key\":\"40\",\"name\":\"\\u98ce\\u66b4\\u4e4b\\u6012\",\"title\":\"\\u8fe6\\u5a1c\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Janna.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":96,\"y\":48,\"w\":48,\"h\":48}},\"JarvanIV\":{\"id\":\"JarvanIV\",\"key\":\"59\",\"name\":\"\\u5fb7\\u739b\\u897f\\u4e9a\\u7687\\u5b50\",\"title\":\"\\u5609\\u6587\\u56db\\u4e16\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"JarvanIV.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":144,\"y\":48,\"w\":48,\"h\":48}},\"Jax\":{\"id\":\"Jax\",\"key\":\"24\",\"name\":\"\\u6b66\\u5668\\u5927\\u5e08\",\"title\":\"\\u8d3e\\u514b\\u65af\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Jax.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":192,\"y\":48,\"w\":48,\"h\":48}},\"Jayce\":{\"id\":\"Jayce\",\"key\":\"126\",\"name\":\"\\u672a\\u6765\\u5b88\\u62a4\\u8005\",\"title\":\"\\u6770\\u65af\",\"tags\":[\"Fighter\",\"Marksman\"],\"image\":{\"full\":\"Jayce.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":240,\"y\":48,\"w\":48,\"h\":48}},\"Jhin\":{\"id\":\"Jhin\",\"key\":\"202\",\"name\":\"\\u620f\\u547d\\u5e08\",\"title\":\"\\u70ec\",\"tags\":[\"Marksman\",\"Mage\"],\"image\":{\"full\":\"Jhin.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":288,\"y\":48,\"w\":48,\"h\":48}},\"Jinx\":{\"id\":\"Jinx\",\"key\":\"222\",\"name\":\"\\u66b4\\u8d70\\u841d\\u8389\",\"title\":\"\\u91d1\\u514b\\u4e1d\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Jinx.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":336,\"y\":48,\"w\":48,\"h\":48}},\"Kaisa\":{\"id\":\"Kaisa\",\"key\":\"145\",\"name\":\"\\u865a\\u7a7a\\u4e4b\\u5973\",\"title\":\"\\u5361\\u838e\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Kaisa.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":384,\"y\":48,\"w\":48,\"h\":48}},\"Kalista\":{\"id\":\"Kalista\",\"key\":\"429\",\"name\":\"\\u590d\\u4ec7\\u4e4b\\u77db\",\"title\":\"\\u5361\\u8389\\u4e1d\\u5854\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Kalista.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":432,\"y\":48,\"w\":48,\"h\":48}},\"Karma\":{\"id\":\"Karma\",\"key\":\"43\",\"name\":\"\\u5929\\u542f\\u8005\",\"title\":\"\\u5361\\u5c14\\u739b\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Karma.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":0,\"y\":96,\"w\":48,\"h\":48}},\"Karthus\":{\"id\":\"Karthus\",\"key\":\"30\",\"name\":\"\\u6b7b\\u4ea1\\u9882\\u5531\\u8005\",\"title\":\"\\u5361\\u5c14\\u8428\\u65af\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Karthus.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":48,\"y\":96,\"w\":48,\"h\":48}},\"Kassadin\":{\"id\":\"Kassadin\",\"key\":\"38\",\"name\":\"\\u865a\\u7a7a\\u884c\\u8005\",\"title\":\"\\u5361\\u8428\\u4e01\",\"tags\":[\"Assassin\",\"Mage\"],\"image\":{\"full\":\"Kassadin.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":96,\"y\":96,\"w\":48,\"h\":48}},\"Katarina\":{\"id\":\"Katarina\",\"key\":\"55\",\"name\":\"\\u4e0d\\u7965\\u4e4b\\u5203\",\"title\":\"\\u5361\\u7279\\u7433\\u5a1c\",\"tags\":[\"Assassin\",\"Mage\"],\"image\":{\"full\":\"Katarina.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":144,\"y\":96,\"w\":48,\"h\":48}},\"Kayle\":{\"id\":\"Kayle\",\"key\":\"10\",\"name\":\"\\u6b63\\u4e49\\u5929\\u4f7f\",\"title\":\"\\u51ef\\u5c14\",\"tags\":[\"Fighter\",\"Support\"],\"image\":{\"full\":\"Kayle.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":192,\"y\":96,\"w\":48,\"h\":48}},\"Kayn\":{\"id\":\"Kayn\",\"key\":\"141\",\"name\":\"\\u5f71\\u6d41\\u4e4b\\u9570\",\"title\":\"\\u51ef\\u9690\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Kayn.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":240,\"y\":96,\"w\":48,\"h\":48}},\"Kennen\":{\"id\":\"Kennen\",\"key\":\"85\",\"name\":\"\\u72c2\\u66b4\\u4e4b\\u5fc3\",\"title\":\"\\u51ef\\u5357\",\"tags\":[\"Mage\",\"Marksman\"],\"image\":{\"full\":\"Kennen.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":288,\"y\":96,\"w\":48,\"h\":48}},\"Khazix\":{\"id\":\"Khazix\",\"key\":\"121\",\"name\":\"\\u865a\\u7a7a\\u63a0\\u593a\\u8005\",\"title\":\"\\u5361\\u5179\\u514b\",\"tags\":[\"Assassin\"],\"image\":{\"full\":\"Khazix.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":336,\"y\":96,\"w\":48,\"h\":48}},\"Kindred\":{\"id\":\"Kindred\",\"key\":\"203\",\"name\":\"\\u6c38\\u730e\\u53cc\\u5b50\",\"title\":\"\\u5343\\u73cf\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Kindred.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":384,\"y\":96,\"w\":48,\"h\":48}},\"Kled\":{\"id\":\"Kled\",\"key\":\"240\",\"name\":\"\\u66b4\\u6012\\u9a91\\u58eb\",\"title\":\"\\u514b\\u70c8\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Kled.png\",\"sprite\":\"champion1.png\",\"group\":\"champion\",\"x\":432,\"y\":96,\"w\":48,\"h\":48}},\"KogMaw\":{\"id\":\"KogMaw\",\"key\":\"96\",\"name\":\"\\u6df1\\u6e0a\\u5de8\\u53e3\",\"title\":\"\\u514b\\u683c\\u83ab\",\"tags\":[\"Marksman\",\"Mage\"],\"image\":{\"full\":\"KogMaw.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":0,\"y\":0,\"w\":48,\"h\":48}},\"Leblanc\":{\"id\":\"Leblanc\",\"key\":\"7\",\"name\":\"\\u8be1\\u672f\\u5996\\u59ec\",\"title\":\"\\u4e50\\u8299\\u5170\",\"tags\":[\"Assassin\",\"Mage\"],\"image\":{\"full\":\"Leblanc.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":48,\"y\":0,\"w\":48,\"h\":48}},\"LeeSin\":{\"id\":\"LeeSin\",\"key\":\"64\",\"name\":\"\\u76f2\\u50e7\",\"title\":\"\\u674e\\u9752\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"LeeSin.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":96,\"y\":0,\"w\":48,\"h\":48}},\"Leona\":{\"id\":\"Leona\",\"key\":\"89\",\"name\":\"\\u66d9\\u5149\\u5973\\u795e\",\"title\":\"\\u857e\\u6b27\\u5a1c\",\"tags\":[\"Tank\",\"Support\"],\"image\":{\"full\":\"Leona.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":144,\"y\":0,\"w\":48,\"h\":48}},\"Lissandra\":{\"id\":\"Lissandra\",\"key\":\"127\",\"name\":\"\\u51b0\\u971c\\u5973\\u5deb\",\"title\":\"\\u4e3d\\u6851\\u5353\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Lissandra.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":192,\"y\":0,\"w\":48,\"h\":48}},\"Lucian\":{\"id\":\"Lucian\",\"key\":\"236\",\"name\":\"\\u5723\\u67aa\\u6e38\\u4fa0\",\"title\":\"\\u5362\\u9521\\u5b89\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Lucian.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":240,\"y\":0,\"w\":48,\"h\":48}},\"Lulu\":{\"id\":\"Lulu\",\"key\":\"117\",\"name\":\"\\u4ed9\\u7075\\u5973\\u5deb\",\"title\":\"\\u7490\\u7490\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Lulu.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":288,\"y\":0,\"w\":48,\"h\":48}},\"Lux\":{\"id\":\"Lux\",\"key\":\"99\",\"name\":\"\\u5149\\u8f89\\u5973\\u90ce\",\"title\":\"\\u62c9\\u514b\\u4e1d\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Lux.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":336,\"y\":0,\"w\":48,\"h\":48}},\"Malphite\":{\"id\":\"Malphite\",\"key\":\"54\",\"name\":\"\\u7194\\u5ca9\\u5de8\\u517d\",\"title\":\"\\u58a8\\u83f2\\u7279\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Malphite.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":384,\"y\":0,\"w\":48,\"h\":48}},\"Malzahar\":{\"id\":\"Malzahar\",\"key\":\"90\",\"name\":\"\\u865a\\u7a7a\\u5148\\u77e5\",\"title\":\"\\u739b\\u5c14\\u624e\\u54c8\",\"tags\":[\"Mage\",\"Assassin\"],\"image\":{\"full\":\"Malzahar.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":432,\"y\":0,\"w\":48,\"h\":48}},\"Maokai\":{\"id\":\"Maokai\",\"key\":\"57\",\"name\":\"\\u626d\\u66f2\\u6811\\u7cbe\",\"title\":\"\\u8302\\u51ef\",\"tags\":[\"Tank\",\"Mage\"],\"image\":{\"full\":\"Maokai.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":0,\"y\":48,\"w\":48,\"h\":48}},\"MasterYi\":{\"id\":\"MasterYi\",\"key\":\"11\",\"name\":\"\\u65e0\\u6781\\u5251\\u5723\",\"title\":\"\\u6613\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"MasterYi.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":48,\"y\":48,\"w\":48,\"h\":48}},\"MissFortune\":{\"id\":\"MissFortune\",\"key\":\"21\",\"name\":\"\\u8d4f\\u91d1\\u730e\\u4eba\",\"title\":\"\\u5384\\u8fd0\\u5c0f\\u59d0\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"MissFortune.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":96,\"y\":48,\"w\":48,\"h\":48}},\"MonkeyKing\":{\"id\":\"MonkeyKing\",\"key\":\"62\",\"name\":\"\\u9f50\\u5929\\u5927\\u5723\",\"title\":\"\\u5b59\\u609f\\u7a7a\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"MonkeyKing.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":144,\"y\":48,\"w\":48,\"h\":48}},\"Mordekaiser\":{\"id\":\"Mordekaiser\",\"key\":\"82\",\"name\":\"\\u94c1\\u94e0\\u51a5\\u9b42\",\"title\":\"\\u83ab\\u5fb7\\u51ef\\u6492\",\"tags\":[\"Fighter\"],\"image\":{\"full\":\"Mordekaiser.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":192,\"y\":48,\"w\":48,\"h\":48}},\"Morgana\":{\"id\":\"Morgana\",\"key\":\"25\",\"name\":\"\\u5815\\u843d\\u5929\\u4f7f\",\"title\":\"\\u83ab\\u7518\\u5a1c\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Morgana.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":240,\"y\":48,\"w\":48,\"h\":48}},\"Nami\":{\"id\":\"Nami\",\"key\":\"267\",\"name\":\"\\u5524\\u6f6e\\u9c9b\\u59ec\",\"title\":\"\\u5a1c\\u7f8e\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Nami.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":288,\"y\":48,\"w\":48,\"h\":48}},\"Nasus\":{\"id\":\"Nasus\",\"key\":\"75\",\"name\":\"\\u6c99\\u6f20\\u6b7b\\u795e\",\"title\":\"\\u5185\\u745f\\u65af\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Nasus.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":336,\"y\":48,\"w\":48,\"h\":48}},\"Nautilus\":{\"id\":\"Nautilus\",\"key\":\"111\",\"name\":\"\\u6df1\\u6d77\\u6cf0\\u5766\",\"title\":\"\\u8bfa\\u63d0\\u52d2\\u65af\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Nautilus.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":384,\"y\":48,\"w\":48,\"h\":48}},\"Neeko\":{\"id\":\"Neeko\",\"key\":\"518\",\"name\":\"\\u4e07\\u82b1\\u901a\\u7075\",\"title\":\"\\u59ae\\u853b\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Neeko.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":432,\"y\":48,\"w\":48,\"h\":48}},\"Nidalee\":{\"id\":\"Nidalee\",\"key\":\"76\",\"name\":\"\\u72c2\\u91ce\\u5973\\u730e\\u624b\",\"title\":\"\\u5948\\u5fb7\\u4e3d\",\"tags\":[\"Assassin\",\"Mage\"],\"image\":{\"full\":\"Nidalee.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":0,\"y\":96,\"w\":48,\"h\":48}},\"Nocturne\":{\"id\":\"Nocturne\",\"key\":\"56\",\"name\":\"\\u6c38\\u6052\\u68a6\\u9b47\",\"title\":\"\\u9b54\\u817e\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"Nocturne.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":48,\"y\":96,\"w\":48,\"h\":48}},\"Nunu\":{\"id\":\"Nunu\",\"key\":\"20\",\"name\":\"\\u96ea\\u539f\\u53cc\\u5b50\",\"title\":\"\\u52aa\\u52aa\\u548c\\u5a01\\u6717\\u666e\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Nunu.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":96,\"y\":96,\"w\":48,\"h\":48}},\"Olaf\":{\"id\":\"Olaf\",\"key\":\"2\",\"name\":\"\\u72c2\\u6218\\u58eb\",\"title\":\"\\u5965\\u62c9\\u592b\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Olaf.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":144,\"y\":96,\"w\":48,\"h\":48}},\"Orianna\":{\"id\":\"Orianna\",\"key\":\"61\",\"name\":\"\\u53d1\\u6761\\u9b54\\u7075\",\"title\":\"\\u5965\\u8389\\u5b89\\u5a1c\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Orianna.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":192,\"y\":96,\"w\":48,\"h\":48}},\"Ornn\":{\"id\":\"Ornn\",\"key\":\"516\",\"name\":\"\\u5c71\\u9690\\u4e4b\\u7130\",\"title\":\"\\u5965\\u6069\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Ornn.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":240,\"y\":96,\"w\":48,\"h\":48}},\"Pantheon\":{\"id\":\"Pantheon\",\"key\":\"80\",\"name\":\"\\u4e0d\\u5c48\\u4e4b\\u67aa\",\"title\":\"\\u6f58\\u68ee\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Pantheon.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":288,\"y\":96,\"w\":48,\"h\":48}},\"Poppy\":{\"id\":\"Poppy\",\"key\":\"78\",\"name\":\"\\u5723\\u9524\\u4e4b\\u6bc5\",\"title\":\"\\u6ce2\\u6bd4\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Poppy.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":336,\"y\":96,\"w\":48,\"h\":48}},\"Pyke\":{\"id\":\"Pyke\",\"key\":\"555\",\"name\":\"\\u8840\\u6e2f\\u9b3c\\u5f71\",\"title\":\"\\u6d3e\\u514b\",\"tags\":[\"Support\",\"Assassin\"],\"image\":{\"full\":\"Pyke.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":384,\"y\":96,\"w\":48,\"h\":48}},\"Qiyana\":{\"id\":\"Qiyana\",\"key\":\"246\",\"name\":\"\\u5143\\u7d20\\u5973\\u7687\",\"title\":\"\\u5947\\u4e9a\\u5a1c\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"Qiyana.png\",\"sprite\":\"champion2.png\",\"group\":\"champion\",\"x\":432,\"y\":96,\"w\":48,\"h\":48}},\"Quinn\":{\"id\":\"Quinn\",\"key\":\"133\",\"name\":\"\\u5fb7\\u739b\\u897f\\u4e9a\\u4e4b\\u7ffc\",\"title\":\"\\u594e\\u56e0\",\"tags\":[\"Marksman\",\"Assassin\"],\"image\":{\"full\":\"Quinn.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":0,\"y\":0,\"w\":48,\"h\":48}},\"Rakan\":{\"id\":\"Rakan\",\"key\":\"497\",\"name\":\"\\u5e7b\\u7fce\",\"title\":\"\\u6d1b\",\"tags\":[\"Support\"],\"image\":{\"full\":\"Rakan.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":48,\"y\":0,\"w\":48,\"h\":48}},\"Rammus\":{\"id\":\"Rammus\",\"key\":\"33\",\"name\":\"\\u62ab\\u7532\\u9f99\\u9f9f\",\"title\":\"\\u62c9\\u83ab\\u65af\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Rammus.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":96,\"y\":0,\"w\":48,\"h\":48}},\"RekSai\":{\"id\":\"RekSai\",\"key\":\"421\",\"name\":\"\\u865a\\u7a7a\\u9041\\u5730\\u517d\",\"title\":\"\\u96f7\\u514b\\u585e\",\"tags\":[\"Fighter\"],\"image\":{\"full\":\"RekSai.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":144,\"y\":0,\"w\":48,\"h\":48}},\"Renekton\":{\"id\":\"Renekton\",\"key\":\"58\",\"name\":\"\\u8352\\u6f20\\u5c60\\u592b\",\"title\":\"\\u96f7\\u514b\\u987f\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Renekton.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":192,\"y\":0,\"w\":48,\"h\":48}},\"Rengar\":{\"id\":\"Rengar\",\"key\":\"107\",\"name\":\"\\u50b2\\u4e4b\\u8ffd\\u730e\\u8005\",\"title\":\"\\u96f7\\u6069\\u52a0\\u5c14\",\"tags\":[\"Assassin\",\"Fighter\"],\"image\":{\"full\":\"Rengar.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":240,\"y\":0,\"w\":48,\"h\":48}},\"Riven\":{\"id\":\"Riven\",\"key\":\"92\",\"name\":\"\\u653e\\u9010\\u4e4b\\u5203\",\"title\":\"\\u9510\\u96ef\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Riven.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":288,\"y\":0,\"w\":48,\"h\":48}},\"Rumble\":{\"id\":\"Rumble\",\"key\":\"68\",\"name\":\"\\u673a\\u68b0\\u516c\\u654c\",\"title\":\"\\u5170\\u535a\",\"tags\":[\"Fighter\",\"Mage\"],\"image\":{\"full\":\"Rumble.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":336,\"y\":0,\"w\":48,\"h\":48}},\"Ryze\":{\"id\":\"Ryze\",\"key\":\"13\",\"name\":\"\\u7b26\\u6587\\u6cd5\\u5e08\",\"title\":\"\\u745e\\u5179\",\"tags\":[\"Mage\",\"Fighter\"],\"image\":{\"full\":\"Ryze.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":384,\"y\":0,\"w\":48,\"h\":48}},\"Sejuani\":{\"id\":\"Sejuani\",\"key\":\"113\",\"name\":\"\\u5317\\u5730\\u4e4b\\u6012\",\"title\":\"\\u745f\\u5e84\\u59ae\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Sejuani.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":432,\"y\":0,\"w\":48,\"h\":48}},\"Senna\":{\"id\":\"Senna\",\"key\":\"235\",\"name\":\"\\u6da4\\u9b42\\u5723\\u67aa\",\"title\":\"\\u8d5b\\u5a1c\",\"tags\":[\"Marksman\",\"Support\"],\"image\":{\"full\":\"Senna.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":0,\"y\":48,\"w\":48,\"h\":48}},\"Sett\":{\"id\":\"Sett\",\"key\":\"875\",\"name\":\"\\u8155\\u8c6a\",\"title\":\"\\u745f\\u63d0\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Sett.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":48,\"y\":48,\"w\":48,\"h\":48}},\"Shaco\":{\"id\":\"Shaco\",\"key\":\"35\",\"name\":\"\\u6076\\u9b54\\u5c0f\\u4e11\",\"title\":\"\\u8428\\u79d1\",\"tags\":[\"Assassin\"],\"image\":{\"full\":\"Shaco.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":96,\"y\":48,\"w\":48,\"h\":48}},\"Shen\":{\"id\":\"Shen\",\"key\":\"98\",\"name\":\"\\u66ae\\u5149\\u4e4b\\u773c\",\"title\":\"\\u614e\",\"tags\":[\"Tank\"],\"image\":{\"full\":\"Shen.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":144,\"y\":48,\"w\":48,\"h\":48}},\"Shyvana\":{\"id\":\"Shyvana\",\"key\":\"102\",\"name\":\"\\u9f99\\u8840\\u6b66\\u59ec\",\"title\":\"\\u5e0c\\u74e6\\u5a1c\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Shyvana.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":192,\"y\":48,\"w\":48,\"h\":48}},\"Singed\":{\"id\":\"Singed\",\"key\":\"27\",\"name\":\"\\u70bc\\u91d1\\u672f\\u58eb\",\"title\":\"\\u8f9b\\u5409\\u5fb7\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Singed.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":240,\"y\":48,\"w\":48,\"h\":48}},\"Sion\":{\"id\":\"Sion\",\"key\":\"14\",\"name\":\"\\u4ea1\\u7075\\u6218\\u795e\",\"title\":\"\\u8d5b\\u6069\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Sion.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":288,\"y\":48,\"w\":48,\"h\":48}},\"Sivir\":{\"id\":\"Sivir\",\"key\":\"15\",\"name\":\"\\u6218\\u4e89\\u5973\\u795e\",\"title\":\"\\u5e0c\\u7ef4\\u5c14\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Sivir.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":336,\"y\":48,\"w\":48,\"h\":48}},\"Skarner\":{\"id\":\"Skarner\",\"key\":\"72\",\"name\":\"\\u6c34\\u6676\\u5148\\u950b\",\"title\":\"\\u65af\\u5361\\u7eb3\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Skarner.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":384,\"y\":48,\"w\":48,\"h\":48}},\"Sona\":{\"id\":\"Sona\",\"key\":\"37\",\"name\":\"\\u7434\\u745f\\u4ed9\\u5973\",\"title\":\"\\u5a11\\u5a1c\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Sona.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":432,\"y\":48,\"w\":48,\"h\":48}},\"Soraka\":{\"id\":\"Soraka\",\"key\":\"16\",\"name\":\"\\u4f17\\u661f\\u4e4b\\u5b50\",\"title\":\"\\u7d22\\u62c9\\u5361\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Soraka.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":0,\"y\":96,\"w\":48,\"h\":48}},\"Swain\":{\"id\":\"Swain\",\"key\":\"50\",\"name\":\"\\u8bfa\\u514b\\u8428\\u65af\\u7edf\\u9886\",\"title\":\"\\u65af\\u7ef4\\u56e0\",\"tags\":[\"Mage\",\"Fighter\"],\"image\":{\"full\":\"Swain.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":48,\"y\":96,\"w\":48,\"h\":48}},\"Sylas\":{\"id\":\"Sylas\",\"key\":\"517\",\"name\":\"\\u89e3\\u8131\\u8005\",\"title\":\"\\u585e\\u62c9\\u65af\",\"tags\":[\"Mage\",\"Assassin\"],\"image\":{\"full\":\"Sylas.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":96,\"y\":96,\"w\":48,\"h\":48}},\"Syndra\":{\"id\":\"Syndra\",\"key\":\"134\",\"name\":\"\\u6697\\u9ed1\\u5143\\u9996\",\"title\":\"\\u8f9b\\u5fb7\\u62c9\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Syndra.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":144,\"y\":96,\"w\":48,\"h\":48}},\"TahmKench\":{\"id\":\"TahmKench\",\"key\":\"223\",\"name\":\"\\u6cb3\\u6d41\\u4e4b\\u738b\",\"title\":\"\\u5854\\u59c6\",\"tags\":[\"Support\",\"Tank\"],\"image\":{\"full\":\"TahmKench.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":192,\"y\":96,\"w\":48,\"h\":48}},\"Taliyah\":{\"id\":\"Taliyah\",\"key\":\"163\",\"name\":\"\\u5ca9\\u96c0\",\"title\":\"\\u5854\\u8389\\u57ad\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Taliyah.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":240,\"y\":96,\"w\":48,\"h\":48}},\"Talon\":{\"id\":\"Talon\",\"key\":\"91\",\"name\":\"\\u5200\\u950b\\u4e4b\\u5f71\",\"title\":\"\\u6cf0\\u9686\",\"tags\":[\"Assassin\"],\"image\":{\"full\":\"Talon.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":288,\"y\":96,\"w\":48,\"h\":48}},\"Taric\":{\"id\":\"Taric\",\"key\":\"44\",\"name\":\"\\u74e6\\u6d1b\\u5170\\u4e4b\\u76fe\",\"title\":\"\\u5854\\u91cc\\u514b\",\"tags\":[\"Support\",\"Fighter\"],\"image\":{\"full\":\"Taric.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":336,\"y\":96,\"w\":48,\"h\":48}},\"Teemo\":{\"id\":\"Teemo\",\"key\":\"17\",\"name\":\"\\u8fc5\\u6377\\u65a5\\u5019\",\"title\":\"\\u63d0\\u83ab\",\"tags\":[\"Marksman\",\"Assassin\"],\"image\":{\"full\":\"Teemo.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":384,\"y\":96,\"w\":48,\"h\":48}},\"Thresh\":{\"id\":\"Thresh\",\"key\":\"412\",\"name\":\"\\u9b42\\u9501\\u5178\\u72f1\\u957f\",\"title\":\"\\u9524\\u77f3\",\"tags\":[\"Support\",\"Fighter\"],\"image\":{\"full\":\"Thresh.png\",\"sprite\":\"champion3.png\",\"group\":\"champion\",\"x\":432,\"y\":96,\"w\":48,\"h\":48}},\"Tristana\":{\"id\":\"Tristana\",\"key\":\"18\",\"name\":\"\\u9ea6\\u6797\\u70ae\\u624b\",\"title\":\"\\u5d14\\u4e1d\\u5854\\u5a1c\",\"tags\":[\"Marksman\",\"Assassin\"],\"image\":{\"full\":\"Tristana.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":0,\"y\":0,\"w\":48,\"h\":48}},\"Trundle\":{\"id\":\"Trundle\",\"key\":\"48\",\"name\":\"\\u5de8\\u9b54\\u4e4b\\u738b\",\"title\":\"\\u7279\\u6717\\u5fb7\\u5c14\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Trundle.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":48,\"y\":0,\"w\":48,\"h\":48}},\"Tryndamere\":{\"id\":\"Tryndamere\",\"key\":\"23\",\"name\":\"\\u86ee\\u65cf\\u4e4b\\u738b\",\"title\":\"\\u6cf0\\u8fbe\\u7c73\\u5c14\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Tryndamere.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":96,\"y\":0,\"w\":48,\"h\":48}},\"TwistedFate\":{\"id\":\"TwistedFate\",\"key\":\"4\",\"name\":\"\\u5361\\u724c\\u5927\\u5e08\",\"title\":\"\\u5d14\\u65af\\u7279\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"TwistedFate.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":144,\"y\":0,\"w\":48,\"h\":48}},\"Twitch\":{\"id\":\"Twitch\",\"key\":\"29\",\"name\":\"\\u761f\\u75ab\\u4e4b\\u6e90\",\"title\":\"\\u56fe\\u5947\",\"tags\":[\"Marksman\",\"Assassin\"],\"image\":{\"full\":\"Twitch.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":192,\"y\":0,\"w\":48,\"h\":48}},\"Udyr\":{\"id\":\"Udyr\",\"key\":\"77\",\"name\":\"\\u517d\\u7075\\u884c\\u8005\",\"title\":\"\\u4e4c\\u8fea\\u5c14\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Udyr.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":240,\"y\":0,\"w\":48,\"h\":48}},\"Urgot\":{\"id\":\"Urgot\",\"key\":\"6\",\"name\":\"\\u65e0\\u754f\\u6218\\u8f66\",\"title\":\"\\u5384\\u52a0\\u7279\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Urgot.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":288,\"y\":0,\"w\":48,\"h\":48}},\"Varus\":{\"id\":\"Varus\",\"key\":\"110\",\"name\":\"\\u60e9\\u6212\\u4e4b\\u7bad\",\"title\":\"\\u97e6\\u9c81\\u65af\",\"tags\":[\"Marksman\",\"Mage\"],\"image\":{\"full\":\"Varus.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":336,\"y\":0,\"w\":48,\"h\":48}},\"Vayne\":{\"id\":\"Vayne\",\"key\":\"67\",\"name\":\"\\u6697\\u591c\\u730e\\u624b\",\"title\":\"\\u8587\\u6069\",\"tags\":[\"Marksman\",\"Assassin\"],\"image\":{\"full\":\"Vayne.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":384,\"y\":0,\"w\":48,\"h\":48}},\"Veigar\":{\"id\":\"Veigar\",\"key\":\"45\",\"name\":\"\\u90aa\\u6076\\u5c0f\\u6cd5\\u5e08\",\"title\":\"\\u7ef4\\u8fe6\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Veigar.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":432,\"y\":0,\"w\":48,\"h\":48}},\"Velkoz\":{\"id\":\"Velkoz\",\"key\":\"161\",\"name\":\"\\u865a\\u7a7a\\u4e4b\\u773c\",\"title\":\"\\u7ef4\\u514b\\u5179\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Velkoz.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":0,\"y\":48,\"w\":48,\"h\":48}},\"Vi\":{\"id\":\"Vi\",\"key\":\"254\",\"name\":\"\\u76ae\\u57ce\\u6267\\u6cd5\\u5b98\",\"title\":\"\\u851a\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Vi.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":48,\"y\":48,\"w\":48,\"h\":48}},\"Viktor\":{\"id\":\"Viktor\",\"key\":\"112\",\"name\":\"\\u673a\\u68b0\\u5148\\u9a71\",\"title\":\"\\u7ef4\\u514b\\u6258\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Viktor.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":96,\"y\":48,\"w\":48,\"h\":48}},\"Vladimir\":{\"id\":\"Vladimir\",\"key\":\"8\",\"name\":\"\\u7329\\u7ea2\\u6536\\u5272\\u8005\",\"title\":\"\\u5f17\\u62c9\\u57fa\\u7c73\\u5c14\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Vladimir.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":144,\"y\":48,\"w\":48,\"h\":48}},\"Volibear\":{\"id\":\"Volibear\",\"key\":\"106\",\"name\":\"\\u96f7\\u9706\\u5486\\u54ee\",\"title\":\"\\u6c83\\u5229\\u8d1d\\u5c14\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Volibear.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":192,\"y\":48,\"w\":48,\"h\":48}},\"Warwick\":{\"id\":\"Warwick\",\"key\":\"19\",\"name\":\"\\u7956\\u5b89\\u6012\\u517d\",\"title\":\"\\u6c83\\u91cc\\u514b\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Warwick.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":240,\"y\":48,\"w\":48,\"h\":48}},\"Xayah\":{\"id\":\"Xayah\",\"key\":\"498\",\"name\":\"\\u9006\\u7fbd\",\"title\":\"\\u971e\",\"tags\":[\"Marksman\"],\"image\":{\"full\":\"Xayah.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":288,\"y\":48,\"w\":48,\"h\":48}},\"Xerath\":{\"id\":\"Xerath\",\"key\":\"101\",\"name\":\"\\u8fdc\\u53e4\\u5deb\\u7075\",\"title\":\"\\u6cfd\\u62c9\\u65af\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Xerath.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":336,\"y\":48,\"w\":48,\"h\":48}},\"XinZhao\":{\"id\":\"XinZhao\",\"key\":\"5\",\"name\":\"\\u5fb7\\u90a6\\u603b\\u7ba1\",\"title\":\"\\u8d75\\u4fe1\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"XinZhao.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":384,\"y\":48,\"w\":48,\"h\":48}},\"Yasuo\":{\"id\":\"Yasuo\",\"key\":\"157\",\"name\":\"\\u75be\\u98ce\\u5251\\u8c6a\",\"title\":\"\\u4e9a\\u7d22\",\"tags\":[\"Fighter\",\"Assassin\"],\"image\":{\"full\":\"Yasuo.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":432,\"y\":48,\"w\":48,\"h\":48}},\"Yorick\":{\"id\":\"Yorick\",\"key\":\"83\",\"name\":\"\\u7267\\u9b42\\u4eba\",\"title\":\"\\u7ea6\\u91cc\\u514b\",\"tags\":[\"Fighter\",\"Tank\"],\"image\":{\"full\":\"Yorick.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":0,\"y\":96,\"w\":48,\"h\":48}},\"Yuumi\":{\"id\":\"Yuumi\",\"key\":\"350\",\"name\":\"\\u9b54\\u6cd5\\u732b\\u54aa\",\"title\":\"\\u60a0\\u7c73\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Yuumi.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":48,\"y\":96,\"w\":48,\"h\":48}},\"Zac\":{\"id\":\"Zac\",\"key\":\"154\",\"name\":\"\\u751f\\u5316\\u9b54\\u4eba\",\"title\":\"\\u624e\\u514b\",\"tags\":[\"Tank\",\"Fighter\"],\"image\":{\"full\":\"Zac.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":96,\"y\":96,\"w\":48,\"h\":48}},\"Zed\":{\"id\":\"Zed\",\"key\":\"238\",\"name\":\"\\u5f71\\u6d41\\u4e4b\\u4e3b\",\"title\":\"\\u52ab\",\"tags\":[\"Assassin\"],\"image\":{\"full\":\"Zed.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":144,\"y\":96,\"w\":48,\"h\":48}},\"Ziggs\":{\"id\":\"Ziggs\",\"key\":\"115\",\"name\":\"\\u7206\\u7834\\u9b3c\\u624d\",\"title\":\"\\u5409\\u683c\\u65af\",\"tags\":[\"Mage\"],\"image\":{\"full\":\"Ziggs.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":192,\"y\":96,\"w\":48,\"h\":48}},\"Zilean\":{\"id\":\"Zilean\",\"key\":\"26\",\"name\":\"\\u65f6\\u5149\\u5b88\\u62a4\\u8005\",\"title\":\"\\u57fa\\u5170\",\"tags\":[\"Support\",\"Mage\"],\"image\":{\"full\":\"Zilean.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":240,\"y\":96,\"w\":48,\"h\":48}},\"Zoe\":{\"id\":\"Zoe\",\"key\":\"142\",\"name\":\"\\u66ae\\u5149\\u661f\\u7075\",\"title\":\"\\u4f50\\u4f0a\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Zoe.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":288,\"y\":96,\"w\":48,\"h\":48}},\"Zyra\":{\"id\":\"Zyra\",\"key\":\"143\",\"name\":\"\\u8346\\u68d8\\u4e4b\\u5174\",\"title\":\"\\u5a55\\u62c9\",\"tags\":[\"Mage\",\"Support\"],\"image\":{\"full\":\"Zyra.png\",\"sprite\":\"champion4.png\",\"group\":\"champion\",\"x\":336,\"y\":96,\"w\":48,\"h\":48}}},\"version\":\"10.6.1\",\"updated\":\"2020-03-24\"}";

        List<String> list = new ArrayList<>();

        JSONObject jsonObject = JSONObject.parseObject(dataString);
        JSONObject dataJsonObject = jsonObject.getJSONObject("data");
        String[] split = names.split(",");
        for (int i = 0; i < split.length; i++) {
            JSONObject nameJsonObject = dataJsonObject.getJSONObject(split[i]);
            String key = nameJsonObject.getString("key");
            for (int j = 0; j < 20; j++) {
                if (j < 10) {
//                    System.out.println("http://ossweb-img.qq.com/images/lol/web201310/skin/big" + key + "00" + j + ".jpg");
                    list.add("\"http://ossweb-img.qq.com/images/lol/web201310/skin/big" + key + "00" + j + ".jpg\"");
                } else {
//                    System.out.println("http://ossweb-img.qq.com/images/lol/web201310/skin/big" + key + "0" + j + ".jpg");
                    list.add("\"http://ossweb-img.qq.com/images/lol/web201310/skin/big" + key + "0" + j + ".jpg\"");
                }
            }
        }

        System.out.println(list.toString());
    }

}
