package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver  implements HandlerExceptionResolver {
    /**
     * 调用处理器时会执行这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 这个就是当前抛出的对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException) e;
        }else {
            ex = new SysException("系统正在维护....");
        }
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg" , ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
