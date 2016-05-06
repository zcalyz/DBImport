package com.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import com.jfreechart.util.MyFreeChartUtil;


public class PolyChart {
	/*
	 * 创建折线图
	 */
	public static void createPolyChart(String title) {
//		order response time
//		XYSeriesCollection dataSet = MyFreeChartUtil.getOrderDataSet_T();
		
//		order utilazation
//		XYSeriesCollection dataSet = MyFreeChartUtil.getOrderDataSet_U();
		
//		user response time
//		XYSeriesCollection dataSet = MyFreeChartUtil.getUserDataSet_T();
		
//		user utilazation
//		XYSeriesCollection dataSet = MyFreeChartUtil.getUserDataSet_U();
		
//		address reponse time
//		XYSeriesCollection dataSet = MyFreeChartUtil.getAddressDataSet_T();
		
//		address utilazation
//		XYSeriesCollection dataSet = MyFreeChartUtil.getAddressDataSet_U();
		
//      client utilazation
		XYSeriesCollection dataSet = MyFreeChartUtil.getClientDataSet_U();
		
		JFreeChart chart = ChartFactory.createXYLineChart(title, "到达率", "利用率", dataSet, PlotOrientation.VERTICAL, true,
				true, false);

		XYPlot plot = (XYPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLineStroke(new BasicStroke(2.0f)); // 设置轴线粗细
		rangeAxis.setAxisLinePaint(Color.BLACK); // 设置轴线颜色
		
		rangeAxis.setUpperBound(100); // 设置坐标最大值
//		rangeAxis.setUpperBound(0.2);
		//设置坐标轴颜色
		colorSet(plot);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));

		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		displayPlotValue(plot);

	/*	// 设置子标题
		TextTitle subtitle = new TextTitle("子标题:", new Font("黑体", Font.BOLD, 12));
		chart.addSubtitle(subtitle);*/

		// 设置主标题
		chart.setTitle(new TextTitle(title, new Font("黑体", Font.ITALIC, 16)));
		chart.setAntiAlias(true);
		
		MyFreeChartUtil.saveChart("Client_utilazation.jpg", chart);
		MyFreeChartUtil.showChart(chart);
		
	}
	/*
	 * 设置坐标轴颜色
	 */
	public static void colorSet(XYPlot plot) {
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
	}
	/*
	 * 显示坐标的值
	 */
	public static void displayPlotValue(XYPlot plot){
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 10));
		plot.setRenderer(xyitem);
	}

	public static void main(String[] args) {
		createPolyChart("Client utilazation");
	}
}
