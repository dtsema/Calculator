package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Contoller implements Initializable
{
	String add = " \\+ ";
	String subtract = " ";
	String multiply = " x ";
	String divide = " ÷ ";
	String decimal = ".";
		
	String[] mathSymbols = {add, subtract, multiply, divide};
	@FXML TextArea answerfield;
    @FXML Button zero, one, two, three, four, five, six, seven, eight, nine;
   
	String inputDataString ="";
	String pressed = "";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }
    
    private void addDecimal(String sign, String regex){
    	 
    	if (inputDataString.contains(".") && inputDataString.contains(sign)){
    		String[] subString = inputDataString.split(regex);
    		if (!subString[1].contains(".")){
    			subString[1] += decimal;
    			inputDataString = subString[0] + sign + subString[1];
    		}
    	}
    }
    
    @FXML public void decimal(ActionEvent event){
   
    	if (!inputDataString.contains(".")){
    	inputDataString += decimal;
    	}
    	 
    	addDecimal("+", "\\+");
    	addDecimal("-", "-");
    	addDecimal("x", "x");
    	addDecimal("÷", "÷");
    
    	answerfield.setText(inputDataString);
    }
   
    @FXML public void C (ActionEvent event){
    	inputDataString = "0";
    	answerfield.setText(inputDataString);
    }
     
    @FXML public void textSize (){
    	if (inputDataString.length() < 12){
    		answerfield.setStyle("-fx-font-size: 30px;");
    	}
    	else if (inputDataString.length() == 12){
    		answerfield.setStyle("-fx-font-size: 29px;");
    	}
    	else if(inputDataString.length() == 13){
    		answerfield.setStyle("-fx-font-size: 27px;");
    	}
    	else if(inputDataString.length() == 14){
    		answerfield.setStyle("-fx-font-size: 25px;");
    	}
    	else if(inputDataString.length() == 15){
    		answerfield.setStyle("-fx-font-size: 24px;");
    	}
    	else if(inputDataString.length() == 16){
    		answerfield.setStyle("-fx-font-size: 22px;");
    	}
    	else if(inputDataString.length() == 17){
    		answerfield.setStyle("-fx-font-size: 21px;");
    	}
    	else if(inputDataString.length() == 18){
    		answerfield.setStyle("-fx-font-size: 20px;");
    	}
    	else if(inputDataString.length() == 19){
    		answerfield.setStyle("-fx-font-size: 19px;");
    	}
    	else if(inputDataString.length() == 20){
    		answerfield.setStyle("-fx-font-size: 18px;");
    	}
    	else if(inputDataString.length() == 21){
    		answerfield.setStyle("-fx-font-size: 17px;");
    	}
    	
    }
    
    @FXML public void backspace(ActionEvent event){
    	StringBuilder sb = new StringBuilder(inputDataString);
    	int index = sb.length() - 1;
    	
    	if(sb.charAt(index)==' ' && sb.charAt(index-1)=='x'){
    		sb.delete(index-2, index);	
    	}
    	else if(sb.charAt(index)==' ' && sb.charAt(index-1)=='÷'){
    		sb.delete(index-2, index);
    	}
    	else if(sb.charAt(index)==' ' && sb.charAt(index-1)=='+'){
    		sb.delete(index-2, index);
    	}
       	else{
    		sb.deleteCharAt(index);
    	}
    	inputDataString = sb.toString();
    	inputDataString= inputDataString.trim();
    	answerfield.setText(inputDataString);
    }
    
    @FXML public void addDigit(ActionEvent event){
    	 Button[] array = {zero, one, two, three, four, five, six, seven, eight, nine};
    	 
    	for (int i =0; i < array.length; i++){
    		 if (event.getSource().equals(array[i])){
    			pressed = Integer.toString(i);
    			
    			break;
    		 }
    	 }
    	
    	if (inputDataString.length() <=42){
    		inputDataString += pressed;
    		textSize();
    	
    		StringBuilder sb = new StringBuilder(inputDataString);
    	
    		if (sb.charAt(0) == '0'){
    			sb.deleteCharAt(0);
    			inputDataString = sb.toString();
    		}
    		answerfield.setText(inputDataString);
    		}
    	}
     
    @FXML public void times(ActionEvent event2){
    	if(!inputDataString.endsWith(" + ") && !inputDataString.endsWith(" -") && !inputDataString.endsWith(" ÷ ") && !inputDataString.endsWith(" x ") ){

			inputDataString = inputDataString + " x ";
			answerfield.setText(inputDataString);
		}
    }

    @FXML public void div(ActionEvent event3){
    	if(!inputDataString.endsWith(" + ") && !inputDataString.endsWith(" -") && !inputDataString.endsWith(" ÷ ") && !inputDataString.endsWith(" x ") ){
			inputDataString = inputDataString + " ÷ ";
			answerfield.setText(inputDataString);
    	}	
    }

    @FXML public void plus(ActionEvent event4){
    	if(!inputDataString.endsWith(" + ") && !inputDataString.endsWith(" -") && !inputDataString.endsWith(" ÷ ") && !inputDataString.endsWith(" x ") ){
			inputDataString = inputDataString + " + ";
			answerfield.setText(inputDataString);
		}	
    }

    @FXML public void minus(ActionEvent event5)
    {
    	if(!inputDataString.endsWith(" + ") && !inputDataString.endsWith(" -") && !inputDataString.endsWith(" ÷ ") && !inputDataString.endsWith(" x ") ){

			inputDataString = inputDataString + " -";
			answerfield.setText(inputDataString);
		}
        
    		
        }
           
    @FXML public void equals(ActionEvent event1){
    	double answer = 0;
    	
		if (inputDataString.contains("+") && !inputDataString.endsWith(" + ")){
			answer = doMath(inputDataString, 0);
			inputDataString = Double.toString(answer);
			textSize();
			answerfield.setText(inputDataString);
		}
		else if(inputDataString.contains("-") && !inputDataString.endsWith("-")){
			answer = doMath(inputDataString, 1);
			inputDataString = Double.toString(answer);
			textSize();
			answerfield.setText(inputDataString);
		}
		else if(inputDataString.contains("x") && !inputDataString.endsWith(" x ")){
			answer = doMath(inputDataString, 2);
			inputDataString = Double.toString(answer);
			textSize();
			answerfield.setText(inputDataString);
		}
		else if (inputDataString.contains("÷")){
			answer = doMath(inputDataString, 3);
			inputDataString = Double.toString(answer);
			textSize();
			answerfield.setText(inputDataString);
		}
		else if (inputDataString.endsWith(" ") || (inputDataString.endsWith("-"))){
			answerfield.setText(inputDataString);
		}
    }
    	
   	public double doMath (String enteredData, Integer mathType){

   		StringBuilder sb = new StringBuilder(enteredData);
   		if(enteredData.charAt(0) == ' '){
   			 sb.deleteCharAt(0);
   			 enteredData = sb.toString();
   		}
   			
   		String[] array = enteredData.split(mathSymbols[mathType]);
   		
   		double[] data = new double[array.length];
   		for (int i =0; i<array.length; i++){
   			data[i] = Double.parseDouble(array[i]);	
   		}
   		double answer = data[0];
   			 
   		for (int i = 1; i<array.length; i++){
   			if(mathType == 0 || mathType == 1){	
   				answer = answer + data[i];
   			}
   			else if (mathType == 2){
   				answer = answer * data[i]; 
   			}
   			else if (mathType == 3){
   				answer = answer / data[i];
   			}
   		}
   		return answer;
   	}
}
   	
   