    package com.app.studenthub.config;

    import org.springframework.security.core.Authentication;
    import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
    import org.springframework.security.oauth2.core.user.OAuth2User;
    import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
    import org.springframework.stereotype.Component;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import java.io.IOException;

    @Component
    public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


        public CustomAuthenticationSuccessHandler() {
            super();
            setDefaultTargetUrl("/home"); // Set the default page to redirect after successful login
        }

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken)authentication;
            OAuth2User user = oauthToken.getPrincipal();

            String email = user.getAttribute("email"); // Extract email from the authentication object

            System.out.println("In handler" + "Email: " + email);
            if(email == null) {
                // Handle the case where email is not present in the authentication object
                // E.g., redirecting to a "login failed" page or logging out
                response.sendRedirect("/login-failed");
                return;
            }
            if (email.endsWith("@stcloudstate.edu") || email.endsWith("@go.stcloudstate.edu") ) {
                System.out.println("Configuring Handler");

                response.sendRedirect("/home");
            } else {
                // Handle access denial for users with email domains other than @uni.edu
                // E.g., redirecting to a "access denied" page or logging out

                response.sendRedirect("/access-denied");
            }
        }
    }
