package com.funzuqiu.ffu.home.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.funzuqiu.ffu.home.common.sms.VerifyCodeUtils;
import com.funzuqiu.ffu.home.common.web.entity.HttpResult;
import com.funzuqiu.ffu.home.modules.ffu.entity.FfuApplication;
import com.funzuqiu.ffu.home.modules.ffu.service.FfuService;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private FfuService ffuService;

    @GetMapping
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("ffu/{channel}")
    public ModelAndView ffu(@PathVariable String channel, ModelAndView mv) {
        mv.setViewName("ffu/" + channel);
        return mv;
    }

    @GetMapping("ffu/join/code")
    public HttpResult verify(@RequestParam String phone) {
        VerifyCodeUtils.sendVerifyCode(phone);
        return HttpResult.ok();
    }

    @PostMapping("ffu/join")
    public HttpResult join(FfuApplication application, HttpSession session) {
        ffuService.register(application, session);
        return HttpResult.ok();
    }

    @GetMapping("league/{league}/{channel}")
    public ModelAndView league(@PathVariable String league, @PathVariable String channel, ModelAndView mv) {
        mv.setViewName("league/" + league + "/" + channel);
        return mv;
    }

    @GetMapping("news")
    public ModelAndView news(ModelAndView mv) {
        mv.setViewName("news/list");
        return mv;
    }

    @GetMapping("news/{id}")
    public ModelAndView news(@PathVariable String id, ModelAndView mv) {
        mv.setViewName("news/detail/" + id);
        return mv;
    }

    @GetMapping("collections")
    public ModelAndView collections(ModelAndView mv) {
        mv.setViewName("collection/list");
        return mv;
    }

}
