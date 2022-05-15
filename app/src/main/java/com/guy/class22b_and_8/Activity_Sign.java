package com.guy.class22b_and_8;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Activity_Sign extends AppCompatActivity {

    private MaterialTextView sign_LBL_info;
    private MaterialButton sign_BTN_user;
    private MaterialButton sign_BTN_sign;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        sign_LBL_info = findViewById(R.id.sign_LBL_info);
        sign_BTN_user = findViewById(R.id.sign_BTN_user);
        sign_BTN_sign = findViewById(R.id.sign_BTN_sign);

        mAuth = FirebaseAuth.getInstance();

        sign_BTN_user.setOnClickListener(view -> updateUI());
        sign_BTN_sign.setOnClickListener(view -> signIn());
    }

    private void signIn() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build()
        );

        Intent signInIntent =
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.headache)
                        .setTosAndPrivacyPolicyUrls("https://firebase.google.com/docs/auth/android/firebaseui?hl=en&authuser=0", "https://firebase.google.com/docs/auth/android/firebaseui?hl=en&authuser=0")
                        .build();
        signInLauncher.launch(signInIntent);
    }

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse r = result.getIdpResponse();

        FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
//        Log.d("pttt", result.getIdpResponse().getProviderType() + "\n" + result.getIdpResponse());
    }

    private void updateUI() {
        FirebaseUser user = mAuth.getCurrentUser();

        String str = "USER:\n";
        if (user != null) {
            str += "\n" + user.getUid();
            str += "\n" + user.getDisplayName();
            str += "\n" + user.isEmailVerified();
            str += "\n" + user.getPhoneNumber();
        }
        sign_LBL_info.setText(str);
    }


}