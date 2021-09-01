package com.dap.animego.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dap.animego.R;
import com.dap.animego.common.Constantes;
import com.dap.animego.common.SharedPreferencesManager;
import com.dap.animego.retrofit.AnimeGoClient;
import com.dap.animego.retrofit.AnimeGoService;
import com.dap.animego.retrofit.request.RequestLogin;
import com.dap.animego.retrofit.response.ResponseAuth;
import com.dap.animego.ui.View.ContainerActivity;
import com.dap.animego.ui.View.CreateAccountActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    AnimeGoClient animeGoClient;
    AnimeGoService animeGoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofitInit();
        findViews();
    }

    private void retrofitInit() {
        animeGoClient = AnimeGoClient.getInstance();
        animeGoService = animeGoClient.getAnimeGoService();
    }

    private void findViews() {
        editTextEmail    = findViewById(R.id.emailLogin);
        editTextPassword = findViewById(R.id.passwordLogin);
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContentHome(View view){
        goToLogin();
    }

    private void goToLogin() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(email.isEmpty()){
            editTextEmail.setError("El email es requerido");
        }else if(password.isEmpty()){
            editTextPassword.setError("El password es requerido");
        }else{
            RequestLogin requestLogin = new RequestLogin(email, password);

            Call<ResponseAuth> call =  animeGoService.doLogin(requestLogin);

            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Sesion iniciada correctamente", Toast.LENGTH_SHORT).show();

                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_TOKEN,response.body().getToken());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_USERNAME,response.body().getUsername());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_PHOTOURL,response.body().getPhotoUrl());

                        Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Algo salio mal Revise sus datos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error de conexion", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
