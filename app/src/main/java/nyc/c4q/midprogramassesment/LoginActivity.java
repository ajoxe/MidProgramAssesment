package nyc.c4q.midprogramassesment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String SHARED_PREFS_KEY = "sharedPrefsLogin";
    private SharedPreferences login;
    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private String defaultUser = "user@aol.com";
    private String defaultPassword = "password1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.edittext_login_email);
        password = (EditText) findViewById(R.id.edittext_login_password);
        checkBox = (CheckBox) findViewById(R.id.remember_me_checkbox);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        if (login.getBoolean("isChecked", true)) {
            username.setText(login.getString("username", null));
            password.setText(login.getString("password", null));
            checkBox.setChecked(login.getBoolean("isChecked", false));
        }
//        editor.commit();

    }

    public void submitButtonClick(View view) {
        /*//TODO Check to see this works
        SharedPreferences.Editor editor = login.edit();
        if (checkBox.isChecked()) {
            editor.putString("username", username.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.putBoolean("isChecked", checkBox.isChecked());
            editor.commit();
        } else {
            editor.putBoolean("isChecked", checkBox.isChecked());
            editor.commit();
        }

        String checkUser = defaultUser;
        String checkPassword = defaultPassword;

        if (username.getText().toString().equalsIgnoreCase(login.getString(checkUser, null))
                && password.getText().toString().equals(login.getString(checkPassword, null))) {
        }*/

        SharedPreferences.Editor editor = login.edit();
        editor.putBoolean("isChecked", checkBox.isChecked());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();

        if (username.getText().toString().equalsIgnoreCase(defaultUser) && password.getText().toString().equals(defaultPassword)) {
            Intent listActivityIntent = new Intent(LoginActivity.this, ListActivity.class);
            listActivityIntent.putExtra("currentUser", username.getText().toString());
            startActivity(listActivityIntent);
        }


//        Intent listActivityIntent = new Intent(LoginActivity.this, ListActivity.class);
//        listActivityIntent.putExtra("currentUser", username.getText().toString());
//        startActivity(listActivityIntent);
    }
}
