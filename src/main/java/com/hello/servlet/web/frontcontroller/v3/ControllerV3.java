package com.hello.servlet.web.frontcontroller.v3;

import com.hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;
import java.util.Objects;

public interface ControllerV3 {

    // Servlet 에 종속적이지 않은 코드로 변경됨.
    ModelView process(Map<String, String> paramMap);
}
