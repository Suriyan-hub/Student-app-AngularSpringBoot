package com.project.demo.util;


import com.project.demo.model.Student;


public interface StudentUtil {

	public static void calculate(Student s) {
		double fee=s.getSfee();
		double disc=fee *10/100.0;
		double gst=fee*12/100.0;
		s.setSdisc(disc);
		s.setSgst(gst);
		
	}
	

}
