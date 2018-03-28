package io.github.bayu1993.binarsesi3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.bayu1993.binarsesi3.R;
import io.github.bayu1993.binarsesi3.adapter.ContactAdapter;
import io.github.bayu1993.binarsesi3.interfaces.ItemClickListener;
import io.github.bayu1993.binarsesi3.pojo.Contact;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Contact> contacts = new ArrayList<>();
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void getContacts() {
        contacts.add(new Contact("Ani", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Herman", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Zaden", "096049860",R.drawable.ic_launcher_background));
        contacts.add(new Contact("Pojo", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Eko", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Eki", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Deni", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Dana", "096049860", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Keyza", "096049860", R.drawable.ic_launcher_background));

        contactAdapter.notifyDataSetChanged();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rec_contact);

        contactAdapter = new ContactAdapter(contacts, new ItemClickListener() {
            @Override
            public void onItemClick(Contact contact, int position) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                intent.putExtra("contact", contact);
                startActivity(intent);
            }
        });

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(contactAdapter);

        getContacts();
    }
}
