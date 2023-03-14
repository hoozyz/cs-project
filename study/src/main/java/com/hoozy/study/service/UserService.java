package com.hoozy.study.service;

import java.io.File;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hoozy.study.entity.User;
import com.hoozy.study.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private static final int SALT_SIZE = 16; // 16비트 솔트 설정

	@Autowired
	private UserRepository userRepository;

	// 유저 업데이트
	public void update(User user) {
		userRepository.save(user);
	}

	// 이메일로 유저 가져오기
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);

		return user;
	}

	// 로그인
	public boolean login(User user) throws Exception {
		String pwd = user.getPwd();
		user = userRepository.findByEmail(user.getEmail());
		if (user == null) {
			return false;
		}
		String salt = user.getSalt();

		if (!(hashing(pwd.getBytes(), salt).equals(user.getPwd()))) {
			return false;
		}

		return true;
	}

	// 유저 생성
	public void create(User user) throws Exception {
		String salt = newSalt();
		String hash = hashing(user.getPwd().getBytes(), salt);
		user.setPwd(hash);
		user.setSalt(salt);
		log.info("해싱 유저 {}", user);

		userRepository.save(user);
	}

	// 비밀번호 해싱하기
	public String hashing(byte[] pwd, String salt) throws Exception {
		// SHA-256 해시 함수 사용
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		// 10번 해시 함수 돌리기. -> 보안성 증가
		for (int i = 0; i < 10; i++) {
			// 비밀번호 + 솔트 값
			String temp = byteToString(pwd) + salt;

			// 위에 값을 해싱하여 md에 저장
			md.update(temp.getBytes());

			// 해싱 값을 pwd에 저장하고 10번 반복.
			pwd = md.digest();
		}

		return byteToString(pwd);
	}

	// 솔트 값 생성 후 16진수로 변경
	public String newSalt() throws Exception {
		// 솔트 값 생성
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[SALT_SIZE];
		sr.nextBytes(salt); // 16개의 랜덤 바이트 배열 생성

		return byteToString(salt);
	}

	// 바이트 배열을 16진수로 변경
	public String byteToString(byte[] temp) {
		// 16진수로 변경
		StringBuilder sb = new StringBuilder();
		for (byte b : temp) {
			// 배열 값마다 2자리 소문자인 16진수로 바꿈
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}

	// email 중복 체크
	public String checkEmail(String email) {
		if (userRepository.findByEmail(email) == null) {
			return "0";
		}

		return "1";
	}

	public String checkNick(String nick) {
		if (userRepository.findByNick(nick) == null) {
			return "0";
		}

		return "1";
	}

	public String checkPwd(String email, String pwd) throws Exception {
		User user = userRepository.findByEmail(email);
		String salt = user.getSalt();
		
		// 원래 비밀번호와 같을 때
		if(hashing(pwd.getBytes(), salt).equals(user.getPwd())) {
			return "1";
		}
		
		return "0";
	}

	public String saveFile(MultipartFile file, String savePath) {
		File folder = new File(savePath);

		// 저장 된 경로가 없으면 폴더를 생성하는 코드
		if (folder.exists() == false) {
			folder.mkdir();
		}

		String originalFileName = file.getOriginalFilename();
		String reNameFileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"))
				+ originalFileName.substring(originalFileName.lastIndexOf("."));
		String reNamePath = savePath + "/" + reNameFileName;

		// 업로드 된 파일의 이름을 변경하고, 실제 보조기억장치(디스크)에 데이터를 저장하는 부
		try {
			file.transferTo(new File(reNamePath));
		} catch (Exception e) {
			return null;
		}

		return reNameFileName;
	}
}
