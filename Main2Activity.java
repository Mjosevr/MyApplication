package com.example.mauvi.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Salir:
                System.exit(1);
                return true;
            case R.id.JuegoNormal:
                juegoNormal();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void juegoNormal() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void click(View view) {
        ImageButton button = (ImageButton) view;

        button.setImageResource(R.drawable.pescado);
        button.setBackgroundColor(getResources().getColor(R.color.rojo));
        Main2Activity.Contador contador = new Main2Activity.Contador( 2000,button);
        contador.start();
    }


    public void reiniciarFigura(ImageButton button){
        button.setImageResource(R.drawable.cubiertos);
        button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    public class Contador extends CountDownTimer {

        ImageButton button;
        public Contador(long tiempo, ImageButton button){
            super(tiempo, 1);
            this.button=button;
        }

        @Override
        public void onTick(long l){

        }

        @Override
        public void onFinish(){
            reiniciarFigura(button);
        }
    }
}
