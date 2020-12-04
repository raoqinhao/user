package com.hh.userservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hh.userservice.inter.Person;
import com.hh.userservice.pojo.Permission;
import com.hh.userservice.pojo.Role;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Accessors(chain = true)
@Data
public class TestLambda {

    public TestLambda() {

    }

    private static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhangsan",19));
        userList.add(new User("lisi",39));
        userList.add(new User("wangwu",26));
        userList.add(new User("maliu",26));
        userList.add(new User("maliu",26));
        return userList;
    }

    private static List<Role> getRoleList() {
        List<Role> roleList = new ArrayList<>();
        Set<Permission> permissions = new HashSet<>();
        Set<Permission> permissions1 = new HashSet<>();
        Set<Permission> permissions2 = new HashSet<>();
        Permission permission = new Permission("1","permission_role");
        Permission permission1 = new Permission("2","permission_info");
        Permission permission2 = new Permission("3","permission_level");
        permissions.add(permission);
        permissions1.add(permission1);
        permissions2.add(permission2);
        roleList.add(new Role("1","zhangsan","123",permissions));
        roleList.add(new Role("5","lisi","123456",permissions1));
        roleList.add(new Role("3","wangwu","123456789",permissions2));
        roleList.add(new Role("5","zhaoqi","123",permissions2));
        return roleList;
    }


    @Test
    public void testStash() {
        System.out.println("111");
        System.out.println("dev2");
        System.out.println("dev1");
        System.out.println("master");
        System.out.println("master.");
        System.out.println("dev222");
        System.out.println("dev22");
        System.out.println("new dev1");
        System.out.println("new dev2");
        System.out.println("new dev11");
        System.out.println("new dev111");
        System.out.println("new dev1111");
        System.out.println("cs");
        System.out.println("dev1 测试 reword");
    }

    @Test
    public void testPeekAnyMatchData() {
        List<User> userList = getUserList();
        List<String> names = new ArrayList<>();
        // 通过peek获取数据的时候如果后面接了anyMatch()方法的时候需要注意了，当匹配成功的时候后面peek中的数据会被丢失了。
        // 所以需要切记peek中放数据的时候需要直接放即可。
        boolean b = userList.stream().peek(user -> names.add(user.getUserName())).anyMatch(e -> "wangwu".equals(e.getUserName()));
        System.out.println(b);
        System.out.println("---------");
        names.forEach(e -> System.out.println(e));
    }

    @Test
    public void testMatchPeek() {
        List<User> userList = getUserList();
        boolean b = userList.stream().peek(e -> System.out.println(e)).anyMatch(e -> "lisi".equals(e.getUserName()));
        System.out.println(b);
    }


    @Test
    public void testMathRandom() {
        while (true) {
            int random = (int) (Math.random() * 10) + 1;
            System.out.println(random);
        }
    }

    @Test
    public void testModulo() {
        int result_1 = 5/3;
        int result_2 = 5%3;
        System.out.println(result_1 + " " + result_2);
    }


    @Test
    public void testStringFormat() {
        for (int i = 0; i < 1; i++) {
            String month = String.format("%02d", i);
            System.out.println(month);
            String month1 = String.format("%2d", i);
            System.out.println(month1);
            String month2 = String.format("%d", i);
            System.out.println(month2);
        }
        System.out.println(String.format("%s:%s:%s",1,2,3));
    }


    @Test
    public void testzhuangyi() {
        String str = "abc||def||hij";
        int i = str.indexOf("||");
        System.out.println(i);
    }

    @Test
    public void testSplitString() {
        String str = "abc||def||hij";
        String[] split = str.split("\\|\\|");
        Arrays.stream(split).forEach(e -> System.out.println(e));
    }

    @Test
    public void testIntStreamRange() {
        IntStream.rangeClosed(0,5).forEach(e -> System.out.println(e));
    }


    @Test
    public void testBaseDataCalculator() {
        int x = 1;
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Integer> collect = integers.stream().map(e -> e + x).collect(Collectors.toCollection(ArrayList::new));
        collect.forEach(e -> System.out.println(e));
    }

    @Test
    public void testSumSumNum() {
        int i = 0;
        System.out.println(++i);
        System.out.println(i++);
    }

    @Test
    public void testBaseTypeData() {
        int x = 0;
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        List<String> collect = strings.stream().map(e -> e + x).collect(Collectors.toCollection(ArrayList::new));
        collect.forEach(e -> System.out.println(e));
    }


    @Test
    public void reverseArray() {
        List intArray = getIntArray();
        System.out.println(intArray);
        int[] arr = new int[]{1,2,3,4,5};
        long[] longs = IntStream.rangeClosed(1, arr.length).mapToLong(e -> arr[arr.length - e]).toArray();
        Arrays.stream(longs).forEach(e -> System.out.println(e));
        System.out.println("------------");
        int[] array = new int[]{1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        Collections.reverse(Arrays.asList(array));
        System.out.println("-----");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    private static List getIntArray() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            integers.add(i);
        }
        return integers;
    }

    private static List<Role> getEmptyRoleList() {
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(UUID.randomUUID().toString().replaceAll("-",""),"admin","permission_1",null));
        roleList.add(new Role(UUID.randomUUID().toString().replaceAll("-",""),"ordinary","permission_1",null));
        return roleList;
    }

    public static void main(String[] args) {
        getStringLength();
    }

    public static void getStringLength() {
        String a = "";
        System.out.println(a.length());
    }

    @Test
    public void testHashMapStream() {
        List<User> userList = getUserList();
        String collect = userList.stream().map(User::getUserName).collect(Collectors.joining());
        System.out.println(collect);
    }

    @Test
    public void testGetMaxByReduce() {
        List<User> userList = getUserList();
        Optional<Integer> reduce = userList.stream().map(User::getUserAge).reduce(Math::max);
        Objects.requireNonNull(reduce.get());
        System.out.println(reduce.get());
//        Optional<Object> empty = null;
//        Objects.requireNonNull(empty.get());
        Object[] a = {1,2,3};
        Object[] b = {1,2,3};
        boolean status = Arrays.deepEquals(a, b);
        System.out.println(status);
    }


    @Test
    public void testFlatMapData() {
        List<Role> roleList = getRoleList();
        Set<Permission> collect = roleList.stream().flatMap(e -> e.getPermissions().stream()).collect(Collectors.toSet());
        collect.forEach(e -> System.out.println(e));
        System.out.println("---------------");
        List<Permission> collect1 = roleList.stream().flatMap(e -> e.getPermissions().stream()).collect(Collectors.toList());
        collect1.forEach(e -> System.out.println(e));
    }


    @Test
    public void testHashMapStream1() {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("zhangsan","19");
        map.putIfAbsent("lisi","29");
        map.putIfAbsent("lisi","20");
        map.forEach((key,value) -> System.out.println(key + " " + value));
        System.out.println("---------");
        map.put("zhangsan","19");
        map.put("lisi","29");
        map.put("lisi","20");
        map.forEach((key,value) -> System.out.println(key + " " + value));
    }


    @Test
    public void testSetUserData() {
        List<User> userList = getUserList();
        userList.forEach(e -> System.out.println(e));
        List<User> testSetUser = userList.stream().map(user -> {
            User newUser = user;
            newUser.setUserName("测试对象");
            return newUser;
        }).collect(Collectors.toCollection(ArrayList::new));
        testSetUser.forEach(e -> System.out.println(e));
    }


    @Test
    public void testEmptyRoleList() {
        List<Role> emptyRoleList = getEmptyRoleList();
        String collect = emptyRoleList.stream().collect(Collectors.mapping(Role::getName, Collectors.joining("||")));
        System.out.println(collect);
        String roleNames = emptyRoleList.stream().collect(Collectors.mapping(Role::getName, Collectors.joining("','","'","'")));
        System.out.println(roleNames);
//        Collectors.toConcurrentMap()
    }


    @Test
    public void testSortRoleList() {
        List<Role> roleList = getRoleList();
        roleList.forEach(e -> System.out.println(e));
        System.out.println("--------");
        List<Role> newRoleList = roleList.stream().sorted(Comparator.comparing(Role::getPermissionId).reversed()).sorted(Comparator.comparing(Role::getRoleId).reversed()).collect(Collectors.toCollection(ArrayList::new));
        newRoleList.forEach(e -> System.out.println(e));
    }


    @Test
    public void testGetObject() {
        List<User> userList = getUserList();
        userList.forEach(e -> System.out.println(e));
        System.out.println("---------");
        List<User> newUserList = userList.stream().sorted(Comparator.comparingInt(User::getUserAge).reversed()).collect(Collectors.toCollection(ArrayList::new));
        newUserList.forEach(e -> System.out.println(e));
    }



    @Test
    public void testMergeTwoList2() {
        List<Role> roleList = getRoleList();
        List<Role> roleList1 = getRoleList();
        List<Role> collect = roleList.stream().collect(Collectors.toCollection(() -> roleList1));
        collect.forEach(e -> System.out.println(e));
        System.out.println(collect);
    }




    static int outerStaticNum;
    int outerNum;

    @Test
    public void testStaticNum() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        System.out.println(stringConverter1.convert(1));
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }


    @Test
    public void testMergeTwoList() {
        List<User> userList = getUserList();
        List<Role> roleList = getRoleList();
        List mergeList = new ArrayList();
        mergeList.addAll(userList);
        mergeList.addAll(roleList);
        Object collect = mergeList.stream().peek(e -> System.out.println(e)).skip(2).limit(3).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        System.out.println("collect = " + JSON.toJSONString(collect));
    }



    @Test
    public void testAnyMatch1() {
        List<User> userList = getUserList();
        try {
            boolean b = userList.stream().anyMatch(e -> e.getUserAge() < 15);
            System.out.println(b);
            assert b ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("断言失败");
        }
    }



    @Test
    public void testGetListIfNull() {
        List<User> userList = new ArrayList<>();
        List<User> collect = userList.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        List<User> users = null;
        List<User> usersArrays = users.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(usersArrays);
    }


    @Test
    public void testGroupByAge() {
        List<User> userList = getUserList();
        Map<String, Map<String, List<User>>> collect = userList.stream().collect(Collectors.groupingBy(User::getUserName, Collectors.groupingBy(e -> {
            if (e.getUserAge() <= 19) {
                return "青少年";
            } else if (e.getUserAge() <= 26) {
                return "年青人";
            } else {
                return "中老年";
            }
        })));
        collect.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
    }



    @Test
    public void testMergeUserListByStream() {
        List<User> userList = getUserList();
        List<User> userList1 = getUserList();

        List<User> collect = userList.stream().collect(Collectors.toCollection(() -> userList1));
        collect.forEach(e -> System.out.println(e));
    }


    @Test
    public void testMergeUserList() {
        List<User> userList = getUserList();
        List<User> userList1 = getUserList();
        List<User> mergeUserList = new ArrayList<>();
        mergeUserList.addAll(userList);
        mergeUserList.addAll(userList1);
        mergeUserList.forEach(e -> System.out.println(e));
        System.out.println("------------------");
        List<String> collect = userList.stream().map(User::getUserName).collect(Collectors.toCollection(ArrayList::new));
        collect.forEach(e -> System.out.println(e));

        for (String s : collect) {
            System.out.println(s);
        }
    }


    @Test
    public void testChangeMap2() {
        List<User> userList = getUserList();
        Map<String, Integer> map = userList.stream().collect(Collectors.toMap(User::getUserName, User::getUserAge, (oldValue, newValue) -> oldValue));
        map.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Integer merge = map.merge(key, map.get(key), (oldValue, newValue) -> newValue);
            System.out.println(merge);
        }

    }


    @Test
    public void testChangeMap() {
        List<User> userList = getUserList();
        Map<String, User> stringUserMap = userList.stream().distinct().collect(Collectors.toMap(User::getUserName, Function.identity(), (oldValue, newValue) -> oldValue));
        stringUserMap.forEach((key,value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
        System.out.println("---------");
        stringUserMap.forEach((key,value) -> {
            int newValue = value.getUserAge() + 2;
            value.setUserAge(newValue);
            stringUserMap.replace(key,value);
        });
        System.out.println("---------");
        stringUserMap.forEach((key,value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
    }




    @Test
    public void testIntStream() {
        List<User> userList = getUserList();
        List<Integer> integerList = userList.stream().map(User::getUserAge).collect(Collectors.toCollection(ArrayList::new));
        Arrays.stream(integerList.toArray()).peek(e -> System.out.println(e)).sorted().distinct().peek(e -> System.out.println(e)).collect(Collectors.toCollection(ArrayList::new));
    }


    @Test
    public void testMap() {
        List<User> userList = getUserList();
        userList.stream().map(User::getUserName).collect(Collectors.toList());

    }

    @Test
    public void testCollectorsToMap() {
        List<User> userList = getUserList();
        Map<String, User> collect = userList.stream().collect(Collectors.toMap(User::getUserName, Function.identity(), (oldValue, newValue) -> oldValue));
        collect.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
    }



    @Test
    public void testFlatMap2() {
        String[] split = new String[]{"21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920","21236iworjfai32","19823787935340920"};
        long l = System.currentTimeMillis();
        ArrayList<String> collect = Arrays.stream(split).map(e -> e.split("")).flatMap(Arrays::stream).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        System.out.println(System.currentTimeMillis() - l);

        long k = System.currentTimeMillis();
        List arrayList = new ArrayList();
        for (String s : split) {
            String[] split1 = s.split("");
            for (int i = 0; i < split1.length; i++) {
                arrayList.add(split1[i]);
            }
        }
        System.out.println(arrayList);
        System.out.println(System.currentTimeMillis() - k);
    }

    @Test
    public void testFlatMap() {
        List<User> userList = getUserList();
        Stream<User> stream1 = userList.stream();
        Stream<User> stream2 = userList.stream();
        Stream<User> stream3 = userList.stream();
        Stream<Stream<User>> stream11 = Stream.of(stream1, stream2, stream3);
        ArrayList<User> wangwuUser = stream11.flatMap(e -> e.filter(z -> z.getUserName().equals("wangwu"))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(wangwuUser);
    }




    @Test
    public void testDistinct() {
        List<User> userList = getUserList();
        System.out.println(userList.size());
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        ArrayList<Integer> collect = userList.parallelStream().map(User::getUserAge).distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
    }


    @Test
    public void testFirstUser() {
        List<User> userList = getUserList();
        Optional<User> first = userList.stream().filter(e -> "lisi".equals(e.getUserName())).findFirst();
        System.out.println(first.get());
    }


    @Test
    public void testReduce() {
        List<User> userList = getUserList();
        Integer integer = userList.stream().map(User::getUserAge).reduce((e1, e2) -> e1 + e2).orElse(0);
        System.out.println(integer);
        System.out.println(19+26+26+29);

    }


    @Test
    public void testArray() {
        int[] array = {1,2,3,5,6,8};
        Stream<int[]> array1 = Stream.of(array);
        array1.forEach(e -> {
            Arrays.stream(e).forEach(System.out::println);
        });
        System.out.println("-------------");
        IntStream stream = Arrays.stream(array);
        stream.forEach(e -> System.out.println(e));
    }


    @Test
    public void testAnyMatch() {
        List<User> userList = getUserList();
        boolean lisi = userList.stream().anyMatch(e -> e.getUserName().equals("zhaoqi"));
        System.out.println(lisi);

    }



    @Test
    public void testArrayList() {
        List<User> userList = getUserList();
        List<User> newUserList = new ArrayList<>(userList);
        newUserList.stream().peek(e -> System.out.println(e)).collect(Collectors.toList());
    }



    @Test
    public void testIndex() {
        List<User> userList = getUserList();
        for (int i = 0; i < userList.size(); i++) {
            if (i==userList.size()) {
                System.out.println("--------");
            }
        }
    }



    @Test
    public void testUpdateUser() {
        List<User> userList = getUserList();
        userList.forEach(e -> System.out.println(e));

        System.out.println("---------");
        userList.forEach(e -> {
            String userName = e.getUserName();
            if ("lisi".equals(userName)) {
                e.setUserAge(1);
            }
        });
        userList.forEach(e -> System.out.println(e));
    }

    @Test
    public void testLambdaGroupBy() {
        List<User> userList = getUserList();
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getUserName));
        collect.forEach((key,value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
        System.out.println("------------");
        Map<Integer, List<User>> collect1 = userList.stream().collect(Collectors.groupingBy(User::getUserAge));
        collect1.forEach((key,value) -> {
            System.out.print(key);
            System.out.print(value);
            System.out.println();
        });
    }


    @Test
    public void testConcurrentMap() {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().collect(Collectors.toList());
    }


    @Test
    public void testLambdaMap() {
        List<User> newUserList = new ArrayList<>();
        List<User> userList = getUserList();
        Map<String, User> userMap = userList.stream().collect(Collectors.toMap(e -> e.getUserName(), Function.identity()));
        userMap.forEach((key,value) -> {
            System.out.print(key);
            System.out.print("  ");
            System.out.print(value);
            System.out.println();
            newUserList.add(value);
        });
        System.out.println("----------------------------");
        newUserList.stream().forEach(e -> System.out.println(e));
    }


    @Test
    public void testLambdaPeek() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhangsan",19));
        userList.add(new User("lisi",29));
        userList.add(new User("wangwu",26));
        List<User> collect = userList.stream().peek(e -> System.out.println(e)).collect(Collectors.toList());
        System.out.println("------------");
        List<User> userList1 = Objects.requireNonNull(collect);
        userList1.forEach(e -> System.out.println(e));
        System.out.println("------------");
        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }
    }


    @Test
    public void testString() {
        String  s = "['1','2','3']";
        JSONArray jsonArray = JSONArray.parseArray(s);
        Object o = jsonArray.get(0);
        String ss = "{\n" +
                "    \"buyNumber\":0,\n" +
                "    \"buySpe\":\"100mg*1支\",\n" +
                "    \"claimAmount\":\"5526.6\",\n" +
                "    \"claimFag\":\"307030\",\n" +
                "    \"idEffectiveDate\":\"2020-08-26T16:00:00.000Z\",\n" +
                "    \"invoiceAmount\":\"19280,438756385,23847392874\",\n" +
                "    \"invoiceCount\":3,\n" +
                "    \"invoiceNum1\":\"134434334,324234,的语言的高富帅\",\n" +
                "    \"invoiceTime\":\"2020-08-26T16:00:00.000Z\",\n" +
                "    \"invoiceTimeTwo\":\",Wed Aug 12 2020 00:00:00 GMT+0800 (中国标准时间),Sun Aug 02 2020 00:00:00 GMT+0800 (中国标准时间)\",\n" +
                "    \"pharmacyName\":\"要点\",\n" +
                "    \"receiveDate\":\"Y,N,Y\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(ss);
        String string = jsonObject.getString("invoiceTimeTwo");
        System.out.println(string);
        String[] split = string.split(",");
        List<String> strings = Arrays.asList(split);
        System.out.println("------------------");
        System.out.println(strings.get(0));
        if ("".equals(strings.get(0))) {
            System.out.println(1);
        }
        System.out.println("------------------");
        strings.forEach(e -> System.out.println(e));
    }


    @Test
    public void testLambda() {
        Integer integer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer integerMin = list.stream().collect(Collectors.minBy(Integer::compareTo)).get();
        System.out.println(integerMin);
        Integer integerMax = list.stream().collect(Collectors.maxBy(Integer::compareTo)).get();
        System.out.println(integerMax);
        Integer integerReduce = list.stream().reduce((x, y) -> x + y).get();
        System.out.println(integerReduce);
        list.stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("--------------");
        System.out.println(list.stream().count());
        System.out.println("--------------");
        System.out.println(list.stream().mapToLong(e -> 1L).sum());
    }


    @Test
    public void testMapForLambda() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a","1");
        hashMap.put("b","2");
        hashMap.put("c","3");
        hashMap.forEach((key, value) -> {
            if ("c".equals(key)) {
                System.out.print(key);
                System.out.print(value);
                System.out.println();
            }
        });
    }


    public TestLambda add(){
        return this;
    }

    @Test
    public void test3() {

        Map<String,String> maps = new HashMap();
        maps.put("111","23");
        maps.put("111","342");

        for (String map : maps.keySet()) {
            System.out.println(map);
        }


        Supplier runable = () -> "1";
        System.out.println(runable.get());

        new TestLambda().add().add().add();

        List<User> users = new ArrayList<>();
        users.add(new User("honey",12));
        users.add(new User("honey1",12));
        Map<String, Integer> collect = users.stream().collect(Collectors.toMap(User::getUserName, User::getUserAge));
        System.out.println(collect.toString());

        Function<User, String> getUserName = User::getUserName;
        String userAge = getUserName.apply(new User("aaa", 1));
        System.out.println(userAge);

        Person person =TestLambda::eat;
        person.eat();

        u u = User::new;
        u.getUser();

        System.out.println("----------------");
        Person person1 = TestLambda::eat;
        person.eat();

        Supplier<JSONArray> supplierJsonArray = JSONArray::new;
        JSONArray jsonArray = supplierJsonArray.get();
        jsonArray.set(2, 1);
        jsonArray.fluentAdd(0,2);
        jsonArray.forEach(e -> System.out.println(e));
        System.out.println("----------------");
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        List<Object> newObjects = new ArrayList<>(2);
        System.arraycopy(objects.toArray(),1,newObjects.toArray(), 0,2);
        newObjects.forEach(e -> System.out.println(e));
        System.out.println("----------------");
        int[] orgArray = new int[]{1,2,3,4,5};
        int[] newArray = new int[3];
        System.arraycopy(orgArray,1,newArray, 0,3);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    interface u{
        User getUser();
    }

    private static void eat(){
        System.out.println("aaa");
    }


    @Test
    public void test2() {
        List<String> al = Arrays.asList("6", "2", "3", "1");
        al.forEach(a -> System.out.print(a));
        System.out.println();
        al.stream().sorted().forEach(s -> System.out.print(s));
        System.out.println();
        al.parallelStream().sorted().forEach(s -> System.out.print(s));
    }

    @Test
    public void test1() {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(TestLambda::success);

        Runnable runnable = () -> System.out.println(" cs ");
        runnable.run();

    }

    public static void success(String str) {
        System.out.println("练习 ：： 用法" + str);
    }

    @Test
    public void testMatch() {
        String test = "12";
        String match = "/^([0]|[1-9][0-9]*)$/";
        System.out.println(test.matches(match));
        Pattern compile = Pattern.compile(match);
        boolean b = compile.matcher(test).find();
        System.out.println(b);

    }












}
