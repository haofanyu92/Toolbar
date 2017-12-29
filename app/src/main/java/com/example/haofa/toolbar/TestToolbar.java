package com.example.haofa.toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {

    private String SnackText = "Option 1 is selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*FloatingActionButton acButton1 = (FloatingActionButton) findViewById(R.id.action_one);
        acButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You selected item 1", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.action_one:
                Snackbar.make(findViewById(R.id.action_one), SnackText, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("Toolbar", SnackText);
                break;


            case R.id.action_two:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.dialog);
                // Add the buttons
                builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();

                Log.d("Toolbar", "Option 2 selected");
                break;



            case R.id.action_three:

                /*AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final EditText ed = (EditText)findViewById(R.id.message);

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder1.setView(inflater.inflate(R.layout.dialog_signin, null))
                        // Add action buttons
                        .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                SnackText = ed.getText().toString();
                            }
                        })
                        .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder1.create().show();*/

                AlertDialog.Builder obuilder = new AlertDialog.Builder(this);

                LayoutInflater li= getLayoutInflater();
                LinearLayout root = (LinearLayout)li.inflate(R.layout.dialog_signin, null);
                final EditText et = (EditText)root.findViewById(R.id.textmessage);
                obuilder.setView(root);


                obuilder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SnackText = et.getText().toString();
                            }
                        })
                        .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                obuilder.create().show();

                break;

            case R.id.action_about:
                Context context = getApplicationContext();
                CharSequence text = "Version 1.0 by Fanyu Hao";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
