package check;

import constants.Constants;

public class Check {
	
//課題①
	private static String firstName = "N";
	private static String lastName = "H";
	
//課題②
	private static String getName(String firstName, String lastName) {
		//
		return firstName + lastName;
		//returnで値を渡す
		
	}


public static void main(String[] args) {
	
	System.out.println("printNameメソッド→" + getName(firstName, lastName));

//課題③
	Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,  Constants.CHECK_CLASS_HOGE);
	pet.introduce();
	
	//Petクラス(型）のpetという変数にPetクラスのインスタンスを生成する
	//引数としてJava吉(Constants.CHECK_CLASS_JAVA)、hogeを渡す(Constants.CHECK_CLASS_HOGE)
	//↑ConstantsクラスのCHECK_CLASS_JAVAを呼び出すため 「Constants.CHECK_CLASS_JAVAとなる」
	//pet.introduceは「変数petの紹介をしろ」
	
	RobotPet robotpet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
	robotpet.introduce();

}

}

/*課題①
【Check.java】にてフィールド変数firstNameとlastNameを宣言し、
firstName →　自分の名字　lastName →　自分の名前で初期化しなさい。
なお、変数のアクセス修飾子は「private」とする。

課題②
【Check.java】にてfirstNameとlastNameを★引数で受け取って、
連結して表示させるメソッド「printName」を作成しなさい。
作成した関数のアクセス修飾子は「private」とする。get Name

課題③
【Check.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。*/

