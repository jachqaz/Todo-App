package co.devhack.todoapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.SignUpContract;
import co.devhack.todoapp.presentation.presenter.SignUpPresenter;
import co.devhack.todoapp.presentation.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View, View.OnClickListener {
    private SignUpContract.UserActionsListener mActionsListener;
    private TextInputLayout tilNombre;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private Button btnSignup;
    private Button btnIhaveaccount;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        mActionsListener = new SignUpPresenter(this);
        tilEmail = view.findViewById(R.id.sigtilEmail);
        tilNombre = view.findViewById(R.id.sigtilNombre);
        tilPassword = view.findViewById(R.id.sigtilPassword);
        btnSignup = view.findViewById(R.id.btnsignup);
        btnIhaveaccount = view.findViewById(R.id.btnIHaveAccount);
        //Recibir eventos de los botones
        btnSignup.setOnClickListener(this);
        btnIhaveaccount.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnsignup:
                signUp();
                break;
            case R.id.btnIHaveAccount:
                goToLoginFragment();
                break;
        }
    }

    private void signUp() {
        try {
            boolean result = true;
            String fullName = tilNombre.getEditText().getText().toString();
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();

            if (Utilities.isEmpty(fullName)) {
                tilNombre.setError(getString(R.string.is_required));
                tilNombre.setErrorEnabled(true);
                result = false;
            } else {
                tilNombre.setError(null);
                tilNombre.setErrorEnabled(false);
            }

            if (Utilities.isEmpty(email)) {
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            } else {
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if (Utilities.isEmpty(password)) {
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result = false;
            } else {
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            //Si la validaciones no generaron errores
            if (result) {
                mActionsListener.onSignUp(fullName, email, password);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void goToLoginFragment() {

        getFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessageError(Exception error) {
        Log.d("Mostrar", error.getMessage());
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }


}
