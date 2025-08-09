package com.tests;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author tasahu
 */
public class test43 {

    @Test
    public void imageTest() {
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("C:\\Tanmay personal\\Test\\src\\main\\resources\\4.png");
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("C:\\Tanmay personal\\Test\\src\\main\\resources\\5.png");
        for ( int i=1; i<14; i++) {
            File resultDestination = new File("C:\\Tanmay personal\\Test\\src\\main\\resources\\result" + i + ".png");
            //Create ImageComparison object and compare the images.
            ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage).compareImages();
            BufferedImage resultImage = new BufferedImage(4000, 4000, i);
            ImageComparisonUtil.saveImage(resultDestination, resultImage);
            imageComparisonResult.writeResultTo(new File("C:\\Tanmay personal\\Test\\src\\main\\resources\\result15.png"));
        }

        //Check the result
     //   Assert.assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
    }
}
