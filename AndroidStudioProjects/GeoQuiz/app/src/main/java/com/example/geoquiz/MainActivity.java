package com.example.geoquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.geoquiz.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DialogFragment dialogFragment;
    private ArrayAdapter<User> playerAdapter;

    private TriviaDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogFragment = new AddTriviaDialog();
        db = TriviaDatabase.getInstance(this);
        db.populateInitialData();
        binding.viewQs.setOnClickListener(v -> startActivity(new Intent(this, TriviaManageActivity.class)));


        List<User> players = db.user().getAll();
        playerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, players);
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.playerSpinner.setAdapter(playerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_task) {
            dialogFragment.show(getSupportFragmentManager(), "");
            Log.d("main", "add new question");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}