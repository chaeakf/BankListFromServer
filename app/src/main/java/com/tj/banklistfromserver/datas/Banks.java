package com.tj.banklistfromserver.datas;

import org.json.JSONException;
import org.json.JSONObject;

public class Banks {

    public int id;
    public String code;
    public String name;
    public String logo;

//    JSON -> Banks 클래스로 전환해주는 메쏘드.

    public static Banks getBankFromJson(JSONObject bankJson){

//        리턴해주기 위한 bacnk 객체를 생성
//        내부 데이터는 모두 비어있늣 ㅏㅇ태

        Banks bankObject = new Banks();

//        비어있는 데이터를 bankJon으로부터 cncnfgotj codnwk

        try {
            bankObject.id = bankJson.getInt("id");
            bankObject.code = bankJson.getString("code");
            bankObject.name = bankJson.getString("name");
            bankObject.logo = bankJson.getString("logo");

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return bankObject;
    }
}
