package com.example.quizgilang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrasiActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText editNik, editNama, editTempat, editAlamat, editEmail, editNomor;
    private RadioButton rbLaki;
    private DatePicker dateLahir;
    private ImageView imgBack;

    private void initUI(){
        btnSubmit = findViewById(R.id.btn_submit);
        editNik = findViewById(R.id.edit_nik);
        editNama = findViewById(R.id.edit_nama);
        editTempat = findViewById(R.id.edit_tempat_lahir);
        editAlamat = findViewById(R.id.edit_alamat);
        editEmail = findViewById(R.id.edit_email);
        editNomor = findViewById(R.id.edit_nomor_telp);
        rbLaki = findViewById(R.id.rd_laki);
        dateLahir = findViewById(R.id.datePicker);
        imgBack = findViewById(R.id.img_back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrasi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initUI();

        imgBack.setOnClickListener(view -> {
            onBackPressed();
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = editNik.getText().toString();
                String nama = editNama.getText().toString();
                String tempatLahir = editTempat.getText().toString();
                String alamat = editAlamat.getText().toString();
                String email = editEmail.getText().toString();
                String nomorTelp = editNomor.getText().toString();
                String jenisKelamin = rbLaki.isChecked() ? "Laki-laki" : "Perempuan";

                int day = dateLahir.getDayOfMonth();
                int month = dateLahir.getMonth() + 1;
                int year = dateLahir.getYear();
                String tanggalLahir = day + "/" + month + "/" + year;

                if (nik.isEmpty() || nama.isEmpty() || tempatLahir.isEmpty() || alamat.isEmpty() || email.isEmpty() || nomorTelp.isEmpty()) {
                    Toast.makeText(RegistrasiActivity.this, "Semua data harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegistrasiActivity.this, DetailActivity.class);

                    intent.putExtra("NIK", nik);
                    intent.putExtra("Nama", nama);
                    intent.putExtra("TempatLahir", tempatLahir);
                    intent.putExtra("TanggalLahir", tanggalLahir);
                    intent.putExtra("Alamat", alamat);
                    intent.putExtra("Email", email);
                    intent.putExtra("NomorTelp", nomorTelp);
                    intent.putExtra("JenisKelamin", jenisKelamin);

                    startActivity(intent);
                }


            }
        });

    }
}