package io.github.bayu1993.binarsesi3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.bayu1993.binarsesi3.R;
import io.github.bayu1993.binarsesi3.pojo.Contact;

public class ChatActivity extends AppCompatActivity {
    TextView tvName,tvPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
        Contact contact = getIntent().getParcelableExtra("contact");
        setTitle(contact.getName());
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());

    }

    private void initView() {
        tvName = findViewById(R.id.tv_name_chat);
        tvPhone = findViewById(R.id.tv_phone_chat);
    }
}
