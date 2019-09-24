package com.piyushmaheswari.mvvmarchitecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE
            ="com.piyushmaheswari.mvvmarchitecture.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION
            ="com.piyushmaheswari.mvvmarchitecture.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY
            ="com.piyushmaheswari.mvvmarchitecture.EXTRA_PRIORITY";


    private EditText editTextTitle23;
    private EditText editTextDesc3;
    private NumberPicker numberPickerPri2;

    private RelativeLayout relativeLayout5;
    private LinearLayout linearLayout6;



    private RelativeLayout relativeLayout;
    private LinearLayout linearLayout;

    private EditText editTextTitle;
    private EditText editTextDesc;
    private NumberPicker numberPickerPri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle=findViewById(R.id.edit_text_title);
        editTextDesc=findViewById(R.id.edit_text_description);
        numberPickerPri=findViewById(R.id.numberpickerPri);

        numberPickerPri.setMaxValue(10);
        numberPickerPri.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add Note");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.saveNote)
        {
            saveNote();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

    private void saveNote() {

        String title=editTextTitle.getText().toString();
        String descr=editTextDesc.getText().toString();
        int priority=numberPickerPri.getValue();
        int priority2=numberPickerPri.getValue();
        int priority3=numberPickerPri.getValue();

        if(title.trim().isEmpty() || descr.trim().isEmpty()) {
            Toast.makeText(this, "Please enter value in Title and Description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,descr);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();


    }
}
