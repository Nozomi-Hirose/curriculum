package study;

// ① TaskクラスにCalculatorクラスを継承させなさい。
	class Task extends Calculator{
	
		
    /**
     * タスクの実行
     */
    public void doTask() {

        // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
        // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。
    	
 
  System.out.println("plusメソッドが引数が一つの場合:" + plus(10));
  System.out.println("plusメソッドが引数が二つの場合:" + plus(10 + 19));
  System.out.println("plusメソッドが引数が三つの場合:" + plus(10+ 19 + 30));
    }
}
	