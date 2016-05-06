package com.jfreechart.servlet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class ChartServlet {

	String equipment_id = "";

	public void service() {
	/*	res.setContentType("image/jpeg");
		equipment_id = req.getParameter("nodeId");*/
		// System.out.print(equipment_id);
		XYSeriesCollection lineDataset = getDataSet();
//		TimeSeriesCollection lineDataset = getDataSet();

//		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "日期2011", "产品良品率", lineDataset, true, true, false);
		JFreeChart chart = ChartFactory.createXYLineChart("title", "x", "y", lineDataset, PlotOrientation.VERTICAL, true, true, false);

		// =============显示各数据点及其数值start====================
		XYPlot plot = (XYPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLineStroke(new BasicStroke(2.0f)); // 设置轴线粗细
		rangeAxis.setAxisLinePaint(Color.BLACK); // 设置轴线颜色
		rangeAxis.setUpperBound(20); // 设置坐标最大值
/*		
		rangeAxis.setLowerBound(50f);
*/

		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();

		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);

		// 设置网格竖线颜色

		plot.setDomainGridlinePaint(Color.pink);

		// 设置网格横线颜色

		plot.setRangeGridlinePaint(Color.pink);

		// 设置曲线图与xy轴的距离

		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));

		// 设置曲线是否显示数据点

		xylineandshaperenderer.setBaseShapesVisible(true);

		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();

		xyitem.setBaseItemLabelsVisible(true);

		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());

		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 10));

		plot.setRenderer(xyitem);

		// =============显示各数据点及其数值end======================

		// 设置子标题

		TextTitle subtitle = new TextTitle("设备编号:" + equipment_id, new Font("黑体", Font.BOLD, 12));

		chart.addSubtitle(subtitle);

		// 设置主标题

		chart.setTitle(new TextTitle("设备良品率折线图", new Font("黑体", Font.ITALIC, 16)));

		chart.setAntiAlias(true);

//		ChartUtilities.writeChartAsJPEG(res.getOutputStream(), 1.0f, chart, 800, 400, null);
		try {
			ChartUtilities.saveChartAsJPEG(new File("src/poly_3.jpg"), chart, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private XYSeriesCollection getDataSet() {

//		DefaultPieDataset dataset = new DefaultPieDataset();

		// TimeSeries timeSeries2012 = new TimeSeries("2011年", Day.class);

		// 时间曲线数据集合

		XYSeries series = new XYSeries("XYGraph");
		series.add(1, 2);
		series.add(1.5, 4);
		series.add(2, 1);
		series.add(3, 9);
		series.add(4, 10);
		
		XYSeriesCollection dataset = new XYSeriesCollection(series);
	/*	TimeSeries timeSeries2011 = new TimeSeries("良品率", Day.class);*/
		// TimeSeries timeSeries2012 = new TimeSeries("二刀良品率", Day.class);
		// 构造数据集合
//		lineDataset.addSeries();
/*
		Map map = StateReportManger.getIntense().getClientLevelCount(equipment_id); // 调用getClientLevelCount()得到所有的数据
		/// StateReportManger sta=new StateReportManger();
		// Map map=sta.getClientLevelCount(equipment_id);
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {// 遍历，用到Map的.
																			// entrySet()方法

			Map.Entry entry = (Map.Entry) iter.next();
			String s = (String) entry.getKey();
			int MM = Integer.parseInt(s.substring(5, 7));

			int dd = Integer.parseInt(s.substring(8, 10));
			int yyyy = Integer.parseInt(s.substring(0, 4));
			timeSeries2011.add(new Day(dd, MM, yyyy), Double.parseDouble(String.valueOf(entry.getValue())));

			// dataset.setValue((String)entry.getKey(),
			// Double.parseDouble(String.valueOf(entry.getValue())));//设置数据

		}
*/
		return dataset;
	}
	
	public static void main(String[] args) {
		ChartServlet obj = new ChartServlet();
		obj.service();
	}

}