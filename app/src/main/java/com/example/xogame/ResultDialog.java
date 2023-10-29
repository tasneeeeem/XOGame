package com.example.xogame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialog extends Dialog {
    private final String messages;
    private final MainActivity mainActivity;

    public ResultDialog(@NonNull Context context ,String messages ,MainActivity mainActivity) {
        super(context);
        this.messages=messages;
        this.mainActivity=mainActivity;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messagesText =findViewById(R.id.messageText);
        Button startAgainBtn=findViewById(R.id.startAgainButton);

        messagesText.setText(messages);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMach();
                dismiss();
            }
        });
    }
}