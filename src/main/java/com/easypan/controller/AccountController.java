package com.easypan.controller;

import static com.easypan.shared.constants.CheckCodeConstants.CHECK_CODE_KEY;
import static com.easypan.shared.constants.CheckCodeConstants.CHECK_CODE_KEY_EMAIL;

import com.easypan.service.UserInfoService;
import com.easypan.shared.dto.CreateImageCode;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AccountController {
  @Resource UserInfoService userInfoService;

  @RequestMapping("/checkCode")
  public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws IOException {
    CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);

    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");

    String code = vCode.getCode();

    if (type == null || type == 0) {
      session.setAttribute(CHECK_CODE_KEY, code);
    } else {
      session.setAttribute(CHECK_CODE_KEY_EMAIL, code);
    }

    vCode.write(response.getOutputStream());
  }
}
