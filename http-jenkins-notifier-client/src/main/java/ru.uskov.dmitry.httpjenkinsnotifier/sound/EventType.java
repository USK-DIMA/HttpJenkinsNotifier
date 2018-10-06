package ru.uskov.dmitry.httpjenkinsnotifier.sound;

public enum EventType {
    PULL_REQUEST("pull_request.wav"),
    APPROVE("approve.wav"),
    NEED_WORK("need_work.wav"),
    BUILD_SUCCESS("build_success.wav"),
    BUILD_FAILED("build_failed.wav"),
    MERGE("merge.wav");

    private final String audioName;

    EventType(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioName() {
        return audioName;
    }
}
