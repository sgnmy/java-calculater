package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.ResultEntity;
import com.example.demo.repositories.Webcalc_Result_Repository;
import com.example.demo.services.CalcService;

@Controller
public class CalcController {

	

	@Autowired
	private CalcService service;
	
	@Autowired 
	private Webcalc_Result_Repository repository;//インスタンス化されている
	

	public String insertTable(String calcResult) {

		System.out.println("[START] ORALCEに接続して従業員データを取得します。");
	    repository.insertResult(calcResult);//メソッドに引数として変数を渡す
		
		System.out.println("[END  ] ORALCEに接続して従業員データを取得します。");
		
		return calcResult;
		
	}
    
	
	


	@PostMapping("calc") //これがあるとhtmlからのリクエストを受け取って飛んでくれる
	public String calc() {


		return "calc";
	}
	
	@PostMapping("History") 
	public String History(
			Model model
		) {
	   
	   List<ResultEntity> ResultHistory = new ArrayList<ResultEntity> ();
	   //List<はスペース空けない、>の後ろはスペース空ける
	   ResultHistory = repository.findAll();
	   model.addAttribute("kotae",ResultHistory);//ResultHistoryに答えが代入されている
		
    

		return "History";

	}
	
	

	@PostMapping("resAdd") 
	public String resAdd(
			Model model,
			@RequestParam("numA") String NumA,//htmlのnumAをキャッチしてjavaの
                                              //numAに代入
			@RequestParam("numB") String NumB

			) {
		String AdResult = service.calculateAdd(NumA, NumB);
		if( AdResult == "Aderror") { //計算結果がエラーならエラー画面へ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", AdResult );//大事
		
		insertTable(AdResult);
		


		return "res";

	}

	@PostMapping("resSub")
	public String resSub(
			Model model,
			@RequestParam("numA") String NumA,
			@RequestParam("numB") String NumB

			) {
		String SubResult=service.calculateSubtract(NumA, NumB);
		if(SubResult=="Suberror") {
			return"error";

		}
		model.addAttribute("kotae",SubResult);
		
		insertTable(SubResult);
		
		
		
		

		return "res";

	}

	@PostMapping("resMul")
	public String resMul(
			Model model,
			@RequestParam("numA") String NumA,
			@RequestParam("numB") String NumB

			) {
		String MulResult=service.calculateMultiply(NumA, NumB);
		if(MulResult=="Mulerror") {
			return"error";
		}
		model.addAttribute("kotae", MulResult);
		
		insertTable(MulResult);
		

		return "res";

	}

	@PostMapping("resDiv")
	public String resDiv(
			Model model,
			@RequestParam("numA") String NumA,
			@RequestParam("numB") String NumB

			) {
		String DivResult=service.calculateDivide(NumA, NumB);
		if(DivResult=="Diverror") {
			return"error";
		}
		model.addAttribute("kotae", DivResult);
		
		insertTable(DivResult);
		

		return "res";
		
	
		
	}
	
	
}


	
		
			
			
			
		
		
		
	
			
	
	

	

	//	引き算、掛け算、割り算を記載していきましょう。
	//	ですが、割り算はちょっと特殊なので注意しましょう！
	//	割り算の答えの出し方をよく思い出してくださいね、他の掛け算までの答え方とは別で回答パターンが複数あると思います、
	//	それを意識してコードを書いていってください。

