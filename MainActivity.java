package com.example.mauvi.myapplication;

import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import static com.example.mauvi.myapplication.R.color.colorPrimary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.salir:
                System.exit(1);
                return true;
            case R.id.juego:
                juegoAvanzado();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void juegoAvanzado() {
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void click(View view) {
        ImageButton button = (ImageButton) view;
        Contador contador  = new Contador( 2000,button);;
        switch (view.getId()){
            case R.id.imageButton1:
                button.setImageResource(R.drawable.pescado);
                button.setBackgroundColor(getResources().getColor(R.color.rojo));
                contador.start();
                break;
            case R.id.imageButton2:
                button.setImageResource(R.drawable.calabaza);
                button.setBackgroundColor(getResources().getColor(R.color.rojo));
                contador.start();
                break;
            case R.id.imageButton3:
                button.setImageResource(R.drawable.hamburguesa);
                button.setBackgroundColor(getResources().getColor(R.color.rojo));
                contador.start();
                break;
            case R.id.imageButton4:
                button.setImageResource(R.drawable.huevo);
                button.setBackgroundColor(getResources().getColor(R.color.rojo));
                contador.start();
                break;
            case R.id.imageButton5:
                button.setImageResource(R.drawable.piza);
                contador.start();
                break;
            case R.id.imageButton6:
                button.setImageResource(R.drawable.huevo);
                contador.start();
                break;
            case R.id.imageButton7:
                button.setImageResource(R.drawable.hamburguesa);
                contador.start();
                break;
            case R.id.imageButton8:
                button.setImageResource(R.drawable.calabaza);
                contador.start();
                break;
            case R.id.imageButton9:
                button.setImageResource(R.drawable.pescado);
                contador.start();
                break;
            default:
                break;
        }

    }

    public void reiniciarFigura(ImageButton button){
        button.setImageResource(R.drawable.cubiertos);
    }

    public class Contador extends CountDownTimer{

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
