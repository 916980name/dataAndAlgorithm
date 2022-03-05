package com.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Number715Test {
    @Test
    void t1() {
        Number715 n = new Number715();
        n.addRange(10, 20);
        Assertions.assertEquals("10-20,", n.stringfy());
        n.addRange(20, 30);
        Assertions.assertEquals("10-30,", n.stringfy());
        n.addRange(40, 50);
        Assertions.assertEquals("10-30,40-50,", n.stringfy());
        n.addRange(22, 35);
        Assertions.assertEquals("10-35,40-50,", n.stringfy());
        n.addRange(39, 52);
        Assertions.assertEquals("10-35,39-52,", n.stringfy());
        n.addRange(36, 37);
        Assertions.assertEquals("10-35,36-37,39-52,", n.stringfy());
        n.addRange(11, 39);
        Assertions.assertEquals("10-52,", n.stringfy());
        n.addRange(0, 5);
        Assertions.assertEquals("0-5,10-52,", n.stringfy());
    }

    @Test
    void t2() {
        Number715 n = new Number715();
        n.addRange(10, 20);
        n.removeRange(15, 20);
        Assertions.assertEquals("10-15,", n.stringfy());
        n.addRange(20, 25);
        n.removeRange(14, 21);
        Assertions.assertEquals("10-14,21-25,", n.stringfy());
        n.addRange(30, 35);
        n.removeRange(13, 31);
        Assertions.assertEquals("10-13,31-35,", n.stringfy());
    }

    @Test
    void t4() {
        Number715 n = new Number715();
        n.addRange(10, 20);
        n.removeRange(14, 16);
        Assertions.assertEquals("10-14,16-20,", n.stringfy());
    }

    @Test
    void t3() {
        Number715 n = new Number715();
        n.addRange(10, 20);
        n.removeRange(14, 16);
        Assertions.assertTrue(n.queryRange(10, 14)); // return True
        Assertions.assertFalse(n.queryRange(13, 15)); // return False
        Assertions.assertTrue(n.queryRange(16, 17)); // return True
    }

    @Test
    void t5() {
        Number715 n = new Number715();
        n.addRange(5, 8);
        Assertions.assertFalse(n.queryRange(3, 4)); // return False
    }

    @Test
    void t6() {
        Number715 n = new Number715();
        n.addRange(6, 8);
        n.removeRange(7, 8);
        n.removeRange(8, 9);
        n.addRange(8, 9);
        n.removeRange(1, 3);
        n.addRange(1, 8);
        Assertions.assertTrue(n.queryRange(2, 4));
        Assertions.assertTrue(n.queryRange(2, 9));
        Assertions.assertTrue(n.queryRange(4, 6));
    }

    @Test
    void t7() {
        Number715 n = new Number715();
        n.removeRange(4, 8);
        n.addRange(1, 10);
        Assertions.assertTrue(n.queryRange(1, 7));
        n.addRange(2, 3);
        n.removeRange(2, 3);
        Assertions.assertTrue(n.queryRange(8, 9));
        Assertions.assertTrue(n.queryRange(6, 9));
        n.addRange(2, 3);
        n.removeRange(1, 8);
    }

    @Test
    void t8() {
        Number715 n = new Number715();
        n.addRange(5, 6);
        n.addRange(2, 8);
        Assertions.assertFalse(n.queryRange(1, 4));
        n.removeRange(2, 4);
        Assertions.assertTrue(n.queryRange(4, 5));
        n.removeRange(4, 6);
        n.addRange(5, 9);
        Assertions.assertTrue(n.queryRange(5, 6));
        n.removeRange(6, 7);
    }

    private String[] operations() {
        return new String[]{"addRange","addRange","removeRange","queryRange","queryRange","removeRange","removeRange","removeRange","removeRange","removeRange","queryRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","addRange","addRange","queryRange","removeRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange","addRange","removeRange","removeRange","removeRange","addRange","addRange","queryRange","queryRange","queryRange","queryRange","queryRange","removeRange","removeRange","queryRange","addRange","addRange","addRange","queryRange","addRange","addRange","removeRange","addRange","queryRange","removeRange","addRange","queryRange","addRange","addRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","removeRange","removeRange","queryRange","removeRange","queryRange","queryRange","removeRange","queryRange","addRange","addRange","queryRange","removeRange","removeRange","queryRange","addRange","removeRange","removeRange","addRange","addRange","addRange","queryRange","queryRange","addRange","queryRange","removeRange","queryRange","removeRange","addRange","queryRange"};
    }

    private int[][] operands() {
        return new int[][]{{55,62},{1,29},{18,49},{6,98},{59,71},{40,45},{4,58},{57,69},{20,30},{1,40},{73,93},{32,93},{38,100},{50,64},{26,72},{8,74},{15,53},{44,85},{10,71},{54,70},{10,45},{30,66},{47,98},{1,7},{44,78},{31,49},{62,63},{49,88},{47,72},{8,50},{49,79},{31,47},{54,87},{77,78},{59,100},{8,9},{50,51},{67,93},{25,86},{8,92},{31,87},{90,95},{28,56},{10,42},{27,34},{75,81},{17,63},{78,90},{9,18},{51,74},{20,54},{35,72},{2,29},{28,41},{17,95},{73,75},{34,43},{57,96},{51,72},{21,67},{40,73},{14,26},{71,86},{34,41},{10,25},{27,68},{18,32},{30,31},{45,61},{64,66},{18,93},{13,21},{13,46},{56,99},{6,93},{25,36},{27,88},{82,83},{30,71},{31,73},{10,41},{71,72},{9,56},{22,76},{38,74},{2,77},{33,61},{74,75},{11,43},{27,75}};
    }

    private Boolean[] expected() {
        return new Boolean[]{null,null,null,false,false,null,null,null,null,null,false,null,null,null,null,false,false,null,null,true,null,false,null,false,null,null,null,null,null,null,null,null,null,true,true,false,false,true,null,null,false,null,null,null,true,null,null,null,null,false,null,null,false,null,null,null,true,null,true,null,null,null,null,false,null,false,false,null,false,null,null,false,null,null,false,null,null,null,null,null,null,true,true,null,true,null,false,null,null,false};
    }

    @Test
    void t9() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] operations = operations();
        int[][] operands = operands();
        Boolean[] expected = expected();
        System.out.println("op: " + operations.length + ", oa: " + operands.length + ", res: " + expected.length);
        Number715 n = new Number715();
        Map<String, Method> methodMap = Arrays.stream(n.getClass().getDeclaredMethods())
                .collect(Collectors.toMap(Method::getName, method -> method));
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < operations.length; i++) {
            Method method = methodMap.get(operations[i]);
            Object result = method.invoke(n, operands[i][0], operands[i][1]);
            if(method.getReturnType() == boolean.class) {
                buf.append("e: ").append(expected[i])
                    .append(", r: ").append(result);
                if((boolean)expected[i] != (boolean) result) {
                    buf.append("\t\t\t\t\t[NOT MATCH]");
                }
                buf.append("\n");
                System.out.print(buf.toString());
            }
            buf.setLength(0);
        }
    }
}
