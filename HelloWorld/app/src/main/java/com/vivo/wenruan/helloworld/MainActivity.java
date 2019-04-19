package com.vivo.wenruan.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SendDataDialogFragment.SendDataDialogListener {

    private static final String TAG = "MainActivity";
    private SendDataDialogFragment sendDataDialogFragment;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar_test);

    }

    private int checkedItem = 0; //默认选中的item
    public void singleClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("你现在的居住地是：");
        String[] cities = {"北京", "上海", "广州", "深圳", "杭州", "天津", "成都"};

        builder.setSingleChoiceItems(cities, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkedItem = which;
            }
        });
        //设置正面按钮
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //设置反面按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void popDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("This is Dialog");
        dialog.setMessage("Something important.");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    /**
     * 复选对话框
     * @param v
     */
    public void listClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("请选择你喜欢的颜色：");
        final String[] colors = {"红色", "橙色", "黄色", "绿色", "蓝色", "靛色", "紫色"};
        final List<String> myColors = new ArrayList<>();
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    myColors.add(colors[which]);
                } else {
                    myColors.remove(colors[which]);
                }
            }
        });

        //设置正面按钮
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (String color : myColors) {
                    Log.e(TAG, "选择的颜色：" + color);
                }
                dialog.dismiss();
            }
        });
        //设置反面按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myColors.clear();
                dialog.dismiss();
            }
        });
//        AlertDialog dialog = builder.create();	//	创建AlertDialog对象，即使不创建，也可以显示dialog，但是在自定义dialog时则必须需要。
//        dialog.show();
        builder.show();
    }

    /**
     * 列表对话框
     */
    public void listItemDialog(View view) {
        final String items[] = new String[]{"魏","蜀","吴"};
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("显示Item对话框")
                .setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancle",null)
                .setPositiveButton("OK",null).create();
        dialog.show();

    }

    /**
     * 简单登录对话框
     */
    public void customClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(MainActivity.this, R.layout.loading_dialog, null);
        //设置对话框布局
        dialog.setView(dialogView);
        dialog.show();
        EditText etName = (EditText) dialogView.findViewById(R.id.et_name);
        EditText etPwd = (EditText) dialogView.findViewById(R.id.et_pwd);
        final String name = etName.getText().toString();
        final String pwd = etPwd.getText().toString();
        Button btnLogin = (Button) dialogView.findViewById(R.id.btn_login);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btn_cancel);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "用户名和密码均不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e(TAG, "用户名：" + name);
                Log.e(TAG, "密码：" + pwd);
                dialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void clickDialogFragment(View view) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(), "MyDialogFragment");
    }

    public void sendData(View view) {
        sendDataDialogFragment = new SendDataDialogFragment();
        sendDataDialogFragment.show(getSupportFragmentManager(), "SendDataDialogFragment");
    }

    @Override
    public void typeInputComplete(String userAccount, String password) {
        Toast.makeText(this, "帐号：" + userAccount + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void destoryFragment() {
        sendDataDialogFragment.dismiss();
    }
}
