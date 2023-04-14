package com.hoozy.study.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 이미지 검색하면 바로 브라우저에 띄우는 컨트롤러 -> 데이터로 바로 제공하는 rest api -> RestController
// 원래 파일을 복사해서 rest api로 응답 -> json 형태로 바로 반환
@RestController
public class ImageController {
	
	// 데이터 타입이 이미지 타입이어서 png 타입으로 했다.
	// 
	@GetMapping(value = "/upload/images", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getImage(@RequestParam("file") String file) { // file 명이 파라미터
		
		// 로컬 저장소에 있는 파일을 읽기 위한 스트림
		FileInputStream fis = null;
		
		// 파일을 byte 단위의 배열로 읽어서 내보내는 스트림
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String filePath = "" + file; // 실제 파일 있는 폴더

		try {
			fis = new FileInputStream(filePath);
		} catch (Exception e) {
			throw new RuntimeException("파일이 없습니다.");
		}

		int count = 0;
		// 한 번 읽을 때 1024바이트 만큼
		byte[] buffer = new byte[1024];
		byte[] fileArray = null;

		try {
			// fis.read(buffer) -> 파일로 부터 읽은 byte들을 buffer에 저장하고, 이때 읽은 byte 수를 리턴.
			// 만약, 읽은 byte가 없다면 -1 리턴.
			while ((count = fis.read(buffer)) > 0) {
				// 파일의 전체 byte 수 = count, buffer에 있는 byte 데이터를 count 수 만큼 baos에 저장.
				baos.write(buffer, 0, count);
			}
			// baos 내부에 저장된 byte 배열을 전부 반환
			fileArray = baos.toByteArray();
			fis.close();
			baos.close();
		} catch (Exception e) {
			throw new RuntimeException("파일 변환 오류입니다.");
		}

		return fileArray;
	}
}
