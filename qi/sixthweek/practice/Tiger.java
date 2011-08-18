ipublic class Tiger implements Mammal{
	public void breath(){
		System.out.println("The Tiger breath");
	}
	public void eat(){
		System.out.println("The Tiger eat");
	}
	public void sleep(){
		System.out.println("The Tiger sleep");
	}
	public void run(){
		System.out.println("The Tiger run");
	}
	public static void main(String[] args){
		Tiger tiger = new Tiger();
		tiger.breath();
		tiger.eat();
		tiger.sleep();
		tiger.run();
	}

}
