# next-security
# SpringSecurity流程
SecurityContextPersistenceFilter  
    -> UsernamePasswordAuthenticationFilter 
    -> BasicAuthenticationFilter 
        -> ExceptionTranslationFilter  
            -> FilterSecurityInterceptor


