package basics;
import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,String[]negOpinionWords) {
		int limit1 = featureSet.length;	    
	   	int[] featureOpinions = new int[limit1]; // output
		
        // your code ~ you will be invoking getOpinionOnFeature		
        outer: for(int i=0; i<limit1; i++){
            featureOpinions[i] = 0;
            inner: for(int j=0,limit2 = featureSet[i].length; j<limit2; j++){
                featureOpinions[i] = getOpinionOnFeature(review,featureSet[i][j],posOpinionWords,negOpinionWords);
                if(featureOpinions[i] != 0){
                    break inner;
                }
            }
        }
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		// your code
		review = review.replaceAll("[,'!:;~@#$%^&*]*","");
		int opinion = checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
		if(opinion == 0){
		    opinion = checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
		}
		
		return opinion;
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		String[] sentences = review.split("\\.");
		int opinion = 0;
		String pattern = feature + " was";
		
		for(int i = 0, limit = sentences.length; i < limit; i++){
		    if(sentences[i].contains(pattern)){
		        String[] words = sentences[i].split(" ");
		        for(int j=2, limit1 = words.length; j<limit1; j++){
		            String featurePhrase = words[j-2]+" "+words[j-1];
					
		            if(featurePhrase.equalsIgnoreCase(pattern)){
		                String opinion_word = words[j];
		                for(int k=0,limit2=posOpinionWords.length; k<limit2; k++){
                            if (opinion_word.equalsIgnoreCase(posOpinionWords[k])){
                                opinion = 1;
                                break;
                                }
                            }
                            
                        if(opinion == 0){
                            for(int k=0,limit2=negOpinionWords.length; k<limit2; k++){
                                if (opinion_word.equalsIgnoreCase(negOpinionWords[k])){
                                    opinion = -1;
                                    break;
                                }
                            }
                        }
		            }
		        }
		    }
		    else{continue;}
		}
		return opinion;
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
		
		for(int i = 0, limit = sentences.length; i < limit; i++){
		    if(sentences[i].contains(feature)){
		        String[] words = sentences[i].split(" ");
		        for(int j=0, limit1 = words.length; j<limit1; j++){
		            
		            if(words[j].equalsIgnoreCase(feature)){
		                String opinion_word = words[j-1];
		                for(int k=0,limit2=posOpinionWords.length; k<limit2; k++){
                            if (opinion_word.equalsIgnoreCase(posOpinionWords[k])){
                                opinion = 1;
                                break;
                                }
                            }
                            
                        if(opinion == 0){
                            for(int k=0,limit2=negOpinionWords.length; k<limit2; k++){
                                if (opinion_word.equalsIgnoreCase(negOpinionWords[k])){
                                    opinion = -1;
                                    break;
                                }
                            }
                        }
		            }
		        }
		    }
		    else{continue;}
		}
		
		// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)		

		return opinion;
	}

	public static void main(String[] args) {
		//String review = "I chose two items from the menu, the shrimp scampi and chicken stroganoff, both with my favorite soup and some warm breadsticks. The soup was amazing , as always, ";
		
		String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The food was awful. Except for the fantastic soup and the bartender was friendly. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}