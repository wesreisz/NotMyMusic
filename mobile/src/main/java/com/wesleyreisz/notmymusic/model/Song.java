package com.wesleyreisz.notmymusic.model;

import android.graphics.Bitmap;

import java.util.Arrays;
/**
 * Created by wesleyreisz on 11/2/14.
 */
public class Song {
    private String title;
    private String[] images;
    private String artist;
    private String releaseDate;
    private String album;
    private Bitmap image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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

        Song song = (Song) o;

        if (!album.equals(song.album)) return false;
        if (!artist.equals(song.artist)) return false;
        if (image != null ? !image.equals(song.image) : song.image != null) return false;
        if (!Arrays.equals(images, song.images)) return false;
        if (!releaseDate.equals(song.releaseDate)) return false;
        if (!title.equals(song.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + Arrays.hashCode(images);
        result = 31 * result + artist.hashCode();
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + album.hashCode();
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", images=" + Arrays.toString(images) +
                ", artist='" + artist + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", album='" + album + '\''+
                '}';
    }
}
