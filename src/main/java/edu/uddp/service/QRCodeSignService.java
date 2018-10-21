package edu.uddp.service;

import edu.uddp.vo.ResponseData;

import javax.servlet.http.HttpSession;

public interface QRCodeSignService {

    ResponseData codeSign(HttpSession session,String openId,String signPassword);
}
