package com.seamount.jdk.java.util;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {


    @Test
    public void asListTest(){
        String[] str = {"a", "b", "c"};
        List<String> listStr = Arrays.asList(str);
        System.out.println(listStr.size());

        //这里结果为1而不是三是因为返回的泛型参数 是数组 而不是 Integer
        //另外基本类型不可以作为泛型
        int[] i = {1, 2, 3};
        List<int[]> listI = Arrays.asList(i);
        System.out.println(listI.size());

        //这个时候返回的size就是3了
        Integer[] integers = {1, 2, 3};
        List<Integer> integers1 = Arrays.asList(integers);
        System.out.println(integers1.size());

        System.out.println("--------------------------");
        String[] str1 = {"h", "e", "l", "l", "o"};
        List<String> strings = Arrays.asList(str1);
        //此处的ArrayList不是常用的java.util.ArrayList 而是Arrays的一个内部类
        System.out.println(strings.getClass().toString());
        //且该定长的数组不可以增加和删除 只能查看和修改
//        System.out.println(strings.add("world"));

        System.out.println("-------------------------");
        System.out.println("返回列表ArrayList里面的元素都是引用不是独立出来的对象");
        String[] str2 = {"a", "b", "c"};
        List<String> stringList = Arrays.asList(str2);
        //执行更新操作前
        System.out.println(Arrays.toString(str2));
        stringList.set(0, "A");//将第一个元素改为大写
        //执行更新之后的操作
        System.out.println(Arrays.toString(str2));
        //总结：修改集合的内容，原数组的内容也变化了，所以这里传入的是引用类型

    }


    @Test
    public void binarySearchTest(){
        int[] num = {1, 3, 8, 5, 2, 4, 6, 7};
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        //二分法查找2 返回下标
        System.out.println(Arrays.binarySearch(num,2));

        System.out.println("--------------------------------");
        int i = myBinarySearch(num, 0, num.length - 1, 2);
        System.out.println(i);

    }


    /**
     * 二分法
     * @param arry  sort拍过顺序
     * @param fromIndex  开始下标
     * @param endIndex  结束下标
     * @param key  关键字
     * @return
     */
    private int myBinarySearch(int[] arry, int fromIndex, int endIndex, int key){
        while (fromIndex < endIndex){
            int mind = (fromIndex + endIndex) >>> 1;
            int mindValue = arry[mind];
            if (mindValue > key) {
                endIndex = mind + 1;
            } else if (mindValue < key) {
                fromIndex = mind - 1;
            } else {
                return mind;
            }
        }
        return -(fromIndex + 1);
    }


    @Test
    public void equalsTest(){
        String[] hello = {"h", "e", "l", "l", "o"};
        String[][] name1 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};
        String[][] name2 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};

        //不支持多维数组的对价
        System.out.println(Arrays.equals(name1, name2));
        //支持任意嵌套的多维数组
        System.out.println(Arrays.deepEquals(name1, name2));

        System.out.println(ArraysTest.toStringSource(hello));
    }


    /**'
     * Arrays toString 源码
     * @param a
     * @return
     */
    public static String toStringSource(Object[] a){
        if (a == null) {
            return "null";
        }
        int max = a.length - 1;
        if (max < 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0;;i++) {
            builder.append(a[i]);
            if (i == max) {
                return builder.append("]").toString();
            }
            builder.append(",");
        }
    }


    @Test
    public void copyTest(){
        int[] num1 = {1, 2, 3};
        int[] num2 = new int[3];
        System.arraycopy(num1, 0, num2, 0, num1.length);
        System.out.println(Arrays.toString(num2));

    }










}
