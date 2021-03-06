package com.example.ruan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Componente [ WebView ]

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Item listItens[] = new Item[]{
            new Item(R.drawable.ic_launcher, "Uva"),
            new Item(R.drawable.ic_launcher, "Maçã"),
            new Item(R.drawable.ic_launcher, "Pera"),
            new Item(R.drawable.ic_launcher, "Laranja"),
            new Item(R.drawable.ic_launcher, "Amora")
        };

        ItensAdapter itensAdapter = new ItensAdapter(this, R.layout.listview_item_row, listItens);

        listView = (ListView)findViewById(R.id.listView);

        View header = (View)getLayoutInflater().inflate(R.layout.list_header_row, null);

        listView.addHeaderView(header);
        listView.setAdapter(itensAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.txt_nome);

                Toast.makeText(getApplicationContext(), v.getText().toString(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
