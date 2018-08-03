"use strict";
const express = require('express');
const router = express.Router();
const passport = require('passport');
const userService = require('../service/userService');

// 로그인 페이지 진입
router.get('/login', function (req, res) {
    let redirectUrl = req.query.redirectUrl;

    if (redirectUrl) {
        res.cookie("redirectUrl", redirectUrl, {
            expires: new Date(Date.now() + (60 * 1000 * 2)),
            httpOnly: true
        });
    }

    res.render('login', {title: '마크다운 에디터 - 로그인', isLogin: false});
});

// 로그아웃
router.get('/logout', (req, res) => {
    req.logout();
    res.redirect('/bitcamp-java-project/tamlaisjeju');
});

// 페이스북 로그인 시작
router.get('/facebook', passport.authenticate('facebook'));

// 페이스북 로그인 결과 콜백
router.get('/facebook/callback', passport.authenticate('facebook', {
    failureRedirect: '/bitcamp-java-project/tamlaisjeju/auth/login'
}), (req, res) => {
    loginSuccessHandler(req, res);
});

// 구글 로그인 시작
router.get('/google', passport.authenticate('google'));

// 구글 로그인 결과 콜백
router.get('/google/callback', passport.authenticate('google', {
    failureRedirect: '/bitcamp-java-project/tamlaisjeju/auth/login'
}), (req, res) => {
    loginSuccessHandler(req, res);
});

// 로그인 성공시 처리
function loginSuccessHandler(req, res) {
    let successRedirectUrl = "/bitcamp-java-project/tamlaisjeju";

    if (req.cookies.redirectUrl) {
        successRedirectUrl = req.cookies.redirectUrl;
        res.clearCookie("redirectUrl");
    }

    return res.redirect(successRedirectUrl);
}

module.exports = router;