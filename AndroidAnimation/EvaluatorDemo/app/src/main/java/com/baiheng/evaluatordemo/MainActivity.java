package com.baiheng.evaluatordemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Evaluator使用示例
 */
public class MainActivity extends AppCompatActivity {

    private int flag = 0;   //用于切换不同的EvaluatorFragment页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.fragment_jump_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (flag) {
                    case 0:
                        replaceFragment(new ArgbEvaluatorFragment());
                        button.setText("ArgbEvaluator Fragment");
                        flag++;
                        break;
                    case 1:
                        replaceFragment();
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.evaluator_fragment,fragment);
        transaction.commit();
    }

}
