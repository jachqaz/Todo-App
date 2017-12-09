package co.devhack.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import co.devhack.todoapp.R;
import co.devhack.todoapp.presentation.presenter.AddTodoContract;
import co.devhack.todoapp.presentation.presenter.AddTodoPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTodoFragment extends Fragment implements AddTodoContract.View, View.OnClickListener {
    private AddTodoContract.UserActionsLister mActionListener;
    private TextInputLayout addtilTarea;
    private EditText edtFecha;
    private ImageButton btnSelectDate;
    private ImageView addimg;
    private Button addbtnsave;


    public AddTodoFragment() {
        // Required empty public constructor
    }

    public static AddTodoFragment getInstance() {
        return new AddTodoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);
        mActionListener = new AddTodoPresenter(this);
        addtilTarea = view.findViewById(R.id.addtilTarea);
        edtFecha = view.findViewById(R.id.edtFecha);
        btnSelectDate = view.findViewById(R.id.btnSelectDate);
        addimg = view.findViewById(R.id.addimg);
        addbtnsave = view.findViewById(R.id.addbtnsave);
        btnSelectDate.setOnClickListener(this);
        addbtnsave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSelectDate:
                break;
            case R.id.addbtnsave:
                break;
        }
    }
}
