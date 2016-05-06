package com.readEnv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadEnvServlet
 */
public class ReadEnvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> envMap = System.getenv();
		StringBuilder builder = new StringBuilder();
		Set<Entry<String, String>> envSet = envMap.entrySet();
		String result = null;
		for(Entry<String, String> entry : envSet){
			builder.append("<p>" + entry.getKey() + "  :  " + entry.getValue() + ";</p>");
			if(entry.getKey().equals("VCAP_SERVICES")){
				result = entry.getValue();
			}
		}
		
		String zookeeper = null;
		String brokers = null;
		
		Pattern zookeeperPattern = Pattern.compile("zookeeper\":\"(.*?)\"");
		Matcher matcher = zookeeperPattern.matcher(result);
		if(matcher.find()){
			zookeeper = matcher.group(1);
		}
		
		Pattern brokersPattern = Pattern.compile("brokers\":\"(.*?)\"");
		matcher = brokersPattern.matcher(result);
		if(matcher.find()){
			brokers = matcher.group(1);
		}
		
		PrintWriter writer = response.getWriter();
		writer.write("<p>zookeeper:" + zookeeper + "</p>");
		writer.write("<p>brokers:" + brokers + "</p>");
		writer.write("<p> </p>");
//		writer.write(builder.toString());
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
