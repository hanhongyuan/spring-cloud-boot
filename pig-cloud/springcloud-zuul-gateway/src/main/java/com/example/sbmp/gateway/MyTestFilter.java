package com.example.sbmp.gateway;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;

/**
 * 用于zuul滤波器的基础抽象类。基类定义了定义的抽象方法:
 */
@Component
public class MyTestFilter extends ZuulFilter {
	/**
	 * 前置过滤器<br>
	 * pre：可以在请求被路由之前调用 <br>
	 * route：在路由请求时候被调用 <br>
	 * post：在route和error过滤器之后被调用 <br>
	 * error：处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 优先级为0，数字越大，优先级越低
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 是否执行该过滤器，此处为true，说明需要过滤
	 */
	@Override
	public boolean shouldFilter() {
		//RequestContext ctx = RequestContext.getCurrentContext();
		return true;//(boolean) ctx.get("isSuccess");// 如果前一个过滤器的结果为true，则说明上一个过滤器成功了，需要进入当前的过滤，如果前一个过滤器的结果为false，则说明上一个过滤器没有成功，则无需进行下面的过滤动作了，直接跳过后面的所有过滤器并返回结果
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(String.format("%s AccessUserNameFilter request to %s", request.getMethod(),
				request.getRequestURL().toString()));

		String username = "chhliu";// request.getParameter("username");// 获取请求的参数
		if (null != username && username.equals("chhliu")) {// 如果请求的参数不为空，且值为chhliu时，则通过
			ctx.setSendZuulResponse(true);// 对该请求进行路由
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
			return null;
		} else {
			ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401);// 返回错误码
			ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容
			ctx.set("isSuccess", false);
			return null;
		}
	}
}
