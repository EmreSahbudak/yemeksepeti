package com.bilgeadam.utility;

import java.util.UUID;

public class CodeGeneretor {

    public static String generateCode(){
        String code= UUID.randomUUID().toString();
        //örnek UUID--> 1b931-e123-4764-8ef2-3960aaa
        //burada tireleri gördükce ayırcak ve ilk gördüğünü alcak
        //yani ---> 1,e,4,8,3 elimdeki veirler olcak bunları bi arraye atalım
        String[] data=code.split("-");
        String newCodee="";
        for (String str : data){
            newCodee += str.charAt(0);   //1e483
        }
        return newCodee;
    }
}
