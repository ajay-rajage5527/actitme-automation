package com.amazon;

import com.orangehrm.automation.Suzuki;

public class Swift {
    public static void main(String[] args){
        Suzuki suzuki=new Suzuki() {//this is normal annanomous class object  creation by using reference of interface
            public void engine() {
               System.out.println("800 cc engine of swift car");
            }
        };
        suzuki.engine();
          Suzuki suzuki1=() ->{
              System.out.println("800 cc engine switft car ");
          };
          suzuki1.engine();
          Suzuki suzuki2=() ->{
              System.out.println("1200 cc engine of swift car");
          };
          suzuki2.engine();

    }
}
