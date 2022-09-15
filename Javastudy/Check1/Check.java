/**
 * バブルソート
 * チェックテスト-Java1章
 *
 */
public class Check{
    public static void main(String[] args){
        /*
        * 問1
        * int型の配列dataを作成し、値を3,1,2,7,5で初期化しなさい
        */int [] data = {3,1,2,7,5};

        /*
        * 問2
        * 以下のfor文を完成させなさい
        */
        //↓このコードは「3 1 2 7 5 」と出力するためのコード
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();

        //配列の要素[0]、[1]、[2]，[3]，[4]に入る数字を昇順で決めたい。（i<data.length）
        //i++は外側のfor文が一巡するたびに決定したい要素の場所が右にずれていく.

        for (int i = 0; i < data.length; i++) {

            //int j = data.length-1は１番右の要素[4]。lengthだけだと[5]が出る。
            //j>iは、iよりもjが大きいときに比較する。
            //j--は内側のfor文が一巡する度に左にずれて比べるため。
            for (int j = data.length -1; i<j; j--) {
                /*
                * 問3
                * 以下、配列の添字を入れてソートを完成させなさい
                */
                //比べる数字で左側にいる要素を[j-1]、右側にいる要素を[j]としている
                //[j-1]が[j]よりも大きい時に左右の並び順の交換が発生。
                if(data[j - 1] > data[j]){
                    //一旦、[j]を避難boxに入れる
                  int box = data[j];
                  //data[j]の居たところにdata[j-1]を入れる
                  data[j] = data[j -1];
                  //data[j-1]がいたとことに[j]を入れる。（今、[j]は避難BOXにいるため変数boxを代入）
                  data[j - 1] = box;
                }
            }
        }
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }
}