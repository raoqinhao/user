package com.hh.userservice.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TestArithmetic {


    @Test
    public void testDeleteDuplicates() {
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        ListNode listNode2 = new ListNode();
        listNode2.val = 1;
        ListNode listNode3 = new ListNode();
        listNode3.val = 2;
        ListNode listNode4 = new ListNode();
        listNode4.val = 3;
        ListNode listNode5 = new ListNode();
        listNode5.val = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        deleteDuplicates(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101, head);
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == pre.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 平方根取整
    * @创建人: 饶钦浩
    * @时间: 2021/8/6 11:19
    * @return void
    * @throws
    */
    @Test
    public void testMySqrt() {
        System.out.println(mySqrt(8));
    }

    public int mySqrt(int x) {
        double sqrt = Math.sqrt(x);
        return (int) sqrt;
    }

    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 数组变数字加一
    * @创建人: 饶钦浩
    * @时间: 2021/8/4 15:42
    * @return void
    * @throws
    */
    @Test
    public void testPlusOne() {
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        System.out.println(plusOne(digits));
    }


    public int[] plusOne(int[] digits) {
        String num = "";
        for (int i = 0; i < digits.length; i++) {
            num += digits[i];
        }
        String resultStr = new BigDecimal(num).add(new BigDecimal(1)).toString();
        int[] result = new int[resultStr.length()];
        char[] chars = resultStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character character = Character.valueOf(chars[i]);
            String s = character.toString();
            result[i] = Long.valueOf(s).intValue();
        }
        return result;
    }


    @Test
    public void testLengthOfLastWord() {
        System.out.println(lengthOfLastWord(" 111"));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0 && s.replace(" ","").length() == 0)
            return 0;
        String[] wordArray = s.split(" ");
//        for (int i = 0; i < wordArray.length; i++) {
//            if (i == (wordArray.length - 1)) {
//                return wordArray[i].length();
//            }
//        }
//        return 0;
        return wordArray[wordArray.length - 1].length();
    }


    @Test
    public void testJump() {
        int[] nums = {2,1};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 1;
        int first = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                continue;
            int num = nums[i];
            if (first < num)
                count++;
        }
        return count;
    }


    @Test
    public void testSearchInsert() {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length > 0 ? nums.length : 0;
    }

    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 替换法获取指定数值的下标。
    * @创建人: 饶钦浩
    * @时间: 2021/7/30 17:31
    * @return void
    * @throws
    */
    @Test
    public void testStrMatch() {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return -1;
        if ("".equals(haystack) && needle.length() > 0)
            return 0;
        haystack = haystack.replace(needle,"&");
        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '&') {
                return i;
            }
        }
        return -1;
    }


    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 移除指定的数值
    * @创建人: 饶钦浩
    * @时间: 2021/7/30 17:15
    * @return void
    * @throws
    */
    @Test
    public void testRemoveElement() {
        int[] nums = {2,2,3};
        System.out.println(removeElement(nums,2));
        System.out.println("---------");
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                index++;
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                nums[i] = 0;
        }
        return nums.length - index;
    }


    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 去重
    * @创建人: 饶钦浩
    * @时间: 2021/7/30 15:22
    * @return void
    * @throws
    */
    @Test
    public void testRemoveDuplicates() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println("111");
    }


    public int removeDuplicates(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = -1000000;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean state =true;
            for (int j = 0; j < newNums.length; j++) {
                int newNum = newNums[j];
                if (num == newNum) {
                    state = false;
                    break;
                }
            }
            if (state) {
                newNums[index++] = num;
            }
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }
        return index;
    }

    /**
     * 二分查找法
     */
    @Test
    public void testBinarySearch() {
        int a = 10;
        int[] arr = new int[]{1,2,3,4,5};
        int index = getBinarySearch(arr, a);
        System.out.println(index);
    }

    private int getBinarySearch(int[] arr, int a) {
        if (arr.length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == a) {
                return mid;
            } else if (arr[mid] < a) {
                left = mid + 1;
            } else if (arr[mid] > a) {
                right = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void testIsValid() {
        String str = "(([]){})";
        System.out.println(isValid(str));
    }

    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                characterStack.push(c);
            } else {
                if (characterStack.isEmpty())
                    return false;
                Character pop = characterStack.pop();
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == ')' && pop != '(') {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 移除指定下标中的数据
    * @创建人: 饶钦浩
    * @时间: 2021/7/20 17:03
    * @return void
    * @throws
    */
    @Test
    public void testRemoveLinkedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode resuleListNodes = removeNthFromEnd(listNode1,2);
        while (resuleListNodes != null) {
            System.out.println(resuleListNodes.val);
            resuleListNodes = resuleListNodes.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode s = listNode;
        ListNode e = listNode;
        while (n != 0) {
            s = s.next;
            n--;
        }
        while (s.next != null) {
            s = s.next;
            e = e.next;
        }
        e.next = e.next.next;
        return listNode.next;
    }

    @Test
    public void testLengthSolution() {
        String[] strs = new String[]{"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix1(strs));
    }

    public String longestCommonPrefix1(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = strs[0].length();
        String targetStr = strs[0];
        out: for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].toCharArray().length) {
                    char c = strs[0].toCharArray()[i];
                    char c1 = strs[j].toCharArray()[i];

                    if (c != c1) {
                        index = i;
                        break out;
                    }
                } else {
                    index = i;
                    break out;
                }
            }
        }
        if (index == -1) {
            return "";
        } else {
            return targetStr.substring(0,index);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean state = true;
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].toCharArray().length) {
                    char c = strs[0].toCharArray()[i];
                    char c1 = strs[j].toCharArray()[i];

                    if (c != c1) {
                        return result;
                    }
                } else {
                    state = false;
                    break;
                }
            }
            if (state)
                result += strs[0].toCharArray()[i];
        }
        return result;
    }


    /***
    * 功能描述:<br>
    * @参数 测试一个数值是否为回文，例如 121   反过来还是121 ，另-121  121- 就不是回文数据了。
    * @描述:
    * @创建人: 饶钦浩
    * @时间: 2021/7/20 9:18
    * @return
    * @throws
    */
    @Test
    public void testPalindrome() {
        System.out.println(palindrome(101));
    }

    private boolean palindrome(int num) {
        int tempNum = num;
        if (num < 0)
            return false;
        int rs = 0;
        while (num > 0) {
            rs *= 10;
            rs += num % 10;
            num /= 10;
        }
        if (Long.valueOf(rs) > (Math.pow(2, 31) - 1) || Long.valueOf(rs) < (Math.pow(-2, 31) + 1))
            return false;
        if (rs == tempNum)
            return true;
        return false;
    }


    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 将数值反过来，并且还在Integer最大值中
    * @创建人: 饶钦浩
    * @时间: 2021/7/20 9:16
    * @return void
    * @throws
    */
    @Test
    public void TestReverse() {
        int reverse = reverse(-123);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        String newStr = "";
        boolean symbolState = false;
        String numStr = String.valueOf(x);
        char[] chars = numStr.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[0];
            String eq = String.valueOf(aChar);
            if ("-".equals(eq) || "+".equals(eq)) {
                symbolState = true;
            }
            char reverseChar = chars[chars.length - 1 - i];
            newChars[i] = reverseChar;
        }
        if (symbolState) {
            newStr = new String(newChars);
            newStr = newStr.substring(0,newStr.length() - 1);
        } else {
            newStr = new String(newChars);
        }
        if (Long.valueOf(newStr) > (Math.pow(2, 31) - 1) || Long.valueOf(newStr) < (Math.pow(-2, 31) + 1))
            return 0;
        if (symbolState) {
            return -Integer.valueOf(newStr);
        } else {
            return Integer.valueOf(newStr);
        }
    }

    /***
    * 功能描述:<br>
    * @参数 []
    * @描述: 查询数组中的两个数相加等于目标数的索引
    * @创建人: 饶钦浩
    * @时间: 2021/7/19 10:55
    * @return void
    * @throws 
    */
    @Test
    public void testFindIndexFromArray() {
        int[] nums = new int[]{1,7,11,15};
        int target = 12;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}