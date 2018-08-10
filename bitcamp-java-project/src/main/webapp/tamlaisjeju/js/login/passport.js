const FacebookStrategy = require('passport-facebook').Strategy;
const GoogleStrategy = require('passport-google-oauth').OAuth2Strategy;
const userService = require('../service/userService');

module.exports = (passport) => {
    passport.serializeUser((user, done) => {
        done(null, user);
    });

    passport.deserializeUser((user, done) => {
        done(null, user);
    });

    passport.use(new FacebookStrategy({
            clientID: "",
            clientSecret: "",
            profileFields: ['id', 'displayName', 'photos'],
            callbackURL: 'http://localhost:8888/bitcamp-java-project/tamlaisjeju/auth/facebook/callback'
        },

        function (accessToken, refreshToken, profile, done) {
            const socialId = profile.id;
            const nickname = profile.displayName;
            const profileImageUrl = profile.photos[0].value;

            onLoginSuccess('Facebook', socialId, nickname, profileImageUrl, done);
        }
    ));

    passport.use(new GoogleStrategy({
            clientID: "",
            clientSecret: "",
            callbackURL: 'http://localhost:8888/bitcamp-java-project/tamlaisjeju/auth/google/callback',
            scope: ['https://www.googleapis.com/auth/plus.me']
        }, function (accessToken, refreshToken, profile, done) {
            const socialId = profile.id;
            const nickname = profile.displayName;
            const profileImageUrl = profile.photos[0].value;

            onLoginSuccess('Google', socialId, nickname, profileImageUrl, done);
        }
    ));

    function onLoginSuccess(platformName, socialId, nickname, profileImageUrl, done) {
        userService.findOrCreate(platformName, socialId, nickname, profileImageUrl)
            .spread((user, created) => {
                if (user.state === 1) {
                    userService.updateUserToJoinedState(user)
                        .then(result => {
                            done(null, user);
                        })
                        .catch(err => {
                            done(null, user);
                        })
                } else {
                    done(null, user);
                }
            });
    }
};