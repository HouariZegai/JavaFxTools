package com.houarizegai.fxtools.sliders.model2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SliderController implements Initializable {

    @FXML // Image of Slider
    private ImageView imgSlider;
    // counter Number of image using in slider
    private final byte NUMBER_IMAGE_SLIDER = 3;
    private int counter = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliderAutoChangePictures();
    }

    private void sliderAutoChangePictures() {
        // Make auto change the slider in duration
        Timeline sliderTimer = new Timeline(new KeyFrame(Duration.ZERO, e -> onNext()), new KeyFrame(Duration.seconds(4)));
        sliderTimer.setCycleCount(Animation.INDEFINITE);
        sliderTimer.play();
    }
    
    @FXML
    private void onPrevious() {
        if (--counter < 1)
            counter = NUMBER_IMAGE_SLIDER;

        imgFadeTransition(counter);
    }

    @FXML
    private void onNext() {
        if (++counter > NUMBER_IMAGE_SLIDER)
            counter = 1;

        imgFadeTransition(counter);
    }

    private void imgFadeTransition(int imgCounter) {
        FadeTransition ft = new FadeTransition();
        ft.setNode(imgSlider);
        ft.setDuration(new Duration(4000));
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(0);
        ft.setAutoReverse(true);
        ft.play();
        imgSlider.setImage(new Image("com/houarizegai/fxtools/sliders/model2/img/" + imgCounter + ".png"));
    }
}
