package lakna.sllit.com.tabs2;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */


public class AddFragment extends Fragment {


    @BindView(R.id.btn_cancel)
    Button btnCancel;

    @BindView(R.id.btn_save)
    Button btnSave;

    @BindView(R.id.imageView4)
    CircleImageView imageView4;

    @BindView(R.id.txt_name)
    EditText txtName;

    @BindView(R.id.rl_name)
    RelativeLayout rlName;

    @BindView(R.id.txt_description)
    EditText txtDescription;

    @BindView(R.id.rl_description)
    RelativeLayout rlDescription;

    Unbinder unbinder;

    private onAddStudentListener mCallback;
    private String stdName;
    private Student newStudent = new Student();

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (onAddStudentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " main activity Fragment exception");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureTextViews();
    }

    private void configureTextViews() {

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                newStudent.setStdName(String.valueOf(s));
            }
        });
        txtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                newStudent.setDescription(String.valueOf(s));
            }
        });

    }

    public interface onAddStudentListener {
        void onAddStudent(Student student);
    }

    @OnClick(R.id.btn_save)
    public void saveStudent() {
        Log.d("student", String.valueOf(newStudent.getStdName()));
        mCallback.onAddStudent(newStudent);
        newStudent = new Student();
        txtDescription.setText("");
        txtName.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

}

