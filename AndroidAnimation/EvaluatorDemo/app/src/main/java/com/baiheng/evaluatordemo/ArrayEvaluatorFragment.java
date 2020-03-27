package com.baiheng.evaluatordemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Array Evaluator使用示例
 */
public class ArrayEvaluatorFragment extends Fragment {

    private int[] start = {200};
    private int[] end = {800};
    private float[] startF = {400f};
    private float[] endF = {1000f};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.array_evaluator_fragment,container,false);
        initData(view);
        return view;
    }

    private void initData(View view) {
        Button button = (Button) view.findViewById(R.id.animator_btn);
        final TextView textView = (TextView) view.findViewById(R.id.text_view);
        final TextView textView1 = (TextView) view.findViewById(R.id.text_view_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
