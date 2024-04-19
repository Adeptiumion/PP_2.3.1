package pp_2_3_1.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MVCConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]
                {
                        SpringConfig.class
                };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
