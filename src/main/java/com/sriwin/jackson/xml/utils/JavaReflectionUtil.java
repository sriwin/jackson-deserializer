package com.sriwin.jackson.xml.utils;

import com.sriwin.jackson.xml.constants.DataTypeConstants;

import java.lang.reflect.Field;

public class JavaReflectionUtil implements DataTypeConstants {

  public static String getFieldValue(Object object, String fieldName) {
    try {
      Field field = object.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      Object fieldValue = field.get(object);
      String fieldType = getFieldType(fieldValue);
      return fieldValue.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static String getFieldType(Object obj) {
    return isDouble(obj)
        ? "Double"
        : (isLong(obj) ? "Long" : (isString(obj) ? "String" : "String"));
  }

  private static boolean isDouble(Object obj) {
    boolean isDecimal = DOUBLE_PATTERN.matcher(obj.toString()).matches();
    return isDecimal;
  }

  private static boolean isLong(Object obj) {
    boolean isDecimal = LONG_PATTERN.matcher(obj.toString()).matches();
    return isDecimal;
  }

  private static boolean isString(Object obj) {
    boolean isDecimal = STRING_PATTERN.matcher(obj.toString()).matches();
    return isDecimal;
  }
}