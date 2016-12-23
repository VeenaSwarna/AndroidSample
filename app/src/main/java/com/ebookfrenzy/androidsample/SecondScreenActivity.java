package com.ebookfrenzy.androidsample;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.content.Intent;



public class SecondScreenActivity extends Activity implements View.OnClickListener {

    ImageView image;
    ImageButton share;
    Button next;
    Button previous;
    TextView text;
    String passedVar = null;
    private TextView passedView = null;
    int stringListCounter = 0;
    TextSwitcher mTextSwitcher;

    // private static final int[] images=new int[] {R.drawable.chicago2,R.drawable.chicago3,R.drawable.chicago1,R.drawable.love};
    String[] tips = null;
    int len = -1;
    static int curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        passedVar = (String) getIntent().getExtras().getString("selectedValue");
        passedView = (TextView) findViewById(R.id.welcomeTitle);
        passedView.setText(getString(R.string.title_sec_screen)+" "+ passedVar);

        if (passedVar != null) {
            switch (passedVar) {
                case "Health":
                    tips = getResources().getStringArray(R.array.health);
                    break;
                case "Fitness":
                    tips = getResources().getStringArray(R.array.fitness);
                    break;
                case "HairCare":
                    tips = getResources().getStringArray(R.array.haircare);
                    break;
                case "SkinCare":
                    tips = getResources().getStringArray(R.array.skincare);
                    break;
                case "Homemade Remedies":
                    tips = getResources().getStringArray(R.array.homeremediees);
                    break;
                case "Tips":
                    tips = getResources().getStringArray(R.array.tips);
                    break;
                default:
                    tips = getResources().getStringArray(R.array.tips);
            }
        }
        len = tips.length - 1;
        image = (ImageView) findViewById(R.id.imageView);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        share = (ImageButton) findViewById(R.id.shareIcon);
        //text.setText(tips[curr]);
        /* This logic is to add animation effect to the text fade in and fade out*/
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mTextSwitcher = (TextSwitcher) findViewById(R.id.tipsDisplaySection);
        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                TextView t = new TextView(SecondScreenActivity.this);
                t.setGravity(Gravity.CENTER);
                t.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                t.setTypeface(null, Typeface.ITALIC);
                t.setTextColor(Color.WHITE);
                //t.setShadowLayer(10, 10, 10, Color.BLACK);
                return t;
            }
        });

        mTextSwitcher.setInAnimation(in);
        mTextSwitcher.setOutAnimation(out);
        mTextSwitcher.setText(tips[curr]);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        share.setOnClickListener(this);


        //addListenerOnButton();

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.next && stringListCounter < len) {
            stringListCounter++;
        } else if (id == R.id.previous && stringListCounter > 0) {
            stringListCounter--;
        }

        mTextSwitcher.setText(tips[stringListCounter]);

        if (id == R.id.shareIcon) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, tips[stringListCounter]);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getString(R.string.social_share)));
        }


    }

  /*  public void addListenerOnButton() {


        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                curr++;

                if (curr > len) {
                    curr = 0;

                }


                text.setText(tips[curr]);
            }
        });

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_android_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
