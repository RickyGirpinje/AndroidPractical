package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserDataActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText, streetEditText, emailEditText, countryEditText, idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        nameEditText = findViewById(R.id.editTextName);
        phoneEditText = findViewById(R.id.editTextPhone);
        streetEditText = findViewById(R.id.editTextStreet);
        emailEditText = findViewById(R.id.editTextEmail);
        countryEditText = findViewById(R.id.editTextCountry);
        idEditText = findViewById(R.id.editTextId);

        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });

        loadUserData(); // Load previously saved data, if any
    }

    private void saveUserData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String street = streetEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String country = countryEditText.getText().toString();
        String id = idEditText.getText().toString();

        editor.putString("user_name", name);
        editor.putString("user_phone", phone);
        editor.putString("user_street", street);
        editor.putString("user_email", email);
        editor.putString("user_country", country);
        editor.putString("user_id", id);

        editor.apply();

        Toast.makeText(this, "User data saved", Toast.LENGTH_SHORT).show();
    }

    private void loadUserData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String name = sharedPreferences.getString("user_name", "");
        String phone = sharedPreferences.getString("user_phone", "");
        String street = sharedPreferences.getString("user_street", "");
        String email = sharedPreferences.getString("user_email", "");
        String country = sharedPreferences.getString("user_country", "");
        String id = sharedPreferences.getString("user_id", "");

        nameEditText.setText(name);
        phoneEditText.setText(phone);
        streetEditText.setText(street);
        emailEditText.setText(email);
        countryEditText.setText(country);
        idEditText.setText(id);
    }
}
