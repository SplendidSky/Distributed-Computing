package IOC_test.IOC_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizMasterService {

	private QuizMaster quizMaster;
	
	public void setQuizMaster(QuizMaster quizMaster) {
		this.quizMaster = quizMaster;
	}

	public void askQuestion(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");  
	    QuizMasterService quizMasterService = (QuizMasterService) context.getBean("quizMasterService");
	    quizMaster = quizMasterService.quizMaster;
		System.out.println(quizMaster.popQuestion());
	}
}