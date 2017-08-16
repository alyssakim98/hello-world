package app;

import data.Evaluation;

/**
 * Eager evaluation
 *
 */
public class EvaluationTest implements Runnable {
	
	
	public static void main(String[] args){
		Thread thread = new Thread(new EvaluationTest());
		thread.start();
	}
	
	public EvaluationTest(){
		
	}

	@Override
	public void run() {
		try {
			Evaluation.eagerEvaluator(Evaluation.evaluate(1), Evaluation.evaluate(2));
			Evaluation.lazyEvaluator(() -> Evaluation.evaluate(1), () -> Evaluation.evaluate(2));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
