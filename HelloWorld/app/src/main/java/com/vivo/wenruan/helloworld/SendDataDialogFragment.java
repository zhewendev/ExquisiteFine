package com.vivo.wenruan.helloworld;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendDataDialogFragment extends DialogFragment {

    private EditText mUserAccount;
    private EditText mPassword;
    private Button mButton;

    public interface SendDataDialogListener {
        void typeInputComplete(String userAccount, String password);
        void destoryFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.loading_dialog, null);
        mUserAccount = (EditText) view.findViewById(R.id.et_name);
        mPassword = (EditText) view.findViewById(R.id.et_pwd);
        mButton = (Button) view.findViewById(R.id.btn_login);
        builder.setView(view);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendDataDialogListener sendDataDialogListener = (SendDataDialogListener) getActivity();
                sendDataDialogListener.typeInputComplete(mUserAccount.getText().toString(), mPassword.getText().toString());
                sendDataDialogListener.destoryFragment();
            }
        });
        return builder.create();
    }
}
