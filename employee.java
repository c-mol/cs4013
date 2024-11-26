import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class employee {
	private String name;
	private int scalepoint;
	private String jobtitle;
	private String jobcatagory;
	private double salary;
    Scanner line ;  // Create a Scanner object

	
	employee(String name,String jc,String jt,int sp)throws FileNotFoundException
	{
		this.name=name.toUpperCase();
		this.jobcatagory=jc.toUpperCase();
		this.jobtitle=jt.toUpperCase();
		this.scalepoint=sp;
		this.setsalary();
		
		
	}
	

	employee(String input)throws FileNotFoundException{
		String[] parts=input.split(",");

		this.name=parts[0].toUpperCase();
		this.jobcatagory=parts[1].toUpperCase();
		this.jobtitle=parts[2].toUpperCase();
		this.scalepoint=Integer.parseInt(parts[3]);
		this.setsalary();
		
	}
	
	//getter methods
	
	/**
	 * gets the salary of this employee
	 * returns double
	 * @throws FileNotFoundException 
	 * */
	public double getSalary() throws FileNotFoundException{
		line = new Scanner(new File("../ulpay/src/payscale.csv"));
		boolean done=false;
		String header=line.nextLine();
		while(line.hasNext())
		{
			String input=line.nextLine();
			if(input.equals(this.getJobcatagory())) {
				while(line.hasNext()) {
					//finds salary
					input=line.nextLine();
					String[] parts=input.split(",");
					
					if(this.scalepoint==Integer.parseInt(parts[1]) && this.jobtitle.equals(parts[0]) )
					{
						return Double.parseDouble(parts[2]);
					}
				
				}
			}
		}
		return -1;
	}
	public String getJobcatagory() {
		return this.jobcatagory;
	}
	/**
	 * gets the salary of this employee
	 * @returns double
	 * may not be as accurate as getSalary 
	 * */
	public double getsalary() {
		return this.salary;
	}
	/**
	 * gets the salary of this employee
	 * @returns double
	 * */
	public String getJobtitle(){
		return this.jobtitle;
	}
	public int getScalepoint(){
		return this.scalepoint;
	}
	//setter
	/**
	 * sets the scale point of the employee
	 * @param number of the point of the scale as an int.
	 * */
	public void setscalepoint(int sp) {
		this.scalepoint=sp;
	} 
	/**
	 * sets the job title of the employee
	 * @param the title of the job gets in upper or lowercase.
	 * */
	public void setjobtitle(String jt) {
		jt.toUpperCase();
		this.jobtitle=jt;
	} 
	/**
	 * sets the job category ie. academic,information technology ect.
	 * @param the title of the job gets in upper or lower case.*/
	public void setjobcatagory(String jc) {
		jc.toUpperCase();
		this.jobcatagory=jc;
	} 
	
	/**
	 * based on the jobtitle and scale point it finds what the salary should be and sets that as the salary
	 * 
	 * */
	public void setsalary() throws FileNotFoundException {
		line = new Scanner(new File("../ulpay/src/payscale.csv"));
		boolean done=false;
		line.nextLine();
		while(line.hasNext()&&!done)
		{
			String input=line.nextLine();
			if(input.equals(this.jobcatagory)) {
				while(line.hasNext()&&!done) {
					//finds salary
					input=line.nextLine();
					String[] parts=input.split(",");
					
					if(this.scalepoint==Integer.parseInt(parts[1]) && this.jobtitle.equals(parts[0]) )
					{
						this.salary=Double.parseDouble(parts[2]);
						done=true;
					}
				
				}
			}
		}
	}
	/**gets the top of the payscale for a given profession.
	 * */
	public int getTopPayscale() throws FileNotFoundException {
		line = new Scanner(new File("../ulpay/src/payscale.csv"));
		boolean done=false;
		int topPayscale;
		//line.nextLine();
		while(line.hasNext())
		{
			String input=line.nextLine();
			if(input.equals(this.jobcatagory)) {
				while(line.hasNext()&&!done) {
					input=line.nextLine();
					String[] parts=input.split(",");
					if( this.jobtitle.equals(parts[0]) )
					{
					input=line.nextLine();
					
					return topPayscale=Integer.parseInt(parts[1]);
					}
				
				}
				}
		}
	
		return -1;
	}
	/**
	 * Moves an employee to the next job title up and sets their salary. 
	 * It then puts them on the first point of the payscale.
	 * 
	 * */
	public void moveupincatagory() throws FileNotFoundException {
		String current=this.getJobtitle();
		line = new Scanner(new File("../ulpay/src/payscale.csv"));
		boolean done=false;
		String change=current;
		line.nextLine();
		while(!done&&line.hasNext()) {
			String input=line.nextLine();
			if(input.equals(this.jobcatagory)) {
				//in the right catagory
				while(line.hasNext()&&!done) {
					input=line.nextLine();
					String[] parts=input.split(",");
					if( current.equals(parts[0]) )
					{
					done=true;
					}
					else{change=parts[0];}
				
				}
				}
			
		}
		if(change!=current) {
		this.setjobtitle(change);
		this.setscalepoint(1);
		this.setsalary();}
		else {System.out.print("At the top\n");}
		
	}
	/**
	 * moves employee up a salary point
	 * */
	public void moveupsalarypoint() throws FileNotFoundException {//check if theycan move up
		if(this.getTopPayscale()>this.scalepoint) {
			this.setscalepoint(this.scalepoint+1);
			this.setsalary();
			;}
		else {System.out.println("Top of payscale\n");}
	}
	
	/**
	 * converts datafields to string
	 * */
	
	public String toString() {
		return this.name+","+this.jobcatagory+","+this.getJobtitle()+","+this.getsalary()+" ";
	}
	
	
	
	
}


