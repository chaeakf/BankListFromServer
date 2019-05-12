package com.tj.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tj.banklistfromserver.Utils.ConnectServer;
import com.tj.banklistfromserver.adapters.BankListadapter;
import com.tj.banklistfromserver.databinding.ActivityMainBinding;
import com.tj.banklistfromserver.datas.Banks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    List<Banks> banksList = new ArrayList<>();
    BankListadapter bankListadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
        onResume();
    }


    @Override
    public void setupEvents() {
        act.serverTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });

    }

    @Override
    public void setValues() {
        bankListadapter = new BankListadapter(mContext, banksList);
        act.bankListView.setAdapter(bankListadapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ConnectServer.getRequestInfoBank(mContext, new ConnectServer.JsonResponseHandler() {

            //                    실제 서버에서 돌아온 응답을
//                    메인엑티비티에서 처리하는 메쏘드
            @Override
            public void onResponse(JSONObject json) {
                try {
                    int code =json.getInt("code");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if(code == 200){

                                Toast.makeText(mContext, "정상적으로 데이터를 가지고 왔습니다 ", Toast.LENGTH_SHORT).show();

                                try {
                                    JSONObject data = json.getJSONObject("data");
                                    JSONArray banks = data.getJSONArray("banks");

//                                    누적으로 데이터가 쌓이지 않게, 미리 한번 비워주는 코드
                                    banksList.clear();

                                    for (int i = 0; i < banks.length(); i++){
                                        JSONObject bank = banks.getJSONObject(i);

//                                                String name = bank.getString("name");
//                                                Log.d("은행이름", name);

                                        Banks bankObj = Banks.getBankFromJson(bank);

                                        banksList.add(bankObj);
                                    }

                                    bankListadapter.notifyDataSetChanged();

                                } catch (JSONException e) {

                                    e.printStackTrace();
                                }

                            }else {

//                                        서버에서 주는 에러메세지를 토스트로 출력
                                try {

                                    String message = json.getString("message");
                                    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {

                                    e.printStackTrace();
                                }

                                Toast.makeText(mContext, "서버통신에 문제가 있습니다 ", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }
}
