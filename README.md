# internationalweb

다국어 처리 진행방법

참조 사이트 : http://yoonbumtae.com/?p=754
           https://kururu.tistory.com/192
           https://mytory.net/2019/04/14/spring-boot-internationalization.html

1. application.properties 수정
    아래의 내용 추가 
    (spring.messages.basename : message 파일이 포함되어있는 패스를 기입, message.properties 파일이 존재하는 패스)
    (spring.messages.encoding : 인코딩 종류 지정 )
    spring.messages.basename=messages/message
    spring.messages.encoding=UTF-8
    
2. 다국어 설정을 위한 Config 클래스 생성
    @Configuration 추가
    WebMvcConfigurer 상속

    1. locale 결정 빈 추가
      @Bean
      public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	      return localeResolver;
	    }
      
    2. locale 변경 인터셉터 추가
      @Bean
      public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		    localeChangeInterceptor.setParamName("lang");
		    return localeChangeInterceptor;
	    }
    3. locale 변경내용을 인터셉터 목록에 추가
      @Override
      public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
      }
	
