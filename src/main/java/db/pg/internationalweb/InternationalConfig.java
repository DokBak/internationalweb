package db.pg.internationalweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalConfig implements WebMvcConfigurer{

    @Bean  // Locale 결정 빈 
	public LocaleResolver localeResolver() {
        
        // Header정보로 부터 locale 정보를 취득
        //AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
        // Cookie정보로 부터 locale 정보를 취득
        //CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        //localeResolver.setCookieName("language");
        //localeResolver.setCookieMaxAge(3600);

        // 고정된 언어 사용되도록 지정
        //FixedLocaleResolver localeResolver = new FixedLocaleResolver();

        // Session정보로 부터 locale 정보를 취득        
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();

        // 디폴트값 지정, 설정하지 않은 경우 접속중인 국가로 자동 설정됨
		//localeResolver.setDefaultLocale(Locale.JAPAN);
		return localeResolver;
	}
	
	@Bean  // 2 Locale 변경 Interceptor 
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // ParamName은 아무거나 지정하여도 된다.
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	@Override // 3 Interceptor 목록에 변경된 Locale 내용을 등록
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

}
