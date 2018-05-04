package com.example.rohit.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
Button btn;
EditText etText;
ListView lview;
private ArrayList<String> items;
private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        etText=findViewById(R.id.etText);
        lview=findViewById(R.id.ltView);
        items= DataFile.readData(this);
adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
lview.setAdapter( adapter );
lview.setOnItemLongClickListener( this );

btn.setOnClickListener(new View.OnClickListener() {
    @Override

    public void onClick(View view) {
        String Textitem = etText.getText().toString();
        if(Textitem.equals( "" )){
            Toast.makeText(MainActivity.this, "Please enter an item to add", Toast.LENGTH_SHORT).show();
        }
        else{
        adapter.add(Textitem);
        etText.setText("");
        DataFile.writeData( items, MainActivity.this );
        Toast.makeText(MainActivity.this, "Item added ", Toast.LENGTH_SHORT).show();}
    }
});

    }
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        items.remove( i );
        adapter.notifyDataSetChanged();
        Toast.makeText( MainActivity.this, "Item Removed", Toast.LENGTH_SHORT ).show();
        return false;
    }
}
