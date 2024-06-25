package com.study.security20240312yeonho.service.auth;

import com.study.security20240312yeonho.web.dto.UsernameCheckReqDto;

public interface AuthService {

	public boolean checkUsername(UsernameCheckReqDto usernameCheckReqDto) throws Exception;
	public boolean signup() throws Exception;
}
