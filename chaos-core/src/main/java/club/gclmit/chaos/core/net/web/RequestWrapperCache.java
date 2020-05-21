package club.gclmit.chaos.core.net.web;

import club.gclmit.chaos.core.exception.ChaosCoreException;
import club.gclmit.chaos.core.util.CharsetUtils;
import club.gclmit.chaos.core.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * 自定义 HttpServletRequestWrapper
 * 设置缓存快照
 * </p>
 *
 * @author: gclm
 * @date: 2020/5/20 5:49 下午
 * @version: V1.0
 * @since 1.8
 */
public class RequestWrapperCache extends HttpServletRequestWrapper {

    /**
     * 设置默认编码格式为 UTF-8
     */
    private static final String DEFAULT_CHARSET = CharsetUtils.UTF_8;

    /**
     * Request Body
     */
    private final String body;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public RequestWrapperCache(HttpServletRequest request){
        super(request);
        try(ServletInputStream stream = request.getInputStream()) {
            this.body = StringUtils.toString(stream, DEFAULT_CHARSET);
        } catch (IOException e) {
            throw new ChaosCoreException("包装 HttpServletRequest 异常",e);
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes(DEFAULT_CHARSET));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public String getBody() {
        return body;
    }
}