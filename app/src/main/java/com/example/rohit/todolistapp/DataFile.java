package com.example.rohit.todolistapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataFile {
    public static final String FILENAME="listinfo.dat";
    public static void writeData(ArrayList<String> ar, Context context){
        try {
            FileOutputStream fos=context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject( ar );
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> readData(Context cx) {
        ArrayList<String> itemlist=null;
        try {
            FileInputStream fis=cx.openFileInput( FILENAME );//open the file and fis points to the file
            ObjectInputStream oos= new ObjectInputStream( fis );
            itemlist= (ArrayList<String>) oos.readObject();//Read object data
        } catch (FileNotFoundException e) {
            itemlist=new ArrayList<>( );
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemlist;
    }
}
