package com.dxc.videoservice.Test;

public class StringTest {

    public static void main(String []args ){
        String prpallCoreUserOrg = "01000000";
        if(prpallCoreUserOrg=="01000000") prpallCoreUserOrg="41000000";
        else if(prpallCoreUserOrg=="02000000") prpallCoreUserOrg="32000000";
        else if(prpallCoreUserOrg=="06000000") prpallCoreUserOrg="14000000";
        else if(prpallCoreUserOrg=="05000000" || prpallCoreUserOrg=="07000000") prpallCoreUserOrg="43000000";
        else if(prpallCoreUserOrg=="04000000") prpallCoreUserOrg="61000000";
        else if(prpallCoreUserOrg=="03000000") prpallCoreUserOrg="51000000";

        System.out.println("prpallCoreUserOrg="+prpallCoreUserOrg);


        String[] arrayExt = {"410000","340000","630000","420000","620000","640000","610000",
                "40000","140000","60000","10000","10000","130000","370000","210000","220000",
                "230000","150000","650000","120000","110000","210200"};
        for(int i=0;i<arrayExt.length;i++){
            String ext = arrayExt[i];
            System.out.println(i+":ext="+ext);
        }
    }
}
