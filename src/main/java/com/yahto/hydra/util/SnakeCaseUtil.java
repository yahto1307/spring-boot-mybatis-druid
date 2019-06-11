package com.yahto.hydra.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.yahto.hydra.model.Activity;

import java.lang.reflect.Field;

/**
 * Created by yahto on 2019-06-11 11:13
 *
 * @author yahto
 */
public class SnakeCaseUtil {
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toLowerCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getResultsStr(Activity.class));
    }
}
