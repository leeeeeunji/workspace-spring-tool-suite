package com.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseDto {

	private int code;
	private String msg;
	@Builder.Default
	private Object data = new HashMap();

}
