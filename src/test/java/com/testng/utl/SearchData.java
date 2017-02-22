package com.testng.utl;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class SearchData {

    @DataProvider(name = "searchKey1")  
    public static Object[][] searchKeys() {
        return new Object[][]{      
                {"apple"},  
                {"Æ»¹û"}
            };
    }

    @DataProvider(name = "searchKey2")
    public Object[][] providerMethod(Method method){
        Object[][] result = null;
        if(method.getName().equals("testSearch1")){
            result = new Object[][]{new Object[]{"apple"}};
        }else if(method.getName().equals("testSearch2")){
            result = new Object[][]{new Object[]{"Æ»¹û"}};
        }
        return result;
    }
}