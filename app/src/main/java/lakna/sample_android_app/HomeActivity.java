package lakna.sample_android_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends Activity {

    @BindView(R.id.img_add)
    ImageView imgAdd;

    @BindView(R.id.rl_add)
    RelativeLayout rlAdd;

    @BindView(R.id.img_delete)
    ImageView imgDelete;

    @BindView(R.id.rl_delete)
    RelativeLayout rlDelete;

    @BindView(R.id.img_view)
    ImageView imgView;

    @BindView(R.id.rl_view)
    RelativeLayout rlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //to genarate butterkinfe injections type ctrl + n



    }

    private void setUpTypefaces() {

//        rlAdd.setOnClickListener(view -> {
//            Intent in = new Intent(this, AddProfile.class);
//            startActivity(in);
//            finish();
//        });

    }
}
