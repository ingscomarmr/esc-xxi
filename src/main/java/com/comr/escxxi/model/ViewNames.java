package com.comr.escxxi.model;

public class ViewNames {
	public class HomeGeneral{
		public static final String HOME="home";
		public static final String LOGIN="login";
		public static final String NOTICIAS="noticias";
		public static final String VER_NOTICIAS="noticia";
		public static final String TEACHER="teacher/";
		public static final String STUDENT="student/";
		public static final String ADVISOR="advisor/";
	}
	
	public class Teacher{
		private static final String PART = "teacher/";
		public static final String HOME= PART + "teacher_home";
	}
	
	public class Student{
		private static final String PART = "student/";
		public static final String HOME= PART + "student_home";
	}
	
}
