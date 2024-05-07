package com.amazon;

import com.orangehrm.automation.Honda;

public class Verna {
    public  static void main(String []args){
        Honda honda =new Honda(){
            public void engine(String cubicPower){
                System.out.println(cubicPower+" cc engine ");
            }
            public void fuel(String type){
                System.out.println(type +" type engine");
            }
        };
        honda.engine("Diesel");
        honda.fuel("2200");
    }
}
