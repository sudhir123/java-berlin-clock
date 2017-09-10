package com.ubs.opsit.interviews;

public class TimeConverterLogic implements TimeConverter{

	@Override
	public String convertTime(String aTime) {

		// TODO Auto-generated method stub
		StringBuilder convertedTime=new StringBuilder();
		String[] strArr=  aTime.split(":");
		
		//yellow logic
		if( (Double.parseDouble(strArr[2])%2) ==0){
			convertedTime.append("Y\r\n");
		}else{
			convertedTime.append("O\r\n");
		}
		
		// hours logic
		if(Integer.parseInt(strArr[0])==0){
			convertedTime.append((pad(rowGenrator(4,"R",4), 4))+"\r\n");
			convertedTime.append((pad(rowGenrator(4,"R",4), 4))+"\r\n");
		}else{
			//first row
			Integer hours = Integer.parseInt(strArr[0]);
			int qqWhenDivideByFive= Math.floorDiv(hours,5);
			convertedTime.append((pad(rowGenrator(4-qqWhenDivideByFive,"R",4), 4))+"\r\n");
			//System.out.println(convertedTime);
			//second Row
			Double remainderHours= Double.parseDouble(strArr[0])%5;
			if( remainderHours==0.0){
				convertedTime.append((pad("", 4))+"");
			}else{
				convertedTime.append((pad(rowGenrator((4-remainderHours.intValue()),"R",4), 4))+"\r\n");
			}
		}
		
		//min logic 
		
		int min= Integer.parseInt(strArr[1]);
		int divideByFiveSlot= Math.floorDiv(min,5);
		convertedTime.append((pad(thirdRow(divideByFiveSlot), 11))+"\r\n");
		
		int remainderForthRow = min%5;
		convertedTime.append((pad(rowGenrator(4-remainderForthRow,"Y",4), 4)));
		return convertedTime.toString();
	
	}

	public static String rowGenrator(Integer appendRed, String appendedChar, Integer dividedSlots) {
    	//logic with hours when 
		//System.out.println("hour::"+appendRed);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<(dividedSlots-appendRed); i++){
			sb.append(appendedChar);
		}
		return sb.toString();
	}
    
    public static String pad(String num, int len){
	    if(len-num.length() <=0) 
	    	return num;
	    StringBuffer sb = new StringBuffer(num);
	    for(int i=num.length(); i<len; i++){
	        sb.append("O");
	    }
	    //sb.append(num);
	    //return sb.reverse().toString();
	    return sb.toString();
	}
    
    public String thirdRow(int divideByFiveSlot) {
    	StringBuffer sb = new StringBuffer();
		int j=2;
		for(int i=0; i<divideByFiveSlot ; i++){
			if(i==j){
				sb.append("R");
				j=j+3;
			}else{
				sb.append("Y");
			}
		}
		return sb.toString();
	}
    
	
	
}
