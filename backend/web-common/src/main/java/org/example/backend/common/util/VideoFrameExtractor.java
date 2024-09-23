package org.example.backend.common.util;

import lombok.Data;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.Mat;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_core.countNonZero;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGR2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/6 17:01
 */
public class VideoFrameExtractor {

    private static final int BLACK_FRAME_THRESHOLD = 30;
    private static final double BLACK_PERCENTAGE_THRESHOLD = 0.99;
    public static SnapshotImage extractFirstFrame(InputStream videoInputStream) throws IOException {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoInputStream);
        try {
            grabber.start();
            int duration = (int) grabber.getLengthInTime() / 1000000;
            String format = grabber.getFormat();

            Frame frame;
            Mat mat = new Mat();
            int frameNumber = 0;
            while ((frame = grabber.grabImage()) != null) {
                frameNumber++;
                new OpenCVFrameConverter.ToMat().convert(frame).copyTo(mat);
                Mat grayMat = new Mat();
                cvtColor(mat, grayMat, COLOR_BGR2GRAY);
                int totalPixels = grayMat.rows() * grayMat.cols();
                int blackPixels = totalPixels - countNonZero(grayMat);
                double blackPercentage = (double) blackPixels / totalPixels;
                if (frameNumber > 30 || (blackPixels < BLACK_FRAME_THRESHOLD &&
                        blackPercentage < BLACK_PERCENTAGE_THRESHOLD)) {
                    break;
                }
            }
            if (frame == null) {
                frame = grabber.grabFrame();
            }
            int origWidth = frame.imageWidth;
            int origHeight = frame.imageHeight;
            // 对截取的帧进行等比例缩放
            int width = 600;
            int height = (int) (((double) width / origWidth) * origHeight);
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage fetchedImage = converter.getBufferedImage(frame);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            bi.getGraphics().drawImage(fetchedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            String imageFormat = "jpg";
            ImageIO.write(bi, imageFormat, out);

            SnapshotImage snapshotImage = new SnapshotImage();
            snapshotImage.setWidth(width);
            snapshotImage.setHeight(height);
            snapshotImage.setImageFormat(imageFormat);

            snapshotImage.setVideoDuration(duration);
            List<String> formats = CommaSplitUtils.toList(format);
            if (T.isNotEmpty(formats)) {
                snapshotImage.setVideoFormat(formats.get(0).trim());
            }
            snapshotImage.setInputStream(new ByteArrayInputStream(out.toByteArray()));
            return snapshotImage;
        } catch (Exception e) {
            throw new IOException("Failed to extract first frame: " + e.getMessage(), e);
        } finally {
            try {
                grabber.stop();
                grabber.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    public static class SnapshotImage {

        private ByteArrayInputStream inputStream;
        private int width;
        private int height;
        private String imageFormat;
        //单位：秒
        private int videoDuration;
        private String videoFormat;

    }
}
