// url경로
var serverRoot2 = 'http://localhost:8888/bitcamp-java-project';
// var serverRoot2 = 'http://tamlaisjeju.java106.com:8888/bitcamp-java-project'

// express 추가
const request = require('request');
var express = require('express');
var session = require('express-session');
var app = express();


// passport 추가
var passport = require('passport');
var FacebookStrategy = require('passport-facebook').Strategy;
var KakaoStrategy = require('passport-kakao').Strategy;
var GoogleStrategy = require('passport-google-oauth20').Strategy;
var NaverStrategy = require('passport-naver').Strategy;

// jade...html 이거로 보고싶으면 하고
app.set('view engine', 'jade');
app.set('views', './views');
app.use(express.static('public'));

app.get('/auth/logout', function(req, res){
    req.logout();
    request(serverRoot2 + '/json/auth/logout');
    console.log('로그아웃완료');
    res.redirect(serverRoot2 +"/tamlaisjeju/index.html");
});

//미들웨어 설정 필수!!!
app.use(passport.initialize());
app.use(passport.session({}));

passport.serializeUser(function(user, done) {
     done(null, user);
});
  
passport.deserializeUser(function(user, done) {
    done(null, user);
});

var fbAccessToken;
var kaAccessToken;

// 페이스북 인증
passport.use(new FacebookStrategy({
        clientID: '228605734455848',
        clientSecret: 'e16581e68a8639de8bf57f08d7654665',
        callbackURL: "/auth/facebook/callback",
        profileFields: ['email', 'name', 'displayName', 'gender']
    },
    function(accessToken, refreshToken, profile, done) {
        fbAccessToken = accessToken;
        done(null,profile);
    }
));

app.get('/auth/facebook', passport.authenticate('facebook', {scope: ['email']}));

app.get('/auth/facebook/callback',
    passport.authenticate('facebook', 
        { //successRedirect: '/welcome',
          failureRedirect: '/auth' }), 
    (req, res) => {
        // 8888 서버에 요청하기

     //   console.log(req);
        console.log(req.session);


        request(serverRoot2 +`/json/auth/facebookLogin?accessToken=${fbAccessToken}`,{ json: true }, (err, resp, body) => {
            console.log("8888 서버에서 응답이 왔음!")
            console.log(body);
            if (body.status === "success") {
                res.redirect(serverRoot2 +"/tamlaisjeju/index.html");
            } else {
                //res.redirect("http://localhost:8888/bitcamp-java-project/tamlaisjeju/index2.html");
                console.log('로그인 실패!')
            }

        });

    }
);

app.get('/auth/is', (req, res) => {
    request(serverRoot2 +"/json/auth/islogin"), {json:true}, (err, resp, body) => {
        console.log(body);
    }   
})

// 카카오 인증
passport.use(new KakaoStrategy({
    clientID: 'cbfb710c30c958007d125829a9752b7c',
    clientSecret: 'efWXNj2rcdNUzB0htLB8icZIl4Dz657m',
    callbackURL: "/auth/kakao/callback",
    profileFields: ['id', 'properties', 'kakao_account.email','kakao_account.gender']
    },
    function(accessToken, refreshToken, profile, done){
        kaAccessToken = accessToken;
        console.log("2222222");
        console.log(kaAccessToken);
        done(null,profile);
    }
));

app.get('/auth/kakao', passport.authenticate('kakao', {scope: ['profile']}));

app.get('/auth/kakao/callback',
    passport.authenticate('kakao', 
        { //successRedirect: '/welcome',
        failureRedirect: '/auth' }),
        (req,res) => {
            console.log('====================>');
            console.log(req.user);
            console.log(kaAccessToken);

            // 8888 서버에 요청하기
        request(serverRoot2 +`/json/auth/kakaoLogin?accessToken=${kaAccessToken}`,{ json: true }, (err, resp, body) => {
            console.log("8888 서버에서 응답이 왔음!")
            if (body.status === "success") {
                console.log(body);
                res.redirect(serverRoot2 +"/tamlaisjeju/index.html");
            } else {
                //res.redirect("http://localhost:8888/bitcamp-java-project/tamlaisjeju/index2.html");
                console.log('로그인 실패!')
            }

            });
        }
);

app.get('/auth/is', (req, res) => {
    request(serverRoot2 +"/json/auth/islogin"), {json:true}, (err, resp, body) => {
        console.log(body);
    }   
})

// 구글 인증
passport.use(new GoogleStrategy({
    api_key: 'AIzaSyDgj_0GgwgTt3qrtq_SNuZLemzIbqaexJU',
    clientID: '216742254118-u8424bjgqqohd6evp78ar2llqdd5uiv2.apps.googleusercontent.com',
    clientSecret: '-bW-0FIjukXhToiKItkHR--4',
    callbackURL: '/auth/google/callback'
    },
    function(accessToken, refreshToken, profile, donen, api_key){
        ggAccessToken = api_key;
        done(null,profile);
        console.log(profile);
        data = profile;
    }
));

app.get('/auth/google', passport.authenticate('google', {scope: ['profile']}));

app.get('/auth/google/callback',
    passport.authenticate('google', 
        { //successRedirect: '/welcome',
        failureRedirect: '/auth' }),
        (req,res) => {
            console.log(ggAccessToken);

            // 8888 서버에 요청하기
        request(serverRoot2 +`/json/auth/googleLogin?accessToken=${ggAccessToken}`,{ json: true }, (err, resp, body) => {
            console.log("8888 서버에서 응답이 왔음!")
            if (body.status === "success") {
                console.log(body);
                res.redirect(serverRoot2 +"/tamlaisjeju/index.html");
            } else {
                //res.redirect("http://localhost:8888/bitcamp-java-project/tamlaisjeju/index2.html");
                console.log('로그인 실패!')
            }

            });
        }
);

app.get('/auth/is', (req, res) => {
    request(serverRoot2 +"/json/auth/islogin"), {json:true}, (err, resp, body) => {
        console.log(body);
    }   
})


app.listen(8000);