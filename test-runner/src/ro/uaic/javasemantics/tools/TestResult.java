package ro.uaic.javasemantics.tools;

import java.io.File;
import java.io.IOException;

/**
 * Date: 26.05.2012
 *
 * @author denis.bogdanas@gmail.com
 */
public class TestResult {

  private String name;
  private long time;
  private boolean success;
  private String comp;
  private File generr;
  private File stderr;

  //error messages generated by testRunner application.
  private String errorMesage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getComp() {
    return comp;
  }

  public void setComp(String comp) {
    this.comp = comp;
  }

  public File getGenerr() {
    return generr;
  }

  public void setGenerr(File generr) {
    this.generr = generr;
  }

  public File getStderr() {
    return stderr;
  }

  public void setStderr(File stderr) {
    this.stderr = stderr;
  }

  public String getErrorMesage() {
    return errorMesage;
  }

  public void setErrorMesage(String errorMesage) {
    this.errorMesage = errorMesage;
  }

  public boolean containsError() {
    return getErrorMesage() != null || getGenerr() != null ||
        getStderr() != null;
  }

  public String getError() {
    try {
      if (getErrorMesage() != null) {
        return getErrorMesage() + "\n";
      } else if (getGenerr() != null) {
        return "Generator error:\n" + TestRunner.readFile(getGenerr());
      } else if (getStderr() != null) {
        return "Test error:\n" + TestRunner.readFile(getStderr());
      } else {
        return null;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getHighLevelStatus() {
    if (containsError()) {
      return "error";
    } else if (isSuccess()) {
      return "ok";
    } else {
      return "failed";
    }
  }

  public String getStatus() {
    if (containsError()) {
      if ("Test generator timed out".equals(getErrorMesage())) {
        return "generator timeout";
      } else if ("Test timed out".equals(getErrorMesage())) {
        return "timeout";
      } else return "error";
    } else if (isSuccess()) {
      return "ok";
    } else {
      return "failed";
    }
  }
}
