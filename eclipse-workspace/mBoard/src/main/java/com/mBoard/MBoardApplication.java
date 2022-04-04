package com.mBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MBoardApplication { // string boot를 런치시키는 중요한 클래스. 이 부분은 매우 중요하니 조심히 다룰 것.

	public static void main(String[] args) {
		SpringApplication.run(MBoardApplication.class, args);
	}

}
