package com.example.quizgilang;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;


public class DetailActivity extends AppCompatActivity {

    private TextView txtNik, txtNama, txtJK, txtTempat, txtTanggal, txtAlamat, txtEmail, txtPhone, txtGreeting;
    private ImageView imgBack;

    private void initUI(){
        txtNik = findViewById(R.id.txt_nik);
        txtNama = findViewById(R.id.txt_nama);
        txtJK = findViewById(R.id.txt_jk);
        txtTempat = findViewById(R.id.txt_tempat);
        txtTanggal = findViewById(R.id.txt_tanggal_lahir);
        txtAlamat = findViewById(R.id.txt_alamat);
        txtEmail = findViewById(R.id.txt_email);
        txtPhone = findViewById(R.id.txt_phone);
        txtGreeting = findViewById(R.id.txt_greeting);
        imgBack = findViewById(R.id.D_img_back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initUI();

        imgBack.setOnClickListener(view -> {
            onBackPressed();
        });

        Intent intent = getIntent();
        if (intent != null) {
            String nik = intent.getStringExtra("NIK");
            String nama = intent.getStringExtra("Nama");
            String jk = intent.getStringExtra("JenisKelamin");
            String tempatLahir = intent.getStringExtra("TempatLahir");
            String tanggalLahir = intent.getStringExtra("TanggalLahir");
            String alamat = intent.getStringExtra("Alamat");
            String email = intent.getStringExtra("Email");
            String nomorTelp = intent.getStringExtra("NomorTelp");

            txtGreeting.setText("Halo! " +  nama + ", Berikut data-data milikmu");
            txtNik.setText("NIK : " + nik);
            txtNama.setText("Nama : " + nama);
            txtJK.setText("Jenis Kelamin : " + jk);
            txtTempat.setText("Tempat Lahir : " + tempatLahir);
            txtTanggal.setText("Tanggal Lahir : " + tanggalLahir);
            txtAlamat.setText("Alamat : " + alamat);
            txtEmail.setText("Email : " + email);
            txtPhone.setText("Nomor Telepon : " + nomorTelp);
        }

    }
}