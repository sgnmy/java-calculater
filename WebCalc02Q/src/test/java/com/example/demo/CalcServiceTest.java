package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.services.CalcService;

class CalcServiceTest {

	private CalcService service = new CalcService();
	
	@Test//足し算
	public void testAdd() {
		
		String actual = service.calculateAdd("3","1");//クラスじゃなくてインスタンスから呼ぶ
		assertEquals( "4", actual);//期待値,結果
	}
	
	@Test//足し算エラー
	public void testAderror() {
		
		String actual = service.calculateAdd("@","1");
		assertEquals("Aderror",actual);
	}
	
	@Test//引き算
	public void testSub() {
		
		String actual = service.calculateSubtract("3","1");
		assertEquals( "2", actual);
	}
	
	@Test//引き算エラー
	public void testSuberror() {
		
		String actual = service.calculateSubtract("@","1");
		assertEquals("Suberror",actual);
	}
	
	@Test//掛け算
	public void testMul() {
		
		String actual = service.calculateMultiply("3","1");
		assertEquals( "3", actual);
	}
	
	@Test//掛け算エラー
	public void testMulerror() {
		
		String actual = service.calculateMultiply("@","1");
		assertEquals("Mulerror",actual);
	}
	
	@Test//割り算
	public void testDiv() {
		
		String actual = service.calculateDivide("3","1");
		assertEquals( "3", actual);
	}
	
	@Test//割り算 無限小数
	public void testDiv2() {
		
		String actual = service.calculateDivide("1","3");
		assertEquals( "無限小数の答えになりました", actual);
	}
	
	@Test//割り算エラー
	public void testDiverror() {
		
		String actual = service.calculateDivide("@","1");
		assertEquals("Diverror",actual);
	}

}
