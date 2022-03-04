package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton x, o;
    private TableLayout table;
    int statusGame;

    String contentTable [][] = {
            {"0", "1", "2"},
            {"3", "4", "5"},
            {"6", "7", "8"}

    };

    private ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = findViewById(R.id.tableLayout);
        x = findViewById(R.id.radioBtnX);
        o = findViewById(R.id.radioBtnO);

        //Buttons
        btn1 = findViewById(R.id.imageButton2);
        btn2 = findViewById(R.id.imageButton);
        btn3 = findViewById(R.id.imageButton3);
        btn4 = findViewById(R.id.imageButton4);
        btn5 = findViewById(R.id.imageButton5);
        btn6 = findViewById(R.id.imageButton6);
        btn7 = findViewById(R.id.imageButton7);
        btn8 = findViewById(R.id.imageButton8);
        btn9 = findViewById(R.id.imageButton9);
    }

    public void cambiarBtn(View view) {
        ImageButton btn = (ImageButton) view;

        Drawable imgDrawable = btn.getDrawable();


        if (x.isChecked()){
            btn.setImageResource(R.mipmap.cruz);
            x.setChecked(false);
            o.setChecked(true);
            btn.setContentDescription("X");
        }else{
            btn.setImageResource(R.mipmap.cero);
            x.setChecked(true);
            o.setChecked(false);
            btn.setContentDescription("O");
        }

        view.setEnabled(false);

        statusGame = isWinner();

        if (statusGame == 1) {
            Toast.makeText(this, "EL GANADOR ES X",Toast.LENGTH_SHORT).show();
            reset();
        }
        else if (statusGame == 2){
            Toast.makeText(this, "EL GANADOR ES O",Toast.LENGTH_SHORT).show();
            reset();
        }
        else if ( statusGame == 3){
            Toast.makeText(this, "EMPATE",Toast.LENGTH_SHORT).show();
            reset();
        }

    }

    public int isWinner() {
        //COLUMNAS
        if(btn1.getContentDescription() == "X" && btn4.getContentDescription() == "X" && btn7.getContentDescription() == "X"){
            return 1;
        }
        else if (btn2.getContentDescription() == "X" && btn5.getContentDescription() == "X" && btn8.getContentDescription() == "X"){
            return 1;
        }
        else if (btn3.getContentDescription() == "X" && btn6.getContentDescription() == "X" && btn9.getContentDescription() == "X"){
            return 1;
        }
        if(btn1.getContentDescription() == "O" && btn4.getContentDescription() == "O" && btn7.getContentDescription() == "O"){
            return 2;
        }
        else if (btn2.getContentDescription() == "O" && btn5.getContentDescription() == "O" && btn8.getContentDescription() == "O"){
            return 2;
        }
        else if (btn3.getContentDescription() == "O" && btn6.getContentDescription() == "O" && btn9.getContentDescription() == "O"){
            return 2;
        }//FILAS
        else if (btn1.getContentDescription() == "X" && btn2.getContentDescription() == "X" && btn3.getContentDescription() == "X"){
            return 1;
        }
        else if (btn4.getContentDescription() == "X" && btn5.getContentDescription() == "X" && btn6.getContentDescription() == "X"){
            return 1;
        }
        else if (btn7.getContentDescription() == "X" && btn8.getContentDescription() == "X" && btn9.getContentDescription() == "X"){
            return 1;
        }
        else if (btn1.getContentDescription() == "O" && btn2.getContentDescription() == "O" && btn3.getContentDescription() == "O"){
            return 2;
        }
        else if (btn4.getContentDescription() == "O" && btn5.getContentDescription() == "O" && btn6.getContentDescription() == "O"){
            return 2;
        }
        else if (btn7.getContentDescription() == "O" && btn8.getContentDescription() == "O" && btn9.getContentDescription() == "O"){
            return 2;
        }//DIAGONALES
        else if (btn1.getContentDescription() == "X" && btn5.getContentDescription() == "X" && btn9.getContentDescription() == "X"){
            return 1;
        }
        else if (btn3.getContentDescription() == "X" && btn5.getContentDescription() == "X" && btn7.getContentDescription() == "X"){
            return 1;
        }
        else if (btn1.getContentDescription() == "O" && btn5.getContentDescription() == "O" && btn9.getContentDescription() == "O"){
            return 2;
        }
        else if (btn3.getContentDescription() == "O" && btn5.getContentDescription() == "O" && btn7.getContentDescription() == "O"){
            return 2;
        }
        else if (!btn1.isEnabled() && !btn2.isEnabled() && !btn3.isEnabled() && !btn4.isEnabled() && !btn5.isEnabled() && !btn6.isEnabled() == !btn7.isEnabled() && !btn8.isEnabled() && !btn9.isEnabled()){
            return 3;
        }
        else {
            return 5;
        }

    }

    public void reset(){
        btn1.setImageResource(R.mipmap.squere);
        btn2.setImageResource(R.mipmap.squere);
        btn3.setImageResource(R.mipmap.squere);

        btn4.setImageResource(R.mipmap.squere);
        btn5.setImageResource(R.mipmap.squere);
        btn6.setImageResource(R.mipmap.squere);

        btn7.setImageResource(R.mipmap.squere);
        btn8.setImageResource(R.mipmap.squere);
        btn9.setImageResource(R.mipmap.squere);

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);

        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);

        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);

        btn1.setContentDescription(" ");
        btn2.setContentDescription(" ");
        btn3.setContentDescription(" ");

        btn4.setContentDescription(" ");
        btn5.setContentDescription(" ");
        btn6.setContentDescription(" ");

        btn7.setContentDescription(" ");
        btn8.setContentDescription(" ");
        btn9.setContentDescription(" ");


    }

}