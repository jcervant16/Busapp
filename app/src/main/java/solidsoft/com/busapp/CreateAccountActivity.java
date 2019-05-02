package solidsoft.com.busapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_title_create_account),true);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextView txEmail = findViewById(R.id.email);
        final TextView txName = findViewById(R.id.name);
        final TextView txPass = findViewById(R.id.confirmPass);
        final TextView txConfirmPass = findViewById(R.id.confirmPass);

        Button btnCrear = findViewById(R.id.unete);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txEmail.getText().toString();
                String name = txName.getText().toString();
                String pass = txPass.getText().toString();
                String confirmPass = txConfirmPass.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.messageToastEmailEmpty),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(confirmPass)){
                    if(pass.isEmpty()){
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.messageToastInvalidPass),
                                Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

            }
        });

    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
