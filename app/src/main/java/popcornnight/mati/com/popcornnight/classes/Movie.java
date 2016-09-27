package popcornnight.mati.com.popcornnight.classes;

import android.os.Parcel;
import android.os.Parcelable;


public class Movie implements Parcelable {

    private int id;
    private String title;
    private String body;
    private String imgUrl;
    private float ratingValue;

    public Movie(){
    }

    public Movie(int id, String title, String body, String imgUrl) {
        this(title, body, imgUrl);
        this.id = id;

    }
    public Movie(String title, String body, String imgUrl) {
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }


    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        body = in.readString();
        imgUrl = in.readString();
        ratingValue = in.readFloat();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(imgUrl);
        dest.writeFloat(ratingValue);
    }
}
