package com.amazon;

import com.orangehrm.automation.SoftwareTesting;

public class AutomationTesting {
    public static void main(String []args){
        SoftwareTesting softwareTesting= (var1,var2) ->{
            System.out.println("this is selenuim method from");
            return "returns value";
        };
        System.out.println(softwareTesting.selenium("java",17));
    }

}
