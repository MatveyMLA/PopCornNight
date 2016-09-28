package popcornnight.mati.com.popcornnight.classes;

import android.os.Parcel;
import android.os.Parcelable;


public class Movie implements Parcelable {

    private int id;
    private int year;
    private String title;
    private String body;
    private String imgUrl;
    private String imdbID;
    private float ratingValue;

    public Movie() {
    }

    public Movie(int year, String title, String body, String imgUrl, String imdbID, float ratingValue) {
        this.year = year;
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.imdbID = imdbID;
        this.ratingValue = ratingValue;
    }

    public Movie(int id,int year, String title, String body, String imgUrl, String imdbID, float ratingValue ) {
        this(year ,title, body, imgUrl, imdbID, ratingValue);
        this.id = id;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        year = in.readInt();
        title = in.readString();
        body = in.readString();
        imgUrl = in.readString();
        imdbID = in.readString();
        ratingValue = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(year);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(imgUrl);
        dest.writeString(imdbID);
        dest.writeFloat(ratingValue);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }
}
