/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.controladores;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *
 * @author roddycorrea
 */
public class ClickjackFilter implements Filter{
    private String mode = "DENY";
    private String xss_protection = "1; mode=block";
    	
    /**
     * Add X-FRAME-OPTIONS response header to tell IE8 (and any other browsers who
     * decide to implement) not to display this content in a frame. For details, please
     * refer to http://blogs.msdn.com/sdl/archive/2009/02/05/clickjacking-defense-in-ie8.aspx.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader("Pragma", "no-cache");
        res.addHeader("Cache-Control", "no-cache");
        res.addHeader("X-FRAME-OPTIONS", mode );
        res.addHeader("Strict-Transport-Security", "max-age=16070400; includeSubDomains");
        res.addHeader("X-XSS-Protection", xss_protection);
        res.addHeader("X-Content-Type-Options", "nosniff");
        res.addHeader("Content-Security-Policy", "default-src 'self'");
        chain.doFilter(request, response);
    }
    
    public void destroy() {
    }
    
    public void init(FilterConfig filterConfig) {
        String configMode = filterConfig.getInitParameter("mode");
        if ( configMode != null ) {
            mode = configMode;
        }
    }
}
