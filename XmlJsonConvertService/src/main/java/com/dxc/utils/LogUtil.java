package com.dxc.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 3/26/2019
 *
 * @author qzhang52
 * @version 1.0
 */
public class LogUtil
{
  private static final String DEBUG = "DEBUG";
  private static final String INFO = "INFO";
  private static final String WARN = "WARN";
  private static final String ERROR = "ERROR";

  public static Logger getLogger()
  {
    return LoggerFactory.getLogger(getLogClass());
  }

  public static void writeLog(Object msg, String level)
  {
    Logger logger = getLogger();

    if ("DEBUG".equals(level))
    {
      logger.debug(getMsg(msg));
    }
    else if ("INFO".equals(level))
    {
      logger.info(getMsg(msg));
    }
    else if ("WARN".equals(level))
    {
      logger.warn(getMsg(msg));
    }
    else if ("ERROR".equals(level))
    {
      logger.error(getMsg(msg));
    }
    else
    {
      logger.error("");
    }
  }

  public static void info(Object msg)
  {
    Logger logger = getLogger();
    logger.info(getMsg(msg));
  }

  public static void info(Object msg, Object o1)
  {
    Logger logger = getLogger();
    logger.info(getMsg(msg), o1);
  }

  public static void info(Object msg, Object o1, Object o2)
  {
    Logger logger = getLogger();
    logger.info(getMsg(msg), o1, o2);
  }

  public static void info(Object msg, Object[] obj)
  {
    Logger logger = getLogger();
    logger.info(getMsg(msg), obj);
  }

  public static void debug(Object msg)
  {
    Logger logger = getLogger();
    logger.debug(getMsg(msg));
  }

  public static void debug(Object msg, Object o)
  {
    Logger logger = getLogger();
    logger.debug(getMsg(msg), o);
  }

  public static void debug(Object msg, Object o1, Object o2)
  {
    Logger logger = getLogger();
    logger.debug(getMsg(msg), o1, o2);
  }

  public static void debug(Object msg, Object[] obj)
  {
    Logger logger = getLogger();
    logger.debug(getMsg(msg), obj);
  }

  public static void warn(Object msg)
  {
    Logger logger = getLogger();
    logger.warn(getMsg(msg));
  }

  public static void warn(Object msg, Object o)
  {
    Logger logger = getLogger();
    logger.warn(getMsg(msg), o);
  }

  public static void warn(Object msg, Object o1, Object o2)
  {
    Logger logger = getLogger();
    logger.warn(getMsg(msg), o1, o2);
  }

  public static void warn(Object msg, Object[] obj)
  {
    Logger logger = getLogger();
    logger.warn(getMsg(msg), obj);
  }

  public static void error(Object msg)
  {
    Logger logger = getLogger();
    logger.error(getMsg(msg));
  }

  public static void error(Object msg, Object o)
  {
    Logger logger = getLogger();
    logger.error(getMsg(msg), o);
  }

  public static void error(Object msg, Object o1, Object o2)
  {
    Logger logger = getLogger();
    logger.error(getMsg(msg), o1, o2);
  }

  public static void error(Object msg, Object[] obj)
  {
    Logger logger = getLogger();
    logger.error(getMsg(msg), obj);
  }

  public static void error(Object msg, Throwable ex)
  {
    Logger logger = getLogger();
    logger.error(getMsg(msg), ex);
  }

  public static String getMsg(Object msg, Throwable ex)
  {
    String str = "";

    if (msg != null)
    {
      str = new StringBuilder().append(getLogMethod()).append("[").append(msg.toString()).append("]").toString();
    }
    else
    {
      str = new StringBuilder().append(getLogMethod()).append("[null]").toString();
    }
    if (ex != null)
    {
      str = new StringBuilder().append(str).append("[").append(ex.getMessage()).append("]").toString();
    }

    return str;
  }

  public static String getMsg(Object msg)
  {
    return getMsg(msg, null);
  }

  private static String getLogClass()
  {
    String str = "";

    StackTraceElement[] stack = new Throwable().getStackTrace();
    if (stack.length > 3)
    {
      StackTraceElement ste = stack[3];
      str = ste.getClassName();
    }

    return str;
  }

  private static String getLogMethod()
  {
    String str = "";

    StackTraceElement[] stack = new Throwable().getStackTrace();
    if (stack.length > 4)
    {
      StackTraceElement ste = stack[4];
      str = new StringBuilder().append("Method[").append(ste.getMethodName()).append("]").toString();
    }

    return str;
  }

  public static String toString(Throwable e) {
    StringWriter sw = null;
    PrintWriter pw = null;
    try {
      sw = new StringWriter();
      pw = new PrintWriter(sw);

      e.printStackTrace(pw);
      pw.flush();
      sw.flush();
    } finally {
      if (sw != null) {
        try {
          sw.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (pw != null) {
        pw.close();
      }
    }
    return sw.toString();
  }

  public static String getExceptionDetailsToStr(Exception e) {
    StringBuilder sb = new StringBuilder(e.toString());
    StackTraceElement[] stackElements = e.getStackTrace();
    for (StackTraceElement stackTraceElement : stackElements) {
      sb.append(stackTraceElement.toString());
      sb.append("\n");
    }
    sb.append("\n");
    return sb.toString();
  }
}