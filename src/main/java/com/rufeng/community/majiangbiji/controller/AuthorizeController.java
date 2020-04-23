package com.rufeng.community.majiangbiji.controller;

import com.rufeng.community.majiangbiji.dto.AccessTokenDto;
import com.rufeng.community.majiangbiji.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state")String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("20088a646b509d7027f4\n");
        accessTokenDto.setClient_secret("77fb618702fd0b1368300a30a6a793bc35180b6a\n");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);
        githubProvider.getAccessToken(accessTokenDto);

        return "index";

    }

}
