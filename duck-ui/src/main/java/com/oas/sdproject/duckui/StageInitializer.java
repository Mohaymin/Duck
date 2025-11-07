package com.oas.sdproject.duckui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import com.oas.sdproject.duckui.LoginApplication.StageReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();

    }
}
