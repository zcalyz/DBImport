package com.jfreechart.util;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MyFreeChartUtil {
	// order response time
	public static XYSeriesCollection getOrderDataSet_T() {
		XYSeries realSeries = SeriesUtil.getOrderRT();
		XYSeries queueSeries = SeriesUtil.getOrderQT();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}

	// order Utilazation
	public static XYSeriesCollection getOrderDataSet_U() {
		XYSeries realSeries = SeriesUtil.getOrderRCpu();
		XYSeries queueSeries = SeriesUtil.getOrderQCPU();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}

	// user response time
	public static XYSeriesCollection getUserDataSet_T() {
		XYSeries realSeries = SeriesUtil.getUserRT();
		XYSeries queueSeries = SeriesUtil.getUserQT();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}

	// user Utilazation
	public static XYSeriesCollection getUserDataSet_U() {
		XYSeries realSeries = SeriesUtil.getUserRCPU();
		XYSeries queueSeries = SeriesUtil.getUserQU();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}

	// address response time
	public static XYSeriesCollection getAddressDataSet_T() {
		XYSeries realSeries = SeriesUtil.getAddressRT();
		XYSeries queueSeries = SeriesUtil.getAddressQT();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}

	// address Utilazation
	public static XYSeriesCollection getAddressDataSet_U() {
		XYSeries realSeries = SeriesUtil.getAddressRCPU();
		XYSeries queueSeries = SeriesUtil.getAddressQU();

		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(realSeries);
		dataSet.addSeries(queueSeries);

		return dataSet;
	}
	
	// client Utilazation
		public static XYSeriesCollection getClientDataSet_U() {
			XYSeries realSeries = SeriesUtil.getClientRCPU();
			XYSeries queueSeries = SeriesUtil.getClientQU();

			XYSeriesCollection dataSet = new XYSeriesCollection();
			dataSet.addSeries(realSeries);
			dataSet.addSeries(queueSeries);

			return dataSet;
		}

	// 直接显示图表
	public static void showChart(JFreeChart chart) {
		ChartFrame frame = new ChartFrame("chart", chart);
		frame.setVisible(true);
		frame.pack();
		frame.show();
	}

	public static void saveChart(String filename, JFreeChart chart) {
		try {
			ChartUtilities.saveChartAsJPEG(new File("src/" + filename), chart, 1000, 700);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
