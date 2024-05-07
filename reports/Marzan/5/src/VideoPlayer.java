class VideoPlayer extends Player {
    public void play() {
        if (isPowerOn()) {
            System.out.println("Video is playing.");
        } else {
            System.out.println("Cannot play video. Player is turned off.");
        }
    }
}