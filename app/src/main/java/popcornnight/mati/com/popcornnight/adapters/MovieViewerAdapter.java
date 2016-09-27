package popcornnight.mati.com.popcornnight.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import popcornnight.mati.com.popcornnight.R;
import popcornnight.mati.com.popcornnight.db_package.DBConstances;
import popcornnight.mati.com.popcornnight.utils.Base64Helper;

/**
 * Created by jbt on 9/27/2016.
 */
public class MovieViewerAdapter extends CursorAdapter {

    private Context context;

    public MovieViewerAdapter(Context context, Cursor c) {
        super(context, c);
        this.context = context;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View v = LayoutInflater.from(context).inflate(R.layout.movie_item, null);

        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);
        RatingBar rating = (RatingBar) view.findViewById(R.id.ratingBar);

        title.setText(cursor.getString(cursor.getColumnIndex(DBConstances.MOVIES_TITLE_COLUMN)));
        rating.setRating(cursor.getFloat(cursor.getColumnIndex(DBConstances.MOVIES_RATING_COLUMN)));

        String imageStr = cursor.getString(cursor.getColumnIndex(DBConstances.MOVIES_IMG_URL_COLUMN));
        setImage(image, cursor, imageStr);
    }



    private void setImage(ImageView image, Cursor cursor, String imageStr) {

        if(imageStr.equals(""))
        {
            image.setImageResource(R.drawable.movie_def_img);
            return;
        }
        if(isUrl(imageStr)){
            Picasso.with(context).load(imageStr).into(image);
            return;
        }

        Bitmap imageBitmap= Base64Helper.decodeBase64(imageStr);
        image.setImageBitmap(imageBitmap);

    }

    private boolean isUrl(String imageStr){
        String urlStartingString = imageStr.substring(0, 5);
        if(urlStartingString.equals("http")){
            return true;
        }
        return false;
    }
}
