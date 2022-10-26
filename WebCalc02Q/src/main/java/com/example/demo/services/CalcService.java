package com.example.demo.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalcService {



	//足し算
	public String calculateAdd(
			String NumA,//受け取った引数をいれる
			String NumB
			)

	{	
		String AdResult = null;
		BigDecimal AdA = null;
		BigDecimal AdB = null;
		try {
			AdA = new BigDecimal(NumA);//()の中をbigdecimal型に変換（キャスト）
			AdB = new BigDecimal(NumB);
			BigDecimal AdR = AdA.add(AdB);//bigdecimal型で計算するときはこれ
			AdResult = AdR.toString();

		} catch (Exception e) {
			AdResult = "Aderror";//エラーの場合はこれをキャッチ

		}
		return AdResult;
	}


	//引き算
	public String calculateSubtract(
			String NumA,
			String NumB


			)
	{
		String SubResult=null;
		BigDecimal SubA=null;
		BigDecimal SubB=null;
		try {
			SubA = new BigDecimal(NumA);
			SubB = new BigDecimal(NumB);
			BigDecimal SubR = SubA.subtract(SubB);
			SubResult = SubR.toString();

		}catch(Exception e) {
			SubResult="Suberror";


		}
		return SubResult;


	}

	//掛け算
	public String calculateMultiply(
			String NumA,
			String NumB

			)
	{

		String MulResult=null;
		BigDecimal MulA=null;
		BigDecimal MulB=null;

		try {
			MulA = new BigDecimal(NumA);
			MulB = new BigDecimal(NumB);
			BigDecimal MulR = MulA.multiply(MulB);
			MulResult = MulR.toString();


		}catch(Exception e) {
			MulResult="Mulerror";

		}

		return MulResult;

	}


	//割り算
	public String calculateDivide(
			String NumA,
			String NumB
			)
	{

		String DivResult=null;
		BigDecimal DivA=null;
		BigDecimal DivB=null;

		try {
			DivA = new BigDecimal(NumA);
			DivB = new BigDecimal(NumB);
			BigDecimal DivR = DivA.divide(DivB);
			DivResult = DivR.toString();
			return DivResult;


		}catch(NumberFormatException e) { //記号の場合
			DivResult="Diverror";
			return DivResult;


		}catch(ArithmeticException e) { //無限小数の場合
			System.out.println(e);	 
			return"無限小数の答えになりました";


		}

	}






}


//		割り算に関しては特殊なので注意
//		
//		ヒントとしてtry、catch構文も記載はしておきます。
//		
//		後は調べてね！

//		try {
//			BigDecimal AdR = 〇〇.〇〇(AdB);
//			return AdR.toString();
//		} catch (Exception e) {
//			return "無限小数の答えになりました";
//		}

/*このコメントアウトは消さない方がいい
 * これは無限少数の桁を設定する際に必要
	BigDecimal AdR = AdA.divide(AdB,7,RoundingMode.HALF_UP); //BigDecimal 〇〇= 〇〇.add(〇〇); これは足し算を書くとき
	String AdResult = AdR.toString();//toStringはクラスで定義されている文字列表現を返すメソッド
	return AdResult;
 */


