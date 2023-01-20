package com.mifo.mifo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class adapter2 extends Adapter{
    dbhelpe dbs;
    static String qr ="";
    List<String> data5 = new ArrayList<>(20);
    List<String> data6 = new ArrayList<>(20);
    List<Integer> jumlah2 = new ArrayList<>(20);
    List<Integer> jumlah3 = new ArrayList<>(20);
    List<Integer> gambardata = new ArrayList<>(20);
    int checkoutcount;
    static int total;

    public adapter2(Context c, int[] b, int idm) {
        super(c, b, idm);
        checkoutcount=0;
        total =0;
        for (int i = 1;i<21;i++){
            if (dbs.jumlah(i)>=1){
                data5.add(checkoutcount, dbs.ambildatanama(i));
                data6.add(checkoutcount, "Rp. " + (dbs.ambildataharga(i)));
                jumlah2.add(checkoutcount, dbs.jumlah(i));
                jumlah3.add(checkoutcount,dbs.jumlah(i) * dbs.ambildataharga(i));
                total = total + jumlah3.get(checkoutcount);
                gambardata.add(checkoutcount,datagambar[i-1]);
                qr = qr + " " + data5.get(checkoutcount) + " " + jumlah2.get(checkoutcount);
                checkoutcount++;
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
            holder.text1.setText(data5.get(position));
            holder.text2.setText(data6.get(position));
            holder.texts.setText(("Jumlah = " + jumlah2.get(position)));
            holder.totals.setText(("Total = Rp." + jumlah3.get(position)));
            holder.img.setImageResource(gambardata.get(position));
    }

    public int getItemCount() {
        return data5.size();
    }

    public static int total(){
        return total;
    }

    public static String qr(){
        return qr;
    }

    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
            View views = inflater.inflate(R.layout.cek2, parent, false);
            return new MyviewHolder(views);
        }

}
