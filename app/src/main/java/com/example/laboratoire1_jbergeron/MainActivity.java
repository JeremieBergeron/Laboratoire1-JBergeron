package com.example.laboratoire1_jbergeron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btn_ValiderMdP(View view) {
        Button btn_ValiderMdP = (Button) findViewById(R.id.btn_ValiderMdP);
        EditText et_motDePasse = (EditText) findViewById(R.id.et_motDePasse);
        TextView tv_afficherMessage = (TextView) findViewById(R.id.tv_afficherMessage);

        boolean contientCaractereValide = et_motDePasse.getText().toString().matches("^[A-Za-z0-9@#$%&\\(\\)\\[\\]\\{\\}\\_\\=\\<\\>\\+\\-\\!\\?\\*\\/\\|\\:\\;\\.\\,\\‘\"\\~\\^]*$");
        boolean contientCaractereSpeciaux = et_motDePasse.getText().toString().matches(".*[@#$%&\\(\\)\\[\\]\\{\\}\\_\\=\\<\\>\\+\\-\\!\\?\\*\\/\\|\\:\\;\\.\\,\\‘\"\\~\\^]+.*");
        boolean longueurValide = et_motDePasse.getText().toString().length() >= 10;
        boolean majusculePresente = et_motDePasse.getText().toString().matches(".*[A-Z]+.*");
        boolean minusculePresente = et_motDePasse.getText().toString().matches(".*[a-z]+.*");
        boolean chiffrePresent = et_motDePasse.getText().toString().matches(".*[0-9]+.*");

        if (contientCaractereSpeciaux && longueurValide && majusculePresente && minusculePresente && chiffrePresent && contientCaractereValide) {
            tv_afficherMessage.setText(getResources().getText(R.string.mdpValide));
            tv_afficherMessage.setTextColor(getResources().getColor(R.color.vert));

        } else {
            tv_afficherMessage.setText(getResources().getText(R.string.mdpInvalide));
            tv_afficherMessage.setTextColor(getResources().getColor(R.color.rouge));

        }
    }

    public void onClick_chk_afficherMdP(View view) {
        CheckBox chk_afficherMdP = (CheckBox) findViewById(R.id.chk_afficherMdP);
        EditText et_motDePasse = (EditText) findViewById(R.id.et_motDePasse);

        if (chk_afficherMdP.isChecked()) {
            et_motDePasse.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            et_motDePasse.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }


}