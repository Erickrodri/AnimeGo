package com.dap.animego.ui.View;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.dap.animego.R;
import com.dap.animego.retrofit.AnimeGoClient;
import com.dap.animego.retrofit.AnimeGoService;
import com.dap.animego.retrofit.request.RequestSingUp;
import com.dap.animego.retrofit.response.ResponseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccountActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextUser, editTextPassword;
    AnimeGoClient animeGoClient;
    AnimeGoService animeGoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);

        retrofitInit();
        findViews();
    }

    private void retrofitInit() {
        animeGoClient = AnimeGoClient.getInstance();
        animeGoService = animeGoClient.getAnimeGoService();
    }

    private void findViews() {
        editTextEmail    = findViewById(R.id.emailSingUp);
        editTextUser     = findViewById(R.id.userNameSingUp);
        editTextPassword = findViewById(R.id.passwordSingUp);
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void btnSingUp(View view){
        goToSingUp();
    }

    private void goToSingUp() {
        String email = editTextEmail.getText().toString();
        String username = editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();

        if(email.isEmpty()){
            editTextEmail.setError("El Email es requerido");
        }else if(username.isEmpty()){
            editTextUser.setError("El Nombre de usuario es requerido");
        }else if(password.isEmpty() || password.length() < 4){
            editTextPassword.setError("La Contraseña es requerida y tiene que tener mas de 4 caracteres");
        }else{
            String rol = "USER";
            RequestSingUp requestSingUp = new RequestSingUp(username, email, password, rol);
            Call<ResponseAuth> call = animeGoService.doSingUp(requestSingUp);

            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if(response.isSuccessful()){
                        Intent intent = new Intent(CreateAccountActivity.this, ContainerActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(CreateAccountActivity.this, "Algo ha ido mal intente nuevamente", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(CreateAccountActivity.this, "Error en la conexion", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
