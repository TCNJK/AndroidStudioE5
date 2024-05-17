package com.example.androidstudioe5;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CaculatorListener extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caculator_listener);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculator('+');
            }
        });

        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculator('-');
            }
        });

        findViewById(R.id.mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculator('*');
            }
        });

        findViewById(R.id.div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculator('/');
            }
        });
    }

    private void caculator(char type){
        Double number1 = checkNumberValid(num1.getText().toString());
        Double number2 = checkNumberValid(num2.getText().toString());

        if (number1 == null || number2 == null){
            result.setText("Invalid input");
            return;
        }
        Double value = calculator(number1, number2, type);
        result.setText(String.format("%.3f", value));
    }

    private Double checkNumberValid(String numberString){
        try{
            if (numberString.isEmpty()){
                return 0.0;
            }
            Double number = Double.parseDouble(numberString);
            return number;
        }
        catch (Exception exception){
            return null;
        }
    }
    private Double calculator(Double number1, Double number2, char type){
        switch (type){
            case '+': return number1+number2;
            case '-': return number1-number2;
            case '*': return number1*number2;
            case '/': return number1/number2;
        }
        return 0.0;
    }
}