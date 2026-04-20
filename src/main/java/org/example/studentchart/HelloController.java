package org.example.studentchart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.*;

public class HelloController
{
    //Objects
    ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    List<Integer> ages = new ArrayList<>();

    private final UI ui;

    public HelloController(UI ui)
    {
        this.ui = ui;
        ui.setDrawChart(e -> drawChart());
        ui.setSaveAction(this::saveAge);
    }


    /*
    Method for drawing a chart using barchart
     */
    public ObservableList<XYChart.Series<String, Number>> buildChart()
    {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int age : ages)
        {
            countMap.put(age, countMap.getOrDefault(age, 0) + 1);
        }

        for (Integer age : countMap.keySet())
        {
            series.getData().add(new XYChart.Data<>(String.valueOf(age), countMap.get(age)));
        }
        data.add(series);

        return data;
    }

    /*
    Takes data from the buildchart method and passes it to the UI class
     */
    private void drawChart() {
        ObservableList<XYChart.Series<String, Number>> data = buildChart();
        ui.updateChart(data);
    }



    public void saveAge(ActionEvent event)
    {
        int age = Integer.parseInt(ui.tfInput.getText());
        ages.add(age);
        clearText();
    }

    private void clearText()
    {
        ui.tfInput.clear();
    }


}
