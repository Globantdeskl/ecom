package com.aeo.framework.model;

import lombok.Data;

import java.util.List;

@Data
public class ErrorObj {

    List<String> fields;
    List<String> args;
    String key;
    String name;
}
