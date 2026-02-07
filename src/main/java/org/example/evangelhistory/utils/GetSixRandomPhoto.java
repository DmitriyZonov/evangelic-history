package org.example.evangelhistory.utils;

import org.example.evangelhistory.entities.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetSixRandomPhoto {
    private final Set<Photo> photoSet;

    public GetSixRandomPhoto (Set<Photo> photoSet) {
        this.photoSet = photoSet;
    }

    public List<Photo> getRandomPhoto() {
        List<Photo> listOfRandomPhoto = new ArrayList<>();
        int counter = 0;
        for (Photo photo : photoSet) {
            counter ++;
            if (counter <= 6) {
                listOfRandomPhoto.add(photo);
            } else {
                break;
            }
        }

        return listOfRandomPhoto;
    }
}
