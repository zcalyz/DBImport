package com.jfreechart.util;

import org.jfree.data.xy.XYSeries;

public class SeriesUtil {
	// order response time
	public static XYSeries getOrderRT() {
		XYSeries series = new XYSeries("order-R");
		series.add(5, 0.124);
		series.add(10, 0.368);
		series.add(20, 1.417);
		series.add(30, 2.197);
		series.add(40, 4.154);
		return series;
	}

	public static XYSeries getOrderQT() {
		XYSeries series = new XYSeries("order-Q");
		series.add(5, 0.182);
		series.add(10, 0.241);
		series.add(20, 0.809);
		series.add(30, 5.15);
		return series;
	}

	// order utilazation
	public static XYSeries getOrderRCpu() {
		XYSeries series = new XYSeries("order-R-CPU");
		series.add(5, 10);
		series.add(10, 28);
		series.add(20, 45);
		series.add(30, 64);
		series.add(40, 66);
		return series;
	}

	public static XYSeries getOrderRIO() {
		XYSeries series = new XYSeries("order-R-IO");
		series.add(5, 3);
		series.add(10, 4);
		series.add(20, 7);
		series.add(30, 7);
		series.add(30, 7);
		return series;
	}

	public static XYSeries getOrderQCPU() {
		XYSeries series = new XYSeries("order-Q");
		series.add(5, 21);
		series.add(10, 42.5);
		series.add(20, 85);
		series.add(30, 97.8);
		return series;
	}

	// User response time
	public static XYSeries getUserRT() {
		XYSeries series = new XYSeries("user-R");
		series.add(5, 0.071);
		series.add(10, 0.072);
		series.add(20, 0.106);
		series.add(30, 0.11);
		return series;
	}

	public static XYSeries getUserQT() {
		XYSeries series = new XYSeries("user-Q");
		series.add(5, 0.113);
		series.add(10, 0.139);
		series.add(20, 0.19);
		series.add(30, 0.216);
		return series;
	}

	// User Utilazation
	public static XYSeries getUserRCPU() {
		XYSeries series = new XYSeries("user-R-CPU");
		series.add(5, 2);
		series.add(10, 4);
		series.add(20, 5);
		series.add(30, 7);
		return series;
	}

	public static XYSeries getUserQU() {
		XYSeries series = new XYSeries("user-Q");
		series.add(5, 9);
		series.add(10, 17.8);
		series.add(20, 35.7);
		series.add(30, 41);
		return series;
	}

	// Address response time
	public static XYSeries getAddressRT() {
		XYSeries series = new XYSeries("address-R");
		series.add(5, 0.04);
		series.add(10, 0.049);
		series.add(20, 0.078);
		series.add(30, 0.082);
		return series;
	}

	public static XYSeries getAddressQT() {
		XYSeries series = new XYSeries("address-Q");
		series.add(5, 0.0446);
		series.add(10, 0.05);
		series.add(20, 0.069);
		series.add(30, 0.08);
		return series;
	}

	// Address Utilazation
	public static XYSeries getAddressRCPU() {
		XYSeries series = new XYSeries("address-R-CPU");
		series.add(5, 3);
		series.add(10, 8);
		series.add(20, 11);
		series.add(30, 20);
		return series;
	}

	public static XYSeries getAddressQU() {
		XYSeries series = new XYSeries("address-Q");
		series.add(5, 4);
		series.add(10, 8.8);
		series.add(20, 17.7);
		series.add(30, 20.3);
		return series;
	}
	
	// Client Utilazation
	public static XYSeries getClientRCPU() {
		XYSeries series = new XYSeries("client-R-CPU");
		series.add(5, 9.6);
		series.add(10, 19);
		series.add(20, 28);
		series.add(30, 43);
		return series;
	}
	
	public static XYSeries getClientQU() {
		XYSeries series = new XYSeries("client-Q");
		series.add(5, 14);
		series.add(10, 28.2);
		series.add(20, 56);
		series.add(30, 64);
		return series;
	}
}
