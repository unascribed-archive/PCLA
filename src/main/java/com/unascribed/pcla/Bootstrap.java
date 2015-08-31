/*
 * PCLA - a JavaFX raster image editor
 * Copyright (C) 2015 Aesen Vismea ("unascribed")
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.unascribed.pcla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bootstrap extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(ClassLoader.getSystemResource("main.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("PCLA ("+randomDefinition()+") v0.0.0");
		stage.setScene(scene);
		stage.show();
	}

	private String randomDefinition() {
		List<String> str;
		try (BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("definitions")))) {
			str = r.lines().collect(Collectors.toList());
		} catch (IOException e) {
			return "Poorly Coded Lazy App";
		}
		return str.get((int)(Math.random()*str.size()));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
