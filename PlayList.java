/**
 * Represnts a list of musical tracks. The list has a maximum capacity (int),
 * and an actual size (number of tracks in the list, an int).
 */
class PlayList {
    private Track[] tracks; // Array of tracks (Track objects)
    private int maxSize; // Maximum number of tracks in the array
    private int size; // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */
    public int getMaxSize() {
        return maxSize;
    }

    /** Returns the current number of tracks in this play list. */
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }

    /**
     * Appends the given track to the end of this list.
     * If the list is full, does nothing and returns false.
     * Otherwise, appends the track and returns true.
     */
    public boolean add(Track track) {
        // first, check if there is room for more tracks
        if (size < maxSize) {
            tracks[size++] = track;
            return true; // Successfully added the track
        }
        return false; // playList is full, the track cannot be added
    }

    /**
     * Returns the data of this list, as a string. Each track appears in a separate
     * line.
     */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        // i don't know howto use StringBuilder, looked at it in google and didn´t quite understand :)

        String result = ""; // Start with an empty string
        for (int i = 0; i < size; i++) {
            // Concatenate each track's string representation to the result string
            result += tracks[i].toString() + "\n";
        }
        return result;
    }

    /**
     * Removes the last track from this list. If the list is empty, does nothing.
     */
    public void removeLast() {
        if (size > 0) {
            tracks[--size] = null; // if playlist is not emplty, it remove the last track and decrements the size
        }
    }

    /** Returns the total duration (in seconds) of all the tracks in this list. */
    public int totalDuration() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += tracks[i].getDuration();
        }
        return total;
    }

    /**
     * Returns the index of the track with the given title in this list.
     * If such a track is not found, returns -1.
     */
    public int indexOf(String title) {
        // Convert the search title to lowercase for case-insensitive comparison
        String searchTitle = title.toLowerCase();

        for (int i = 0; i < size; i++) {
            // Convert each track's title to lowercase before comparing
            if (tracks[i].getTitle().toLowerCase().equals(searchTitle)) {
                return i;
            }
        }


        return -1;
    }

    /**
     * Inserts the given track in index i of this list. For example, if the list is
     * (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     * If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     * If i is negative or greater than the size of this list, or if the list
     * is full, does nothing and returns false. Otherwise, inserts the track and
     * returns true.
     */
    public boolean add(int i, Track track) {
    if (i < 0 || i > size || size == maxSize) {
        return false;
    }
    for (int j = size; j > i; j--) {
        tracks[j] = tracks[j - 1];
    }
    // Insert the new track at index
    tracks[i] = track;
    // Increment the size of the playlist
    size++;

    return true;
    }

    /**
     * Removes the track in the given index from this list.
     * If the list is empty, or the given index is negative or too big for this
     * list,
     * does nothing and returns -1.
     */
    public void remove(int i) {
        if (i >= 0 && i < size) { // Check for valid index
            System.arraycopy(tracks, i + 1, tracks, i, size - i - 1);
            //juts discovered from System class, the most useful method. we copy elements from source array
            // into destination array :) we start at position i+1 on sourdce array copies the array after the track i want to remove at i 
            // we start the new destinastion array at i to override the old song at position i and the number of element we copy is 
            // size - i - 1 since we dont include the element at index i in the count 
            tracks[--size] = null; // reduce the size and clear the last element
        }
    }

    /**
     * Removes the first track that has the given title from this list.
     * If such a track is not found, or the list is empty, or the given index
     * is negative or too big for this list, does nothing.
     */
    public void remove(String title) {
        int index = indexOf(title); 
        if (index != -1) { 
            remove(index); 
        }
    }

    /**
     * Removes the first track from this list. If the list is empty, does nothing.
     */
    public void removeFirst() {
        if (size > 0) { 
            System.arraycopy(tracks, 1, tracks, 0, size - 1); 
            tracks[--size] = null;
        }
    }

    /**
     * Adds all the tracks in the other list to the end of this list.
     * If the total size of both lists is too large, does nothing.
     */
    //// An elegant and terribly inefficient implementation.
    public void add(PlayList other) {
       if(this.size+ other.size <= maxSize){
        for (int i = 0; i < other.size; i++){
            this.add(other.getTrack(i));
        }
       }
    }

    /**
     * Returns the index in this list of the track that has the shortest duration,
     * starting the search in location start. For example, if the durations are
     * 7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the
     * minimum value (5) when starting the search from index 2.
     * If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        //// replace the following statement with your code
        return 0;
    }

    /**
     * Returns the title of the shortest track in this list.
     * If the list is empty, returns null.
     */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /**
     * Sorts this list by increasing duration order: Tracks with shorter
     * durations will appear first. The sort is done in-place. In other words,
     * rather than returning a new, sorted playlist, the method sorts
     * the list on which it was called (this list).
     */
    public void sortedInPlace() {
        // Uses the selection sort algorithm,
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
    }
}
