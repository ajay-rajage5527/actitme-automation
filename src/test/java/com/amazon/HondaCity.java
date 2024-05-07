package com.amazon;

import com.orangehrm.automation.Honda;

public class HondaCity implements Honda {
    public void engine(String cubicPower){
        System.out.println("cubicPower"+cubicPower);
    }
    public void fuel(String Type){
        System.out.println("type"+Type);
        }
        public String tyres(){
        return "16 inches";
        }
        public static void main(String []args){
        HondaCity hondaCity=new HondaCity();
        hondaCity.engine("1500");
        hondaCity.fuel("Petrol");
        System.out.println(hondaCity.tyres().toLowerCase());
        }
}
