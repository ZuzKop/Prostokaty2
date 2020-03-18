package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bitmap> rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ConstraintLayout layout = findViewById(R.id.layout); //zmienna layout, reprezentuje ona miejsce gdzie wrzucamy rzeczy z kodu na widok
        ImageView imageSquare = findViewById(R.id.imageViewSquare);//zmienna imageSquare, typu ImageView. Reprezentuje ona kwadracik w formie graficznej


        imageSquare.post(new Runnable() {
            @Override
            public void run() {

                ImageView imageRectangle = new ImageView(getApplicationContext()); //tworze nowa zmienna typu ImageView
                imageRectangle.setImageBitmap(createRectangle(2,2)); //ustawiam imageRectangle jako wynik funkcji createRectangle() o wymiarach 2x2 (przykladowe wartosci prostokata)
                layout.addView(imageRectangle);//do layout dodaje zmienna imageRectangle
            }

        });

    }

    //postaram sie stworzyc funkcje, ktora tworzy prostokaty z malych kwadratow i zwraca prostakat jako bitmapa
    private Bitmap createRectangle( int x, int y) {
        //x i y oraz sizeX i sizeY to wymiar prostokata ktory chcemy stworzyc z malych kwadratow
        int sizeX = x;
        int sizeY = y;


        ImageView squareImage = findViewById(R.id.imageViewSquare); //pobieram z activity_main obrazek z id imageViewSquare
        BitmapDrawable drawable = (BitmapDrawable) squareImage.getDrawable(); //pobiera obraz kwadratu do zmiennej typu BitmapDrawable

        //tworzymy dwie zmienne typu bitmapa, jedna "merged", druga "toMerge", kazda z nich zawiera obrazek square, co zostalo ustalone wczesniej
        Bitmap merged = drawable.getBitmap(); //tworzy typ Bitmap z typu BitmapDrawable powyzej
        Bitmap toMegre = merged.copy(merged.getConfig(), true);//kopiuje Bitmape merged do bitmapy toMerge

        //sizeX-1 razy laczymy bitmapy sposobem funkcja ktora trzeba napisac ponizej
        for(int i=0; i<sizeX-1; i++){
            //mergeHorizontally( merged, toMerge);
        }

        //po wykonaniu tej petli powinnismy miec rzadek o wymiarze x
        toMegre = merged.copy(merged.getConfig(), true); //kopiujemy ponownie merged do "toMerge"

        //sizeY-1 razy laczymy bitmapy
        for(int i=0; i<sizeY-1; i++){
            //mergeVertically(merged, toMerge);
        }

        //otrzymujemy bitmape zlozona z kwadratow o wymiarze x na y ktora mozemy zwrocic w return :)
        return merged;


    }
    //todo:
    //funkcja merge horizontaly: thread z stackOverflow jest w pliku TODO "funkcja na laczenie bitmap"
    public Bitmap mergeHorizontally( Bitmap a, Bitmap b){
        Bitmap ab = null;

        //todo

        return ab;
    }
    public Bitmap mergeHVertically( Bitmap a, Bitmap b){
        Bitmap ab = null;

        //todo

        return ab;
    }




}

