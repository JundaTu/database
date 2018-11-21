package com.otherUsefulObject;

import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

/**
 * @program database
 * @description: TODO: A class which will navigate
 * @author: tujunda
 * @create: 2018/11/20 23:09
 */
public class Navigator {
    public static final Set<String> navigator;

    static {
        Set<String> directorySet = new HashSet<>();
        //directorySet.add("login");
        directorySet.add("exit");
        directorySet.add("student menu");
        directorySet.add("transcript");
        directorySet.add("enroll");
        directorySet.add("withdraw");
        directorySet.add("personal");
        directorySet.add("logout");
        navigator = directorySet;
    }

    public static int toDifferntScreen(String s) {
        switch (s) {
            case "student menu":
                return ConsForLevels.STUDENT_MENU;
            case "transcript":
                return ConsForLevels.TRANSCRIPT;
            case "enroll":
                return ConsForLevels.ENROLL;
            case "personal":
                return ConsForLevels.PERSONAL;
            case "logout":
                return ConsForLevels.LOGOUT;
            case "withdraw":
                return ConsForLevels.WITHDRAW;
            case "exit":
                return ConsForLevels.EXIT;
            default:
                return ConsForLevels.ERROR;
        }
        //return -1;
    }
}

