package com.mifo.mifo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyviewHolder> {

    String[] data1 = {"a","a","a","a","a"}; //nama
    String[] data2 = {"a","a","a","a","a"}; //harga
    int []data3; //gambar
    int []datagambar;//gambar2
    int []jumlah ={0,0,0,0,0}; //jumlah
    int dataid;
    Context context;
    Button button1,button2;
    dbhelpe dbs;

    //Data untuk inflater
    public Adapter(Context c,int []b,int idm){
        context = c;
        data3 = b;
        dataid = idm;
        dbs = new dbhelpe(c);

        if (idm == 1){
            for (int i = 1 ;i < 6;i++){
                data1[i-1] = dbs.ambildatanama(i);
                data2[i-1]= "Rp. "+ (dbs.ambildataharga(i));
                jumlah[i-1] = dbs.jumlah(i);
            }
        }
        if (idm == 2){
            for (int i = 1 ;i < 6;i++){
                data1[i-1] = dbs.ambildatanama(i+5);
                data2[i-1]= "Rp. "+ (dbs.ambildataharga(i+5));
                jumlah[i-1] = dbs.jumlah(i+5);
            }
        }
        if (idm == 3){
            for (int i = 1 ;i < 6;i++){
                data1[i-1] = dbs.ambildatanama(i+10);
                data2[i-1]= "Rp. "+ (dbs.ambildataharga(i+10));
                jumlah[i-1] = dbs.jumlah(i+10);
            }
        }
        if (idm == 4){
            for (int i = 1 ;i < 6;i++){
                data1[i-1] = dbs.ambildatanama(i+15);
                data2[i-1]= "Rp. "+ (dbs.ambildataharga(i+15));
                jumlah[i-1] = dbs.jumlah(i+15);
            }
        }

    }

    //create view holder
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.row,parent,false);
            return new MyviewHolder(view);
    }
    // inflate
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
            holder.text1.setText(data1[position]);
            holder.text2.setText(data2[position]);
            holder.texts.setText(String.valueOf(jumlah[position]));
            holder.img.setImageResource(data3[position]);
    }
    //count
    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView text1,text2,texts,totals;
        ImageView img;

        public MyviewHolder (@NonNull View itemView){
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            texts = itemView.findViewById(R.id.jumlah);
            totals = itemView.findViewById(R.id.jumlah2);
            img = itemView.findViewById(R.id.imgview);
            if (dataid != 5){
                button1 = itemView.findViewById(R.id.tambah);
                button2 = itemView.findViewById(R.id.kurang);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (dataid == 1){
                            String text2s = String.valueOf(dbs.ambiljumlah(getPosition()+1));
                            texts.setText(text2s);
                        }
                        if (dataid == 2){
                            String text2s = String.valueOf(dbs.ambiljumlah(getPosition()+6));
                            texts.setText(text2s);
                        }
                        if (dataid == 3){
                            String text2s = String.valueOf(dbs.ambiljumlah(getPosition()+11));
                            texts.setText(text2s);
                        }
                        if (dataid == 4){
                            String text2s = String.valueOf(dbs.ambiljumlah(getPosition()+16));
                            texts.setText(text2s);
                        }

                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dataid == 1 && dbs.jumlah(getPosition()+1) > 0){
                            String text2s = String.valueOf(dbs.kurangjumlah(getPosition()+1));
                            texts.setText(text2s);
                        }
                        if (dataid == 2 && dbs.jumlah(getPosition()+6) > 0){
                            String text2s = String.valueOf(dbs.kurangjumlah(getPosition()+6));
                            texts.setText(text2s);
                        }
                        if (dataid == 3 && dbs.jumlah(getPosition()+11) > 0){
                            String text2s = String.valueOf(dbs.kurangjumlah(getPosition()+11));
                            texts.setText(text2s);
                        }
                        if (dataid == 4 && dbs.jumlah(getPosition()+16) > 0){
                            String text2s = String.valueOf(dbs.kurangjumlah(getPosition()+16));
                            texts.setText(text2s);
                        }
                    }
                });
            }
        }
    }



}
