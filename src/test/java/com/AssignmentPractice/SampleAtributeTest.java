    package com.AssignmentPractice;
    
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
    
    public class SampleAtributeTest {
        @Test(priority=1,enabled=true)//if we make enabled as false then this method will not execute
        public void login(){
           System.out.println("This is login method");
        }
        @Test(priority = 2,description = " Add task using valid details")
        public int[][] addTask() {
            System.out.println("This is add task method");
            int[][] a = new int[2][2];
            a[0][0] = 2;
            a[0][1] = 5;
            a[1][0] = 7;
            a[1][1] = 6;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            int[][] b = new int[][]{
                    {4, 5},
                    {9, 6},
                    {4, 8}
            };
            System.out.println("no of rows " + b.length);
            System.out.println("No of columns " + b[0].length);
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[1].length; j++) {
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();
            }
            return a;

        }
            @DataProvider
                    public Object[][] getTestData(){
                Object[][]obj=new Object[][]{
                        {"rajagea@gmail.com","ajay5527"},
                        {"rajage@","gh"},
                        {" ","ajay5527"}
                };
                return obj;
            }
            @Test(dataProvider="getTestData")
        public void login(Object username,Object Password){
            System.out.println("username "+ username);
                System.out.println("password "+ Password);
            }
        }

