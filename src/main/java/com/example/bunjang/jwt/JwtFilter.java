package com.example.bunjang.jwt;

//JWT를 위한 커스텀 필터
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {


    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;


//    실제 필터링 로직은 여기에 작성
//    토큰의 인증정보를 SecurityContext에 저장하는 역할 수행
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String jwt = resolveToken(httpServletRequest); //request에서 해더를 받아와서 저장
        String requestURI = httpServletRequest.getRequestURI();
        
        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) { //토큰의 유효성 검증 메소드 통과
            Authentication authentication = tokenProvider.getAuthentication(jwt); //정상적인 토큰일 경우 토큰에서 authentication 객체를 받아옴
            SecurityContextHolder.getContext().setAuthentication(authentication); // 받아온 authentication 객체를 SecurityContext에 저장
            log.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
        } else {
            log.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

//   Request Header에서 Token을 꺼내오기 위한 resolveToken
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}

