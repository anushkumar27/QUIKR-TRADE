package com.anush.pes.quikrtrade;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.util.Log;
import org.json.JSONObject;

public class MainActivity extends ActionBarActivity {

    String cat_id = "categoryId=71&city=Delhi&from=0&size=2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(),json.toString() ,Toast.LENGTH_LONG).show();
        //System.out.print(json);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void trade(View v){

        RetrieveFeedTask retrieveFeedTask = new RetrieveFeedTask();
        JSONObject json = retrieveFeedTask.getJSON(cat_id);
        System.out.println(" MainMethod:json:" + json);
        Intent i = new Intent(this,TradeActivity.class);
        startActivity(i);
    }

}
