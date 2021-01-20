package com.buyer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class BeforeAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{

}
