package com.example.mauvi.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import static com.example.mauvi.myapplication.R.color.colorPrimary;

public class MainActivity extends AppCompatActivity {

    ImageButton im1,im2,im3,im4,im5,im6,im7,im8,im9;
    Integer[] cartasArreglo = {10,11,12,13,14,15,16,17,18};
    int image1,image2,image3,image4,image5,image6,image7,image8,image9;

    int primeraCarta, segundaCarta;
    int primerClick, segundoClick;
    int numeroCarta = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im1 = (ImageButton) findViewById(R.id.imageButton1);im1.setTag("1");
        im2 = (ImageButton) findViewById(R.id.imageButton2);im2.setTag("2");
        im3 = (ImageButton) findViewById(R.id.imageButton3);im3.setTag("3");
        im4 = (ImageButton) findViewById(R.id.imageButton4);im4.setTag("4");
        im5 = (ImageButton) findViewById(R.id.imageButton5);im5.setTag("5");
        im6 = (ImageButton) findViewById(R.id.imageButton6);im6.setTag("6");
        im7 = (ImageButton) findViewById(R.id.imageButton7);im7.setTag("7");
        im8 = (ImageButton) findViewById(R.id.imageButton8);im8.setTag("8");
        im9 = (ImageButton) findViewById(R.id.imageButton9);im9.setTag("9");

        cargaCartas();
        Collections.shuffle(Arrays.asList(cartasArreglo));
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

    private void cargaCartas(){
        image1= R.drawable.calabaza;
        image2= R.drawable.sandia;
        image3= R.drawable.salchicha;
        image4= R.drawable.pollo;
        image5= R.drawable.piza;
        image6= R.drawable.pescado;
        image7= R.drawable.papas;
        image8= R.drawable.huevo;
        image9= R.drawable.hamburguesa;
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
                int carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im1,carta);
                contador.start();
                break;
            case R.id.imageButton2:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im2,carta);
                contador.start();
                break;
            case R.id.imageButton3:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im3,carta);
                contador.start();
                break;
            case R.id.imageButton4:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im4,carta);
                contador.start();
                break;
            case R.id.imageButton5:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im5,carta);
                contador.start();
                break;
            case R.id.imageButton6:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im6,carta);
                contador.start();
                break;
            case R.id.imageButton7:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im7,carta);
                contador.start();
                break;
            case R.id.imageButton8:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im8,carta);
                contador.start();
                break;
            case R.id.imageButton9:
                carta = Integer.parseInt((String) view.getTag());
                desarrolloJuego(im9,carta);
                contador.start();
                break;
            default:
                break;
        }

    }

    public void desarrolloJuego(ImageButton image,int carta) {
        if(cartasArreglo[carta] == 10){image.setImageResource(image1);      //1
        }else if(cartasArreglo[carta] == 11){image.setImageResource(image2);//2
        }else if(cartasArreglo[carta] == 12){image.setImageResource(image3);//3
        }else if(cartasArreglo[carta] == 13){image.setImageResource(image4);//1
        }else if(cartasArreglo[carta] == 14){image.setImageResource(image5);//2
        }else if(cartasArreglo[carta] == 15){image.setImageResource(image6);//3
        }else if(cartasArreglo[carta] == 16){image.setImageResource(image7);//1
        }else if(cartasArreglo[carta] == 17){image.setImageResource(image8);//2
        }else if(cartasArreglo[carta] == 18){image.setImageResource(image9);}//3

        if(numeroCarta == 1){
            primeraCarta=cartasArreglo[carta];
            if(primeraCarta > 13){
                primeraCarta = primeraCarta - 3;
            }
            numeroCarta = 2;
            primerClick = carta;

            image.setEnabled(false);
        }else if (numeroCarta == 2){
            segundaCarta=cartasArreglo[carta];
            if(segundaCarta > 13){
                segundaCarta = segundaCarta - 3;
            }
            numeroCarta = 1;
            segundoClick = carta;

            im1.setEnabled(false);im2.setEnabled(false);
            im3.setEnabled(false);im4.setEnabled(false);
            im5.setEnabled(false);im6.setEnabled(false);
            im7.setEnabled(false);im8.setEnabled(false);
            im9.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calcular();
                }
            }, 1000);
        }
    }

    private void calcular(){
        if(primeraCarta==segundaCarta){
            if(primerClick==0){im1.setVisibility(View.INVISIBLE);
            }else if(primerClick==1){im2.setVisibility(View.INVISIBLE);
            }else if(primerClick==2){im3.setVisibility(View.INVISIBLE);
            }else if(primerClick==3){im4.setVisibility(View.INVISIBLE);
            }else if(primerClick==4){im5.setVisibility(View.INVISIBLE);
            }else if(primerClick==5){im6.setVisibility(View.INVISIBLE);
            }else if(primerClick==6){im7.setVisibility(View.INVISIBLE);
            }else if(primerClick==7){im8.setVisibility(View.INVISIBLE);
            }else if(primerClick==8){im9.setVisibility(View.INVISIBLE);}


            if(segundoClick==0){im1.setVisibility(View.INVISIBLE);
            }else if(segundoClick==1){im2.setVisibility(View.INVISIBLE);
            }else if(segundoClick==2){im3.setVisibility(View.INVISIBLE);
            }else if(segundoClick==3){im4.setVisibility(View.INVISIBLE);
            }else if(segundoClick==4){im5.setVisibility(View.INVISIBLE);
            }else if(segundoClick==5){im6.setVisibility(View.INVISIBLE);
            }else if(segundoClick==6){im7.setVisibility(View.INVISIBLE);
            }else if(segundoClick==7){im8.setVisibility(View.INVISIBLE);
            }else if(segundoClick==8){im9.setVisibility(View.INVISIBLE);}
        }else {
            im1.setImageResource(R.drawable.cubiertos);
            im2.setImageResource(R.drawable.cubiertos);
            im3.setImageResource(R.drawable.cubiertos);
            im4.setImageResource(R.drawable.cubiertos);
            im5.setImageResource(R.drawable.cubiertos);
            im6.setImageResource(R.drawable.cubiertos);
            im7.setImageResource(R.drawable.cubiertos);
            im8.setImageResource(R.drawable.cubiertos);
            im9.setImageResource(R.drawable.cubiertos);
        }

        im1.setEnabled(true);
        im2.setEnabled(true);
        im3.setEnabled(true);
        im4.setEnabled(true);
        im5.setEnabled(true);
        im6.setEnabled(true);
        im7.setEnabled(true);
        im8.setEnabled(true);
        im9.setEnabled(true);

        salir();
    }

    public void salir(){
        if (im1.getVisibility() == View.INVISIBLE &&
                im2.getVisibility() == View.INVISIBLE &&
                im3.getVisibility() == View.INVISIBLE &&
                im4.getVisibility() == View.INVISIBLE &&
                im5.getVisibility() == View.INVISIBLE &&
                im6.getVisibility() == View.INVISIBLE &&
                im7.getVisibility() == View.INVISIBLE &&
                im8.getVisibility() == View.INVISIBLE &&
                im9.getVisibility() == View.INVISIBLE ){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("JUEGO TERMINADO! \n" );
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
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
