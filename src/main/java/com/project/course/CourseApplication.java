package com.project.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.course.ui.MainMenuController;

import javax.swing.*;



@SpringBootApplication
public class CourseApplication {
	
	
	 public static void main(String[] args) {
//	        LookAndFeelUtils.setWindowsLookAndFeel();
		 try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	        ConfigurableApplicationContext context = createApplicationContext(args);
	        displayMainFrame(context);
	    }
	 
	 
	  private static ConfigurableApplicationContext createApplicationContext(String[] args) {
	        return new SpringApplicationBuilder(CourseApplication.class)
	                .headless(false)
	                .run(args);
	    }

	    private static void displayMainFrame(ConfigurableApplicationContext context) {
	        SwingUtilities.invokeLater(() -> {
	            MainMenuController mainMenuController = context.getBean(MainMenuController.class);
	            mainMenuController.prepareAndOpenFrame();
	        });
	    }


//	public static void main(String[] args) {
//		SpringApplication.run(CourseApplication.class, args);
//	}

}
