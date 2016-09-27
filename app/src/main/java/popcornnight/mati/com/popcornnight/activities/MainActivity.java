package popcornnight.mati.com.popcornnight.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import popcornnight.mati.com.popcornnight.adapters.MovieViewerAdapter;
import popcornnight.mati.com.popcornnight.R;
import popcornnight.mati.com.popcornnight.db_package.DBConstances;
import popcornnight.mati.com.popcornnight.db_package.SQLHelper;

public class MainActivity extends AppCompatActivity {

    private ListView listView = (ListView)findViewById(R.id.mainListView);
    private SQLHelper helper = new SQLHelper(this);;
    private Cursor cursor;
    private int positionOnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListView();
        registerForContextMenu(listView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(cursor.moveToPosition(position))
                {
                   // ShowMovieData activity
                }
            }
        });








    }

    private void setListView(){
        this.cursor = helper.getReadableDatabase().query(DBConstances.MOVIES_TABLE, null,null,null,null,null,null);
        MovieViewerAdapter movieViewerAdapter= new MovieViewerAdapter(this,cursor);
        this.listView.setAdapter(movieViewerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.exit)
        {
            finish();
        }
        else if(item.getItemId() == R.id.addInternetMovie)
        {

            Intent intent= new Intent(this, AddInternetMovie.class);
            startActivity(intent);
            return true;
        }


        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(menuInfo!= null)
        {
            AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) menuInfo;
            positionOnList=info.position;
        }

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.cotext_menu ,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

//        if(item.getItemId()== R.id.delete)
//        {
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    DBHelper helper= new DBHelper(MainActivity.this);
//                    cursor.moveToPosition(positionOnList);
//                    int cityID= cursor.getInt(cursor.getColumnIndex("_id"));
//                    helper.deleteCity(cityID);
//                    onResume();
//                }
//            })
//                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(MainActivity.this, "user canceled..", Toast.LENGTH_SHORT).show();
//                        }
//                    }).show();
//
//        }
         return true;
    }



}
