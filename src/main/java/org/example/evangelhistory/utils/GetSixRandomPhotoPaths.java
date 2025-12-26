package org.example.evangelhistory.utils;

import org.example.evangelhistory.entities.Photo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetSixRandomPhotoPaths {
    private final Set<Photo> photoSet;

    public GetSixRandomPhotoPaths (Set<Photo> photoSet) {
        this.photoSet = photoSet;
    }

    public List<String> getRandomPhotoPaths() {
        List<String> listOfRandomPhotoPaths = new ArrayList<>();
        int counter = 0;
        for (Photo photo : photoSet) {
            counter ++;
            if (counter <= 6) {
                String path = photo.getPath();
                listOfRandomPhotoPaths.add(path);
            } else {
                break;
            }
        }

        return listOfRandomPhotoPaths;
    }
}
