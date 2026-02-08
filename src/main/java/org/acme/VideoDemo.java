package org.acme;

import dev.onvoid.webrtc.media.MediaDevices;
import dev.onvoid.webrtc.media.video.VideoCaptureCapability;
import dev.onvoid.webrtc.media.video.VideoDevice;

import java.util.List;
import java.util.Objects;

public class VideoDemo {

    // https://jrtc.dev/guide/video/camera-capture

    public void retrieveAllAvailableCameras() {
        List<VideoDevice> cameras = MediaDevices.getVideoCaptureDevices();
        if (Objects.isNull(cameras)) {
            System.out.println("No cameras found.");
            return;
        }

        // Get the first camera
        VideoDevice camerasFirst = cameras.getFirst();
        System.out.println("Camera: " + camerasFirst.getName());

        // Print cameras capabilities
        List<VideoCaptureCapability> captureCapabilities = MediaDevices.getVideoCaptureCapabilities(camerasFirst);
        for (VideoCaptureCapability capability : captureCapabilities) {
            System.out.println("  Resolution: " + capability.width + "x" + capability.height);
            System.out.println("  Frame Rate: " + capability.frameRate + " fps");
        }


    }
}
