package com.dxc.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
/**
 * 3/26/2019
 *
 * @author qzhang52
 * @version 1.0
 */
public class FileUtil extends FileUtils
{
  public static String createBillingFileStoreDirectory(String storePath, String tenantId)
  {
    File storeDir = new File(getUserDirectory(), storePath);
    if (!storeDir.exists()) {
      storeDir.mkdir();
    }
    File tenantDir = new File(storeDir, tenantId);
    if (!tenantDir.exists()) {
      tenantDir.mkdir();
    }
    return tenantDir.getPath();
  }

  public static String loadTextFileContext(String path, boolean withLineSeperator) throws IOException {
    StringBuilder buffer = new StringBuilder();
    PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

    Resource[] resources = patternResolver.getResources(path);
    if ((resources != null) && (resources.length > 0)) {
      InputStream in = resources[0].getInputStream();

      Scanner scanner = new Scanner(in, "utf-8");
      while (scanner.hasNextLine()) {
        buffer.append(scanner.nextLine());
        if ((scanner.hasNextLine()) && (withLineSeperator)) {
          buffer.append(System.getProperty("line.separator"));
        }
      }
      in.close();
      scanner.close();
    }

    return buffer.toString();
  }

  public static String loadWarFile(String path) {
    String result = "";
    try {
      ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
      InputStream resourceContent = context.getResourceAsStream(path);
      if (resourceContent == null) {
        return result;
      }
      result = StreamUtils.copyToString(resourceContent, Charset.forName("UTF-8"));
    } catch (IOException e) {
      LogUtil.error(e);
    }
    return result;
  }
}