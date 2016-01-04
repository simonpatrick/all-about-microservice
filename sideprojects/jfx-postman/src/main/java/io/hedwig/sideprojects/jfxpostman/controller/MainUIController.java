package io.hedwig.sideprojects.jfxpostman.controller;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import io.hedwig.sideprojects.jfxpostman.request.RequestExecutor;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class MainUIController implements Initializable {

	@FXML
	private TextField url;

	@FXML
	private TextField threadNum;

	@FXML
	private MenuButton action;

	@FXML
	private TextField fileField;

	@FXML
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		url.setText("your URL here");
		// url.setText("http://ZHUZHI1.asiapacific.hpqcorp.net:8080/rest/private/v2/community/document/upload?communityId=id777&currentPortal=hpes&currentFolder=&topicId=abc");
		threadNum.setText("10");
	}

	@FXML
	void setAction() {
		System.out.println("action");
	}

	@FXML
	void sendRequest() throws URISyntaxException, InterruptedException, ExecutionException {
		String url_ = url.getText();
		RequestExecutor executor = new RequestExecutor(url_, "POST", Integer.valueOf(threadNum.getText()), "");
		Platform.runLater(executor);
	}

	@FXML
	void chooseFile() {
		FileChooser choose = new FileChooser();
		Window window = new PopupControl();
		File file = choose.showOpenDialog(window);
		String path = file.getAbsolutePath();
		fileField.setText(path);
	}

}
