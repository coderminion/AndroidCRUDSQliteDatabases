package com.coderminion.androidsqlitedatabases.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.coderminion.androidsqlitedatabases.R;
import com.coderminion.androidsqlitedatabases.model.User;
import com.coderminion.androidsqlitedatabases.sqliteutils.SqliteHelper;

import static com.coderminion.androidsqlitedatabases.sqliteutils.UserOperations.DB_NAME;

public class MainActivity extends AppCompatActivity {

    /*  Vars*/
    ArrayAdapter<String> listAdapter;
    Button addButton,inst;
    EditText nameEditText;
    ListView listView;
    SqliteHelper sqliteHelper;
    List<String> listUsers;
    List<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteHelper = new SqliteHelper(getApplicationContext(),DB_NAME,null,1);

        users = sqliteHelper.getAll();
        listUsers = new ArrayList<>();



        for (int i = 0 ; i<users.size();i++)
        {
            listUsers.add(users.get(i).getName());
        }
        initViews();
        //init Adapter
        listAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.item_listview,R.id.name,listUsers);
        listView.setAdapter(listAdapter);

        initOnClicks();
    }

    private void initOnClicks() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nameEditText.getText().toString();
                if(!userName.equals("")) {
                    User tempUser = new User(sqliteHelper.getCount(), userName);
                    sqliteHelper.add(tempUser);
                    listUsers.add(tempUser.getName());
                    listAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Cant be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showinstructions();
            }
        });

    }


    private void initViews() {
         addButton = (Button)findViewById(R.id.bt_add);
         inst = (Button)findViewById(R.id.inst);
         nameEditText = (EditText) findViewById(R.id.et_name);
         listView = (ListView) findViewById(R.id.listview);
    }

    public void showinstructions()
    {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Instructions")
                .setMessage("We have done CR from CRUD. You can use methods From SqliteHelper.java for Update and delete")
                .show();
    }


}
