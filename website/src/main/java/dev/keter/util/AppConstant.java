package dev.keter.util;

import org.springframework.core.ParameterizedTypeReference;

import java.util.Map;

public class AppConstant {
    public static final ParameterizedTypeReference<Map<String, String>> TYPE_MAP_STRING_TO_STRING = new ParameterizedTypeReference<>() {
    };
    public static final ParameterizedTypeReference<Map<String, Object>> TYPE_MAP_STRING_TO_OBJECT = new ParameterizedTypeReference<>() {
    };
}
