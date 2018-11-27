package com.example.mihirnewalkar.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jokeactivity.JokeActivity;
import com.example.mihirnewalkar.builditbigger.EndpointsAsyncTask.Callback;

public class MainActivity extends AppCompatActivity implements Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchLibraryActivity(View view) {
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, "Manfred"));
    }


//    public void launchLibraryActivity(View view) {

//        Joker myJoker = new Joker();
//        String joke = myJoker.getJoke();

//        Intent intent = new Intent(this,JokeActivity.class);
//        intent.putExtra(JokeActivity.JOKE_KEY,joke);
//        startActivity(intent);
//    }

    @Override
    public void onFinished(String result) {

        Intent intent = new Intent(this,JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY,result);
        startActivity(intent);

    }
}
