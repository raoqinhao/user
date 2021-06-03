package com.hh.userservice.test;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName TestPoint
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/20 17:34
 * @Version 1.0
 **/
public class TestPoint {

    public static void main(String[] args) {
        String point=
                "113.700001,34.800001_" +
                "113.700002,34.800002_" +
                "113.700003,34.800000_" +
                "113.700004,34.800000_" +
                "113.700005,34.800000_" +
                "113.700006,34.800000_" +
                "113.700007,34.800000_" +
                "113.700008,34.800000_" +
                "113.700009,34.800000_" +
                "113.700010,34.800000_" +
                "113.700011,34.800000_" +
                "113.700012,34.800000_" +
                "113.700013,34.800000_" +
                "113.700014,34.800000_" +
                "113.700015,34.800000_" +
                "113.700016,34.800000_" +
                "113.700017,34.800000_" +
                "113.700018,34.800000_" +
                "113.700019,34.800000_" +
                "113.700020,34.800000_" +
                "113.700021,34.800000_" +
                "113.700022,34.800000_" +
                "113.7000,34.800000_" +
                "113.700001,34.800000_" +
                "113.700001,34.800000_" +
                "113.700001,34.800000";
        String isPoint="113.74,34.85";
        String[] sp = isPoint.split(",");
        double xx= Double.parseDouble(sp[0]);
        double yy= Double.parseDouble(sp[1]);
        // 获取区域坐标信息。
        String[] coordinates = point.split("_");
        List<Point2D.Double> potions=new ArrayList<>();
        for (String value : coordinates) {
            String[] split = value.split(",");
            double x = Double.parseDouble(split[0]);
            double y = Double.parseDouble(split[1]);
            Point2D.Double point2D = new Point2D.Double(x, y);
            potions.add(point2D);
        }

        GeneralPath path=new GeneralPath();
        Point2D.Double firstPoint2D = potions.get(0);
        //设置起点坐标
        path.moveTo(firstPoint2D.x,firstPoint2D.y);
        for(Point2D.Double d:potions){
            //将当前坐标连线到下方坐标
            path.lineTo(d.x,d.y);
        }
        // 设置终点坐标（本质上是还是起点坐标。围成一个区域范围）
        path.lineTo(firstPoint2D.x,firstPoint2D.y);
        path.closePath();
        boolean b = path.contains(xx, yy);
        System.out.println(b);

    }

    @Test
    public void createPointDataArray() {
        List<List> pointList = new ArrayList<>();
        String points = "121.496528,31.252129;121.500034,31.253495;121.500532,31.251526;121.497627,31.250887";
        String[] split = points.split(";");
        for (int i = 0; i < split.length; i++) {
            List<String> strings = new ArrayList<>();
            String[] split1 = split[i].split(",");
            strings.add(split1[0].trim());
            strings.add(split1[1].trim());
            pointList.add(strings);
        }
        System.out.println(pointList.toString().replaceAll(" ",""));
    }

    @Test
    public void createPointData() {
        String json = "[[121.533651,31.271897],[121.532921,31.270865],[121.536252,31.271429],[121.535432,31.272585]]";
        String points = "[[121.533624,31.26916],[121.532965,31.26966],[121.535062,31.270362],[121.535137,31.268885],[121.535116,31.268867],[121.535116,31.268867],[121.53467,31.268514]]";
        JSONArray jsonArray = JSONArray.parseArray(points);
//        jsonArray.stream().flatMap(e -> {
//            JSONArray array = (JSONArray) e;
//            String jd = array.getString(0);
//            String wd = array.getString(1);
//            return jd+","+wd;
//        })

        String collect = jsonArray.stream().map(e -> {
            JSONArray array = (JSONArray) e;
            return array.getString(0) + "," + array.getString(1);
        }).collect(Collectors.joining("_"));
        System.out.println(collect);




    }

    @Test
    public void simple() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(new Date());
        System.out.println(date1);

        Date date = new Date();
        String s = Calendar.YEAR + "-" + Calendar.MONTH + "-" + Calendar.DAY_OF_MONTH + " 08:00:00";
        System.out.println(s);

        ZonedDateTime of = ZonedDateTime.of(LocalDateTime.parse("2021-05-24 21:57:04", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), ZoneId.of("Asia/Shanghai"));
        int year = of.getYear();
        System.out.println(year);
    }

    @Test
    public void testTime() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar currentCalendar = Calendar.getInstance();
        Date date = new Date();
        currentCalendar.setTime(date);

        String beforeDate = simpleDateFormat1.format(date) + " 08:00:00";
        String afterDate = simpleDateFormat1.format(date) + " 23:00:00";

        Calendar beforeCalendar = Calendar.getInstance();
        beforeCalendar.setTime(simpleDateFormat.parse(beforeDate));
        Calendar afterCalendar = Calendar.getInstance();
        afterCalendar.setTime(simpleDateFormat.parse(afterDate));

        if (currentCalendar.after(beforeCalendar) && currentCalendar.before(afterCalendar)) {
            System.out.println("----1----");
        } else {
            System.out.println("----2----");
        }

    }


    @Test
    public void getLngLatPoint() {

        String address = "虹桥路2272号,上海市长宁区程家桥街道华联超市(青溪店)春花苑,上海市长宁区虹桥街道中山西路1057号SOHO中山广场";
        String[] split1 = address.split(",");
        for (int i = 0; i < split1.length; i++) {
            // 获取地图的经纬度
            Map buildingParametersMap = new HashMap<>(3);
            buildingParametersMap.put("key", "e9b5e6dcee60e344dd667adba94bcc03");
            buildingParametersMap.put("city", "上海");
            buildingParametersMap.put("address", split1[i]);
            String buildingResponseGPSJson = HttpUtil.get("restapi.amap.com/v3/geocode/geo", buildingParametersMap);
            JSONObject buildingJsonGPSObject = JSONObject.parseObject(buildingResponseGPSJson);
            JSONArray buildingArray = buildingJsonGPSObject.getJSONArray("geocodes");
            Map<String, Object> buildingRow = new LinkedHashMap<>();
            if (buildingArray != null && buildingArray.size() > 0) {
                Map map = (Map) buildingArray.get(0);
                String location = map.get("location").toString();
                String[] split = location.split(",");
                if (split.length > 1) {
                    buildingRow.put("lng", split[0]);
                    buildingRow.put("lat", split[1]);
                } else {
                    buildingRow.put("lng", "0");
                    buildingRow.put("lat", "0");
                }
            }
            if (buildingRow.size()>0) {
                System.out.println(buildingRow.get("lng").toString() + " ：经度" + "   " + "纬度：" + buildingRow.get("lat").toString());
            } else {
                System.out.println("111.111111" + " ：经度" + "   " + "纬度：" + "111.111111");
            }

        }
    }



}
