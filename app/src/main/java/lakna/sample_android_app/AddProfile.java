package lakna.sample_android_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AddProfile extends AppCompatActivity {

    @BindView(R.id.txt_add_profile)
    TextView txtAddProfile;
    @BindView(R.id.rl_add_profile)
    RelativeLayout rlAddProfile;
    @BindView(R.id.imageView4)
    CircleImageView imageView4;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_description)
    TextView txtDescription;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_description)
    EditText editDescription;
    @BindView(R.id.rl_profile_description)
    RelativeLayout rlProfileDescription;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.rl_save)
    RelativeLayout rlSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        ButterKnife.bind(this);
    }

}
