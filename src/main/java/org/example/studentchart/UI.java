package org.example.studentchart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UI
{
    //Objects
    CategoryAxis cAxis = new CategoryAxis();
    NumberAxis nAxis = new NumberAxis();

    //Panes
    public Pane root;

    //Textfield
    public TextField tfInput = new TextField();

    //Buttons
    public Button btnAddAge = new Button();
    public Button btnDrawChart = new Button();

    //Charts
    //BarChart bcStudentChart;

    //Shapes
    Line lineX = new Line(100,400,400,400);
    Line lineY = new Line(100,400,100,100);


    //Item coordinates
    final int TF_INPUT_X = 100;
    final int TF_INPUT_Y = 450;
    final int BTN_AGE_X = 100;
    final int BTN_AGE_Y = 500;
    final int BTN_CHART_X = 150;
    final int BTN_CHART_Y = 500;
    //final int BC_CHART_X = 50; for barchart
    //final int BC_CHART_Y = 50; for barchart
    final int CHART_DATA_Y = 410;
    final int RECT_HEIGHT = 400;
    final int RECT_X = 100;




    public UI()
    {
        layoutSetup();
        promptText();

    }

    private void layoutSetup()
    {
        root = new Pane();

        //bcStudentChart = new BarChart<>(cAxis, nAxis);
        tfInput.setLayoutX(TF_INPUT_X);
        tfInput.setLayoutY(TF_INPUT_Y);
        btnAddAge.setLayoutX(BTN_AGE_X);
        btnAddAge.setLayoutY(BTN_AGE_Y);
        btnDrawChart.setLayoutX(BTN_CHART_X);
        btnDrawChart.setLayoutY(BTN_CHART_Y);
        //bcStudentChart.setLayoutX(BC_CHART_X); for barchart
        //bcStudentChart.setLayoutY(BC_CHART_Y); for barchart

        root.getChildren().addAll(tfInput, btnAddAge, btnDrawChart,lineX, lineY);
    }

    private void promptText()
    {
        tfInput.setPromptText("Enter age");
        btnAddAge.setText("Save");
        btnDrawChart.setText("Draw chart");
    }

    public Parent getView()
    {
        return root;
    }


    /*
    public void updateChart(ObservableList<XYChart.Series<String, Number>> data)
    {
        bcStudentChart.setData(data);
    }
    */


    public void drawRectangles(ArrayList<Integer> data)
    {
        Map<Integer, Integer> countMap = new TreeMap<>();

        int NoOfStudToYConversion = 50; //used to add more height to the bars
        int rectX = 100; //starting point of the rectangles on the x axis
        int rectPadding = 20; //padding between bars

        for (int age : data)
        {
            countMap.put(age, countMap.getOrDefault(age, 0) + 1); //loops through the arraylist and inserts values into the hashmap
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
        {
            int count = entry.getValue(); //used to set the height of the bar
            int age = entry.getKey(); //used to set the text underneath the bar

            Label chartData = createLabel(age, rectX);

            Rectangle chartRect = createRectangle(count, rectX);

            root.getChildren().addAll(chartRect, chartData);

            rectX += rectPadding;
        }
    }

    private Rectangle createRectangle(int count, int x)
    {
        int NoOfStudToYConversion = 50; //used to add more height to the bars

        Rectangle chartRect = new Rectangle();
        chartRect.setLayoutX(x);
        chartRect.setHeight(count * NoOfStudToYConversion);
        chartRect.setLayoutY(RECT_HEIGHT - chartRect.getHeight());
        chartRect.setWidth(10);

        return chartRect;
    }

    private Label createLabel(int age, int x)
    {
        Label chartData = new Label();
        chartData.setLayoutY(CHART_DATA_Y);
        chartData.setLayoutX(x);
        chartData.setText(String.valueOf(age));
        return chartData;
    }



    public void setSaveAction(EventHandler<ActionEvent> handler)
    {
        btnAddAge.setOnAction(handler);
    }

    public void setDrawChart(EventHandler<ActionEvent> handler)
    {
        btnDrawChart.setOnAction(handler);
    }

}
