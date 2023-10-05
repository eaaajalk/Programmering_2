package bibliotekssystem;

import java.util.ArrayList;
import java.util.List;

public class MediaCatalog {
    private List<Media> mediaList = new ArrayList<>();

    public MediaCatalog(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public void add (Media media) {
        if (!mediaList.contains(media)) {
            mediaList.add(media);
            sort();
        }
    }
    public void sort() {
        for (int i = 1; i < mediaList.size(); i++) {
            Media next = mediaList.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getReleaseYear() >= mediaList.get(j-1).getReleaseYear()) {
                    found = true;
                } else {
                    mediaList.add(j, mediaList.get(j-1));
                    j--;
                }
            }
            mediaList.add(j, next);
    }
    }

    public void remove (Media media) {
        mediaList.remove(media);
    }

    public List<Media> getMediaList() {
        return new ArrayList<>(mediaList);
    }
}
