package com.mifo.mifo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelpe extends SQLiteOpenHelper {

    public dbhelpe(Context context) {
        super(context, "cart.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("drop Table if exists incart;");
        db.execSQL("create Table incart(id int primary key, namamakanan TEXT,harga int,jumlah int);");
        //Apps
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (1,'Siomay Goreng',15000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (2,'Lumpia Goreng',10000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (3,'Wonton',12500,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (4,'Baso Tahu',25000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (5,'Kroket',10000,0)");
        //Main
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (6,'Nasi Goreng',35000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (7,'Mie Goreng',35000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (8,'Nasi Uduk',30000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (9,'Sate',45000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (10,'Nasi Ayam',55000,0)");
        //Desert
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (11,'Choco Cake',35000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (12,'Ice Cream',20000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (13,'Martabak',25000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (14,'Kue Lapis',15000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (15,'Biji Salak',15000,0)");
        //Drink
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (16,'Air Mineral',5000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (17,'Lemon Tea',15000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (18,'Soft Drink',7500,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (19,'Jus Jeruk',15000,0)");
        db.execSQL("insert into incart(id,namamakanan,harga,jumlah) values (20,'Coffee',55000,0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("drop Table if exists incart;");
    }

    //buat ngambil nama
    public String ambildatanama (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM incart where id = ? ;", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        String data = cursor.getString(1);
        cursor.close();
        return data;
    }
    //buat ngambil harga
    public int ambildataharga (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM incart where id = ? ;", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        int dat = cursor.getInt(2);
        cursor.close();
        return dat;
    }
    //buat tambah jumlah
    public int ambiljumlah (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM incart where id = ? ;", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        int dat = cursor.getInt(3);
        dat += 1;
        db.execSQL("update incart SET jumlah = ? WHERE id = ?;",new String []{String.valueOf(dat), String.valueOf(id)});
        cursor.close();
        return dat;
    }
    //kurang jumlah
    public int kurangjumlah (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM incart where id = ? ;", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        int dat = cursor.getInt(3);
        dat = dat - 1;
        db.execSQL("update incart SET jumlah = ? WHERE id = ?;",new String []{String.valueOf(dat), String.valueOf(id)});
        cursor.close();
        return dat;
    }


    //tampilan jumlah
    public int jumlah (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM incart where id = ? ;", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        cursor.close();
        return cursor.getInt(3);
    }
}
