package com.example.akash.login;

import android.media.Image;
import android.widget.Button;

public class listitems {
    private Image img;
    private String status;
    private Button book;

    public listitems(Image img, String status) {
        this.img = img;
        this.status = status;
    }

    public Image getImg() {
        return img;
    }

    public String getStatus() {
        return status;
    }

    public Button getBook() {
        return book;
    }
}
