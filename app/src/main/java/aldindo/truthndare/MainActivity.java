package aldindo.truthndare;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private Button button;
private ImageView imageView;
private int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);

    }

    public void spin(View view){
        int newDirection=6600+((int)(Math.random()*3600));
        int piviotX=imageView.getWidth()/2;
        int piviotY=imageView.getHeight()/2;

        Animation rotate= new RotateAnimation(lastDirection,newDirection,piviotX,piviotY);
        rotate.setDuration(2000);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
//                button.setBackground(Color.parseColor("#c1c1c1"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rotate.setFillAfter(true);
        lastDirection=newDirection;
        imageView.startAnimation(rotate);



    }
}
