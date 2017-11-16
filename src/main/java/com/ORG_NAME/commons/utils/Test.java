package com.ORG_NAME.commons.utils;

import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UGAM\rohit.verma on 17/11/17.
 */
public class Test {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("Comedy");
        test.add("Drama");
        System.out.println(test.toString().replaceAll("\\[|]", ""));
    }
}
