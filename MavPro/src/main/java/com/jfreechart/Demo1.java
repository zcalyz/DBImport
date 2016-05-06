package com.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jboss.netty.util.CharsetUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Demo1 {

	public static void createPolyLine() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "测2", "安全");
		dataset.addValue(150, "测3", "流");
		dataset.addValue(300, "测3", "结果");
		dataset.addValue(100, "测4", "效益");

		JFreeChart chart = ChartFactory.createLineChart("曲线图", "x", "value", dataset);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("src/poly.png");
			ChartUtilities.writeChartAsPNG(fos, chart, 800, 600);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createPolyLine_2(){
		XYSeries series = new XYSeries("XYGraph");
		series.add(1, 2);
		series.add(1.5, 4);
		series.add(2, 1);
		series.add(3, 9);
		series.add(4, 10);
		
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart("title", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLineStroke(new BasicStroke(2.0f)); // 设置轴线粗细
		rangeAxis.setAxisLinePaint(Color.BLACK); // 设置轴线颜色
		/*	rangeAxis.setUpperBound(100f); // 设置坐标最大值
		rangeAxis.setLowerBound(50f);*/
		
		try {
			ChartUtilities.saveChartAsJPEG(new File("src/poly_k.jpg"), chart, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		createPolyLine_2();
	}

}
