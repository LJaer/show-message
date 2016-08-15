package cn.zk.ssm.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**  
 * 解决SpringMVC使用@ResponseBody返回json时，日期格式默认显示为时间戳的问题。需配合<mvc:message-converters>使用  
 *   
 * @author hellostory  
 * @date 2013-10-31 下午04:17:52  
 */  
@Component("customDateMapper")  
public class CustomDateMapper extends ObjectMapper {  
  
}  