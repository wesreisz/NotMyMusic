package com.wesleyreisz.notmymusic.model;

import android.graphics.Bitmap;

/**
 * Created by wesleyreisz on 11/9/14.
 */
public class ImageContainer {
    private String position;
    private Bitmap image;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageContainer that = (ImageContainer) o;

        if (position != that.position) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GridViewContainer{" +
                "position=" + position +
                ", image=" + image +
                '}';
    }
}
