package com.sriwin.jackson.xml.constants;

import java.util.regex.Pattern;

public interface DataTypeConstants {
  Pattern DOUBLE_PATTERN = Pattern.compile("^[\\+\\-]{0,1}[0-9]+[\\.]{1}[0-9]+$");
  Pattern STRING_PATTERN = Pattern.compile("^[a-zA-Z0-9]*$");
  Pattern LONG_PATTERN = Pattern.compile("^-?\\d{1,19}$");
}