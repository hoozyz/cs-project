package com.hoozy.study.entity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class S3Uploader {
	
	private final AmazonS3Client amazonS3Client;

	@Value("${cloud.aws.s3.bucket}") // 버킷 명 가져와서 담기
	private String bucket;
	
	// multipartfile 가져와서 파일로 변환 후 업로드
	public String uploadFile(MultipartFile file, String dirName) throws IOException {
        File uploadFile = convert(file)
        .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));

        return upload(uploadFile, dirName);
	}

    public String upload(File uploadFile, String dirName) {
    	// S3에 저장된 파일 경로 -> 이미지 명이 겹칠수도 있어서 UUID로 유일한 값 만들어 저장 -> images/ 폴더에 저장
    	String fileName = dirName + "/" + uploadFile.getName();
        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
        removeNewFile(uploadFile);
        return uploadImageUrl; // S3 이미지 url 반환
    }

    // 실제로 S3 저장소에 업로드 하고 url을 반환하는 메소드
    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile)
        		.withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    // 이미지 변경할 떄 이전 이미지 지우기
    public void deleteFile(String fileName) {
    	fileName = "static/" + fileName; // 폴더명까지 적어줘야한다.
    	amazonS3Client.deleteObject(new DeleteObjectRequest(bucket, fileName));
    }

    // 로컬에 저장된 이미지 지우기
    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("파일 삭제 성공");	
            return;
        }
        log.info("파일 삭제 실패");
    }

    // 로컬에 파일 업로드 하기
    private Optional<File> convert(MultipartFile file) throws IOException {
    	// user.dir : 현재 폴더 가져오기.
    	// 현재 폴더에 이미지 -> 현재 시간을 밀리초까지 넣어서 이미지 안겹치게 함
        File convertFile = new File(System.getProperty("user.dir") + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"))
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))); 
        if(convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}
