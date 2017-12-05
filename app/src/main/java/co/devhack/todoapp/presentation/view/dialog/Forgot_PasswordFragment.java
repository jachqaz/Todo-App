package co.devhack.todoapp.presentation.view.dialog;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.Forgot_PasswordContract;
import co.devhack.todoapp.presentation.presenter.Forgot_PasswordPrensenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Forgot_PasswordFragment extends DialogFragment implements Forgot_PasswordContract.View, View.OnClickListener {
    private Forgot_PasswordContract.UserActionsListener mActionListener;
    private TextInputLayout tilEmail;
    private Button btnsave;

    public Forgot_PasswordFragment() {
        // Required empty public constructor
    }

    public static Forgot_PasswordFragment getInstance() {
        return new Forgot_PasswordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        mActionListener = new Forgot_PasswordPrensenter(this);
        tilEmail = view.findViewById(R.id.fptilemail);
        btnsave = view.findViewById(R.id.fpbtnsave);
        btnsave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        onForgot();
    }

    private void onForgot() {
        try {
            boolean result = true;
            tilEmail.getEditText().getText().toString();
            String email = tilEmail.getEditText().getText().toString();
            if (Utilities.isEmpty(email)) {
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            } else {
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if (result) {
                mActionListener.onForgot(email);

            }
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    @Override
    public void showErrorMessage(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage() {
        Snackbar.make(getView(), R.string.msg_forgot_password, Snackbar.LENGTH_LONG).show();
        btnsave.setEnabled(false);
    }
}
