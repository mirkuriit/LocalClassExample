package com.example.localclassexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= findViewById(R.id.button);
        EditText editText = findViewById(R.id.et);
        TextView names_tv, surnames_tv, patronymics_tv;
        names_tv = findViewById(R.id.names_tv);
        surnames_tv = findViewById(R.id.surnames_tv);
        patronymics_tv = findViewById(R.id.patronymics_tv);
        class A {
            class B {
                String[] str;

                public B(String content) {
                    this.str = content.split(" ");
                }

                String division_of_names(String[] strAr) {
                    String names = "";
                    for (int i = 0; i < strAr.length; i += 3) {
                        names += " "+strAr[i];
                    }
                    return names;
                }

                String division_of_surnames(String[] strAr) {
                    String surnames = "";
                    for (int i = 1; i < strAr.length; i += 3) {
                        surnames += " "+strAr[i];
                    }
                    return surnames;
                }

                String division_of_patronymics(String[] strAr) {
                    String patronymics = "";
                    for (int i = 2; i < strAr.length; i += 3) {
                        patronymics += " "+ strAr[i] ;
                    }
                    return patronymics;
                }
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString();
                A a = new A();
                A.B b = a.new B(content);
                names_tv.setText(b.division_of_names(b.str));
                surnames_tv.setText(b.division_of_surnames(b.str));
                patronymics_tv.setText(b.division_of_patronymics(b.str));
            }
        });
    }
}